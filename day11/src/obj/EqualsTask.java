package obj;

public class EqualsTask {
	public static void main(String[] args) {
		
	
	Student std=new Student(1,"신재민");
	//Student클래스에서 재정의하면 재정의된게 equals에 사용이 되므로 재정의 해준다.
	System.out.println(std.equals(new Student(1,"신재민"))) ;
}
}
//학생의 번호가 같다면 true가 나올 수 있도록 equals()를 재정의 하기
 