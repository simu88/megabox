package dao;

import model.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import common.DBConfig;

public class CustomerDAO {
	
	static Connection con = null;
	static PreparedStatement pstmt = null;
	static ResultSet rs = null;
	//가입과 권한 조회를 제외한 이용자와 관련된 DAO
	
	//전체 회원 조회
	public static Vector readAllCutomer() throws SQLException {
		
		try {
			Class.forName(DBConfig.driver);
			con = DriverManager.getConnection(DBConfig.URL, DBConfig.dbUserName, DBConfig.dbPassword);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(SQLException e){
            System.out.println("에러: " + e);
        }
		
		String sql = "SELECT id, email, phone, role, review_count FROM customer";
		
		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();
		

		
		Vector<CustomerDTO> vector = new Vector<>();
		
		CustomerDTO customerDTO = null;
		
		while (rs.next()) {
			customerDTO.setID(rs.getString(1));
			customerDTO.setEmail(rs.getString(2));
			customerDTO.setPhone(rs.getString(3));
			customerDTO.setRole(rs.getInt(4));
			customerDTO.setReview_count(rs.getInt(5));
			
			vector.add(customerDTO);
		}
		
		pstmt.close();
		con.close();
		rs.close();
		
		return vector;
	}
	
	//아이디 사용해 회원 찾기
	public static CustomerDTO findCustomerByID(String id) throws SQLException {
		
		try {
			Class.forName(DBConfig.driver);
			con = DriverManager.getConnection(DBConfig.URL, DBConfig.dbUserName, DBConfig.dbPassword);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(SQLException e){
            System.out.println("에러: " + e);
        }
		
		String sql = "SELECT id, email, phone, role, review_count FROM customer WHERE id=?";
		
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, id);
		rs = pstmt.executeQuery();
		
		CustomerDTO customerDTO = new CustomerDTO("", "", "", "", 0, 0);
		
		while (rs.next() ) {
			customerDTO.setID(rs.getString(1));
			customerDTO.setEmail(rs.getString(2));
			customerDTO.setPhone(rs.getString(3));
			customerDTO.setRole(rs.getInt(4));
			customerDTO.setReview_count(rs.getInt(5));
		}
		
		pstmt.close();
		con.close();
		
		return customerDTO;
	}
	
	//회원가입 시 아이디 중복 체크를 위한 로직
	public static Vector checkID(String id) throws SQLException {
		//Class.forName(DBConfig.driver);
		//con = DriverManager.getConnection(DBConfig.URL, DBConfig.dbUserName, DBConfig.dbPassword);
			try {
				Class.forName(DBConfig.driver);
				con = DriverManager.getConnection(DBConfig.URL, DBConfig.dbUserName, DBConfig.dbPassword);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch(SQLException e){
	            System.out.println("에러: " + e);
	        }
			
			Vector<Integer> vector = new Vector<>();
			
			String sql = "SELECT COUNT(*) FROM customer where id =?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			
			while (rs.next()) {
				vector.add(rs.getInt(1));
			}
			
			pstmt.close();
			con.close();
			rs.close();
			
			return vector;
			
	}
	
	//이용자 정보 수정하는 update 메소드
	public static void updateCustomer(CustomerDTO customerDTO) throws SQLException {
		try {
			Class.forName(DBConfig.driver);
			con = DriverManager.getConnection(DBConfig.URL, DBConfig.dbUserName, DBConfig.dbPassword);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(SQLException e){
            System.out.println("에러: " + e);
        }
		
		String sql = "UPDATE customer SET password=?, SET email=?, SET phone=? WHERE id=?";
		
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, customerDTO.getPassword());
		pstmt.setString(2, customerDTO.getEmail());
		pstmt.setString(3, customerDTO.getPhone());
		pstmt.setString(4, customerDTO.getID());
		pstmt.executeUpdate();
		
		
		pstmt.close();
		con.close();
		

		
	}
	
	//로그인을 위한 select 쿼리 메소드
	public static Vector login(CustomerDTO customerDTO) throws SQLException {
		try {
			Class.forName(DBConfig.driver);
			con = DriverManager.getConnection(DBConfig.URL, DBConfig.dbUserName, DBConfig.dbPassword);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(SQLException e){
            System.out.println("에러: " + e);
        }
		
		String sql = "SELECT id, password, role FROM customer WHERE id=?";
		
		Vector<CustomerDTO> vector = new Vector<>();
		
		//System.out.println(customerDTO.getID());
		
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, customerDTO.getID());
		
		rs = pstmt.executeQuery();

		
		CustomerDTO customerDTO2 = new CustomerDTO("", "", "", "", 0, 0);
		
		//존재하지 않는 아이디라면
//		if (rs.next() == false) {
//			customerDTO2.setID(customerDTO.getID());
//			customerDTO2.setRole(4);
//			vector.add(customerDTO2);
//		}
		
		while (rs.next()) {	
			customerDTO2.setID(rs.getString(1));
			customerDTO2.setPassword(rs.getString(2));
			customerDTO2.setRole(rs.getInt(3));
			
			vector.add(customerDTO2);
		}
			
		pstmt.close();
		con.close();
		rs.close();
		
		return vector;
		
		
	}

}
