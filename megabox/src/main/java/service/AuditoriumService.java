package service;
import dao.AuditoriumDAO;
import model.*;

public class AuditoriumService {
	
	//�󿵰� �߰�
	public static void addAuditorium(int theater_id, String auditorium_name, int seat_number) {
		
		AuditoriumDTO auditoriumDTO = new AuditoriumDTO(theater_id, auditorium_name, seat_number);
	}
}
