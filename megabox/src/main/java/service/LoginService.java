package service;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import dao.*;
import model.CustomerDTO;

public class LoginService {
	//�α��� ó��
	public static CustomerDTO loginProcess(String id, String password) throws SQLException, UnsupportedEncodingException, NoSuchAlgorithmException {
		
		CustomerDTO customerDTO = new CustomerDTO(id, PasswordEncryptService.passwordEncrypt(password), "", "", 0, 0);
		
		Vector<CustomerDTO> vc = CustomerDAO.login(customerDTO);
			
		System.out.println(vc.size());
		
		CustomerDTO customerDTOTemp = null;
		
		for (int i = 0; i < 1; i++) {
			
			customerDTOTemp = vc.get(i);
			
			if (customerDTOTemp.getRole() == 4) {
				customerDTO.setID(id);
				customerDTO.setRole(4);
				continue;
			}
			
//			System.out.println("customerDTO.getID() : " + id);
//			System.out.println("customerDTOTemp.getID() : " + customerDTOTemp.getID());
//			System.out.println("customerDTOTemp.getPassword() : " + customerDTOTemp.getPassword());
//			System.out.println("customerDTO.getPassword() : " + customerDTO.getPassword());
//			System.out.println("customerDTOTemp.getRole() : " + customerDTOTemp.getRole());
			
			if (id.equals(customerDTOTemp.getID()) && customerDTO.getPassword().equals(customerDTOTemp.getPassword())) {
				customerDTO.setID(customerDTOTemp.getID());
				customerDTO.setPassword(customerDTOTemp.getPassword());
				customerDTO.setRole(customerDTOTemp.getRole());
				
				vc.add(customerDTOTemp);
			}
			else {
				customerDTO.setID(id);
				customerDTO.setRole(4);
			}
			//������ 4�� �α��� ����! ���� �ֱ�
		}
		
		
		
		return customerDTO;
	}
}
