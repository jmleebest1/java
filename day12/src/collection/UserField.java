package collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import org.json.simple.JSONObject;

import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;

public class UserField {
	//회원을 저장할 자료구조 선언
	private ArrayList<User> users = new ArrayList<User>();
	
	
	//암호키
			private static final int KEY=3;
	
//	private UserField(String name) {
//	
//	}
	//아이디 중복검사
			public User checkId(String id) {
				User user=null;
				for(int i=0; i<users.size();i++) {
					//전체 회원에서 id를 검사해야 하므로 반복
					if(users.get(i).getId().equals(id)) {
						//users의 get i번째 방에 getid가 전달받은 id랑 같으면 그 아이디를 갖고 있는 회원이 있다는거니까
						user=users.get(i);
						//그 회원을 user에 넣어주고
						break;
					}
				}
				return user;
			}//끝
	
	//회원가입
	public void join(User user) {//외부에서 입력받은 데이터를 객체로 받아오고
		//이걸 그냥 그대로 넣으면 된다
		user.setPw(encrypt(user.getPw()));  
		//패스워드를 암호화를 해야하니까 암호화를 해서 넣는다
		//user.getPw()기존에 사용자가 입력하던 패스워드를 가져와서 encrypt에 전달하면 암호화된 패스워드가 되고 
		//암호화된 패스워드를 기존에 있었던 패스워드setPw에다가 수정을하니까 암호화된걸로 바뀐다
		users.add(user);
		//그리고나서 DB에다가 넣으면 회원가입은 완료
		
	}
	//로그인(아이디랑 비밀번호를 받아서 암호화된 비밀번호끼리 비교)
	static public boolean login(String id, String pw,ArrayList<User> userList) { 
	      for (int i = 0; i < userList.size(); i++) { // userList 길이만큼 반복
	         if(userList.get(i).getId().equals(id) && userList.get(i).getPw().equals(UserField.encrypt(pw)) ) {
	            // userList 길이만큼 반복하면서 get() 메소드를 통해 i번째 주소의 접근 -> private되어 있는 id를 매개변수로 받아온 id와 equals()로 비교한다
	            //  userList 길이만큼 반복하면서 get() 메소드를 통해 i번째 주소의 접근 -> private되어 있는 pw를 매개변수로 받아온 pw와 equals()로 비교한다
	            return true; // &&연산자를 통해서 두가지 조건 모두 참일 경우 true를 리턴
	         }

	      }//끝
	      // 위에서 조건물을 통해 return을 만나지 못했다면 매개변수는 없는 값이므로 false를 return한다.  
	      
	      return false;
	   }
	//암호화(단방향)
		public static String encrypt(String pw) {//패스워드를 받아서
			String en_pw="";//암호화를 해줘야되니까
		for(int i=0; i<pw.length();i++) {//반복문 돌려야지뭐, 각각의 문자가 필요하잖아
			en_pw+=(char)(pw.charAt(i)*3); //각각의 문자를 다 i값으로 곱하든 나누든, char로 형변환 해주고
		}//이걸 en_pw에 연결을 해주면
		return en_pw;//여기까지가 이제 암호화
		}//끝
	
		//복호화
				public static String decrypt(String pw) {//패스워드를 받아서
					String en_pw="";//암호화를 해줘야되니까
				for(int i=0; i<pw.length();i++) {//반복문 돌려야지뭐, 각각의 문자가 필요하잖아
					en_pw+=(char)(pw.charAt(i)/3); //각각의 문자를 다 i값으로 곱하든 나누든, char로 형변환 해주고
				}//이걸 en_pw에 연결을 해주면
				return en_pw;//여기까지가 이제 암호화
				}//끝
	
	
	//비밀번호찾기(이름과 핸드폰 번호로 찾기, SMS로 비밀번호 전송)
	public boolean findPw(String name, String phoneNum) {
		for(int i=0; i < users.size(); i++) {
				boolean checkName =users.get(i).getName().equals(name);
				boolean checkphoneNum =users.get(i).getPhone().equals(phoneNum);
				
			if(checkName && checkphoneNum) {
				sendSMS(phoneNum, decrypt(users.get(i).getPw()));
			}
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

		

}
