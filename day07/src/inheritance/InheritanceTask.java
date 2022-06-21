package inheritance;
//자동차 클래스
//브랜드, 색상, 가격
//- 열쇠로 시동 킴
//- 열쇠로 시동 끔
class Car{
String brand;
String color;
int price;

//인스턴스 변수 선언

public Car() {}//기본생성자는 항상 만들어놓자!
	

public Car(String brand, String color, int price) {
	super();
	this.brand = brand;
	this.color = color;
	this.price = price;
}

void engineStart() {
   System.out.println("열쇠로 시동 킴");
}
void engineStop() {
   System.out.println("열쇠로 시동 끔");
}
}

//슈퍼카 클래스
//브랜드, 색상, 가격, 모드(String)
//- 열쇠로 시동 킴, 음성으로 시동 킴
//- 음성으로 시동 끔
//- 지붕 열림
//- 지붕 닫힘
class SuperCar extends Car{
	String mode;
	
	public SuperCar() {}	
	
public SuperCar(String brand, String color, int price, String mode) {
		super(brand, color, price);//부모 필드에 있는 인스턴스 변수를 초기화 해준다
		this.mode = mode;//shift alt s -> o 선택창에서 초기화 생성자 만들어주기
	}

@Override
void engineStart() {
   super.engineStart();
   System.out.println("음성으로 시동 킴");
}

@Override
void engineStop() {
   System.out.println("음성으로 시동 끔");
}

void openRoof() {
   System.out.println("뚜껑 열림");
}

void closeRoof() {
   System.out.println("뚜껑 닫힘");
}
}


public class InheritanceTask {
	public static void main(String[] args) {
	      SuperCar ferrari = new SuperCar("Ferrari", "Red", 35_000, "Sport");
	      ferrari.engineStart();
	      ferrari.engineStop();
	      Car c = new SuperCar();
	    
//	      car.openRoof();부모클래스에 정의되어 있지 않은 메서드라 오류 발생
//	      c.openRoof();//부모클래스에 정의되어 있지 않은 메서드라 오류 발생
	      System.out.println(ferrari.mode);
	   }
	}
