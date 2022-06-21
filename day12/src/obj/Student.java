package obj;

public class Student {
   int num;
   String name;

   public Student() {;}

   public Student(int num, String name) {
      super();
      this.num = num;
      this.name = name;
   }

   public Student(String name) {
      super();
      this.name = name;
   }
   
   @Override
   public String toString() {
      return "이름 : " + name;
   }

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + num;
	return result;
}

@Override
public boolean equals(Object obj) {
	if(this == obj) {return true;}// 주소비교
	if(obj instanceof Student) { // 타입비교
		Student std = (Student)obj; // 다운 캐스팅
	if(this.num == std.num) { // 원하는 필드 비교
		return true;
	}
	}
	return false;
 
   
}
}














