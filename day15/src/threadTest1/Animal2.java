package threadTest1;

public class Animal2 {
	public static void main(String[] args) {
		Animal1 dog = new Animal1("멍멍");
	    Animal1 cat = new Animal1("꺅꺅");
	    Animal1 cow = new Animal1("음머");
	    
	    dog.start();
	      cat.start();
	      cow.start();
	}

}
