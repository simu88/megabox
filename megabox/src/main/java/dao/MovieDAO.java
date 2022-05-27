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
	
	//영화 정보 전체 내림차순 조회
	public static Vector readAllMovies() throws SQLException {
		try {
			Class.forName(DBConfig.driver);
			con = DriverManager.getConnection(DBConfig.URL, DBConfig.dbUserName, DBConfig.dbPassword);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(SQLException e){
            System.out.println("에러: " + e);
        }
		
		String sql = "SELECT movie_id, title, title_origin, thumbnail_image, release_date, summary, type, director, genre, rating, cast, preview_url, review_count, average_score, sum_score FROM movie order by movie_id desc";
		
		Vector<MovieDTO> vector = new Vector<>();
		
		MovieDTO movieDTO = null;
		
		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();
		
		while (rs.next()) {
			movieDTO.setMovie_id(rs.getInt(1));
			movieDTO.setTitle(rs.getString(2));
			movieDTO.setTitle_origin(rs.getString(3));
			movieDTO.setThumbnail_image(rs.getString(4));
			movieDTO.setRelease_date(rs.getDate(5));
			movieDTO.setSummary(rs.getString(6));
			movieDTO.setType(rs.getString(7));
			movieDTO.setDirector(rs.getString(8));
			movieDTO.setGenre(rs.getString(9));
			movieDTO.setRating(rs.getInt(10));
			movieDTO.setCast(rs.getString(11));
			movieDTO.setPreview_url(rs.getString(12));
			movieDTO.setReview_count(rs.getInt(13));
			movieDTO.setAverage_score(rs.getDouble(14));
			movieDTO.setSum_score(rs.getInt(15));
			
			vector.add(movieDTO);
		}
				
		pstmt.close();
		con.close();
		rs.close();
		
		return vector;
	}
	
	//제목으로 영화 조회
	public static Vector readMovieByTitle(String title) throws SQLException {
		try {
			Class.forName(DBConfig.driver);
			con = DriverManager.getConnection(DBConfig.URL, DBConfig.dbUserName, DBConfig.dbPassword);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(SQLException e){
            System.out.println("에러: " + e);
        }
		
		String sql = "SELECT movie_id, title, title_origin, thumbnail_image, release_date, summary, type, director, genre, rating, cast, preview_url, review_count, average_score, sum_score FROM movie WHERE title LIKE %?%";
		
		Vector<MovieDTO> vector = new Vector<>();
		
		MovieDTO movieDTO = null;
		
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, title);
		rs = pstmt.executeQuery();
		
		while (rs.next()) {
			movieDTO.setMovie_id(rs.getInt(1));
			movieDTO.setTitle(rs.getString(2));
			movieDTO.setTitle_origin(rs.getString(3));
			movieDTO.setThumbnail_image(rs.getString(4));
			movieDTO.setRelease_date(rs.getDate(5));
			movieDTO.setSummary(rs.getString(6));
			movieDTO.setType(rs.getString(7));
			movieDTO.setDirector(rs.getString(8));
			movieDTO.setGenre(rs.getString(9));
			movieDTO.setRating(rs.getInt(10));
			movieDTO.setCast(rs.getString(11));
			movieDTO.setPreview_url(rs.getString(12));
			movieDTO.setReview_count(rs.getInt(13));
			movieDTO.setAverage_score(rs.getDouble(14));
			movieDTO.setSum_score(rs.getInt(15));
			
			vector.add(movieDTO);
		}
		
		pstmt.close();
		con.close();
		rs.close();
		
		return vector;
	}
	
	//특정 영화 개수 내림차순으로 가져오기
	public static Vector readMovieBylimit(int start, int limit) throws SQLException {
		//start 행부터 limit개를 가져옴. 처음부터 가져올 경우 start는 0
		try {
			Class.forName(DBConfig.driver);
			con = DriverManager.getConnection(DBConfig.URL, DBConfig.dbUserName, DBConfig.dbPassword);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(SQLException e){
            System.out.println("에러: " + e);
        }
		
		
		String sql = "SELECT movie_id, title, title_origin, thumbnail_image, release_date, summary, type, director, genre, rating, cast, preview_url, review_count, average_score, sum_score FROM movie order by movie_id desc LIMIT ?, ?";
	
		Vector<MovieDTO> vector = new Vector<>();
		
		MovieDTO movieDTO = null;
		
		pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, start);
		pstmt.setInt(2, limit);
		rs = pstmt.executeQuery();
		
		while (rs.next()) {
			movieDTO.setMovie_id(rs.getInt(1));
			movieDTO.setTitle(rs.getString(2));
			movieDTO.setTitle_origin(rs.getString(3));
			movieDTO.setThumbnail_image(rs.getString(4));
			movieDTO.setRelease_date(rs.getDate(5));
			movieDTO.setSummary(rs.getString(6));
			movieDTO.setType(rs.getString(7));
			movieDTO.setDirector(rs.getString(8));
			movieDTO.setGenre(rs.getString(9));
			movieDTO.setRating(rs.getInt(10));
			movieDTO.setCast(rs.getString(11));
			movieDTO.setPreview_url(rs.getString(12));
			movieDTO.setReview_count(rs.getInt(13));
			movieDTO.setAverage_score(rs.getDouble(14));
			movieDTO.setSum_score(rs.getInt(15));
			
			vector.add(movieDTO);
		}
		
		pstmt.close();
		con.close();
		rs.close();
		
		return vector;
	
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
		
		String sql = "UPDATE movie SET title=?, SET title_origin=?, SET thumbnail_image=? SET release_date=?, SET summary=?, SET type=?, SET director=?, SET genre=?, SET rating=?, SET cast=?, SET preview_url=?, SET review_count=?, SET average_score=?, SET sum_score=? WHERE title=?";
		
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
		pstmt.setDouble(13, movieDTO.getAverage_score());
		pstmt.setInt(14, movieDTO.getSum_score());
		pstmt.setString(15, movieDTO.getTitle());
		
		pstmt.executeUpdate();
		pstmt.close();
		con.close();
		
	}
}
