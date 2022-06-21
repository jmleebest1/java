package day02;

import java.util.Scanner;

public class InputTask {
	public static void main(String[] args) {
		//두 정수를 입력한 후 덧셈 결과 출력
		//단, next()만 사용
//		Scanner sc = new Scanner(System.in);
//		int num1 = 0, num2 = 0;
//		String n1Msg = "첫번째 정수 : ";
//		String n2Msg = "두번째 정수 : ";
//		
//		System.out.print(n1Msg);
//		num1 = Integer.parseInt(sc.next());
//		
//		System.out.print(n2Msg);
//		num2 = Integer.parseInt(sc.next());
//		
//		System.out.printf("%d + %d = %d", num1, num2, num1 + num2);
		
		//3개의 정수를 한 번에 입력받은 후
		//3개의 정수의 합 출력
		
	/*	int num1 = 0;
		int num2 = 0;
		int num3 = 0;*/
		int num1, num2, num3 = 0;
		int result = 0;
		
		String msg = "세 개의 정수를 입력해주세요. 예: 1 3 5";
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println(msg);
		num1= sc.nextInt();
		num2= sc.nextInt();
		num3= sc.nextInt();
		
		result = num1+num2+num3;
		
		System.out.printf("%d + %d + %d = %d", num1, num2, num3, result);
				
				
		
	}
}











