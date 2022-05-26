package service;
import service.*;

import java.sql.SQLException;

import dao.SignUpDAO;

public class Test {

	public static void main(String[] args) throws SQLException {
		SignUpService a=new SignUpService();
		a.signUp("a", "b", "c", "d");
	}

}