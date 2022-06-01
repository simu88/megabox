package dao;
import common.*;
import model.*;
import java.sql.*;
import service.*;
public class ScheduleDAO {

	static Connection con=null;
	static PreparedStatement pstmt=null;
	static ResultSet rs = null;
	
	public static void createSchedule(ScheduleDTO scheduleDTO) {
		
		Date date = StringToDateService.transformDate(scheduleDTO.getDate() + "");
		
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
			pstmt.setDate(3, date);
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
	
	//상영관번호 입력하면 해당 상영관에서 상영하는 상영시간표의 개수 출력. 상영관 삭제를 위한 메소드
	public static int countSchedule(int auditorium_id) throws SQLException {
		try {
			Class.forName(DBConfig.driver);
			con = DriverManager.getConnection(DBConfig.URL, DBConfig.dbUserName, DBConfig.dbPassword);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(SQLException e){
            System.out.println("¿¡·¯: " + e);
        }
		
		String sql = "SELECT (*) FROM schedule WHERE auditorium_id=?";
		
		pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, auditorium_id);
		rs = pstmt.executeQuery();
		
		int result = 0;
		
		while (rs.next()) {
			result += 1;
		}
		
		return result;
	}
	
	//잔여 좌석 수 반환
	public static int countRestSeat(int schedule_id) throws SQLException {
		try {
			Class.forName(DBConfig.driver);
			con = DriverManager.getConnection(DBConfig.URL, DBConfig.dbUserName, DBConfig.dbPassword);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(SQLException e){
            System.out.println("¿¡·¯: " + e);
        }
		
		String sql = "SELECT rest_seat_count FROM shcedule WHERE schedule_id=?";
		
		pstmt=con.prepareStatement(sql);
		pstmt.setInt(1, schedule_id);
		
		rs = pstmt.executeQuery();
		
		int restSeat = 0;
		
		while (rs.next()) {
			restSeat = rs.getInt(1);
		}
		
		rs.close();
		pstmt.close();
		con.close();
		
		return restSeat;
	}
	
	//예매 시 잔여 좌석에서 사람 수 만큼 뺌
	public static void updateRestSeat(int schedule_id, int customer_count) throws SQLException {
		try {
			Class.forName(DBConfig.driver);
			con = DriverManager.getConnection(DBConfig.URL, DBConfig.dbUserName, DBConfig.dbPassword);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(SQLException e){
            System.out.println("에러: " + e);
        }
		
		int restSeat = countRestSeat(schedule_id);
		
		String sql = "UPDATE schedule SET rest_seat_count=? WHERE schedule_id=?";
		
		pstmt = con.prepareStatement(sql);
		
		pstmt.setInt(1, restSeat - customer_count);
		pstmt.setInt(2, schedule_id);
		
		pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
	}
	
	//상영시간표 삭제
	public static void deleteSchedule(int schedule_id) throws SQLException {
		try {
			Class.forName(DBConfig.driver);
			con = DriverManager.getConnection(DBConfig.URL, DBConfig.dbUserName, DBConfig.dbPassword);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(SQLException e){
            System.out.println("에러: " + e);
        }
		
		//해당 상영시간표의 모든 예매 삭제
		ReserveDAO.deleteAllReserveBySchedule(schedule_id);
		
		String sql = "DELETE FROM schedule WHERE schedule_id=?";
		
		pstmt = con.prepareStatement(sql);
		
		pstmt.setInt(1, schedule_id);
		
		pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
		
		
	}
	
	//해당 영화의 모든 상영시간표 삭제
	public static void deleteAllScheduleByMovie(int movie_id) throws SQLException {
		try {
			Class.forName(DBConfig.driver);
			con = DriverManager.getConnection(DBConfig.URL, DBConfig.dbUserName, DBConfig.dbPassword);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(SQLException e){
            System.out.println("에러: " + e);
        }
		
		//해당 상영시간표의 모든 예매 삭제
		
		String sql = "DELETE FROM schedule WHERE movie_id=?";
		
		pstmt = con.prepareStatement(sql);
		
		pstmt.setInt(1, movie_id);
		
		pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
		
		
	}
}
