package service;
import dao.*;
import model.CustomerDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

import dao.*;

public class CustomerService {
	
	//아이디 중복 체크 메소드
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
		
		//만약 isIDOverlap이 0보다 크면 아이디 중복. 0이면 문제 없으므로 false 반환
		if (isIDOverlap > 0)
			return true;
		else
			return false;
	}
	
	//모든 회원의 정보 가져오기
	public static ResultSet viewAllCustomer() throws SQLException {
		ResultSet rs = null;
		
		rs = CustomerDAO.readAllCutomer();
		
		return rs;
	}
	
	//아이디로 회원 조회
	public static CustomerDTO viewCustomerByID(String id) throws SQLException {
		CustomerDTO customerDTO = CustomerDAO.findCustomerByID(id);
		
		return customerDTO;
	}
	
	//회원 정보 수정
	public static void editCustomer(String ID, String password, String email, String phone) throws SQLException {
		CustomerDTO customerDTO = new CustomerDTO(ID, PasswordEncryptService.passwordEncrypt(password), email, phone, 0, 0);
		
		CustomerDAO.updateCustomer(customerDTO);
	}
	}

