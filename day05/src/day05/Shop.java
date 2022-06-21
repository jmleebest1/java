package day05;

import java.util.Scanner;

class SuperCar{
	
	String brand;
	String color;
	int price;
	String pw = "0000";
	boolean check;
	int policeCount;
	//인스턴스 변수 선언
	
	public SuperCar(String brand, String color, int price) { //생성자로 매개변수를 받아 인스턴스 변수를 초기화 해준다 
		super();
		this.brand = brand;
		this.color = color;
		this.price = price;
	}

	public SuperCar(String brand, String color, int price, String pw) {
		this.brand = brand;
		this.color = color;
		this.price = price;
		this.pw = pw;
	}
	
	//[심화]
	//시동을 켜기 위해서는 비밀번호 4자리를 입력해야 한다.
	//입력한 비밀번호가 3회 연속 실패하면 "경찰 출동"메세지를 출력한다.
	
	boolean checkPw(String pw){
		//문자열 비교 시 equals()를 사용!
		return this.pw.equals(pw);
	}
	
	//시동 켜기(만약 이미 시동이 켜져있다면 경고 메세지 출력)
	boolean engineStart() {
		if(!check) {
			check = true; // 시동 켜짐
			return true;
		}
		return false;
	}
	//시동 끄기(만약 이미 시동이 꺼져있다면 경고 메세지 출력)
	boolean engineStop() {
		if(check) {
			check = false; // 시동 꺼짐
			return true;
		}
		return false;
	}
	
}

public class Shop {
	public static void main(String[] args) {
		SuperCar ferrari = new SuperCar("Ferrari", "Red", 35_000, "1234");
		//객체를 생성하고 바로 값을 할당해준다.
		Scanner sc = new Scanner(System.in);
		//입력 스캐너 생성
		int choice = 0;
		// choice 변수 만들고 초기값 할당
		String pw = null;
		// qw 변수 만들고 초기값 할당
		
		while(true) {//while문으로 반복을 돌려준다 // policeCount가 3이 될때까지 반복
			System.out.println("1.시동켜기\n2.시동끄기");
			choice = sc.nextInt();
			// 입력값을 choice에 저장
			
			if(choice == 1) {//choice(입력값)이 1이면
				if(ferrari.engineStart()) {// 참조변수 ferrari로 engineStart메서드를 실행해주고
					System.out.print("비밀번호 : "); //비밀번호를 입력 받는다.
					pw = sc.next();
					
					if(ferrari.checkPw(pw)) { //시동이 켜지면 참조변수 ferrari로 checkPw메서드를 실행해주고 위에서 입력한 비밀번호를 받아온다.
						ferrari.check = true; //입력한 패스워드가 일치하면
						ferrari.policeCount = 0;// policeCount는 0이되고 시동이 켜진다
						System.out.println("시동 켜짐"); 
					}else {//패스워드가 불일치할시
						ferrari.policeCount++; //PoliceCount가 1 증가
						System.out.println("비밀번호" + ferrari.policeCount + "회 오류");
						if(ferrari.policeCount == 3) {//policeCount가 3이 되면
							System.out.println("경찰 출동");// 경찰출동하는 메시지 출력
							break;
						}
					}
					
				}else {
					System.out.println("시동이 이미 켜져있습니다.");
				}
				
			}else if(choice == 2) {//2번을 입력했을시
				if(ferrari.engineStop()) { //참조변수 ferrari로 engineStop()메서드를 실행해주고
					ferrari.check = false;//시동 꺼진 상태
					System.out.println("시동 꺼짐");
				}else {
					System.out.println("시동이 이미 꺼져있습니다.");
				}
			}
			
		}

//		if(ferrari.engineStart()) {
//			System.out.println("시동 킴");
//		}else {
//			System.out.println("이미 시동이 켜져있습니다.");
//		}
//		
//		if(ferrari.engineStop()) {
//			System.out.println("시동 끔");
//		}else {
//			System.out.println("이미 시동이 꺼져있습니다.");
//		}
	}
}
















