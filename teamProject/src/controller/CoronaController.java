package controller;




import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CoronaController {
	private WebDriver driver;
	private String url;
	
	public static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
	public static final String WEB_DRIVER_PATH = "C:/chromedriver.exe";

	public CoronaController() {
//		세팅
		System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);	
		
	ChromeOptions options = new ChromeOptions();
		options.addArguments("headless");
		driver = new ChromeDriver(options);
		url = "https://corona-live.com/";
		driver.get(url);
	}
	
	
	
	
	
	public void operate() {
//		searchArea();
		driver.close();
		driver.quit();
	
	}
	
	public String searchArea(String region) {
		
		String result = "";
		
		
		
		int ranking = 0;
		int index= 0;
		List<WebElement> areas = driver.findElements(By.cssSelector("a div.c-PJLV"));
		try {Thread.sleep(1000);} catch (InterruptedException e) {;}
		
		// 지역별 확진자수로 데이터가 크롤링이 불안정함
		List<WebElement> counts =driver.findElements(By.cssSelector("tr td:nth-child(2) div.c-davuDQ")); 
		
//		List<WebElement> counts =driver.findElements(By.cssSelector("c-dKTxzV c-davuDQ"));
		try {Thread.sleep(1000);} catch (InterruptedException e) {;}
		
		
		for(int i=0; i<areas.size();i++) {
			if(areas.get(i).getText().equals(region)) {
//				System.out.println(counts.get(i).getText());
				result = counts.get(i).getText();
				result = result.replaceAll(",", "1");
				result = result.replaceAll("명", "1");
				return result;
			}
		}
	

		
		return null;
		
	}	
	
	public String totalCorona() {
		String result="";
		try{
			driver.findElement(By.cssSelector("c-eXgEiQ"));
		}catch(Exception e){
			result = driver.findElement(By.cssSelector("div.c-ftcwwt div.c-eXgEiQ")).getText();
		}		
		try {Thread.sleep(1000);} catch (InterruptedException e) {;}
		

		result = result.replaceAll(",", "1");
		result = result.replaceAll("명", "1");
		return result;
	}

// 총 화	
	
	
	
	public static void main(String[] args) {
		CoronaController c = new CoronaController();
//		c.operate();
		
		
		
		String data = c.searchArea("경기");
		if (data != null) {
			System.out.println(data);

		}else {
			// 데이터 로딩시 알수없는 문제로 지역별 코로나 확진자수를 가져오지 못하는 경우가 존재한다.
			// 이때 null리턴하여 전체 확진자를 기준으로 작업한다. 
			
			System.out.println(c.totalCorona()); // 코로나 총 확진자명
		}
		
		
		c.operate();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}