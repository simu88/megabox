package model;

import java.util.*;

public class MovieDTO {

	String title;
	String title_origin;
	String thumbnail_image;
	Date release_date;
	String summary;
	String type;
	String director;
	String genre;
	int rating;
	String cast;
	String preview_url;
	int review_count;
	double average_score;
	int sum_score;

	public MovieDTO(String title, String title_origin, String thumbnail_image, Date release_date, String summary,
			String type, String director, String genre, int rating, String cast, String preview_url, int review_count,
			double average_score, int sum_score)
	{
		this.title=title;
		this.title_origin=title_origin;
		this.thumbnail_image=thumbnail_image;
		this.release_date=release_date;
		this.summary=summary;
		this.type=type;
		this.director=director;
		this.genre=genre;
		this.rating=rating;
		this.cast=cast;
		this.preview_url=preview_url;
		this.review_count=review_count;
		this.average_score=average_score;
		this.sum_score=sum_score;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title=title;
	}
	
	public String getTitle_origin() {
		return title_origin;
	}
	public void setTitle_origin(String title_origin) {
		this.title_origin=title_origin;
	}

	public String getThumbnail_image() {
		return thumbnail_image;
	}
	public void setThumbnail_image(String thumbnail_image) {
		this.thumbnail_image=thumbnail_image;
	}
	
	public Date getRelease_date() {
		return release_date;
	}
	public void setRelease_date(Date release_date) {
		this.release_date=release_date;
	}
	
	public String getSummary() {
		return summary;
	}
	public void setSummary(String Sumamry) {
		this.summary=summary;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type=type;
	}
	
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director=director;
	}
	
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre=genre;
	}
	
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating=rating;
	}
	
	public String getCast() {
		return cast;
	}
	public void setCast(String cast) {
		this.cast=cast;
	}
	
	public String getPreview_url() {
		return preview_url;
	}
	public void setPreview_url(String preview_url) {
		this.preview_url=preview_url;
	}
	
	public int getReview_count() {
		return review_count;
	}
	public void setReview_count(int review_count) {
		this.review_count=review_count;
	}
	
	public double getAverage_score() {
		return average_score;
	}
	public void setAverage_score(double average_score) {
		this.average_score=average_score; 
	}
	
	public int getSum_score() {
		return sum_score;
	}
	public void setSum_score(int sum_score) {
		this.sum_score=sum_score;
	}	
	

}
