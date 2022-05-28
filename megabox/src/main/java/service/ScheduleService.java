package service;

import java.sql.SQLException;
import java.time.LocalTime;
import java.util.Date;

import dao.*;
import model.*;

public class ScheduleService {
	//�� ��ǥ �߰�
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
	
	//�󿵽ð�ǥ ����
	public static void deleteSchedule(ScheduleDTO s) throws SQLException {
		
		ScheduleDAO.deleteSchedule(s.getSchedule_id());
		
	}
}
