package obj;

public class StringTest {
	public static void main(String[] args) {
		String data1="ABC";//필드보다 문자열 값을 우선시
		String data2="ABC";
		String data3=new String("ABC");//문자열 값보다 필드를 우선시
		String data4=new String("ABC");
		
		System.out.println(data1==data2);
		System.out.println(data1.equals(data2));
		System.out.println(data3==data4);
		System.out.println(data3.equals(data4));
		//문자열을 정확히 비교할땐 equals를 쓰는게 낫다(필드를 비교하는게 아니라 "값을 비교"하기 때문)
	}

}
