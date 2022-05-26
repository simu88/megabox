package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import common.*;
import model.*;
public class AuditoriumDAO {

	public static void createAuditorium(AuditoriumDTO auditoriumDTO) {
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
		
		String sql="insert into auditorium(theater_id, auditorium_name, seat_number) values(?, ?, ?)";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, auditoriumDTO.getTheater_id());
			pstmt.setString(2, auditoriumDTO.getAuditorium_name());
			pstmt.setInt(3, auditoriumDTO.getSeat_number());
			
			int cnt=pstmt.executeUpdate();
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
}
