package abstractTest;

public class Refrigerator extends Electronics {//부모 클래스를 업캐스팅한다

	@Override
	void on() {
		System.out.println("버튼을 on쪽으로 누른다.");
	}

	@Override
	void off() {
		System.out.println("버튼을 off쪽으로 누른다.");
	}

}
 