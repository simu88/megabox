package service;
import model.*;
import service.*;
import dao.*;
import model.CustomerDTO;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class Test {

	public static void main(String[] args) throws SQLException, UnsupportedEncodingException, NoSuchAlgorithmException {
		
		
		CustomerDTO customerDTO = LoginService.loginProcess("admin56", "1234");
		
		System.out.println(customerDTO.getRole());
		
		//boolean a = SignUpService.signUp("admin5", "1234", "admin@admin.com", "010-5171-1783");

}
}
