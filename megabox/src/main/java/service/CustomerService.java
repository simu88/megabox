package service;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.*;

public class CustomerService {
	public static boolean checkID(String id) {
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
	}

