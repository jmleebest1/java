package anonymous;

public class Knotted {
	
	public String branchName;
	//지점 이름
							//양식을 받아온다
	public void register(Form form) {
		String[] menus = form.getMenu();
		//지점의 메뉴를 받아온다
		System.out.println("=====`===" + branchName + " 도넛 메뉴========");
		for (int i = 0; i < menus.length; i++) {
			//메뉴가 여러개이므로 반복을 돌려준다
			System.out.println(i + 1 + ". " + menus[i]);
		}
		
		form.sell("민트초코");
		//외부에서 사용자의 주문을 받아서 어떻게 처리할지는 그 체인점에서 구현한다
		//사용자가 민트초코를 주문했을때! 라는 의미, 원래는 입력을 받아야 하지만 받았다 치고 그냥 이렇게 하자
	}
}
