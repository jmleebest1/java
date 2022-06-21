package exceptionTest;

public class ExceptionTest1 {
	public static void main(String[] args) {
		//4칸 배열을 만들고 인덱스로 접근할 때 0~4 범위를 벗어나면
		//"다시 시도해주세요" 출력
		int[] arData = new int[4];//오류가 날 수 있는 문장을 잡고 alt+shift+z -> try/catch
		try {
			arData[-1] = 10;
//		} catch (Exception e) {
//			System.out.println(e);//먼저 객체명을 넣어준다(객체명에 이미 주소값이 들어가 있기 때문)
//		}
		} catch (ArrayIndexOutOfBoundsException e) {// Exception 자리에 예외 이름 넣어준다
			System.out.println("다시 시도해주세요."); // 출력하고자 하는 문장 넣어준다
		}
//		try {
//			System.out.println(10 / 0);
//		} catch(ArithmeticException e) {
//			System.out.println("0으로 나눌 수 없습니다.");
//		}
//		System.out.println("반드시 실행해야 되는 문장");
	}
}
