package map;

public class Student extends Person{
   //실행 순서
   //1. super()
   //2. {}
   //3. this()
   
   {
      System.out.println(this.getNum() + "번 " + this.getName() + "님이 추가되었습니다.");
   }//인스턴트 필드 생성			//변수로 가져오지 않는 이유는 private이라 접근할수 없기 때문에 게터로 접근
   
   public Student() {;}//기본 생성자

   public Student(int num, String name) {
      super(num, name);//부모 생성자에서 초기화
   }

   @Override
   public boolean equals(Object obj) {
      if(this == obj) { return true; }//주소비교
      if(obj instanceof Student) {//타입비교
         Student std = (Student)obj;//다운캐스팅
         if(std.getNum() == this.getNum()) {//번호비교
            return true;
         }
      }
      return false;//서로 다른 학생
   }
   
   @Override
   public int hashCode() {//equals재정의하면 hashCode도 재정의해준다
      return this.getNum();
   }
   
}







