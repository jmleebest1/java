package threadTest1;

public class Animal1 extends Thread{
	
	String data;
	
	
	public Animal1() {;}
	
	
	public Animal1(String data) {
		super();
		this.data = data;
	}


	@Override
	public void run() {
		  for (int i = 0; i < 10; i++) {
		         System.out.println(data);
		super.run();
	} 
	
	
	}
}
