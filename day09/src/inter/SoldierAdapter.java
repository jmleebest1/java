package inter;

public abstract class SoldierAdapter implements Soldier {//Adapter를 생성한 후엔 부모 인터페이스를?
																				//지정해준다.

	@Override
	public void saulte() {} //중괄호 : 바디(몸통)

	@Override
	public void work() {}

	@Override
	public void eat() {}

	@Override
	public void sleep() {}
}
