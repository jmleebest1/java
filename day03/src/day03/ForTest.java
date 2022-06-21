package day03;

public class ForTest {
	public static void main(String[] args) {
		//이름 10번 출력
		//포문 사용
//		for(int i = 0; i < 10; i = i+1) {
//		//출력	System.out.println(i + 1 + ".신재민");
		//i값이 1씩 증가하므로 i를 앞에 붙여서 숫자가 출력되게 한다
//		}
		
		//이름 10번 출력, 10~1까지 출력
//		for (int i = 0; i < 10; i++) {
//			System.out.println(10 - i + ".신재민");
//		}
		//이름 10번 출력, 10~20까지 출력
		// - 10번 반복
//		int end = 10;
//		for (int i = 0; i < end; i++) {
//			System.out.println(i + 10 + (end == 11 ? "." : ".신재민"));
//			if(i == 9) {end++;}
//		}
		// - 11번 반복
		for (int i = 0; i < 11; i++) {
			System.out.println(i + 10 + (i == 10 ? "." : ".신재민"));
		}
	}}









