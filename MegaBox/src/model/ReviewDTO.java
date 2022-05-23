package model;

public class ReviewDTO {

	int customer_id;
	int movie_id;
	int score;

	public ReviewDTO(int customer_id, int movie_id, int score) {

		this.customer_id=customer_id;
		this.movie_id=movie_id;
		this.score=score;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id=customer_id;
	}
	
	public int getMovie_id() {
		return movie_id;
	}

	public void setMovie_id(int movie_id) {
		this.movie_id=movie_id;
	}
	
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score=score;
	}
}
