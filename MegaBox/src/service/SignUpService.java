package service;
import java.sql.SQLException;

import dao.*;
import model.CustomerDTO;
import model.*;

//회원가입 처리 모듈
public class SignUpService {
	public void signUp(String ID, String password, String email, String phone) {
		//CustomerDTO 객체 생성
		CustomerDTO customerDTO = new CustomerDTO(ID, PasswordEncryptService.passwordEncrypt(password), email, phone, 1, 0);
		
		//DAO 메소드에 DTO getter 메소드로 값 입력
		try {
			SignUpDAO.register(customerDTO.getID(), customerDTO.getPassword(), customerDTO.getEmail(), customerDTO.getEmail(), customerDTO.getRole(), customerDTO.getReview_count());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}