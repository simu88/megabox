package service;
import dao.*;
import model.CustomerDTO;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import dao.*;

public class CustomerService {
	
	//���̵� �ߺ� üũ �޼ҵ�
	public static boolean checkID(String id) throws SQLException {
		Vector vc = CustomerDAO.checkID(id);
		
		int isIDOverlap = 0;
		
		
		for (int i = 0; i < vc.size(); i++) {
			isIDOverlap = (int) vc.get(i);
		}
		
		//���� isIDOverlap�� 0���� ũ�� ���̵� �ߺ�. 0�̸� ���� �����Ƿ� false ��ȯ
		if (isIDOverlap > 0)
			return true;
		else
			return false;
	}
	
	//��� ȸ���� ���� ��������
	public static Vector viewAllCustomer() throws SQLException {
		Vector vc = CustomerDAO.readAllCutomer();
		
		return vc;
	}
	
	//���̵�� ȸ�� ��ȸ
	public static CustomerDTO viewCustomerByID(String id) throws SQLException {
		CustomerDTO customerDTO = CustomerDAO.findCustomerByID(id);
		
		return customerDTO;
	}
	
	//ȸ�� ���� ����
	public static void editCustomer(String ID, String password, String email, String phone) throws SQLException, UnsupportedEncodingException, NoSuchAlgorithmException {
		CustomerDTO customerDTO = new CustomerDTO(ID, PasswordEncryptService.passwordEncrypt(password), email, phone, 0, 0);
		
		CustomerDAO.updateCustomer(customerDTO);
	}
	}

