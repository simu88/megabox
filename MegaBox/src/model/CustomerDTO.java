package model;

public class CustomerDTO {

	private String ID;
	private String password;
	private String email;
	private String phone;
	private int role;
	private int review_count;
	
	public CustomerDTO(String ID, String password, String email, String phone, int role, int review_count) {
		this.ID=ID;
		this.password=password;
		this.email=email;
		this.phone=phone;
		this.role=role;
		this.review_count=review_count;
	}
	
	public String getID() {
		return ID;
	}
	public void setID(String ID) {
		this.ID=ID;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password=password;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email=email;
	}
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone=phone;
	}
	
	public int getRole() {
		return role;
	}
	
	public void setRole(int role) {
		this.role=role;
	}
	
	public int getReview_count() {
		return review_count;
	}
	public void setReview_count(int review_count) {
		this.review_count=review_count;
	}
	
	//public void doBankerWork() {};  // 이 메소드는 오버라이딩될 매소드임}
}
