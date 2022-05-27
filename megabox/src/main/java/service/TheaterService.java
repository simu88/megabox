package service;

import model.TheaterDTO;
import dao.*;

public class TheaterService {
	
	//새 영화관 추가
	public static void addTheater(String region) {
		
		TheaterDTO theaterDTO = new TheaterDTO(region);
		
		TheaterDAO.createTheater(theaterDTO);
	}
}
