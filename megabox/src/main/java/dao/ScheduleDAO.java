package dao;
import common.*;
import model.*;
import java.sql.*;
public class ScheduleDAO {

	public static void createSchedule(ScheduleDTO scheduleDTO) {
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
			Class.forName(DBConfig.driver);
			con = DriverManager.getConnection(DBConfig.URL, DBConfig.dbUserName, DBConfig.dbPassword);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(SQLException e){
            System.out.println("¿¡·¯: " + e);
        }
		
		String sql="insert into schedule(movie_id, auditorium_id, date, time, end_time, rest_seat_count) values"
				+ "(?, ?, ?, ?, ?, ?)";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, scheduleDTO.getMovie_id());
			pstmt.setInt(2, scheduleDTO.getAuditorium_id());
			pstmt.setDate(3, Date.valueOf(scheduleDTO.getDate()));
			pstmt.setTime(4, Time.valueOf(scheduleDTO.getTime()));
			pstmt.setTime(5, Time.valueOf(scheduleDTO.getEnd_time()));
			pstmt.setInt(6, scheduleDTO.getRest_seat_count());
			
			int cnt=pstmt.executeUpdate();
			pstmt.close();
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}
}
