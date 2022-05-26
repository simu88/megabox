package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import common.DBConfig;
import model.CustomerDTO;

public class GetRoleDAO {
	
	static Connection con = null;
	static PreparedStatement pstmt = null;
	static ResultSet rs = null;
	
	//회원의 아이디를 입력하면 권한을 가져오는 메소드
	public static Vector getRole(String id) throws SQLException {

		
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
		Vector<CustomerDTO> vector = new Vector<>();
		
		CustomerDTO customerDTO = null;
		
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, id);
		rs = pstmt.executeQuery();
		
		while (rs.next()) {
			customerDTO.setRole(rs.getInt(1));
			vector.add(customerDTO);
		}

		pstmt.close();
		con.close();
		rs.close();
		
		return vector;
	}
	
}
