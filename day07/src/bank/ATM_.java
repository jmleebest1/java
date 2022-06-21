//package bank;
//
//import java.util.Random;
//import java.util.Scanner;
//
//public class ATM_{
//	public static void main(String[] args) {
//		// 각 은행별로 최대 100명의 고객을 유치할 수 있다.
//		String msg = "1.신한은행\n2.국민은행\n3.우리은행\n4.나가기";
//		String menu = "1.계좌만들기\n2.입금하기\n3.출금하기\n4.잔액조회\n5.계좌번호 찾기\n6.나가기";
//
//		// 은행 이름 넣어주는 배열 선언
//		String[] bankName = { "신한은행", "국민은행", "우리은행" };
//
//		Scanner sc = new Scanner(System.in);
//		Random r = new Random();
//
//		// 임시저장공간
//		String name="",  pw = "", account = "",   phone = "";
//		
//		// 검사한 객체를 담을 저장공간**********************
//		Bank user = null;
//		
//		//선택창 입력받기
//		int choice = 0, menu_choice = 0;
//		while(true) {
//			System.out.println(msg);
//			choice = sc.nextInt();
//			
//			if(choice == 4 ) { break; }
//			// 사용자가 선택한 은행번호가 choice - 1 이므로 1 빼준다
//			choice--;
//			
//			while(true) {
//				System.out.println(menu);
//				menu_choice = sc.nextInt();
//				// 엔터 먹기
//				sc.nextLine();
//				
//				// 나가기
//				if(menu_choice == 6 ) {System.out.println("프로그램 종료합니다."); break;}
//				switch (menu_choice) {
//				
//				case 1:
//					//각 은행에 규칙성을 부여하고자 배열에 달아준다
//					Bank[] arBank = {new KBbank(), new NHbank(), new Kakaobank()};
//					while(true) {
//						// 새로운 회원의 랜덤한 계좌번호를 account에 담아준다.
//						account = "" + (r.nextInt(90000) + 10000 );
//						// 만약 존재하지 않는 계좌번호라면 탈출한다.
//						// 중복이 있다면 없을 때까지 무한반복
//						if(Bank.checkDup(account) == null ) break;
//					}
//					// 위의 반복문을 탈출했다면 acc에는 중복이 없는 계좌번호가 담겨있다.
//					// 해당 은행 객체는 계좌번호 및 정보를 넣어준다.
//					arBank[choice].account = account;
//				
//					
//					System.out.print("예금주 : " );
//					arBank[choice].name = sc.next();
//					
//					while(true) {
//						int i = 0;
//						System.out.print("핸드폰 번호 [  '-' 제외 ] : ");
//						phone = sc.next();
//						for(i = 0 ; i <phone.length(); i++ ) {
//							// 문자를 넣으면 다시 반복되고 숫자만 입력할 수 있게끔
//							
//							// 입력한 숫자가 0~9까지만 입력되도록 
//							if (phone.charAt(i) < 48 || phone.charAt(i) > 57) {
//								break;
//							}
//						}
//						// 위의 for문에서 강제로 break를 만나서 탈출한다면 i는 phone.length() 까지 
//						// 절대로 증가할 수 없다. 따라서 정상적으로 증가하여 i가 phone.length()가 되었다면 
//						// 사용자가 핸드폰번호를 특수문자 없이 잘 입력했다는 뜻이다. 
//						if (i == phone.length()) {
//							// 사용자가 입력한 폰번호가 중복이 없다면 탈출 
//							if(Bank.checkPhone(phone)==null) break;
//							else System.out.println("이미 존재하는 번호 입니다.");
//						}
//					}
//					
//					// 핸드폰 번호를 정상적으로 입력했을 때 올 수 있는 영역
//					arBank[choice].phone = phone;
//					while(true) {
//						System.out.print("비밀번호 4자리 : ");
//						pw=sc.next();
//						// 비번은 4자리로 만들자******************
//						if(pw.length() == 4 ) { break; }
//					}
//					
//					arBank[choice].pw = pw;
//					// 사용자가 선택한 은행(행 : choice)에 arCnt[choice]번째 고객으로 신규고객arBank[choice]저장
//					Bank.arrBank[choice][Bank.arCnt[choice]] = arBank[choice];
//					System.out.println("내 계좌번호 : "+account);
//					// 사용자가 선택한 은행의 고객수 1증가
//					Bank.arCnt[choice]++;
//					break;
//					
//					// 입금하기
//				case 2 : 
//					System.out.print("계좌번호 : ");
//					account = sc.next();
//					System.out.print("비밀번호 : ");
//					pw = sc.next();
//					
//					// 로그인 성공시 객체 리턴. 실패시 null 리턴*****************
//					user = Bank.login(account, pw);
//					//입금시 타행에서 입금 할 수 없음, 고객의 은행 번호와 현재 이용중인 은행번호가 일치하지 않으면 
//					// 사용자에게 안내 메시지 출력
//					if ( Bank.bank_num != choice ) {
//						System.out.println(bankName[Bank.bank_num] + "에서 처리 가능합니다.");
//						continue;
//					}
//					// 로그인 성공시 참 
//					if (user != null ) {
//						System.out.print("입금액 : ");
//						// 해당 객체가 Bank의 자식 객체면 재정의된 메소드로 실행된다.
//						user.deposit(sc.nextInt());
//						System.out.println("잔고 : "+user.money);
//					} else { System.out.println("입금 실패 : 정보 오류"); }
//					break;
//					
//					// 출금하기 
//				case 3 : 
//					System.out.print("계좌번호 : ");
//					account = sc.next();
//					System.out.print("비밀번호 : ");
//					pw = sc.next();
//					
//					user = Bank.login(account, pw);
//							if(user != null ) {
//								System.out.print("출금액 : ");
//								if (user.withdraw(sc.nextInt())) {
//									System.out.println("잔고 : "+user.money);
//								} else {	System.out.println("출금 실패 : 잔액 부족");
//								}
//							} else System.out.println("출금 실패 : 정보 오류 ");
//						break;
//					// 잔액조회
//				case 4 :
//					System.out.print("계좌번호 : ");
//					account = sc.next();
//					System.out.print("비밀번호 : ");
//					pw = sc.next();
//					user = Bank.login(account, pw);
//					if(user != null ) user.show();
//					else System.out.println("조회 실패 : 정보 오류 ");
//					break;
//					
//					// 계좌번호 찾기
//				case 5 :
//					System.out.print("계좌 개설시 등록한 핸드폰 번호 : ");
//					phone = sc.nextLine();
//					user = Bank.checkPhone(phone);
//					if ( user != null ) {
//						// 사용자의 은행과 일치하는 은행에서만 계좌번호를 찾을 수 있다. 
//						if(Bank.bank_num != choice) {
//							System.out.println(bankName[Bank.bank_num] +" 에서 처리 가능합니다.");
//							continue;
//						}
//						System.out.print("비밀번호 : ");
//						pw = sc.nextLine();
//						
//						//만약 핸드폰번호와 비밀번호가 일치하면 중복되지 않는 새로운 계좌번호를 생성해준다.
//						if(user.pw.equals(pw)) {
//							while(true) {
//								account = "" + (r.nextInt(90000)+10000);
//								if(Bank.checkDup(account) == null ) {break;}
//							}
//							user.account = account;
//							System.out.println(user.name+"님의 새로운 계좌번호 : "+account);
//						} else { System.out.println(" ** 정보 오류 ** "); }
//					}
//					break;
//				}
//			}
//		}
//	}
//}
//
//
//case 1:
//	//각 은행에 규칙성을 부여하고자 배열에 달아준다
//	Bank[] arBank = {new KBbank(), new NHbank(), new Kakaobank()};
//	while(true) {
//		// 새로운 회원의 랜덤한 계좌번호를 account에 담아준다.
//		account = "" + (r.nextInt(90000) + 10000 );
//		//없는 계좌면 멈추고 중복이 아닐때까지 반복
//		if(Bank.checkDup(account) == null ) break;
//	}
//	
//	arBank[choice].account = account;
//	
//	System.out.print("예금주 : " );
//	arBank[choice].name = sc.next();
//	
//	while(true) {
//		int i = 0;
//		System.out.print("핸드폰 번호  '-' 제외  : ");
//		phone = sc.next();
//		for(i = 0 ; i <phone.length(); i++ ) {
//			//문자를 넣으면 다시 반복되고 숫자만 입력할수있게끔
//			
//			// 입력한 숫자가 0~9까지만 되도록 설정
//			if (phone.charAt(i) < 48 || phone.charAt(i) > 57) {
//			
//			}
//		}
//		if (i == phone.length()) {
//			// 사용자가 입력한 폰번호가 중복이 없다면 탈출 
//			if(Bank.checkPhone(phone)==null) break;
//			else System.out.println("이미 존재하는 번호 입니다.");
//		}
//	}
//	
//
//	arBank[choice].phone = phone;
//	while(true) {
//		System.out.print("비밀번호(4자리) : ");
//		pw=sc.next();
//			
//	}
//
////임금하기	
//case 2 : 
//	System.out.print("계좌번호 : ");
//	account = sc.next();
//	System.out.print("비밀번호 : ");
//	pw = sc.next();
//
//	
//}
//}
//}
//}
//}