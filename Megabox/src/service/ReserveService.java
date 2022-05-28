package service;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

import dao.*;
import model.*;

public class ReserveService {

	//�깉 �삁留� 異붽�
	public static void addReserve(
			int customer_id, int schedule_id, LocalDate date, 
			String credit_card, String payment_type, LocalDateTime reserve_time,
			int customer_count, int price_sum
			) throws SQLException {
		ReserveDTO reserveDTO = new ReserveDTO(customer_id, schedule_id, date, 
				credit_card, payment_type, reserve_time,
				customer_count, price_sum);
		
		int restSeat = ScheduleDAO.countRestSeat(schedule_id);
		
		//留뚯빟 �옍�뿬 醫뚯꽍 �닔媛� 怨좉컼 �닔蹂대떎 �겕嫄곕굹 媛숈쑝硫�
		if (restSeat >= customer_count) {
			//�삁�빟�븳 �떎�쓬 �긽�쁺�몴�뿉�꽌 �옍�뿬 醫뚯꽍�쓣 怨좉컼 �닔留뚰겮 類�
			ReserveDAO.createReserve(reserveDTO);
			ScheduleDAO.updateRestSeat(schedule_id, customer_count);
		}

	}
	
	//�쉶�썝�씠�굹 愿�由ъ옄媛� 媛쒕퀎 �삁留� 痍⑥냼
	public static void deleteReserve(ReserveDTO r) throws SQLException {
		//�긽�쁺�떆媛꾪몴�쓽 �옍�뿬 醫뚯꽍 �닔瑜� 援ы븿
		int customerCount = ScheduleDAO.countRestSeat(r.getSchedule_id());
		
		ReserveDAO.deleteReserve(r, customerCount);
	}
}