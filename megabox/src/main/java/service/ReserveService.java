package service;

import java.sql.Date;
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
			) {
		ReserveDTO reserveDTO = new ReserveDTO(customer_id, schedule_id, date, 
				credit_card, payment_type, reserve_time,
				customer_count, price_sum);
		
		ReserveDAO.createReserve(reserveDTO);
	}
}
