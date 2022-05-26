package service;
import dao.*;
import model.CustomerDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

import dao.*;

public class CustomerService {
	
	//���̵� �ߺ� üũ �޼ҵ�
	public static boolean checkID(String id) throws SQLException {
		ResultSet rs = CustomerDAO.checkID(id);
		
		int isIDOverlap = 0;
		
		try {
			while (rs.next() ) {
				isIDOverlap = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//���� isIDOverlap�� 0���� ũ�� ���̵� �ߺ�. 0�̸� ���� �����Ƿ� false ��ȯ
		if (isIDOverlap > 0)
			return true;
		else
			return false;
	}
	
	//��� ȸ���� ���� ��������
	public static ResultSet viewAllCustomer() throws SQLException {
		ResultSet rs = null;
		
		rs = CustomerDAO.readAllCutomer();
		
		return rs;
	}
	
	public static CustomerDTO viewCustomerByID(String id) throws SQLException {
		CustomerDTO customerDTO = CustomerDAO.findCustomerByID(id);
		
		return customerDTO;
	}
	}

