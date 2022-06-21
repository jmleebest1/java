package bank;

public class Bank {
	// 모든 Bank객체에서 공유하는 static 변수 (클래스 변수)
		static Bank[][] arrBank = new Bank[3][100]; // 각 3개의 은행에서 은행별 고객수 100명
		static int[] arCnt = new int[arrBank.length]; // 각 은행별 고객수 만큼
		// 객체
		// 돈
		int money;
		String name;
		String account;
		String phone;
		String pw;

		// 검색된 객체의 은행번호 
		// 은행이 3개이기 때문에 들어갈 수 있는 번호는 0~2이다. (0,1,2)
		static int bank_num = -1;
		public Bank() {	}

		// 중복검사
		static Bank checkDup(String account) {
			// 외부에서 계좌번호를 전달받고 전체 사용자의 계좌번호와 비교한다.
			// 중복이 없다면 b에 null이 담기고, 중복이 있다면 해당 객체가 b에 담긴다.
			Bank b = null;
			// 이전 bank_num을 초기화 
			bank_num = -1;
			
			for(int i = 0; i < arrBank.length; i++ ) {
				// 은행 갯수 만큼 반복
				for(int j = 0; j < arCnt[i]; j++ ) {
					if(arrBank[i][j].account.equals(account)) {
						// 각 고객의 계좌번호와 외부에서 전달된 계좌번호 비교 
						// 이미 있는 계좌번호라면 이 영역으로 들어옴 
						
						// 검색된 고객의 은행 번호 bank_num에 저장
						bank_num = i;
						
						// 검색된 객체 b에 저장
						b = arrBank[i][j];
						
						// 계좌번호는 중복이 없으므로 더 이상 반복할 필요가 없다. 
						break;
					}
				}
			}
			return b;
		}
		
		// 핸드폰번호 검사
		static Bank checkPhone(String phone) {
			// 위의 중복검사와 기능은 똑같다. accoun를 phone으로만 변경함
			Bank b = null;
			bank_num =-1;
			for(int i =0; i<arrBank.length; i++ ) {
				for(int j = 0; j < arCnt[i]; j++ ) {
					if(arrBank[i][j].phone.equals(phone)) {
						bank_num = i;
						b = arrBank[i][j];
						break;
					}
				}
			}
			return b;
		}
		// 로그인
		static Bank login(String account, String pw) {
			// 외부에서 전달한 계좌번호와 비번 중 
			// 계좌번호 먼저 checkDup(String account)에 전달하고 b에 null이 담겼다면 없는 계좌번호라는 뜻
			Bank b = checkDup(account);
			if(b != null ) {
				// 계좌번호를 찾았다면 해당 객체의 비번과 외부에서 전달된 비번 비교 
				if(!b.pw.equals(pw)) b = null; // 비번이 일치하지 않으면 b에 다시 null이 담긴다.
			}
			// 계좌번호와 비번이 일치하면 b 객체에는 해당 객체가 담겨 있다.
			// 그 외 모든 상황에서는 null 이 담겨있다.
			return b;
		}
		
		// 메소드
		// 입금 , 출금, 잔액조회
		void deposit(int bal) { // 입금
			if (bal < 1) {
				throw new ArithmeticException();
			}
			money += bal;
		}

		boolean withdraw(int bal) { // 출금
			boolean check = false;
			if (!(this.money - bal < 0)) {
				this.money -= bal;
				check = true;
			}
			return check;
		}

		void show() { // 잔액조회
			System.out.println("-------------잔액 조회-------------");
			System.out.println("현재 통장 잔액은 " + this.money + "원 입니다.");
			System.out.println("-------------END----------------");
		}

		public static void main(String[] args) {
	// 확인
			Bank bk = new Bank();
			try {
				bk.deposit(0);
			} catch (ArithmeticException e) {
				System.out.println("입금하려는 금액이 1보다 작을 수 없습니다.");
			}
			bk.show();

			try {
				bk.withdraw(15000);
				System.out.println(bk.money + "원이 남았습니다.");
			} catch (ArithmeticException e) {
				System.out.println("출금 잔액이 부족합니다.");
			}
			bk.show();

		}
	}



