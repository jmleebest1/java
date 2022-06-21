package day04;

import java.util.Scanner;

public class ArTask2 {
	public static void main(String[] args) {
		
		//사용자에게 입력받은 문자열 중 소문자는 모두 대문자로, 대문자는 모두 소문자로 변경한다.
//		Scanner sc = new Scanner(System.in);
		//아래에서 대입 연산자를 사용할 때에는 null,
		//연결을 할 때에는 ""로 초기화
//		String str = null, result = "";
//		
//		System.out.print("문자열 : ");
//		str = sc.next();
//		
//		for (int i = 0; i < str.length(); i++) {
//			char c = str.charAt(i);
//			if(c >= 65 && c <= 90) {//대문자
//				result += (char)(c + 32);
//			}else if(c >= 97 && c <= 122) {//소문자
//				result += (char)(c - 32);
//			}else {//그 이외의 문자
//				result += c;
//			}
//		}
//		
//		System.out.println(result);
		
		//정수를 한글로 변경
		//입력 예 : 1024
		//출력 예 : 일공이사
		int num = 0;
		String result = "";
		String hangle = "공일이삼사오육칠팔구";
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 : ");
		num = sc.nextInt();
		
		while(num != 0) {
			result = hangle.charAt(num % 10) + result;
			num /= 10;
		}
		System.out.println(result);
	}
}









