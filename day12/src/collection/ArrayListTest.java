package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.function.UnaryOperator;

public class ArrayListTest{
   
   public static void main(String[] args) {
      // <?> : 제네릭(이름이 없는, 포괄적인 개념)
      // 객체로 사용할 때 타입을 지정하는 기법
      // 지정할 타입에 제한을 둘 수 있다. 예)<T extends Number> Number의 자식이 아니면 오류난다
      // 따로 다운캐스팅을 할 필요가 없다.
	   
//	   T data;
//	   
//	   void printData(T data) {
//		   this.data=data;
//		   System.out.println(data);
//	   }
	   
      ArrayList<Integer> arList = new ArrayList<>();
      arList.add(10);//arList의 마지막에 10이 추가된다
      arList.add(20);
      arList.add(40);
      arList.add(50);
      arList.add(90);
      arList.add(80);
      arList.add(70);
      arList.add(60);
      
      System.out.println(arList);
      
//      System.out.println(arList.size());//사이즈 확인해서
//      System.out.println(arList.get(2));//인덱스로 접근해서 갖고온다
      
      for (int i = 0; i < arList.size(); i++) {
         System.out.println(arList.get(i));
      }
      
      // 정렬 (오름차순 내림차순...)
      Collections.sort(arList);//sort메소드는 Collections이라는 클래스에서 사용된다 주의!collection인터페이스랑 다르다
      System.out.println(arList);//static메소드 이기 때문에 따로 객체화를 할 필요가 없다.
      Collections.reverse(arList);
      //오름차순 정렬을 한 뒤 reverse를 사용하면 좌우를 반대로 정렬을 해준다
      System.out.println(arList.toString());
      Collections.shuffle(arList);
      System.out.println(arList);
      
      // 추가(삽입)
      // 50 뒤에 500 삽입
      //50을 가져와서(contatins(50)) 50이 있나 없나 먼저 검사 //  
      if(arList.contains(50)) {
         arList.add(arList.indexOf(50) + 1, 500);//indexOf(50)로 50이 몇번째 방에 있는지 검사
         System.out.println(arList);					//50이 500 뒤에 가야 하므로 +1을 해준다
      }//리스트를 출력한다
      
    //수정
      //90을 9로 수정
      if(arList.contains(90)) {
    	  arList.set(arList.indexOf(90), 9);
      }
      System.out.println(arList);
      // 삭제
      // 80 삭제
      // 1. 인덱스로 삭제
//      if(arList.contains(80)) {
//         int result = arList.remove(arList.indexOf(80));
//         System.out.println(result + "이 삭제되었습니다.\n" + arList);
//      }
      // 2. 값으로 삭제
//      if(arList.remove(Integer.valueOf(80))) {//int값을 Integer로 바꾸면서 실행한다.
//    	  //리스트에서 80을 삭제한다 (Integer.valueOf로 
//         System.out.println(arList);
//      }
   }
}


