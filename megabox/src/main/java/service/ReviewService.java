package service;
import java.sql.SQLException;

import dao.MovieDAO;

public class ReviewService {
	
	////���� ���� �־����� ��ȭ ���� ����, ��� ����, ���� �� ����
	public static void renewMovieReview(int movie_id, int score) throws SQLException {
		MovieDAO.renewMovieReview(movie_id, score);
	}
}
