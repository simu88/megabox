package service;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import dao.*;
import model.*;

public class MovieService {

	//새로운 영화 추가
	public static void addNewMovie(String title,
	String title_origin,
	String thumbnail_image,
	Date release_date,
	String summary,
	String type,
	String director,
	String genre,
	int rating,
	String cast,
	String preview_url) throws SQLException {
		MovieDTO movieDTO = new MovieDTO(title, title_origin, thumbnail_image, release_date, summary,
				type, director, genre, rating, cast, preview_url, 0,
				0, 0);
		
		MovieDAO.createMovie(movieDTO);
	}
	
	//영화 정보 전체 조회
	public static ResultSet viewAllMovies() throws SQLException {
		ResultSet rs = MovieDAO.readAllMovies();
		
		return rs;
	}
	
	//제목으로 영화 검색해서 조회
	public static ResultSet viewMovieByTitle(String title) throws SQLException {
		ResultSet rs = MovieDAO.readMovieByTitle(title);
		
		return rs;
	}
	
	//영화 정보 수정
	public static void modifyMovie(
			String title,
			String title_origin,
			String thumbnail_image,
			Date release_date,
			String summary,
			String type,
			String director,
			String genre,
			int rating,
			String cast,
			String preview_url,
			int review_count,
			double average_score,
			int sum_score
			) throws SQLException {	
		
		MovieDTO movieDTO = new MovieDTO(title, title_origin, thumbnail_image, release_date, summary,
				type, director, genre, rating, cast, preview_url, review_count,
				average_score, sum_score);
		
		MovieDAO.updateMovie(movieDTO);
	}
}
