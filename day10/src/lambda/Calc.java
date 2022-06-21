package lambda;

import java.util.Scanner;

public class Calc {
	public static MyMath calculator(String oper) {
		  // 사용할 스태틱 메서드

		MyMath math = null;
		// 람다식 구현 이전 스위치문에서 사용하기 위해서 객체를 만든다. 
		
		
		 // 스위치를 사용하여 oper에 따라서 + 또는  - 계산을 실행한다.
	      // int를 리턴하는 함수형 인터페이스를 리턴하는 메소드 구현
		switch(oper) {
		case "+":
			math = (num1, num2) -> num1 + num2;
			break;
		case "-":
			math = (num1, num2) -> num1 - num2;
			break;
		}
		return math;
	}
	
	
	public static void main(String[] args) {
		 // 람다식 구현
		OperCheck operCheck = (expression) -> {
			String temp = "";
			for (int i = 0; i < expression.length(); i++) {
				char c = expression.charAt(i); // 반복문을 통해서 +, - 기호를 가져온다
				if(c == 43 || c == 45) {  // 아스키 코드가 각각 43,45이므로 if문을 통해서 temp변수에 누적연산 시킨다.
					temp += c;
				}
			}
			return temp.split(""); // 그후 한글자씩 split 을 한다
		};
		// 사용한 변수를 선언
		String msg = "정수의 덧셈, 뺄셈에 대한 식을 입력하세요";
		String exMsg = "예)7 + 65 - 8";
		String temp = null;
		String[] nums = null;
		String[] opers = null;
		int num1 = 0, num2 = 0;
		Scanner sc = new Scanner(System.in);
		
		System.out.println(msg);
		System.out.println(exMsg);
		temp = sc.next();
		  // 식 입력 값을 받아온다
		
		nums = temp.split("\\+|\\-"); // +,-를 구분으로 나눈다.
		opers = operCheck.getOpers(temp);
		// 기호값을 받아주는 함수에 temp를 념겨준다. 
	      // 리턴값을 opers에 저장
		
		num1 = Integer.parseInt(nums[123].equals("") ? opers[0] + nums[1] : nums[0]);
		// 음수로 시작하면 생기는 오류를 해결한다. 
	      // 0번이 음수일 경우 생기는 오류이므로 0번방에서 "" 값이라면 0번
		
		for (int i = 0; i < opers.length; i++) { // 기호(+,-)의 길이만큼 돈다
			if(i == 0 && num1 < 0) {continue;}// i랑 같고 0보다 크면 컨티뉴를 해준다. 
															//음수라면 이 연선자를 건너뛴다 
															//두번째 반복으로 감으로 다음 정수와 앞에 수와 비교
			num2 = Integer.parseInt(nums[i + 1]);// i번재방 +1이  두 번째수이다. 
			num1 = calculator(opers[i]).calc(num1, num2);// num1에 calculator 하고 계산을 한 결과값이 담긴다.  
		}
		System.out.println(num1); // 값 출력 
	}
}









