package service;

import dao.*;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import dao.*;
import model.CustomerDTO;
import model.*;

//ȸ������ ó�� ���
public class SignUpService {
	public static boolean signUp(String ID, String password, String email, String phone) throws SQLException, UnsupportedEncodingException, NoSuchAlgorithmException {
		//CustomerDTO ��ü ����
		CustomerDTO customerDTO = new CustomerDTO(ID, PasswordEncryptService.passwordEncrypt(password), email, phone, 1, 0);
		
		boolean checkID = CustomerService.checkID(ID);
		
		if (checkID == true)
			return false;
		else {
			try {
				SignUpDAO.register(customerDTO.getID(), customerDTO.getPassword(), customerDTO.getEmail(), customerDTO.getEmail(), customerDTO.getRole(), customerDTO.getReview_count());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return true;
		}
			
		
	}
	
}
