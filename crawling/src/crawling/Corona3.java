package crawling;

import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Corona3 {

   private WebDriver driver;
      public static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
      public static final String WEB_DRIVER_PATH = "C:/chromedriver.exe";
      
      public static void main(String[] args) {
         
         Corona3 corona = new Corona3();
         String url = "https://corona-live.com/";
         
        
         System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
         corona.driver = new ChromeDriver();
         corona.driver.get(url);
         
         try {Thread.sleep(1000);} catch (InterruptedException e) {;}
         
                 
         int ranking = 0;
  
         Scanner sc = new Scanner(System.in);
         int index = 0;
         
   
         
         
         List<WebElement> titles = corona.driver.findElements(By.cssSelector("a div.c-PJLV"));
         List<WebElement> btns	= corona.driver.findElements(By.cssSelector("a"));
        		
         
        
		
	   
	   
		for(WebElement resion : titles) {
			   System.out.println(++index + "." + resion.getText());
		   }
		
		try {Thread.sleep(1000);} catch (InterruptedException e) {;}
		
	   System.out.println("지역 번호를 선택해주세요.");
	   index = sc.nextInt();
	   
	   try {Thread.sleep(1000);} catch (InterruptedException e) {;}
	   
	   corona.driver.get(btns.get(index-1).getAttribute("href"));
	   //click()이 안되므로 해당 a태그의 href를 직접 가져와서 넣어준다
         
	   try {Thread.sleep(1000);} catch (InterruptedException e) {;}
	 
	   int total = 0;
	   
       WebElement count = corona.driver.findElement(By.className("c-dbuePK"));
           String result = count.getText();
           
          
			
				try {
					total += Integer.parseInt(result.replaceAll("," , ""));
				} catch (NumberFormatException e) {
					total += Integer.parseInt(result.replaceAll("." , ""));
				}
       	
       	
           System.out.println("금일 확진자 수 : " + total + "명");

	   
//         corona.driver.close(); 
//         corona.driver.quit();
      }
      
      
}