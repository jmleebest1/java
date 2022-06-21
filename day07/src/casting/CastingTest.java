package casting;

class Car{
   
   void engineStart() {
      System.out.println("열쇠로 시동 킴"); 
   }
   
}

class SuperCar extends Car{
   @Override
   void engineStart() {
      System.out.println("음성으로 시동 킴");
   }
   
   void openRoof() {
      System.out.println("지붕 염");
   }
}

public class CastingTest {
   public static void main(String[] args) {
      Car matiz = new Car();
      SuperCar ferrari = new SuperCar();
      //up casting
      Car noOptionFerrari = new SuperCar();
//      noOptionFerrari.engineStart();
//      noOptionFerrari.openRoof(); // 자식 필드의 객체를 사용할 수 있지만 부모 필드에 정의되어 있지 않는 메서드는 호출이 불가능하다
      
      //down casting
      SuperCar fullOptionFerrari = (SuperCar)noOptionFerrari; // 업캐스팅 한 참조변수를 다시 다운캐스팅을 해줘야 자손타입의
      																			   // 객체를 다 사용할 수 있다.
      fullOptionFerrari.openRoof();
      
      //오류
//      SuperCar brokenFerrari = (SuperCar)new Car();
      
      
      // matiz instanceof Car                     : true
//      System.out.println(matiz instanceof Car);
      // matiz instanceof SuperCar               : false
//      System.out.println(matiz instanceof SuperCar);
      // ferrari instanceof Car                     : true
//      System.out.println(ferrari instanceof Car);
      // ferrari instanceof SuperCar               : true
//      System.out.println(ferrari instanceof SuperCar);
      // noOptionFerrari instanceof Car         : true
//      System.out.println(ferrari instanceof SuperCar);
      // noOptionFerrari instanceof SuperCar   : true
//      System.out.println(ferrari instanceof SuperCar);
      // fullOptionFerrari instanceof Car         : true
//      System.out.println(ferrari instanceof SuperCar);
      // fullOptionFerrari instanceof SuperCar   : true
//      System.out.println(ferrari instanceof SuperCar);
      
   }
}
















