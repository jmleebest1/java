package day04;

public class MethodTask {
	
	// 아이언
	// 1~10까지 println()으로 출력하는 메소드
	// "홍길동"을 n번 println()으로 출력하는 메소드
	
	// 브론즈
	// 이름을 n번 println()으로 출력하는 메소드
	// 세 정수의 뺄셈을 해주는 메소드
	
	// 실버
	// 두 정수의 나눗셈을 해주는 메소드(몫과 나머지)
	int[] div(int num1, int num2){
		int[] result = null;
		if(num2 != 0) {
			result = new int[2];
			result[0] = num1 / num2;
			result[1] = num1 % num2;
		}
		return result;
	}
	// 1~n까지의 합을 구해주는 메소드
	int getTotal(int n) {
		int total=0;
		for(int i=0; i<n; i++) {
			total += i+1;
		}
		return total;
	}
	
	// 골드
	// 홀수를 짝수로, 짝수를 홀수로 바꿔주는 메소드//*2로 나눴을때 나머지가 0이면 짝수, 1이면 홀수
	int holjjak(int n) {
		int result = 0;
		if(n%2 ==0) {
			result += n+1;
		}else if(n%2 ==1) {
			result += n+1;
		}
		return result;
	}
		
		
	// 문자열을 입력받고 소문자는 대문자로, 대문자는 소문자로 바꿔주는 메소드 //대문자: 65~90, 소문자: 97~122
	String UpperAndLower(String str) {
		int temp = 0;
		String result = "";
		for(int i=0; i<str.length(); i++) {
			temp = (int)(str.charAt(i));
			if(65<=temp && temp <=90) {
				result += (char)(temp+32); 
			}else if(97<=temp && temp <=122) {
				result += (char)(temp-32);
			}
		}
		return result;
	}
	
	
	// 플래티넘
	// 문자열을 입력받고 원하는 문자의 개수를 구해주는 메소드
	int countChar(String str, char c) {
		int count = 0;
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i) == c)
				count++;
		}
		return count;
	}
	// 5개의 정수를 입력받은 후 원하는 번째 값을 구해주는 메소드
	
	
	
	// 다이아
	// 한글을 정수로 바꿔주는 메소드(일공이사 -> 1024)
	int HangleToInt(String str) {
		String s = "공일이삼사오육칠팔구";
		String result = "";
		for(int i=0; i<str.length(); i++) {
		result += s.indexOf(str.charAt(i));//s의 인덱스는 입력한 문자열의 인덱스가 된다. 
		}		
		return Integer.parseInt(result);
	}
	
	// 마스터
	// 5개의 정수를 입력받고 최대값과 최소값을 구해주는 void형 메소드(메소드 안에서 출력 금지, 리턴타입은 void)
	

	public static void main(String[] args) {
		MethodTask m = new MethodTask();
//		int result = m.getTotal(10);
//		System.out.println(result);
		
//		System.out.println(m.holjjak(1));
		
//		System.out.println(m.UpperAndLower("HelloWorld"));
		
//		System.out.println(m.countChar("helloworld", 'l'));
		
		System.out.println(m.HangleToInt("일공이사"));
	}
}
