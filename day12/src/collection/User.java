package collection;

public class User {
	// 접근자는 모두 private으로 한다.
	// 이름
	// 아이디
	// 비밀번호
	// 휴대폰 번호
	
	private String name;
	private String id;
	private String pw;
	private String phone;
	//전역변수 선언
	
	public User() {;}
	//기본생성자
	
	//게터 세터 생성
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	}
	
	

