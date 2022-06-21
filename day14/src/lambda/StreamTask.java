package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class StreamTask {
	public static void main(String[] args) {
		//1~10까지 ArrayList에 담고 출력(IntStream)
//		ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
//		System.out.println(nums);
//		IntStream.range(0, 100).forEach(v -> System.out.println(v + 1));
		
		//1~100까지 중 짝수만 ArrayList에 담고 출력(filter)
		ArrayList<Integer>	datas=new ArrayList<>();
		IntStream.range(1, 51).forEach(v -> System.out.println(v*2));
		
		//A~F까지 ArrayList에 담고 출력(IntStream.range(),map)
//		ArrayList<Character>datas=new ArrayList<>();
		
//		ArrayList<Object> alphabets = 
//				new ArrayList<>(Arrays.asList((char)65,(char)66,(char)67,(char)68,(char)69,(char)70));
//		System.out.println(alphabets);
		//A~F까지 중 D제외하고 ArrayList에 담은 후 출력(IntSream,map,삼항 연산자)
//		ArrayList<Object> alphabets2 = 
//				new ArrayList<>(Arrays.asList(65,66,67,68,69,70));
//		alphabets2.stream().filter(d -> d != 68).forEach(d -> System.out.println((char)d));
		//5개의 정수를 입력받은 후 ArrayList에 담고 최대값과 최소값 출력(구글링)(sorted또는 mapToInt)
		//문자열을 5개 입력받고 모두 소문자로 변경(입력 : IntStream, map)
		//Apple, banana, Melon 중 첫번째 문자가 대문자인 문자열 출력(Arrays.asLit(),filter,collect)
		//한글을 정수로 변경(map)
		
		//정수를 한글로 변경
//		String hangle= "공일이삼사오육칠팔구";
//		Scanner sc=new Scanner(System.in);
//		System.out.println("입력 : ");
//		String data=sc.next();
//		
//		data.chars().map(a-> a-48).forEach(a->System.out.print(hangle.charAt(a)));
	}
}
