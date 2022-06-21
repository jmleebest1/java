package collection;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.simple.JSONObject;

import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;

public class UserField {
	//회원을 저장할 자료구조 선언
	ArrayList<User> users = new ArrayList<>();
	
	//암호키
	private static final int KEY = 3;
	
	//아이디 중복검사
	//boolean보다 User타입으로 리턴하는 것이 좋다.
	public User checkId(String id) {
		User user = null;//checkId가 null이라는건 입력한 아이디가 없다는것
		for (int i = 0; i < users.size(); i++) {
			if(users.get(i).getId().equals(id)) {
				
				user = users.get(i);
				//데이터베이스에 있는 회원의 주소를 보낸다
				break;
			}
		}
		return user;
		//회원의 정보(주소)를 가져오게끔 리턴
	}
	//회원가입
	public void join(User user) {
		user.setPw(encrypt(user.getPw()));//패스워드를 암호화해서 넣는다
		users.add(user);
		//데이터베이스에 입력한 정보를 넣는다
	}
	
	//로그인(아이디랑 비밀번호를 받아서 암호화된 비밀번호끼리 비교)
	public boolean login(String id, String pw) {//id,pw를 매개변수로 받는다
		User user = checkId(id);//User객체를 통해서 checkId메소드에 보내 id를 우선 검사한다(리턴타입User)
		if(user != null) {//유저가 null이 아니면 입력한 아이디가 데이터베이스에 있다 
							//id있는 주소값에 비밀번호도 같이 있을것!
			if(user.getPw().equals(encrypt(pw))) {//equals로 문자열 비교, 즉 값을 비교해준다
				//유저의 아이디,비밀번호가 있는 주소값으로 접근해서 패스워드를 가져오고 암호화된 비밀번호와
				//같은지 비교 // (user.getPw()는 암호화가 되있는거다)
				return true;
			}
		}
		return false;
	}
	
	//암호화
	public String encrypt(String pw) {
		String en_pw = "";
		for(int i =0; i<pw.length(); i++) {
			en_pw += (char)(pw.charAt(i)*3);
		}
		return en_pw;
	}
	
	//복호화
	public String decrypt(String en_pw) {
		String de_pw = "";
		for (int i = 0; i < en_pw.length(); i++) {
			de_pw += (char)(en_pw.charAt(i) / 3);
		}
		return de_pw;
	}
	
	//비밀번호 찾기(이름과 핸드폰 번호로 찾기, SMS로 비밀번호 전송)
	public boolean findPw(String name, String phoneNumber) {
		for (int i = 0; i < users.size(); i++) {
			boolean checkName = users.get(i).getName().equals(name);
			//이름, 핸드폰 둘 다 true여야 하므로 유저들의 이름을 먼저 비교해준다 (getName()은 데이터베이스에 있는 정보, name은 사용자가 입력한 정보)
			boolean checkPhoneNumber = users.get(i).getPhone().equals(phoneNumber);
			//마찬가지로 핸드폰 번호도 비교해준다
			if(checkName && checkPhoneNumber) {
				//이름과 폰번호 둘 다 참이면 문자 발송
				sendSMS(phoneNumber, decrypt(users.get(i).getPw()));
												//암호화된 패스워드를 복호화해서 전송한다
				return true;
			}
		}
		return false;
	}
	
	//SMS
	public void sendSMS(String phoneNumber, String pw) {
		String api_key = "NCS6JPJHXZSKSYWS";
	    String api_secret = "2FUBP2NBZXPBD3XUCLDVZYSKHBSP6YTD";
	    Message coolsms = new Message(api_key, api_secret);

	    // 4 params(to, from, type, text) are mandatory. must be filled
	    HashMap<String, String> params = new HashMap<String, String>();
	    params.put("to", phoneNumber);
	    params.put("from", "01089087253");
	    params.put("type", "SMS");
	    params.put("text", pw);
	    params.put("app_version", "test app 2.2"); // application name and version

	    try {
	      JSONObject obj = (JSONObject) coolsms.send(params);
	      System.out.println(obj.toString());
	    } catch (CoolsmsException e) {
	      System.out.println(e.getMessage());
	      System.out.println(e.getCode());
	    } //자동임포트 Ctrl+Shift+O
	}
	
}









