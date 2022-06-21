package ambiguity;

public interface InterA {
	default void printData() {
		//default를 쓰는 이유는 추상메소드에 {}를 쓰면 오류나기 때문에
		//일반메소드라고 알리기 위해 default를 써준다
		//abstract를 없애기 위해 default를 써준다
		System.out.println("InterA");
	}
}
