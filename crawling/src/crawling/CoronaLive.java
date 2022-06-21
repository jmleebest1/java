package crawling;

import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CoronaLive {
		private WebDriver driver;
		private String url;
	   
		public static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
		public static final String WEB_DRIVER_PATH = "C:/chromedriver.exe";
	   
		public static void main(String[] args) {
		
			CoronaLive cl = new CoronaLive();
	   
	  
	      //드라이버 설정
		   CGV cgv = new CGV();
		      String url = "http://ncov.mohw.go.kr/bdBoardList_Real.do?brdId=1&brdGubun=13&ncvContSeq=&contSeq=&board_id=&gubun=";
		      
		      //운영체제에 드라이버 설정
		      System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
		      
		      //ChromeDriver를 driver에 담아주기
		      cl.driver = new ChromeDriver();
		      cl.driver.get(url);
		      
		      try {Thread.sleep(1000);} catch (InterruptedException e) {;}
		      
//		      cl.driver.findElement(By.cssSelector("a.c-PJLV")).click();
	   
//		      List<WebElement> resions = cl.driver.findElements(By.cssSelector("a span.tit"));
//		      List<WebElement> btns = cl.driver.findElements(By.cssSelector("a.s_link_text"));
		      List<WebElement> resions = cl.driver.findElements(By.cssSelector("span.name"));
		      List<WebElement> btns = cl.driver.findElements(By.cssSelector("#main_maplayout button"));
		      
		    
			  Scanner sc = new Scanner(System.in);
			  int index = 0;
		   
		   
			for(WebElement resion : resions) {
				   System.out.println(++index + "." + resion.getText());
			   }
			
			try {Thread.sleep(1000);} catch (InterruptedException e) {;}
			
		   System.out.println("지역 번호를 선택해주세요.");
		   index = sc.nextInt();
		   
		   try {Thread.sleep(1000);} catch (InterruptedException e) {;}
		   
		   btns.get(index-1).click();
				   
//			cl.driver.close();
//		      cl.driver.quit();
	   }
	   
	
	   
}
