package model;

import java.time.LocalTime;
import java.util.*;

public class ScheduleDTO {

	int movie_id;
	int auditorium_id;
	Date date;
	LocalTime time;
	LocalTime end_time;
	int rest_seat_count;

	public ScheduleDTO(int movie_id, int auditorium_id, Date date, LocalTime time, LocalTime end_time, int rest_seat_count) {

		this.movie_id=movie_id;
		this.auditorium_id=auditorium_id;
		this.date=date;
		this.time=time;
		this.end_time=end_time;
		this.rest_seat_count=rest_seat_count;

	}

	public int getMovie_id() {
		return movie_id;
	}

	public void setMovie_id() {
		this.movie_id=movie_id;
	}
	
	public int getAuditorium_id() {
		return auditorium_id;
	}

	public void setAuditorium_id(int auditorium_id) {
		this.auditorium_id=auditorium_id;
	}
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date=date;
	}
	
	public LocalTime getTime() {
		return time;
	}

	public void setLocalTime(LocalTime time) {
		this.time=time;
	}
	
	public LocalTime getEnd_time() {
		return end_time;
	}

	public void setEnd_time(LocalTime end_time) {
		this.end_time=end_time;
	}
	
	public int getRest_seat_count() {
		return rest_seat_count;
	}

	public void setRest_seat_count(int rest_seat_count) {
		this.rest_seat_count=rest_seat_count;
	}
	
	
}
