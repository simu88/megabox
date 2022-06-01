package service;
import model.*;
import service.*;
import dao.*;
import model.CustomerDTO;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Vector;

public class Test {

	public static void main(String[] args) throws SQLException, UnsupportedEncodingException, NoSuchAlgorithmException, ParseException {
		
//		Vector<TheaterDTO> vc = TheaterService.viewAllTheater();
//		
//		TheaterDTO t = new TheaterDTO("");
//		for (int i = 0; i < vc.size(); i++) {
//			t = vc.get(i);
//			System.out.println(i);
//			System.out.println(t.getTheater_id());
//			System.out.println(t.getRegion());
//		}
		
		//TheaterService.deleteTheater(146);
		
		Timestamp t = StringToTimeService.transformTime("12:12:12");
		
		System.out.println(t);
		
		//TheaterService.addTheater("¼­¿ï");
		
		//CustomerDTO customerDTO = LoginService.loginProcess("admin56", "1234");
		
		//System.out.println(customerDTO.getRole());
		
		//boolean a = SignUpService.signUp("admin5", "1234", "admin@admin.com", "010-5171-1783");

}
}
