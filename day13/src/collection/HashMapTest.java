package collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class HashMapTest {
	public static void main(String[] args) {
		//아이디, 비밀번호, 이름, 나이
		HashMap<String, Object> userMap = new HashMap<>();
		userMap.put("id", "hds1234");
		userMap.put("pw", "1234");
		userMap.put("name", "한동석");
		userMap.put("age", 20);
		
		System.out.println(userMap.size());
		System.out.println(userMap.get("id")); // key를 가져오면 value값이 반환된다
		//key값을 입력하면 value값을 가져온다.
		
		System.out.println(userMap.toString()); //출력하면 key와 value가 =으로 묶여있다.
		
		
		//Iterator 인터페이스를 사용할 수 없는 컬렉션인 Map에서 Iterator 인터페이스를 사용하기 위해서는 
		//	Map에 entrySet(), keySet() 메소드를 사용하여 Set 객체를 반환받은 후 Iterator 인터페이스를 사용한다.
		Iterator<Entry<String, Object>> iter = userMap.entrySet().iterator();
																//entrySet이 순서가 없으므로 iterator로 순서를 부여해준다
		System.out.println(userMap.entrySet().iterator());
		
		while(iter.hasNext()) {
			Entry<String, Object> entry = iter.next();
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}
		
		System.out.println(userMap.keySet());//내가해본거 key의 값만 필요한 경우 사용

	}
}












