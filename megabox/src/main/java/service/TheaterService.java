package service;

import model.TheaterDTO;

import java.sql.SQLException;
import java.util.Vector;

import dao.*;

public class TheaterService {
	
	//�� ��ȭ�� �߰�
	public static void addTheater(String region) {
		
		TheaterDTO theaterDTO = new TheaterDTO(region);
		
		TheaterDAO.createTheater(theaterDTO);
	}
	
	//��ȭ�� ��ü ��ȸ
	public static Vector viewAllTheater() throws SQLException {
		Vector<TheaterDTO> vc = TheaterDAO.readAllTheater();
		
		return vc;
	}
	
	public static void deleteTheater(int theater_id) throws SQLException {
		TheaterDAO.deleteTheater(theater_id);
	}
}


