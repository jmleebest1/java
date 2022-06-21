package dao;



import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestDAO {
   private WebDriver driver;
   private String url;
   
   public static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
   public static final String WEB_DRIVER_PATH = "C:/chromedriver.exe";

   public TestDAO() {
//      세팅
      System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);   
      
   ChromeOptions options = new ChromeOptions();
      options.addArguments("headless");
      driver = new ChromeDriver(options);
      url = "https://corona-live.com/";
      driver.get(url);
   }
   
   
   
   
   
   public void operate() {
//      searchArea();
      driver.close();
      driver.quit();
   
   }
   
   public void searchArea(String region) {
      
   
      
      
      int ranking = 0;
      int index= 0;
      List<WebElement> areas = driver.findElements(By.cssSelector("a div.c-PJLV"));
      List<WebElement> counts =driver.findElements(By.cssSelector("tr td:nth-child(2) div.c-davuDQ"));
      
      try {Thread.sleep(500);} catch (InterruptedException e) {;}
      
      
      
      for(int i=0; i<areas.size();i++) {
         if(areas.get(i).getText().equals(region)) {
            System.out.println(areas.get(i).getText()); //아직 지역명이 출력이 안된다
            System.out.println(counts.get(i).getText());
         }
      }
      
      try {Thread.sleep(500);} catch (InterruptedException e) {;}

   
      
   }   
   
   public String totalCorona() {
      String result="";
      try{
         driver.findElement(By.cssSelector("c-eXgEiQ"));
      }catch(Exception e){
         result = driver.findElement(By.cssSelector("div.c-ftcwwt div.c-eXgEiQ")).getText();
      }      
      try {Thread.sleep(1000);} catch (InterruptedException e) {;}
      
      return result;
   }
      
   
   
   
   public static void main(String[] args) {
      TestDAO c = new TestDAO();
//      c.operate();
      c.searchArea("서울");
      System.out.println(c.totalCorona()); // 코로나 총 확진자명
      
      c.operate();
   }
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
}