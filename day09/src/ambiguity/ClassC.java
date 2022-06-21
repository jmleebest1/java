package ambiguity;

public class ClassC implements InterA, InterB{
	@Override//printData가 중복되기 때문에 오류가 생긴다 A에서 온건지 B에서 온건지 모르므로
				//클래스에서 직접 오버라이드로 재정의하여 모호성을 해결한다.
	public void printData() {
		InterB.super.printData();
	}
}
