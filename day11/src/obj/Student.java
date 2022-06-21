package obj;

public class Student {
	int num;
	String name;
	
	public Student() {;}
	
	public Student(int num, String name) {//생성자 초기화
		super();
		this.num=num;
		this.name=name;
	}
	
	
	public Student(String name) {
		super();
		this.name=name;
	}
	public String toString() {//toString을 재정의
		return"이름:"+name;
	}
	@Override
	public boolean equals(Object obj) {//equals를 재정의해서 같은 값이 나올수 있도록한다
		//주소비교
		if(this==obj) {return true;}//this와 obj의 주소가 같으면 true다(같은 학생이다)
		//타입비교
		if(obj instanceof Student) {//주소가 다르면 일단 학생인지 검사해야 하므로 obj가 student인지 비교
			//다운 캐스팅
			Student std=(Student)obj;//타입이 같다면 짤린 num을 넣어야 하므로 다운캐스팅을 해서 num을 살려준다
			//원하는 필드 비교
			if(this.num==std.num) {//this.num의 번호와 전달받은 std.num번호가 같다면 true로 리턴
				return true; //이쪽까지 안들어온다면 다른 학생이므로 if문 밖으로 return false를 해준다
			}
		}
		
		
		// TODO Auto-generated method stub
		return false;
	}
 }
