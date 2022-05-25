package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.DBConfig;

public class GetRoleDAO {
	//회원의 아이디를 입력하면 권한을 가져오는 메소드
	public static ResultSet getRole(String id) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(DBConfig.driver);
			con = DriverManager.getConnection(DBConfig.URL, DBConfig.dbUserName, DBConfig.dbPassword);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(SQLException e){
            System.out.println("에러: " + e);
        }
		
		String sql = "SELECT role FROM customer WHERE id=?";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, id);
		rs = pstmt.executeQuery();

		pstmt.close();
		con.close();
		
		return rs;
	}
	
}
