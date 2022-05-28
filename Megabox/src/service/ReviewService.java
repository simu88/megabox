package service;
import java.sql.SQLException;
import java.util.Vector;

import dao.MovieDAO;
import dao.ReviewDAO;
import model.*;

public class ReviewService {
	
	//리뷰 추가
	public static void addReview(int customer_id, int movie_id, int score) throws SQLException {
		ReviewDTO reviewDTO = null;
		reviewDTO.setCustomer_id(customer_id);
		reviewDTO.setMovie_id(movie_id);
		reviewDTO.setScore(score);
		
		ReviewDAO.createReview(reviewDTO);
		
		renewMovieReview(movie_id, score);
	}
	
	//리뷰 점수 주어지면 영화 리뷰 개수, 평균 평점, 평점 합 갱신
	public static void renewMovieReview(int movie_id, int score) throws SQLException {
		MovieDAO.updateMovieReview(movie_id, score);
	}
	
	//리뷰 삭제 시 영화 리뷰 개수, 평균 평점, 평점 합 갱신
	public static void renewMovieReviewAfterDelete(int movie_id, int score) throws SQLException {
		MovieDAO.updateMovieReviewAfterDelete(movie_id, score);
	}
	
	//영화 ID 주어지면 해당 영화의 모든 리뷰 가져오기
	public static Vector viewAllReview(int movie_id) throws SQLException {
		Vector vc = ReviewDAO.readReviewByMovieID(movie_id);
		
		return vc;
	}
	
	//movie_id와 review_id 주어지면 리뷰 삭제 및 평점 갱신
	public static void deleteReview(int movie_id, int review_id) throws SQLException {
		int score = ReviewDAO.deleteReview(review_id);
		
		renewMovieReviewAfterDelete(movie_id, score);
		
	}
}