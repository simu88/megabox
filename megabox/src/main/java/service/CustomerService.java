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
		
		//���� isIDOverlap�� 0���� ũ�� ���̵� �ߺ�. 0�̸� ���� �����Ƿ� false ��ȯ
		if (isIDOverlap > 0)
			return true;
		else
			return false;
	}
	}

