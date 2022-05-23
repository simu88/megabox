package service;
import service.*;

import java.sql.SQLException;

import dao.*;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*try {
			SignUpDAO.register("a", "b", "c", "d");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
		GetRoleDAO a=new GetRoleDAO();
		a.getRole();
	}
}