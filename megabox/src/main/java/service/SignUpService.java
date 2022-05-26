package service;

import dao.*;
import java.sql.SQLException;

import dao.*;
import model.CustomerDTO;
import model.*;

//ȸ������ ó�� ���
public class SignUpService {
	public static void signUp(String ID, String password, String email, String phone) throws SQLException {
		//CustomerDTO ��ü ����
		CustomerDTO customerDTO = new CustomerDTO(ID, PasswordEncryptService.passwordEncrypt(password), email, phone, 1, 0);
		
		boolean checkID = CustomerService.checkID(ID);
		
		if (checkID == true)
			return;
		else {
			try {
				SignUpDAO.register(customerDTO.getID(), customerDTO.getPassword(), customerDTO.getEmail(), customerDTO.getEmail(), customerDTO.getRole(), customerDTO.getReview_count());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
		
	}
	
}
