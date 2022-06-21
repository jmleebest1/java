package inter;

//강제성을 없애 주기 위한 Adapter를 선언하여 오류를 해결한다.
public class Tiger extends PetAdapter {

	@Override
	public void poop() { // 부모 클래스에 선언된 추상메소드를 모두 구현하지 않았을때 문제가 생긴다
		System.out.println("알아서 잘 쌉니다.");
	}

}
