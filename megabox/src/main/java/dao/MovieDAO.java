package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.sql.Date;

import common.DBConfig;
import model.*;
import java.util.*;

public class MovieDAO {
	
	static Connection con = null;
	static PreparedStatement pstmt = null;
	static ResultSet rs = null;
	
	//영화 정보 입력
	public static void createMovie(MovieDTO movieDTO) throws SQLException {
		
		
		Date date = new Date(0);
		
		SimpleDateFormat simpledate = new SimpleDateFormat(movieDTO.getRelease_date() + "");
		
		String formatedDate = simpledate.format(date);
		
		java.sql.Date releaseDate = java.sql.Date.valueOf(formatedDate);
		
		
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
		
		String sql = "INSERT INTO movie(title, ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, movieDTO.getTitle());
			pstmt.setString(2, movieDTO.getTitle_origin());
			pstmt.setString(3, movieDTO.getThumbnail_image());
			pstmt.setDate(4, releaseDate);
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
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		pstmt.close();
		con.close();
		
	}
	
	//영화 정보 전체 조회
	public static ResultSet viewAllMovies() throws SQLException {
		try {
			Class.forName(DBConfig.driver);
			con = DriverManager.getConnection(DBConfig.URL, DBConfig.dbUserName, DBConfig.dbPassword);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(SQLException e){
            System.out.println("에러: " + e);
        }
		
		String sql = "SELECT title, title_origin, thumbnail_image, release_date, summary, type, director, genre, rating, cast, preview_url, review_count, average_score, sum_score FROM movie";
		
		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();
		
		return rs;
	}
	
	//제목으로 영화 조회
	public static ResultSet viewMovieByTitle(String title) throws SQLException {
		try {
			Class.forName(DBConfig.driver);
			con = DriverManager.getConnection(DBConfig.URL, DBConfig.dbUserName, DBConfig.dbPassword);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(SQLException e){
            System.out.println("에러: " + e);
        }
		
		String sql = "SELECT title, title_origin, thumbnail_image, release_date, summary, type, director, genre, rating, cast, preview_url, review_count, average_score, sum_score FROM movie WHERE title LIKE %?%";
		
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, title);
		rs = pstmt.executeQuery();
		
		return rs;
	}
	
	//영화 정보 수정하는 update 메소드
	public static void updateMovie(MovieDTO movieDTO) throws SQLException {
		
		Date date = new Date(0);
		
		SimpleDateFormat simpledate = new SimpleDateFormat(movieDTO.getRelease_date() + "");
		
		String formatedDate = simpledate.format(date);
		
		java.sql.Date releaseDate = java.sql.Date.valueOf(formatedDate);
		
		try {
			Class.forName(DBConfig.driver);
			con = DriverManager.getConnection(DBConfig.URL, DBConfig.dbUserName, DBConfig.dbPassword);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(SQLException e){
            System.out.println("에러: " + e);
        }
		
		String sql = "UPDATE movie SET title=?, SET title_origin=?, SET thumbnail_image=? SET release_date=?, SET summary=?, SET type=?, SET director=?, SET genre=?, SET rating=?, SET cast=?, SET preview_url=? WHERE title=?";
		
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, movieDTO.getTitle());
		pstmt.setString(2, movieDTO.getTitle_origin());
		pstmt.setString(3, movieDTO.getThumbnail_image());
		pstmt.setDate(4, releaseDate);
		pstmt.setString(5, movieDTO.getSummary());
		pstmt.setString(6, movieDTO.getType());
		pstmt.setString(7, movieDTO.getDirector());
		pstmt.setString(8, movieDTO.getGenre());
		pstmt.setInt(9, movieDTO.getRating());
		pstmt.setString(10, movieDTO.getCast());
		pstmt.setString(11, movieDTO.getPreview_url());
		pstmt.setString(12, movieDTO.getTitle());
		
		pstmt.executeUpdate();
		pstmt.close();
		con.close();
		
	}
}
