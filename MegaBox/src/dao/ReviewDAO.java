package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import common.DBConfig;
import model.*;

public class ReviewDAO {

	public static void createReview(ReviewDTO reviewDTO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName(DBConfig.driver);
			con = DriverManager.getConnection(DBConfig.URL, DBConfig.dbUserName, DBConfig.dbPassword);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(SQLException e){
            System.out.println("¿¡·¯: " + e);
        }
		
		String sql="insert into review(customer_id, movie_id, score) values(?, ?, ?);";
		try {
			pstmt=con.prepareStatement(sql);
			
			pstmt.setInt(1, reviewDTO.getCustomer_id());
			pstmt.setInt(2, reviewDTO.getMovie_id());
			pstmt.setInt(3, reviewDTO.getScore());
			
			int cnt=pstmt.executeUpdate();
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
