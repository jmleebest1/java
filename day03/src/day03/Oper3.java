package day03;

import java.util.Scanner;

public class Oper3 {
	public static void main(String[] args) {
		//심리 테스트
		/*
		 * Q. 당신이 좋아하는 색을 선택하세요.
		 * 1. 빨간색
		 * 2. 노란색
		 * 3. 검은색
		 * 4. 흰색
		 * 
		 * 빨간색 : 불같고 열정적이고 적극적이다.
		 * 노란색 : 발랄하고 밝고 귀엽고 개성있고 유하다.
		 * 검은색 : 묵묵하고 든든하고 냉철하고 멋지다 그리고 강하다.
		 * 흰색 : 천사같고 깔끔하고 정리를 좋아고 배려심이 많다.
		 * 
		 * ※ 삼항 연산자 사용!
		 */
		
		//사용자에게 출력할 메세지
		String Msg = "Q. 당신이 좋아하는 색을 선택하세요.";
		String choiceMsg = "1.빨간색\n2.노란색\n3.검은색\n4.흰색";
		//빨간색 선택시 출력할 메시지
		String redMsg = "불같고 열정적이고 적극적이다.";
		//노란색 선택시 출력할 메시지
		String yellowMsg = "발랄하고 밝고 귀엽고 개성있고 유하다.";
		//검은색 선택시 출력할 메시지
		String blackMsg = "묵묵하고 든든하고 냉철하고 멋지다 그리고 강하다.";
		//흰색 선택시 출력할 메시지
		String whiteMsg = "천사같고 깔끔하고 정리를 좋아고 배려심이 많다.";
		//에러 메시지
		String errorMsg = "다시 시도해주세요.";
		//결과값 변수에 담기
		String resultMsg = null;
		//선택값 만들기
		int choice = 0;
		Scanner sc = new Scanner(System.in);
		//메시지 출력하기
		System.out.println(Msg + "\n"	 + choiceMsg);
		//선택창 만들기
		choice = sc.nextInt();
		
		//삼항연산자 사용하여 조건 만들기
		resultMsg = choice == 1 ? redMsg:
			choice == 2 ? yellowMsg:
				choice == 3 ? blackMsg:
					choice == 4 ? whiteMsg : errorMsg;
		
		//결과값 출력하기
		System.out.println(resultMsg);
		
		
		
	}
}






