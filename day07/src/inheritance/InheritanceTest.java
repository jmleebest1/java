package inheritance;

class A{
	   String nameA = "A";
	   int data = 10;
	   //부모 클래스 인스턴스 생성
	   
	   public A() { //클래스 A 생성자
		   System.out.println("부모 생성자 호출");
	   }
	}

	class B extends A{ //클래스 A를 상속
	   String nameB = "B";
	   
	   public B() {	// 클래스 B 생성자
	      System.out.println("자식 생성자 호출");
	   }
	   
	   void printData() {
	      System.out.println(data);
	   }  //변수 data값을 출력하는 메서드
	}

	public class InheritanceTest {
	   public static void main(String[] args) {
	      B b = new B(); // 참조변수 b 객체화
	      System.out.println(b.nameA); // 참조변수 b로 A클래스에 있는 인스턴스 참조
	      b.printData();// 참조변수 b로 메서드 실행하면 부모 클래스에 있는 data값이 들어와서 실행된다
	   }
	}