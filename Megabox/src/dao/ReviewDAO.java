package dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import common.DBConfig;
import model.*;

public class ReviewDAO {

	static Connection con = null;
	static PreparedStatement pstmt = null;
	static ResultSet rs = null;
	
	public static void createReview(ReviewDTO reviewDTO) {

		
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
	
	//영화 ID 주면 해당 영화의 리뷰 가져오기
	public static Vector readReviewByMovieID(int movie_id) throws SQLException {
		try {
			Class.forName(DBConfig.driver);
			con = DriverManager.getConnection(DBConfig.URL, DBConfig.dbUserName, DBConfig.dbPassword);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(SQLException e){
            System.out.println("¿¡·¯: " + e);
        }
		
		String sql = "SELECT * FROM review WHERE movie_id=? order by desc";
		
		pstmt=con.prepareStatement(sql);
		pstmt.setInt(1, movie_id);
		
		Vector<ReviewDTO> vector = new Vector<>();
		
		ReviewDTO reviewDTO = null;
		
		rs = pstmt.executeQuery();
		
		while (rs.next()) {
			reviewDTO.setReview_id(rs.getInt(1));
			reviewDTO.setCustomer_id(rs.getInt(2));
			reviewDTO.setScore(rs.getInt(4));
			
			vector.add(reviewDTO);
		}
		
		rs.close();
		pstmt.close();
		con.close();
		
		return vector;
	}
	
	//리뷰 아이디 주어지면 해당 리뷰 삭제 및 삭제한 평점 반환
	public static int deleteReview(int review_id) throws SQLException {
		int score = 0;
		
		try {
			Class.forName(DBConfig.driver);
			con = DriverManager.getConnection(DBConfig.URL, DBConfig.dbUserName, DBConfig.dbPassword);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(SQLException e){
            System.out.println("¿¡·¯: " + e);
        }
		
		String sqlGetScore = "SELECT score FROM review review_id=?";
		
		pstmt = con.prepareStatement(sqlGetScore);
		pstmt.setInt(1, review_id);
		rs = pstmt.executeQuery();
		
		while (rs.next()) {
			score = rs.getInt(1);
		}
		
		rs.close();
		pstmt.close();
		
		String sql = "DELETE FROM review WHERE review_id=?";
		
		pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, review_id);
		pstmt.executeQuery();
		
		con.close();
		
		return score;
	}
}