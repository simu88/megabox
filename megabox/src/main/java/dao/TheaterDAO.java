package dao;
import java.sql.*;
import java.util.Vector;

import model.*;
import common.*;
public class TheaterDAO {
	static Connection con=null;
	static PreparedStatement pstmt=null;
	static ResultSet rs = null;
	
	public static void createTheater(TheaterDTO theaterDTO) {

		try {
			Class.forName(DBConfig.driver);
			con = DriverManager.getConnection(DBConfig.URL, DBConfig.dbUserName, DBConfig.dbPassword);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(SQLException e){
            System.out.println("에러: " + e);
        }
		
		String sql="insert into theater(region) values(?);";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, theaterDTO.getRegion());
			int cnt=pstmt.executeUpdate();
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	//영화관 전체 조회
	public static Vector readAllTheater() throws SQLException {
		try {
			Class.forName(DBConfig.driver);
			con = DriverManager.getConnection(DBConfig.URL, DBConfig.dbUserName, DBConfig.dbPassword);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(SQLException e){
            System.out.println("에러: " + e);
        }
		
		String sql = "SELECT * FROM theater";
		
		Vector<TheaterDTO> vector = new Vector<>();
		
		
		
		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();
		
		while (rs.next()) {
			TheaterDTO theaterDTO = new TheaterDTO("");
			//System.out.println(rs.getInt(1));
			//System.out.println(rs.getString(2));
			theaterDTO.setTheater_id(rs.getInt(1));
			theaterDTO.setRegion(rs.getString(2));
			
			vector.add(theaterDTO);
			System.out.println("la: "+ theaterDTO.getTheater_id());
			System.out.println(theaterDTO.getRegion());
		}
		
		
		rs.close();
		pstmt.close();
		con.close();
		
		return vector;
	}
	
	//영화관 삭제
	public static void deleteTheater(int theater_id) throws SQLException {
		try {
			Class.forName(DBConfig.driver);
			con = DriverManager.getConnection(DBConfig.URL, DBConfig.dbUserName, DBConfig.dbPassword);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(SQLException e){
            System.out.println("에러: " + e);
        }
		
		String sql = "DELETE FROM theater WHERE theater_id=?";
		
		pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, theater_id);
		pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
	}
}