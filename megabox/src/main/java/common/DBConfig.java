package common;

import java.sql.Connection;

public class DBConfig {

	public static String driver;
	public static String dbms;
	public static String URL;
	public static String database;
	public static String dbUserName = "root";
	public static String dbPassword = "123456";

	static String driverMySQL = "com.mysql.jdbc.Driver";
	static String URLLocalMySQL = "jdbc:mysql://localhost:3305/" ;
	
	static {
		driver = driverMySQL;
		dbms = "MySQL";
		database = "megabox";
		URL = URLLocalMySQL + database;
	}
}
