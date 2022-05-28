package service;
import java.sql.SQLException;
import java.util.Vector;

import dao.AuditoriumDAO;
import model.*;

public class AuditoriumService {
	
	//상영관 추가
	public static void addAuditorium(int theater_id, String auditorium_name, int seat_number) {
		
		AuditoriumDTO auditoriumDTO = new AuditoriumDTO(theater_id, auditorium_name, seat_number);
	}
	
	//영화관번호 입력하면 해당 영화관의 모든 상영관 출력
	public static Vector viewAuditoriumByTheater(int theater_id) throws SQLException {
		Vector vc = AuditoriumDAO.readAuditoriumByTheaterID(theater_id);
		
		return vc;
	}
	
	//영화관 삭제
	public static boolean deleteAuditorium(AuditoriumDTO a) throws SQLException {
		boolean result = AuditoriumDAO.deleteAuditorium(a);
		
		//result가 false면 영화관 및에 상영시간표가 존재해 삭제 불가
		return result;
	}
}