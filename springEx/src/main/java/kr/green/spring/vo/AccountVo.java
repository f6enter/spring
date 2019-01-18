package kr.green.spring.vo;

public class AccountVo {
	private String Id;
	private String pw;
	private String name;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "AccountVo [Id=" + Id + ", pw=" + pw + ", name=" + name + "]";
	}
	
	
}
