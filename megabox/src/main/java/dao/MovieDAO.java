package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import common.DBConfig;
import model.*;
import java.util.*;

public class MovieDAO {
	public static void createMovie(MovieDTO movieDTO) {
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
		
		String sql = "INSERT INTO movie VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		pstmt = con.prepareStatement(sql);
		
		pstmt.setString(1, movieDTO.getTitle());
		pstmt.setString(2, movieDTO.getTitle_origin());
		pstmt.setString(3, movieDTO.getThumbnail_image());
		pstmt.setDate(4, movieDTO.getRelease_date());
		pstmt.setString(5, movieDTO.getSummary());
		pstmt.setString(6, movieDTO.getType());
		pstmt.setString(7, movieDTO.getDirector());
		pstmt.setString(8, movieDTO.getGenre());
		pstmt.setInt(9, movieDTO.getRating());
		pstmt.setString(10, movieDTO.getCast());
		pstmt.setString(11, movieDTO.getPreview_url());
		pstmt.setInt(12, movieDTO.getReview_count());
		pstmt.setInt(14, movieDTO.getSum_score());
		
		pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
		
	}
}
