package model;

public class AuditoriumDTO {
	int theater_id;
	String auditorium_name;
	int seat_number;

	public AuditoriumDTO(int theater_id, String auditorium_name, int seat_number) {

		this.theater_id=theater_id;
		this.auditorium_name=auditorium_name;
		this.seat_number=seat_number;
		
	}

	public int getTheater_id() {
		return theater_id;
	}

	public void setTheater_id(int theater_id) {
		this.theater_id=theater_id;
	}
	
	public String getAuditorium_name() {
		return auditorium_name;
	}

	public void setAuditorium_name(String auditorium_name) {
		this.auditorium_name=auditorium_name;
	}
	
	public int getSeat_number() {
		return seat_number;
	}

	public void setSeat_number(int seat_number) {
		this.seat_number=seat_number;
	}
}