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
	
	//아이디 중복 체크 메소드
	public static boolean checkID(String id) throws SQLException {
		Vector vc = CustomerDAO.checkID(id);
		
		int isIDOverlap = 0;
		
		
		for (int i = 0; i < vc.size(); i++) {
			isIDOverlap = (int) vc.get(i);
		}
		
		//만약 isIDOverlap이 0보다 크면 아이디 중복. 0이면 문제 없으므로 false 반환
		if (isIDOverlap > 0)
			return true;
		else
			return false;
	}
	
	//모든 회원의 정보 가져오기
	public static Vector viewAllCustomer() throws SQLException {
		Vector vc = CustomerDAO.readAllCutomer();
		
		return vc;
	}
	
	//아이디로 회원 조회
	public static CustomerDTO viewCustomerByID(String id) throws SQLException {
		CustomerDTO customerDTO = CustomerDAO.findCustomerByID(id);
		
		return customerDTO;
	}
	
	//회원 정보 수정
	public static void editCustomer(String ID, String password, String email, String phone) throws SQLException, UnsupportedEncodingException, NoSuchAlgorithmException {
		CustomerDTO customerDTO = new CustomerDTO(ID, PasswordEncryptService.passwordEncrypt(password), email, phone, 0, 0);
		
		CustomerDAO.updateCustomer(customerDTO);
	}
	}

