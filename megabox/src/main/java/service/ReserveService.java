package service;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.*;

import dao.*;
import model.*;

public class ReserveService {

	//�� ���� �߰�
	public static void addReserve(
			int customer_id, int schedule_id, Date date, 
			String credit_card, String payment_type, LocalDateTime reserve_time,
			int customer_count, int price_sum
			) throws SQLException {
		ReserveDTO reserveDTO = new ReserveDTO(customer_id, schedule_id, date, 
				credit_card, payment_type, reserve_time,
				customer_count, price_sum);
		
		int restSeat = ScheduleDAO.countRestSeat(schedule_id);
		
		//���� �ܿ� �¼� ���� �� ������ ũ�ų� ������
		if (restSeat >= customer_count) {
			//������ ���� ��ǥ���� �ܿ� �¼��� �� ����ŭ ��
			ReserveDAO.createReserve(reserveDTO);
			ScheduleDAO.updateRestSeat(schedule_id, customer_count);
		}

	}
	
	//ȸ���̳� �����ڰ� ���� ���� ���
	public static void deleteReserve(ReserveDTO r) throws SQLException {
		//�󿵽ð�ǥ�� �ܿ� �¼� ���� ����
		int customerCount = ScheduleDAO.countRestSeat(r.getSchedule_id());
		
		ReserveDAO.deleteReserve(r, customerCount);
	}
}
