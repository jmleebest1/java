package lambda;

public class PrintNameTest {

	//함수형 인터페이스를 매개변수로 받는다//외부에서 람다식으로 구현한 값을 name으로 전달받는다
	public static void printFullName (PrintName name) {
		//외부에서 구현한 getName()을 사용하여 출력한다.
		System.out.println(name.getName("재민", "신"));
	}
	
	public static void main(String[] args) {
		//매개변수 2개를 설정하고, 두 문자열을 연결하도록 구현한다.
		//람다식은 값으로 봐야하며, PrintName이라는 함수형 인터페이스에 구현된 람다식이 전달된다.
		printFullName((f,l)->f+l);
		//매개변수는 뭐로 입력해도 선언부와 구현부 동일하게만 하면 된다
	}
}
