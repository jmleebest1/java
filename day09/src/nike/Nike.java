package nike;

public class Nike {
	public String branchName;
	
	public void register(Form form) {
		String[]menus=form.getMenu();
		System.out.println("========="+branchName+"=========");
		for(int i=0;i<menus.length;i++) {
			System.out.println(i+1+"."+menus[i]);
		}
		form.sell("에어포스");
		
	}
}
