package inter;

public class Sergeant extends SoldierAdapter {//골라서 재정의할때는 Adapter 추상클래스를 만들어서
																//상속한다(일반클래스로 상속해도 되지만 일종의 약속)

	@Override
	public void eat() {
		System.out.println("군대 편의점으로 달려간다.");
	}

	@Override
	public void sleep() {
		System.out.println("24시간 잔다.");
	}
}
