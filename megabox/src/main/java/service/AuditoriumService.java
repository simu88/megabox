package service;
import java.sql.SQLException;
import java.util.Vector;

import dao.AuditoriumDAO;
import model.*;

public class AuditoriumService {
	
	//�󿵰� �߰�
	public static void addAuditorium(int theater_id, String auditorium_name, int seat_number) throws SQLException {
			
		AuditoriumDTO auditoriumDTO = new AuditoriumDTO(theater_id, auditorium_name, seat_number);
		
		AuditoriumDAO.createAuditorium(auditoriumDTO);
	}
	
	//��ȭ����ȣ �Է��ϸ� �ش� ��ȭ���� ��� �󿵰� ���
	public static Vector viewAuditoriumByTheater(int theater_id) throws SQLException {
		Vector<AuditoriumDTO> vc = AuditoriumDAO.readAuditoriumByTheaterID(theater_id);
		
		return vc;
	}
	
	//�󿵰� ����
	public static boolean deleteAuditorium(AuditoriumDTO a) throws SQLException {
		boolean result = AuditoriumDAO.deleteAuditorium(a);
		
		//result�� false�� ��ȭ�� �׿� �󿵽ð�ǥ�� ������ ���� �Ұ�
		return result;
	}
}
