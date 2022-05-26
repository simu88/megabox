package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.DBConfig;

public class CustomerDAO {
	
	static Connection con = null;
	static PreparedStatement pstmt = null;
	static ResultSet rs = null;
	//���԰� ���� ��ȸ�� ������ �̿��ڿ� ���õ� DAO
	public static ResultSet checkID(String id) throws SQLException {
				
			try {
				Class.forName(DBConfig.driver);
				con = DriverManager.getConnection(DBConfig.URL, DBConfig.dbUserName, DBConfig.dbPassword);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch(SQLException e){
	            System.out.println("����: " + e);
	        }
			
			String sql = "SELECT COUNT(*) FROM customer where id =?";
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, id);
				rs = pstmt.executeQuery();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			pstmt.close();
			con.close();
			
			return rs;
			
	}

}
