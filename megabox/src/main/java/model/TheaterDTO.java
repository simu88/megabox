package model;

public class TheaterDTO {

	int theater_id;
	String region;
	
	public TheaterDTO(String region) {
		this.region=region;
	}
	
	public int getTheater_id() {
		return theater_id;
	}
	
	public String getRegion() {
		return region;
	}
	
	public void setRegion(String region) {
		this.region=region;
	}
	
	public void setTheater_id(int id) {
		this.theater_id = id;
	}
}