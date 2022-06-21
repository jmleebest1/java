package file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileTask {
	public static void main(String[] args) throws IOException{
		//food.txt파일을 현재 경로에 생성하고,
		//파일 내용은 족발, 보쌈, 짜장면, 탕수육 네 가지 음식으로 작성한다(append : true)
		//각 음식은 줄바꿈 후 다음 음식을 넣도록 한다.
		BufferedWriter fd = new BufferedWriter(new FileWriter("food.txt"));
		String[] foods= {"족발","보쌈","짜장면","탕수육"};
		for(int i =0;i<foods.length;i++) {
			fd.write(foods[i]+"\n");
		}
		fd.close();
	
		//작성한 내용을 콘솔에 출력한다.
		
	}

}
