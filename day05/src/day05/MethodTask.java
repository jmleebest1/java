package day05;

import java.util.Arrays;

public class MethodTask {
	
	// 아이언
	// 1~10까지 println()으로 출력하는 메소드
	void printFrom1to10() {
		for(int i=0; i<10; i++) {
			System.out.println(i+1);
		}
	}
	
	// "홍길동"을 n번 println()으로 출력하는 메소드
	void printGildong(int time) {
		for(int i=0; i<time;i++) {
			System.out.println("홍길동");
		}
	}
	
	// 브론즈
	// 이름을 n번 println()으로 출력하는 메소드
	// 이름과 반복횟수를 알지 못함으로 printName이라는 메소드를 만들어서 
	// String 타입의 name과 int 타입의 time을 넣어준다.
		void printName(String name, int time){
			//for문 사용하여 사용자가 원하는 만큼의 횟수를 반복해줄수 있도록 해준다
		for (int i = 0; i < time; i++) {
			// 이름이 출력될수 있도록 println을 사용한다.
			System.out.println(name);
		}
	}
	
	// 세 정수의 뺄셈을 해주는 메소드
	int sub(int num1, int num2, int num3) {
		//매개변수로 값을 받아서 뺄셈을 해준다
		return num1 - num2 - num3;
	}
	
	// 실버
	// 두 정수의 나눗셈을 해주는 메소드(몫과 나머지)
	int divide(int num, int num2) {
		// 매개변수로 두 정수를 받아서
		if(num / num2 == 0) {
			// 나눴을때 0이면 반환해주고
			return num / num2;
		}else
			return num % num2;
		//0 이 아니면 나머지가 나오는 것이므로 몫과 나머지를 반환해준다
	}
	// 1~n까지의 합을 구해주는 메소드
//리턴타입/메소드명/      자료형/매개변수명 입력*********(메소드선언)
	int getTotalFrom1(int n){
		//n을 매개변수로 받는다
		int total = 0;
		// 결과값을 저장할 변수에 초기값 넣어준다
		for(int i=0; i<n; i++) {
			//입력받은 n만큼 반복을 돌려준다
			total += i+1;
			//반복해서 나온 값을 더해주고 total에 담는다
			
			}
		return total;
	}
	
	// 골드
	// 홀수를 짝수로, 짝수를 홀수로 바꿔주는 메소드
	int change(int num){
		//정수를 매개변수로 받는 메서드 선언
		return ++num;
	}
	// 문자열을 입력받고 소문자는 대문자로, 대문자는 소문자로 바꿔주는 메소드
	String changeToUpperAndLower(String str){
		//문자열을 매개변수로 받는 메서드를 선언한다
		String result = "";
		//결과값을 저장할 변수 선언
		
		for (int i = 0; i < str.length(); i++) {
			//입력받은 문자열의 길이만큼 반복을 돌려준다.
			char c = str.charAt(i);
			// 문자형 변수 c에 str에서 추출한 문자를 하나씩 담아준다.
			if(c >= 65 && c <= 90) {//대문자
				result += (char)(c + 32);
				//대문자면 소문자로 변환해준다
			}else if(c >= 97 && c <= 122) {//소문자
				result += (char)(c - 32);
				//소문자면 대문자로 변환해준다
			}else {//그 이외의 문자
				result += c;
				//그 외에는 그냥 반환한다(ex. 한글을 입력하면 그대로 한글 출력)
			}
		}
		
		return result;
		
	}
	
	// 플래티넘
	// 문자열을 입력받고 원하는 문자의 개수를 구해주는 메소드
	int getCount(String str, char c){
		//문자열과 문자를 매개변수로 받는 메서드 생성
		int count = 0;
		//개수를 담아줄 변수 선언
		for (int i = 0; i < str.length(); i++) {
			//문자열의 길이만큼 반복을 돌려주고
			if(str.charAt(i) == c) {
				//문자열의 인덱스가 c와 같다면
				count++;
				//개수를 증가시켜준다
			}
		}
		return count;
	}
	
	// 5개의 정수를 입력받은 후 원하는 번째 값을 구해주는 메소드
	int getValue(int[] arData, int ordinal){
		return arData[ordinal - 1];
	}
	
	// 다이아
	// 한글을 정수로 바꿔주는 메소드(일공이사 -> 1024)
	int changeToInteger(String hangle){
		String hangleOri = "공일이삼사오육칠팔구";
		String result = "";
		for (int i = 0; i < hangle.length(); i++) {
			result += hangleOri.indexOf(hangle.charAt(i));
		}
		return Integer.parseInt(result);
	}
	
	// 마스터
	// 5개의 정수를 입력받고 최대값과 최소값을 구해주는 void형 메소드(메소드 안에서 출력 금지, 리턴타입은 void)
	void getMaxAndMin(int[] arData, int[] results) {
		results[0] = arData[0];
		results[1] = arData[0];
		
		for (int i = 1; i < arData.length; i++) {
			if(results[0] < arData[i]) { results[0] = arData[i]; }
			if(results[1] > arData[i]) { results[1] = arData[i]; }
		}
	}
	
	public static void main(String[] args) {
		MethodTask m = new MethodTask();
//		m.printFrom1to10();
		
//		m.printGildong(3);
//		int result = m.sub(5, 2, 1);
//		System.out.println(result);
//		int result = m.divide(5, 2);
//		System.out.println(result);
//		System.out.println(m.divide(7, 4));
//		System.out.println(m.changeToUpperAndLower("ABcDeFgㅅ"));		
		System.out.println(m.changeToInteger("삼사오육"));
//		int result = m.getTotalFrom1(5);
//		System.out.println(result);
//		--------------------------------------------------------------------------------------------------------------------
		//정수에서 쉼표 대신 _를 사용한다.
		//1,000,000
//		int data = 1_000_000;
//		System.out.println(data);
		
//		MethodTask m = new MethodTask();
		
//		 5개의 정수를 입력받고 최대값과 최소값을 구해주는 void형 메소드(메소드 안에서 출력 금지, 리턴타입은 void)
//		int[] results = new int[2];
//		int[] arData = {1, 3, 6, 4, 2};
//		
//		m.getMaxAndMin(arData, results);
//		
//		System.out.println("최대값 : " + results[0]);
//		System.out.println("최소값 : " + results[1]);
		
//		 한글을 정수로 바꿔주는 메소드(일공이사 -> 1024)
//		int result = m.changeToInteger("공일삼구육삼칠팔사");
//		System.out.println(result);
		
//		 5개의 정수를 입력받은 후 원하는 번째 값을 구해주는 메소드
//		int[] arData = {1, 34, 64, 65, 12};
//		System.out.println(m.getValue(arData, 3));
		
//		 문자열을 입력받고 원하는 문자의 개수를 구해주는 메소드
//		int count = m.getCount("ABCAAAA", 'A');
//		System.out.println(count);
		
//		 문자열을 입력받고 소문자는 대문자로, 대문자는 소문자로 바꿔주는 메소드
//		String result = m.changeToUpperAndLower("Apple1234!@#$");
//		System.out.println(result);
		
//		 홀수를 짝수로, 짝수를 홀수로 바꿔주는 메소드
//		int result = m.change(4);
//		String msg = result % 2 == 0 ? "홀수에서 짝수로 바뀌었습니다." : "짝수에서 홀수로 바뀌었습니다.";
//		System.out.println(msg);
		
//		 1~n까지의 합을 구해주는 메소드
//		int result = m.getTotalFrom1(10);
//		System.out.println(result);
		
//		 세 정수의 뺄셈을 해주는 메소드
//		int result = m.sub(1, 2, 3);
//		System.out.println(result);
		
//		 이름을 n번 println()으로 출력하는 메소드
//		m.printName("신재민", 12);
		
//		 "홍길동"을 n번 println()으로 출력하는 메소드
//		m.printHong(10);
		
//		 1~10까지 println()으로 출력하는 메소드
//		m.printFrom1To10();
		
//		 두 정수의 나눗셈을 해주는 메소드(몫과 나머지)
//		int[] result = m.div(10, 3);
//		
//		if(result == null) {
//			System.out.println("0으로 나눌 수 없습니다.");
//		}else {
//			System.out.println("몫 : " + result[0]);
//			System.out.println("나머지 : " + result[1]);
//		}
	}
}










