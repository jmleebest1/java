package day05;

class A{
	int data = 100; //인스턴스 변수 선언
	
	A(){//클래스 선언. 사용자가 직접 생성자 생성
		System.out.println("안녕");
	}//"안녕" 출력
	
	void printData() {//메소드(기능)를 만들어준다
		System.out.println(data);
	}
}

public class ClassTest {
	public static void main(String[] args) {//메인 메소드는 메인 클래스 안에서만 동작한다.
		
		A a = new A();//기본 생성자
		System.out.println(a);
		a.data = 200;
		a.printData();//?????????????
	}
}
