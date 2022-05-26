package service;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.*;

public class IsAdminService {
	//���������� �Ϲ� ȸ������ �Ǵ��ϴ� �޼ҵ�
	public static boolean isAdmin(String id) throws SQLException {
		ResultSet rs = GetRoleDAO.getRole(id);
		
		int role = 0;
		
		while (rs.next() ) {
			role = rs.getInt(1);
		}
		
		//������ 0�̸� ������ �� true. 1�̸� �Ϲ� ȸ���̹Ƿ� false ��ȯ
		if (role == 0)
			return true;
		else
			return false;
	}
}
