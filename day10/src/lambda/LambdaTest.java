package lambda;

public class LambdaTest {
	public static void main(String[] args) {
//		boolean check = new LambdaInter() { //new LambdaInter()은 생성자이다
//		@Override
//			public boolean checkMultipleOf10(int number) {// 이 익명클래스는 전체가 주소값으로 봐야한다
//				// TODO Auto-generated method stub
//				return false;
//			}.checkMultipleOf10(10);
//			System.out.println(check);			
									//이름이없다 -> 익명메소드//리턴값
		LambdaInter lambda1 = (int number) -> number % 10 == 0;
		boolean check1 = lambda1.checkMultipleOf10(10);
	//불린타입 check1 매개변수 // 메소드를 사용해서 값을 check1에 넣어준다 10을 넣어줬기 때문에 true
		System.out.println(check1);
	// check1(true)출력
		
		//"10의 배수 검사"를 출력하고 리턴한다.
		LambdaInter lambda2 = (int number) -> {System.out.println("10의 배수 검사");  return number % 10 ==0;};
		boolean check2 = lambda2.checkMultipleOf10(99);
		System.out.println(check2);
		
	
		
//		boolean check = new LambdaInter() {
//			@Override
//			public boolean checkMultipleOf10(int number) {
//				return number % 10 == 0;
//			}
//		}.checkMultipleOf10(10);
//		System.out.println(check);
	}
}
