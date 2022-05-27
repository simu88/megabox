package service;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Vector;

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
	public static Vector viewAllMovies() throws SQLException {
		Vector vc = MovieDAO.readAllMovies();
		
		return vc;
	}
	
	//제목으로 영화 검색해서 조회
	public static Vector viewMovieByTitle(String title) throws SQLException {
		Vector vc = MovieDAO.readMovieByTitle(title);
		
		return vc;
	}
	
	//특정 영화 개수 내림차순으로 가져오기
	public static Vector viewMovieLimit(int start, int end) throws SQLException {
		//start 행부터 limit개를 가져옴. 처음부터 가져올 경우 start는 0
		Vector vc = MovieDAO.readMovieBylimit(start, end);
		
		return vc;
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
