package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Vector;

import common.DBConfig;
import model.ReserveDTO;

public class ReserveDAO {
	static Connection con = null;
	static PreparedStatement pstmt = null;
	
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
	

}