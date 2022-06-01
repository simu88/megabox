package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import common.*;
import model.*;
public class AuditoriumDAO {

	static Connection con = null;
	static PreparedStatement pstmt = null;
	static ResultSet rs = null;
	
	public static void createAuditorium(AuditoriumDTO auditoriumDTO) throws SQLException {

		
		try {
			Class.forName(DBConfig.driver);
			con = DriverManager.getConnection(DBConfig.URL, DBConfig.dbUserName, DBConfig.dbPassword);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(SQLException e){
            System.out.println("¿¡·¯: " + e);
        }
		
		//DAO °øÅë ÄÚµå
		
		String sql="INSERT into auditorium(theater_id, auditorium_name, seat_number) values(?, ?, ?)";
		
		pstmt=con.prepareStatement(sql);
		pstmt.setInt(1, auditoriumDTO.getTheater_id());
		pstmt.setString(2, auditoriumDTO.getAuditorium_name());
		pstmt.setInt(3, auditoriumDTO.getSeat_number());
			
		pstmt.executeUpdate();
		pstmt.close();
		con.close();

		
	}
	
	//모든 상영관을 영화관 순서대로 출력
	public static Vector readAllAuditorium() throws SQLException {
		try {
			Class.forName(DBConfig.driver);
			con = DriverManager.getConnection(DBConfig.URL, DBConfig.dbUserName, DBConfig.dbPassword);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(SQLException e){
            System.out.println("에러: " + e);
        }
		
		String sql = "SELECT * FROM auditorium ORDER BY theater_id";
		
		Vector<AuditoriumDTO> vector = new Vector<>();
		
		AuditoriumDTO auditoriumDTO = new AuditoriumDTO(0, "", 0);
		
		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();
		
		while (rs.next()) {
			auditoriumDTO.setAuditorium_id(rs.getInt(1));
			auditoriumDTO.setTheater_id(rs.getInt(2));
			auditoriumDTO.setAuditorium_name(rs.getString(3));
			auditoriumDTO.setSeat_number(rs.getInt(4));
			
			vector.add(auditoriumDTO);
		}
		
		pstmt.close();
		con.close();
		rs.close();
		
		return vector;
	
	}
	
	//영화관 번호 입력하면 해당 영화관의 모든 상영관 출력
	public static Vector readAuditoriumByTheaterID(int theater_id) throws SQLException {
		try {
			Class.forName(DBConfig.driver);
			con = DriverManager.getConnection(DBConfig.URL, DBConfig.dbUserName, DBConfig.dbPassword);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(SQLException e){
            System.out.println("에러: " + e);
        }
		
		String sql = "SELECT * FROM auditorium WHERE theater_id=?";
		
		Vector<AuditoriumDTO> vector = new Vector<>();
		
		AuditoriumDTO auditoriumDTO = new AuditoriumDTO(0, "", 0);
		
		pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, theater_id);
		rs = pstmt.executeQuery();
		
		while (rs.next()) {
			auditoriumDTO.setAuditorium_id(rs.getInt(1));
			auditoriumDTO.setTheater_id(rs.getInt(2));
			auditoriumDTO.setAuditorium_name(rs.getString(3));
			auditoriumDTO.setSeat_number(rs.getInt(4));
			
			vector.add(auditoriumDTO);
		}
		
		pstmt.close();
		con.close();
		rs.close();
		
		return vector;
	}
	
	//영화관 삭제
	public static boolean deleteAuditorium(AuditoriumDTO auditoriumDTO) throws SQLException {
		//true를 반환하면 삭제 성공, false면 영화관 및에 상영시간표가 있기 때문에 삭제 불가
		
		if (ScheduleDAO.countSchedule(auditoriumDTO.getAuditorium_id()) != 0)
			return false;
		
		try {
			Class.forName(DBConfig.driver);
			con = DriverManager.getConnection(DBConfig.URL, DBConfig.dbUserName, DBConfig.dbPassword);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(SQLException e){
            System.out.println("에러: " + e);
        }
		
		String sql = "DELETE from auditorium WHERE auditorium_id=?";
		
		pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, auditoriumDTO.getAuditorium_id());
		pstmt.executeQuery();
		
		pstmt.close();
		con.close();
		
		return true;
		
	}
}