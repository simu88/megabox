package service;

import java.sql.SQLException;
import java.time.LocalTime;
import java.util.Date;

import dao.*;
import model.*;

public class ScheduleService {
	//새 상영표 추가
	public static void addSchedule(
			int movie_id,
			int auditorium_id,
			Date date,
			LocalTime time,
			LocalTime end_time,
			int rest_seat_count
			) {
		ScheduleDTO scheduleDTO = new ScheduleDTO(movie_id,
				auditorium_id,
				date,
				time,
				end_time,
				rest_seat_count);
		
		ScheduleDAO.createSchedule(scheduleDTO);
	}
	
	//상영시간표 삭제
	public static void deleteSchedule(ScheduleDTO s) throws SQLException {
		
		ScheduleDAO.deleteSchedule(s.getSchedule_id());
		
	}
}
