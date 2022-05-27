package service;
import java.sql.SQLException;
import java.util.Vector;

import dao.MovieDAO;
import dao.ReviewDAO;
import model.*;

public class ReviewService {
	
	//���� �߰�
	public static void addReview(int customer_id, int movie_id, int score) throws SQLException {
		ReviewDTO reviewDTO = null;
		reviewDTO.setCustomer_id(customer_id);
		reviewDTO.setMovie_id(movie_id);
		reviewDTO.setScore(score);
		
		ReviewDAO.createReview(reviewDTO);
		
		renewMovieReview(movie_id, score);
	}
	
	//���� ���� �־����� ��ȭ ���� ����, ��� ����, ���� �� ����
	public static void renewMovieReview(int movie_id, int score) throws SQLException {
		MovieDAO.updateMovieReview(movie_id, score);
	}
	
	//���� ���� �� ��ȭ ���� ����, ��� ����, ���� �� ����
	public static void renewMovieReviewAfterDelete(int movie_id, int score) throws SQLException {
		MovieDAO.updateMovieReviewAfterDelete(movie_id, score);
	}
	
	//��ȭ ID �־����� �ش� ��ȭ�� ��� ���� ��������
	public static Vector viewAllReview(int movie_id) throws SQLException {
		Vector vc = ReviewDAO.readReviewByMovieID(movie_id);
		
		return vc;
	}
	
	//movie_id�� review_id �־����� ���� ���� �� ���� ����
	public static void deleteReview(int movie_id, int review_id) throws SQLException {
		int score = ReviewDAO.deleteReview(review_id);
		
		renewMovieReviewAfterDelete(movie_id, score);
		
	}
}
