package service;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

import dao.*;
import model.*;


public class ScheduleService {
	// �깉 �긽�쁺�몴 異붽�
	public static void addSchedule(int movie_id, int auditorium_id, LocalDate date, LocalTime time, LocalTime end_time,
			int rest_seat_count) {
		ScheduleDTO scheduleDTO = new ScheduleDTO(movie_id, auditorium_id, date, time, end_time, rest_seat_count);

		ScheduleDAO.createSchedule(scheduleDTO);
	}

	// �긽�쁺�떆媛꾪몴 �궘�젣
	public static void deleteSchedule(ScheduleDTO s) throws SQLException {

		ScheduleDAO.deleteSchedule(s.getSchedule_id());

	}

}