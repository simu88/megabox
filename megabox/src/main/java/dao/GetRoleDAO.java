package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import common.DBConfig;

public class GetRoleDAO {

	public static int getRole(String id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName(DBConfig.driver);
			con = DriverManager.getConnection(DBConfig.URL, DBConfig.dbUserName, DBConfig.dbPassword);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(SQLException e){
            System.out.println("¿¡·¯: " + e);
        }
		
		return 1;
	}
	
}
