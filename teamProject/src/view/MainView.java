package view;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;

import controller.CoronaController;
import controller.userController;
import dao.UserDAO;
import dao.UserRecordDAO;
import vo.UserRecordVO;
import vo.UserVO;

public class MainView {
	public static void main(String[] args) {

		String chatBotName ="빡빡이 아저씨";
		String userMsgTab = "\t\t\t\t\t";


		UserDAO uDAO = new UserDAO();
		UserRecordDAO recordDAO = new UserRecordDAO();
		userController userC = new userController();
		CoronaController coranaC = new CoronaController();

		Scanner sc = new Scanner(System.in);
		int choice = 0 ;
		boolean JoinCk = false; // 회원가입이후 바로 로그인을 위한 값


		String id = "";
		String pw = "";



		while(true) {
			boolean cancelLogin = true; // 로그인취소시 다시 반복을 할 수 있게 true로 설정
			if (!JoinCk) {


				System.out.println();
				System.out.println("당신의 건강을 지켜드리는 "+chatBotName+"입니다!");
				System.out.println();

				try {Thread.sleep(1000);} catch (InterruptedException e) {;}
				System.out.println(chatBotName+"가 처음 이신가요?");
				System.out.println("1.네  2.아니요 3. 나가기" );
				choice = sc.nextInt();
			}else {
				choice = 2;
			}
			if (choice == 1) {
				// 회원가입
				try {Thread.sleep(300);} catch (InterruptedException e) {;}
				System.out.println(userMsgTab+"네 처음 이용합니다.");
				try {Thread.sleep(1000);} catch (InterruptedException e) {;}
				System.out.println(chatBotName+"가 회원가입을 도와줄게요!");
				// 회원가입 
				// 회원가입 메소드 사용

				try {Thread.sleep(1000);} catch (InterruptedException e) {;}

				String name = "";
				int genderChoice = 0;
				String PhoneNum ="";
				String  birthdayBeforeAge = "";
				char gender = 'F'; 
				int regionChoice = 0;
				String region= "";

				UserVO user = new UserVO();

				boolean joinFlag = true;
				while(true) {
					boolean flag = false;
					System.out.println("사용할 아이디를 입력해주세요! :");
					id = sc.next();

					// 아이디 중복체크  , 정규화
					//				userC.id
					if(uDAO.checkId(id)== -1 ) {
						flag = true;
					}else {
						System.out.println("이미 존재하는 ID입니다 ㅠㅠ ");
						continue;
					}

					if (userC.idFromCk(id)) {
						flag = true;
					}else {
						System.out.println("5~12자 영문 대 소문자 숫자를 사용해주세요. (영어로 시작해야하며  '_'를 제외한 특수문자는사용할 수 없습니다)");
						continue;
					}

					if(flag) {break;}

				}

				while(true) {
					System.out.println("사용할 비밀번호를 입력해주세요! :");
					pw = sc.next();
					String result = userC.passwordFromCk(pw);
					if(result.equals("pass")) {
						break;
					}else {
						System.out.println(result);
						continue;
					}
				}


				int pwChance = 4;
				while(true) {
					System.out.println("비밀번호 확인을 위해 한번 더 비밀번호를 입력해주세요! :");
					String ckPw = sc.next();

					if (userC.passwordCk(pw,ckPw)) {
						break;
					}else {
						System.out.println("비밀번호가 일치 하지 않습니다 ㅠㅠ");
						System.out.println("다시 시도 해주세요! ("+pwChance+"회 남음)");
						pwChance--;
						if (pwChance == 0) {
							System.out.println("5회 이상 실패하였습니다... 다시 시도해주세요!");
							joinFlag = false;
							break;
						}
						continue;
					}
				}

				if (!joinFlag) {
					continue;
				}
				System.out.println("이름을 알려주세요!"); // 중복검사 필요
				name = sc.next(); // 한글만 들어가게 메소드 구현@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

				while(true) {
					System.out.println("성별을 알려주세요!");
					System.out.println("1. 남자  2. 여자");
					// 성별 선택 로직
					genderChoice = sc.nextInt();
					if (genderChoice > 2 || genderChoice <= 0) {
						System.out.println(chatBotName+"가 모르는 입력입니다... ");
					}else {
						gender = userC.getGender(genderChoice);
						break;
					}

				}

				while(true) {
					System.out.println("전화번호를 알려주세요!");
					PhoneNum = sc.next(); 
					if(userC.phonNumCk(PhoneNum)) {
						break;
					}else {
						System.out.println("잘못된 전화번호입니다.");
						continue;
					}
				}
				// 전화번호 유효성 검사
				int ageYear  = 0;
				int ageMonth = 0;
				int ageMount = 0;
				while(true) {
					System.out.println("생일를 알려주세요!");
					System.out.println("몇 년도에 태어나셨나요? ex) 1985");
					ageYear = sc.nextInt();
					if(ageYear < 0) {
						System.out.println("정말인가요?..."+chatBotName+"은 인정할 수 없어요..! "+" 다시 입력해주세요!");
						continue;
					}
					break;
				}

				while(true) {
					System.out.println("몇월에 태어나셨나요? ex) 3");
					ageMonth = sc.nextInt();
					if (ageMonth <= 0 || ageMonth > 12) {
						System.out.println("1월~12월 사이에 태어나지 않으셨나요? "+chatBotName+"이랑 지옥훈련 하고 싶으신가요?");
						continue;
					}
					break;
				}

				while(true) {
					System.out.println("몇 일에 태어나셨나요? ex) 25");
					ageMount = sc.nextInt();
					if (ageMonth == 2) {
						if (ageMount <= 0 || ageMount > 28 ) {
							System.out.println("없는 날짜입니다.. 다시 입력해주세요!");
							continue;
						}
					}else if(ageMonth % 2 == 0) {
						if (ageMount <= 0 || ageMount > 31 ) {
							System.out.println("없는 날짜입니다.. 다시 입력해주세요!");
							continue;
						}
					}else {
						if (ageMount <= 0 || ageMount > 30 ) {
							System.out.println("없는 날짜입니다.. 다시 입력해주세요!");
							continue;
						}
					}

					break;
				}


				birthdayBeforeAge +=  ageYear+"-"+ageMonth+"-"+ageMount;







				while(true) {
					String[] regionData = {"서울","경기", "인천", "강원", "충북", "울산","부산", "대구", "광주", "대전"
							, "세종", "충남", "경북", "경남", "전북", "전남", "제주"};
					for (int i = 0; i < regionData.length; i++) {
						System.out.print(i+1+". "+regionData[i]+"\t");
						if( (i+1) % 5 == 0) {
							System.out.println();
						}
					}
					System.out.println();
					System.out.println();
					System.out.println("거주지를 선택해주세요!");
					regionChoice = sc.nextInt();
					if (regionChoice > 0 && regionChoice <= regionData.length) {
						region = userC.getRegion(regionChoice);
						break;
					}else {
						System.out.println(chatBotName+"가 모르는 입력입니다...");
					}


				}







				// 메소드로 거주지 번호를 에 따른 지역  String 리턴 


				Date resultDate = Date.valueOf(birthdayBeforeAge); // 스트링을 Date 타입으로 변경

				user.setUserId(id); // 중복검사 전
				user.setUserPw(pw); // 유효성 검사 구현 전 
				user.setUserName(name); 
				user.setUserGender(gender); // 선택 구현 전
				user.setUserPhoneNum(PhoneNum); // 유효성 검사 구현전
				user.setUserAge(resultDate); 
				user.setUserRegion(region); // 선택지 구현전

				if (uDAO.join(user)) {
					System.out.println("회원가입 성공!! 축하해요 이제"+chatBotName+"를 이용할 수 있어요!");
					JoinCk = true;
					continue;
				}else {
					System.out.println("=====확인되지 않은 오류가 발생했습니다 ... 빠른 시일내에 복구하겠습니다 다시 시도해주세요!=====");
				}




			}else if(choice == 2) {

				// 로그인
				if (!JoinCk) {
					try {Thread.sleep(300);} catch (InterruptedException e) {;}
					System.out.println(userMsgTab+"네 이용해봤어요");
				}
				try {Thread.sleep(1000);} catch (InterruptedException e) {;}
				System.out.println(chatBotName+"의 도움을 받기 위해서는 로그인을 해야해요!");
				System.out.println();
				while(cancelLogin) {
					try {Thread.sleep(1000);} catch (InterruptedException e) {;}
					System.out.println("아이디를 입력하세요! ");
					id = sc.next();
					System.out.println("비밀번호를 입력하세요! ");
					pw = sc.next();


					if( uDAO.login(id, pw) ) {
						// 로그인 성공 
						try {Thread.sleep(1000);} catch (InterruptedException e) {;}
						System.out.println("로그인에 성공했어요!");
						System.out.println();
						System.out.println(chatBotName+"가 무엇을 도와드릴까요?");
						// 선택지 제공
						System.out.println(uDAO.userNumber);


						// 선택지 제공
						System.out.println("1. 마이페이지\n2. 오늘의 운동 추천\n3.운동 기록하기 \n4. 나가기");
						choice = sc.nextInt();
						ArrayList<UserRecordVO> records =new ArrayList<>();
						UserVO user = new UserVO();
						while(true){
							if(choice == 1){
								//  1.  1-1 마이페이지 getMyInfo, 1-2 getALLRecord,
								//회원정보 수정 or 조회

								// 조회 
								user = uDAO.getMyInfo();
								System.out.println(user.getUserName()+"님의 마이페이지입니다!");
								System.out.println("전화번호 :"+user.getUserPhoneNum());
								
								// 날짜 나이로 변경시 문법 오류 발생 
//								System.out.println(user.getUserAge()); 
								
								break;
							}else if(choice == 2){
								//  2. 코로나 크롤링			
								// 2-1. searchArea()로 로그인한 유저의 지역과 비교하여 값 가져오기
								//  2-2. 300명 이하이면 야외운동을 추천합니다 출력    				(향상 -> 운동 리스트중랜덤출력도 가능하다)
								//  2-3. 300명 이상이면 홈트레이닝을 추천합니다 출력 				(향상-> 홈 트레이닝 운동 랜덤출력)
								System.out.println("코로나 확진자를 통한 운동추천");
								int  coranaCnt = 0;
								
								records =	recordDAO.getALLRecord(user.getUserId());
								for(UserRecordVO v:records) {
									System.out.println(v);
								}
								
								String data =coranaC.searchArea(user.getUserRegion());

								if (data != null) {
									
									coranaCnt = Integer.parseInt(data) ;
									if( coranaCnt >= 300) {
										// 이상
										System.out.println("홈 트레이닝을 추천합니다");
										break;
									}else {
										// 이하 
										System.out.println("야외 운동을 해보는건 어떨까요?");
										break;
									}
									//
								}else {
									String data2 = coranaC.totalCorona();
									

										 coranaCnt = Integer.parseInt(data2) ;
									if( coranaCnt>= 1000) {
										// 이상
										System.out.println("홈 트레이닝을 추천합니다");
										break;
									}else {
										// 이하 
										System.out.println("야외 운동을 해보는건 어떨까요?");
										break;
									}
									
									
									
								}
							}else if(choice ==3){
								// 운동 기록  
								// insertRecord(UserRecordVO record)로 넘겨줌
								// 운동종목은 배열로 운동리스트 만들어서 사용자가 인덱스번호를 선택해서 운동값 insert해준다
								// UserId(로그인된 객체에서 게터로 가져온다) , RecordTime,RecordExercise, RecordCount
								
								
								
								
							}else if(choice == 4){//나가기
								break;
							}else {
								System.out.println("뒤로 갑니다.");
							}
						}               



						// 3 성우님










					}else {
						// 로그인 실패
						try {Thread.sleep(1000);} catch (InterruptedException e) {;}
						System.out.println(" 로그인에 실패 했어요 ㅠㅠ ");
						System.out.println(" 1. 로그인 다시 시도하기  \n 2. 이전으로 돌아가기");
						System.out.println();
						System.out.println();

						choice = sc.nextInt();
						if (choice == 1) {
							continue;
						}else if (choice == 2) {
							JoinCk = false;
							cancelLogin = false;
							break;
						}else {
							System.out.println(chatBotName+"가 모르는 입력입니다... 이전 작업을 다시 시도합니다.");
							continue;
						}

					}
				}



			}else if(choice == 3) {
				System.out.println(userMsgTab+"그만할래요.");
				try {Thread.sleep(1000);} catch (InterruptedException e) {;}
				System.out.println(" 또 도움이 필요하면 빡빡이 아저씨를 찾아오세요! ");
				try {Thread.sleep(1000);} catch (InterruptedException e) {;}
				System.out.println(chatBotName+"가 퇴장했습니다. ");
				JoinCk = false;
				break;
			}else {
				try {Thread.sleep(1000);} catch (InterruptedException e) {;}
				System.out.println(chatBotName+"가 모르는 입력입니다... 이전 작업을 다시 시도합니다.");
				//JoinCk = false; 
				continue;
			}




		}







	}






}
