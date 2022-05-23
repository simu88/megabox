package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import common.*;

public class GetRoleDAO {

	static  Connection con         = null;
    static  Statement stmt         = null;
    static  ResultSet rs           = null ;
	
	public static int getRole() {
/*		try {
			Class.forName(DBConfig.driver);
			con = DriverManager.getConnection(DBConfig.URL, DBConfig.dbUserName, DBConfig.dbPassword);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(SQLException e){
            System.out.println("¿¡·¯: " + e);
        }*/
		
		try {
			Class.forName(DBConfig.driver);
			System.out.println("드라이버 적재 성공");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("드라이버 적재 실패");
		}
		
		try {
			con=DriverManager.getConnection(DBConfig.URL, DBConfig.dbUserName, DBConfig.dbPassword);
			System.out.println("데이터페이스 연결 성공");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("데이터페이스 연결 실패");
			e.printStackTrace();
		}
		
		return 1;
	}
	
	
	
}