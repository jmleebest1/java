package controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class userController {
	
	
	public boolean idFromCk(String id) {
		//시작은 영문으로만, '_'를 제외한 특수문자 안되며 영문, 숫자, '_'으로만 이루어진 5 ~ 12자 이하
	    String idPattern = "^[a-zA-Z]{1}[a-zA-Z0-9_]{4,11}$";
	    Matcher matcher = Pattern.compile(idPattern).matcher(id);
		if(!matcher.matches()){
			return false;
			
		}
		return true;

	}
	
	
	
	public boolean passwordCk(String pw, String ckPw) {
		if (pw.equals(ckPw)) {
			return true;
		}
		return false;
	}
	
	
	// 비밀번호 정규식 메소드
	public String passwordFromCk(String pw) {
		// 10자리 미만 한글은 사용할 수 없다 
		String result ="pass";

		/*
		1. 영문, 숫자

		2. 9~12자리 사이 문자

		3. 같은 문자 4개 이상 사용 불가

		4. 공백문자 사용 불가

*/

		
		String pwPattern = "^(?=.*\\d)(?=.*[~`!@#$%\\^&*()-])(?=.*[a-z]).{9,12}$";
		Matcher matcher = Pattern.compile(pwPattern).matcher(pw);
		 
		pwPattern = "(.)\\1\\1\\1"; 
		Matcher matcher2 = Pattern.compile(pwPattern).matcher(pw);
		
		// 영문(대소문자 구분), 숫자 그리고 9~12자리 사이 문자
		if(!matcher.matches()){
			result = "9~12자 영문 대 소문자, 숫자, 특수문자를 사용하세요.";
		
		
		}
		// 같은 문자 4개 이상 사용 불가
		if(matcher2.find()){
			result = "비밀번호에 연속된 문자를 4번이상 사용할 수 없어요 ㅠㅠ";
		}

		
		//공백문자 사용 불가
		if(pw.contains(" ")){
			result = "비밀번호에 공백은 사용할 수없어요 ㅠㅠ";
		}
		return result;
	}
	


	
	
// 성별 선택 메소드
	public char getGender(int genderChoice) {
		char gender = 'F';
		if (genderChoice == 1) {
			gender ='M';
			// 남성
		}else {
			// 여성
			gender = 'F';
		}
		
		
		return gender;
	}
	
// 전화번호 유효성 검사

	public boolean phonNumCk(String phonNum) {
		//11 자리인지 검사 10자리 번호는 없다고 가정
		boolean flag = false;
		if (phonNum.length() != 11  ) {
			 flag = false;
		} 
		// 10자리 전화번호도 허용 한다면 아래 코드 사용
/*		if (phonNum.length() != 11 || phonNum.length() != 10 ) {
			flag = false;
		} */
		

		if (phonNum.charAt(0) =='0') {
			flag = true;
		}else {
			flag = false;
		}

        
        for (int i = 0; i < phonNum.length(); i++) {
           int result = phonNum.charAt(i) - 48;
           if(result < 0 || result > 9) {
        	   flag = true;
           }
        }
        
        return flag;
	}
	
// 메소드로 거주지 번호를 에 따른 지역  String 리턴 
	public String getRegion(int regionChoice ) {
		String[] regionData = {"서울","경기", "인청", "강원", "충북", "울산","부산", "대구", "광주", "대전"
				, "세종", "충남", "경북", "경남", "전북", "전남", "제주"};
		
		return regionData[--regionChoice];
		}
	
	
	
	
}
