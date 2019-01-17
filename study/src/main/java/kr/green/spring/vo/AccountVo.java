package kr.green.spring.vo;

import java.sql.Date;
// DB정보
public class AccountVo {
	private String Id;
	private String pw;
	private String email;
	private String gender;
	private String authority;
	private Date registered_data;
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	public Date getRegistered_data() {
		return registered_data;
	}
	public void setRegistered_data(Date registered_data) {
		this.registered_data = registered_data;
	}
	
	@Override
	public String toString() {
		return "AccountVo [Id=" + Id + ", pw=" + pw + ", email=" + email + ", gender=" + gender + ", authority="
				+ authority + ", registered_data=" + registered_data + "]";
	}
	
	
}
