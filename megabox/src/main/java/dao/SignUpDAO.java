package dao;
import java.sql.*;
import service.PasswordEncryptService;

import common.DBConfig;

public class SignUpDAO {
	
	static Connection con = null;
	static PreparedStatement pstmt = null;
	
	public static void register(String id, String password, String email, String phone, int role, int review_count) throws SQLException {
		
		
		
		try {
			Class.forName(DBConfig.driver);
			con = DriverManager.getConnection(DBConfig.URL, DBConfig.dbUserName, DBConfig.dbPassword);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(SQLException e){
            System.out.println("����: " + e);
        }
		
		//DAO ���� �ڵ�
		
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
