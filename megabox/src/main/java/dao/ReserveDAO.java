package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Vector;

import common.DBConfig;
import model.ReserveDTO;

public class ReserveDAO {
	static Connection con = null;
	static PreparedStatement pstmt = null;
	static ResultSet rs = null;
	
	public static void createReserve(ReserveDTO reserveDTO) {

		
		try {
			Class.forName(DBConfig.driver);
			con = DriverManager.getConnection(DBConfig.URL, DBConfig.dbUserName, DBConfig.dbPassword);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(SQLException e){
            System.out.println("¿¡·¯: " + e);
        }
		
		
		String sql="insert into reserve values(?, ?, ?, ?, ?, ?, ?, ?,);";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, reserveDTO.getCustomer_id());
			pstmt.setInt(2, reserveDTO.getSchedule_id());
			pstmt.setDate(3, Date.valueOf(reserveDTO.getDate()));
			pstmt.setString(4, reserveDTO.getCreditcard());
			pstmt.setString(5, reserveDTO.getPayment_type());
			pstmt.setTimestamp(6, Timestamp.valueOf(reserveDTO.getReserve_time()));
			pstmt.setInt(7, reserveDTO.getCustomer_count());
			pstmt.setInt(8, reserveDTO.getPrice_sum());
			
			int cnt=pstmt.executeUpdate();
			
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	//회원이나 관리자가 개별 예매 취소
	public static void deleteReserve(ReserveDTO reserveDTO, int customer_count) throws SQLException {
		try {
			Class.forName(DBConfig.driver);
			con = DriverManager.getConnection(DBConfig.URL, DBConfig.dbUserName, DBConfig.dbPassword);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(SQLException e){
            System.out.println("¿¡·¯: " + e);
        }
		
		String sql = "DELETE from reserve WHERE reserve_id=?";
		
		pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, reserveDTO.getReserve_id());
		pstmt.executeQuery();
		
		pstmt.close();
		con.close();
		
		//상영시간표의 잔여 좌석 수에서 예매의 고객 수만큼 더해줌
		int CustomerCount = customer_count + reserveDTO.getCustomer_count();
		sql = "UPDATE schedule SET customer_count=?";
		
		pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, CustomerCount);
		pstmt.executeQuery();
		
		pstmt.close();
		con.close();
	}
	
	//예매 취소 시 삭제 전에 해당 예매의 인원 수를 구함
//	public static int readCustomerCount(int reserve_id) throws SQLException {
//		try {
//			Class.forName(DBConfig.driver);
//			con = DriverManager.getConnection(DBConfig.URL, DBConfig.dbUserName, DBConfig.dbPassword);
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch(SQLException e){
//            System.out.println("¿¡·¯: " + e);
//        }
//		
//		int customerCount = 0;
//		
//		String sql = "SELECT customer_count FROM reserve WHERE reserve_id=?";
//		
//		pstmt = con.prepareStatement(sql);
//		pstmt.setInt(1, reserve_id);
//		rs = pstmt.executeQuery();
//		
//		while (rs.next()) {
//			customerCount = rs.getInt(1);
//		}
//		
//		return customerCount;
//	}
	
	//상영시간표 삭제 시 해당 상영표의 모든 예매 삭제. 관리자만 쓰는 메소드
	public static void deleteAllReserveBySchedule(int schedule_id) throws SQLException {
		try {
			Class.forName(DBConfig.driver);
			con = DriverManager.getConnection(DBConfig.URL, DBConfig.dbUserName, DBConfig.dbPassword);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(SQLException e){
            System.out.println("¿¡·¯: " + e);
        }
		
		String sql = "DELETE from reserve WHERE schedule_id=?";
		
		pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, schedule_id);
		pstmt.executeQuery();
		
		pstmt.close();
		con.close();
	}
	

}