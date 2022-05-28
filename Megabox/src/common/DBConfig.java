package common;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBConfig {
	
	static  Connection con         = null;
	static  Statement stmt         = null;
	static  ResultSet rs           = null ;	

	public static String driver="com.mysql.jdbc.Driver";
	public static String URL="jdbc:mysql://localhost:3306/megabox" ;
	

	public static String dbUserName = "root";
	public static String dbPassword = "onlyroot";



}
