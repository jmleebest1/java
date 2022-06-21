package wrapper;

public class WrapperTask {
	public static void main(String[] args) {
		// 1, 3.5, 12.5F, 'A', "ABC", true
		//위 6개의 값을 6칸 배열에 담기
		
		//자료형이 서로 다른 6개 값을 담는다 이때 자료형은 Object를 사용하여 모든 자료형을 담을 수 있게 한다.
		Object[] arData={1,3.5,12.f,'A',"ABC",true}; // autoboxing이 먼저 되고 upcasting이 된다
		//반복문을 사용해서 arData의 길이만큼 반복해준다		//왜냐하면 기본 자료형은 클래스타입으로 바뀌어야 업캐스팅 될 수 있기 때문이다.
		for(int i=0;i<arData.length;i++) {
			System.out.println(arData[i]);
			//arData[i]를 출력한다.
		}
		
	

}
	
}
