package inheritance;

class Human{
	
	void eat() {
		System.out.println("먹기");
	}
	
	void sleep() {
		System.out.println("자기");
	}
	
	void walk() {
		System.out.println("두 발로 걷기"); //이것이 바로 다형성!!!!!!!! 이름은 하난데(walk)형태가 다양하다!@!
	}												// 다형성 1. 오버로딩 2. 재정의(오버라이딩)
	
}

class Monkey extends Human{
	void eatLouse() {
		System.out.println("냠냠");
	}
	
	
	@Override//@를 어노테이션이라 한다
	void walk() {
		// 
		super.walk();
		System.out.println("네 발로 걷기");
	}
	}
	
	


public class InheritanceTest2 {
	public static void main(String[] args) {
		Monkey kingkong = new Monkey();
		kingkong.walk();
	}
}
