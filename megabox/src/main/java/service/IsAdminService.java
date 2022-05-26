package service;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import dao.*;

public class IsAdminService {
	//���������� �Ϲ� ȸ������ �Ǵ��ϴ� �޼ҵ�
	public static boolean isAdmin(String id) throws SQLException {
		Vector vc = GetRoleDAO.getRole(id);
		
		int role = 0;
		
		for (int i = 0; i < vc.size(); i++) {
			role = (int) vc.get(i);
		}
			
		//������ 0�̸� ������ �� true. 1�̸� �Ϲ� ȸ���̹Ƿ� false ��ȯ
		if (role == 0)
			return true;
		else
			return false;
	}
}
