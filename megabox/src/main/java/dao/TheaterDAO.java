package dao;
import java.sql.*;
import model.*;
import common.*;
public class TheaterDAO {

	public static void createTheater(TheaterDTO theaterDTO) {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			Class.forName(DBConfig.driver);
			con = DriverManager.getConnection(DBConfig.URL, DBConfig.dbUserName, DBConfig.dbPassword);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(SQLException e){
            System.out.println("¿¡·¯: " + e);
        }
		
		String sql="insert into theater(region) values(?);";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, theaterDTO.getRegion());
			int cnt=pstmt.executeUpdate();
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	
		
	}
}