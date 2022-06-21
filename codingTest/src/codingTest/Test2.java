package codingTest;

import java.util.ArrayList;
import java.util.Collections;

//'0'과 '1'로만 이루어진 문자열이 있습니다. 이 문자열에서 '1'이 최대 몇 번 연속해서 나타나는지 구하려 합니다.
//예를 들어 "110111" 이라는 문자열이 주어졌을 때, '1'이 연속해 나타나는 곳은 맨 앞의 11과 맨 뒤의 111입니다.
//이 경우 1은 최대 3번 연속해서 나타났습니다.
//'0'과 '1'로만 이루어진 문자열 s가 매개변수로 주어질 때, 
//이 문자열에서 '1'이 최대 몇 번 연속해서 나타나는지 return하도록 solution함수를 완성해주세요.

public class Test2 {

	public int solution(String number) {
		ArrayList<String> datas = new ArrayList();
		String temp = "";
		int max = 0;
		
		for(int i=0; i<number.length(); i++) {
			if(number.charAt(i)=='1') {
				temp+=number.charAt(i);
			}else if(number.charAt(i)=='0') {
				datas.add(temp);
				temp = "";
			}
			
			if(i==number.length()-1) {
				datas.add(temp);
			}
		}
		
		for(int i=0; i<datas.size(); i++) {
			if(max<datas.get(i).length()) {
				max=datas.get(i).length();
			}
		}
		return max;

	}		   
	
	public int solution2(String number) {
		int result=0;
		
		//0을 기준으로 문자열을 나눠서 문자열 배열에 담아준다
		String[] num = number.split("0");
		ArrayList<Integer>ar = new ArrayList<>();
		
		//문자열 배열의 길이만큼 반복을 돌려준다
		for(int i=0; i<num.length; i++) {
		//문자열 각 배열의 크기를 ar객체에 저장해준다
			ar.add(num[i].length());
		}
		//각 배열들을 순서대로 정렬해준 후 반대로 돌려준다 -> 가장 큰 값이 가장 맨 앞(인덱스0)에 위치하게 된다
		Collections.sort(ar, Collections.reverseOrder());
		
		//배열의 크기가 0이면 문자 1값이 없는 것이므로 결과 0을 리턴하고
		if(ar.size()==0) {
			result = 0;
		}else {
		//배열이 있으면 0번재 방을 리턴해준다(가장 큰 값)
			result = ar.get(0);
		}
		return result;
	}
	
	
	
	
	public static void main(String[] args) {
		
		Test2 t = new Test2();
		System.out.println(t.solution("10110011111"));
		
		char jumsu='C';
		
		switch(jumsu) {
		case 'F' : System.out.print(0);
		case 'D' : System.out.print(1);
		case 'C' : System.out.print(2);
		case 'B' : System.out.print(3);
		case 'A' : System.out.print(4);
		}
		
	}
}