package service;
import java.sql.SQLException;

import dao.MovieDAO;

public class ReviewService {
	
	////리뷰 점수 주어지면 영화 리뷰 개수, 평균 평점, 평점 합 갱신
	public static void renewMovieReview(int movie_id, int score) throws SQLException {
		MovieDAO.renewMovieReview(movie_id, score);
	}
}
