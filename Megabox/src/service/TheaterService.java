package service;

import model.TheaterDTO;

import java.sql.SQLException;
import java.util.Vector;

import dao.*;

public class TheaterService {
	
	//새 영화관 추가
	public static void addTheater(String region) {
		
		TheaterDTO theaterDTO = new TheaterDTO(region);
		
		TheaterDAO.createTheater(theaterDTO);
	}
	
	//영화관 전체 조회
	public static Vector viewAllTheater() throws SQLException {
		Vector vc = TheaterDAO.readAllTheater();
		
		return vc;
	}
}