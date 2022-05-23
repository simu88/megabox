package dao;
import java.sql.*;
import service.PasswordEncryptService;

import common.DBConfig;

public class SignUpDAO {
	
	public static void register(String id, String password, String email, String phone, int role, int review_count) throws SQLException {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName(DBConfig.driver);
			con = DriverManager.getConnection(DBConfig.URL, DBConfig.dbUserName, DBConfig.dbPassword);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(SQLException e){
            System.out.println("에러: " + e);
        }
		
		//DAO 공통 코드
		
		String sql = "INSERT INTO customer(id, password, email, phone, role, review_count) VALUES (?, ?, ?, ?, ?, ?);";
		
		pstmt = con.prepareStatement(sql);
		
		pstmt.setString(1, id);
		pstmt.setString(2, password);
		pstmt.setString(3, email);
		pstmt.setString(4, phone);
		pstmt.setInt(5, role);
		pstmt.setInt(6, review_count);
		
		pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
		
	}
}