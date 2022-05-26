package service;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import dao.*;

public class IsAdminService {
	//관리자인지 일반 회원인지 판단하는 메소드
	public static boolean isAdmin(String id) throws SQLException {
		Vector vc = GetRoleDAO.getRole(id);
		
		int role = 0;
		
		for (int i = 0; i < vc.size(); i++) {
			role = (int) vc.get(i);
		}
			
		//권한이 0이면 관리자 즉 true. 1이면 일반 회원이므로 false 반환
		if (role == 0)
			return true;
		else
			return false;
	}
}
