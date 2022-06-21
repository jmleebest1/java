package thread;

public class Thread2 implements Runnable{
   
   @Override
   public void run() {
      for (int i = 0; i < 10; i++) {
         System.out.println(Thread.currentThread().getName()); //접근한 객체의 이름을 출력
         try {Thread.sleep(1000);} catch (InterruptedException e) {;}
      }
   }
}