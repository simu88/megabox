package service;

import model.TheaterDTO;
import dao.*;

public class TheaterService {
	
	//�� ��ȭ�� �߰�
	public static void addTheater(String region) {
		
		TheaterDTO theaterDTO = new TheaterDTO(region);
		
		TheaterDAO.createTheater(theaterDTO);
	}
}
