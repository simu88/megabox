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
	//���԰� ���� ��ȸ�� ������ �̿��ڿ� ���õ� DAO
	
	//��ü ȸ�� ��ȸ
	public static Vector readAllCutomer() throws SQLException {
		
		try {
			Class.forName(DBConfig.driver);
			con = DriverManager.getConnection(DBConfig.URL, DBConfig.dbUserName, DBConfig.dbPassword);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(SQLException e){
            System.out.println("����: " + e);
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
	
	//���̵� ����� ȸ�� ã��
	public static CustomerDTO findCustomerByID(String id) throws SQLException {
		
		try {
			Class.forName(DBConfig.driver);
			con = DriverManager.getConnection(DBConfig.URL, DBConfig.dbUserName, DBConfig.dbPassword);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(SQLException e){
            System.out.println("����: " + e);
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
	
	//ȸ������ �� ���̵� �ߺ� üũ�� ���� ����
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
	            System.out.println("����: " + e);
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
	
	//�̿��� ���� �����ϴ� update �޼ҵ�
	public static void updateCustomer(CustomerDTO customerDTO) throws SQLException {
		try {
			Class.forName(DBConfig.driver);
			con = DriverManager.getConnection(DBConfig.URL, DBConfig.dbUserName, DBConfig.dbPassword);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(SQLException e){
            System.out.println("����: " + e);
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
	
	//�α����� ���� select ���� �޼ҵ�
	public static Vector login(CustomerDTO customerDTO) throws SQLException {
		try {
			Class.forName(DBConfig.driver);
			con = DriverManager.getConnection(DBConfig.URL, DBConfig.dbUserName, DBConfig.dbPassword);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(SQLException e){
            System.out.println("����: " + e);
        }
		
		String sql = "SELECT id, password, role FROM customer WHERE id=?";
		
		Vector<CustomerDTO> vector = new Vector<>();
		
		//System.out.println(customerDTO.getID());
		
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, customerDTO.getID());
		
		rs = pstmt.executeQuery();

		
		CustomerDTO customerDTO2 = new CustomerDTO("", "", "", "", 0, 0);
		
		//�������� �ʴ� ���̵���
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
