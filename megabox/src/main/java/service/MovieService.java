package service;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Vector;

import dao.*;
import model.*;

public class MovieService {

	//���ο� ��ȭ �߰�
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
	
	//��ȭ ���� ��ü ��ȸ
	public static Vector viewAllMovies() throws SQLException {
		Vector vc = MovieDAO.readAllMovies();
		
		return vc;
	}
	
	//�������� ��ȭ �˻��ؼ� ��ȸ
	public static Vector viewMovieByTitle(String title) throws SQLException {
		Vector vc = MovieDAO.readMovieByTitle(title);
		
		return vc;
	}
	
	//Ư�� ��ȭ ���� ������������ ��������
	public static Vector viewMovieLimit(int start, int end) throws SQLException {
		//start ����� limit���� ������. ó������ ������ ��� start�� 0
		Vector vc = MovieDAO.readMovieBylimit(start, end);
		
		return vc;
	}
	
	//��ȭ ���� ����
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
