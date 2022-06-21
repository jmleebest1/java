package ambiguity;

public class ClassB extends ClassA implements InterA{
	public static void main(String[] args) {
		new ClassB().printData();
		//클래스와 인터페이스가 동시에 상속이 되었을때는 부모 클래스 타입이 된다.
	}
}
