package service;
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
		
		
		CustomerDTO customerDTO;
		
		customerDTO = LoginService.loginProcess("admin", "1234");
		
		System.out.println(customerDTO.getRole());

}
}
