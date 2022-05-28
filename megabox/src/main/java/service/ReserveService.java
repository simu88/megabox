package service;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.*;

import dao.*;
import model.*;

public class ReserveService {

	//새 예매 추가
	public static void addReserve(
			int customer_id, int schedule_id, Date date, 
			String credit_card, String payment_type, LocalDateTime reserve_time,
			int customer_count, int price_sum
			) throws SQLException {
		ReserveDTO reserveDTO = new ReserveDTO(customer_id, schedule_id, date, 
				credit_card, payment_type, reserve_time,
				customer_count, price_sum);
		
		int restSeat = ScheduleDAO.countRestSeat(schedule_id);
		
		//만약 잔여 좌석 수가 고객 수보다 크거나 같으면
		if (restSeat >= customer_count) {
			//예약한 다음 상영표에서 잔여 좌석을 고객 수만큼 뺌
			ReserveDAO.createReserve(reserveDTO);
			ScheduleDAO.updateRestSeat(schedule_id, customer_count);
		}

	}
	
	//회원이나 관리자가 개별 예매 취소
	public static void deleteReserve(ReserveDTO r) throws SQLException {
		//상영시간표의 잔여 좌석 수를 구함
		int customerCount = ScheduleDAO.countRestSeat(r.getSchedule_id());
		
		ReserveDAO.deleteReserve(r, customerCount);
	}
}
