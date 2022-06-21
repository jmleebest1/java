package obj;

import java.util.Random;

public class HashCodeTest {
	public static void main(String[] args) {
		String data1="ABC";	//얘네 둘은 원칙적으론! 주소값이 같으면 안된다. 각각의 필드 주소가 나와야 한다.
		String data2="ABC";
		String data3=new String("ABC");
		String data4=new String("ABC");
		//4개의 객체가 모두 해쉬코드가 달라야한다.
		
		System.out.println(data1.hashCode());
		//.마침표는 주소 뒤에만 쓸 수 있다 따라서 data1,2도 주소값을 가지고 있다
		System.out.println(data2.hashCode());//Object가 String클래스로 재정의(오버라이딩)가 되었다.
		System.out.println(data3.hashCode());
		System.out.println(data4.hashCode()); 
		//오브젝트라는 클래스에서 선언된 해쉬코드는 무조건 필드의 주소
		//우리는 문자열을 비교할건데 값의 주소를 비교해야지!
		//String 클래스로 재정의가 되었기 때문에 값의주소가 들어가므로 주소값이 모두 동일해진다.
		
		
//		Random r1=new Random();
//		Random r2=new Random();
//		
//		System.out.println(r1.hashCode());
//		System.out.println(r2.hashCode());
	}
}
