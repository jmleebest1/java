package view;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import controller.userController;

import java.sql.Date;

import dao.UserDAO;
import dao.UserRecordDAO;
import vo.UserRecordVO;
import vo.UserVO;

public class TestView {    



	
	public static void main(String[] args) throws Exception {
		UserDAO dao = new UserDAO();
		UserRecordDAO rDao = new UserRecordDAO();
		UserVO user = new UserVO();
		UserRecordVO rVo = new UserRecordVO();
		Scanner sc = new Scanner(System.in);
		userController userC = new userController();
		
		
		int test = 0;
		int test2 = 0;
		while(true) {
			System.out.println("입력: ");
			test = sc.nextInt();
		if (test <= 0 || test > 12) {
			System.out.println("1월~12월 사이에 태어나지 않으셨나요? "+"이랑 지옥훈련 하고 싶으신가요?");
			continue;
		}
		break;
		}
		
	
		while(true) {
		System.out.println("몇 일에 태어나셨나요? ex) 25");
		test2 = sc.nextInt();
		if (test == 2) {
			if (test2 <= 0 || test2 > 28 ) {
				System.out.println("없는 날짜입니다.. 다시 입력해주세요!");
				continue;
			}
		}else if(test % 2 == 0) {
			if (test2 <= 0 || test2 > 31 ) {
				System.out.println("없는 날짜입니다.. 다시 입력해주세요!");
				continue;
			}
		}else {
			if (test2 <= 0 || test2 > 30 ) {
				System.out.println("없는 날짜입니다.. 다시 입력해주세요!");
				continue;
			}
		}

		break;
		}	
		
		
		
		
		// id 체크
//		System.out.println(userC.idFromCk("test_1234"));
		
		
		
		//지역 선택
/*		String region ="";
		
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
		int regionChoice = sc.nextInt();
		if (regionChoice > 0 && regionChoice <= regionData.length) {
			region = userC.getRegion(regionChoice);
			break;
		}else {
			System.out.println("빡빡이 아저씨가 모르는 입력입니다...");
		}
			
		
		}
		System.out.println(region);*/
		
		// 지역선택
/*		String[] regionData = {"서울","경기", "인천", "강원", "충북", "울산","부산", "대구", "광주", "대전"
				, "세종", "충남", "경북", "경남", "전북", "전남", "제주"};
		for (int i = 0; i < regionData.length; i++) {
			System.out.println(i+1+regionData[i]);
		}
		System.out.println(userC.getRegion(1));*/
		
		
		// 성별 선택
/*		char gender = 'F';
		while(true) {
		System.out.println("성별을 알려주세요!");
		System.out.println("1. 남자  2. 여자");
		// 성별 선택 로직
		int genderChoice = sc.nextInt();
		if (genderChoice > 2 || genderChoice <= 0) {
			System.out.println(" 빡빡이 아저씨가 모르는 입력입니다... ");
		}else {
			gender = userC.getGender(genderChoice);
			break;
		}
		
		}
		System.out.println(gender);*/
		
//		if(dao.checkNumber("1234")) {
//			System.out.println("확인");
//		}else {
//			System.out.println("실패");
//		}

//		 정규식 테스트
//		userController uc = new userController();
//		System.out.println(uc.passwordFromCk("asdqwe12@"));
		
	
//		Date endDate = Date.valueOf("1992-12-04");
//
//		user.setUserAge(endDate);
//		user.setUserGender('F');
//		user.setUserName("사용자7");
//		user.setUserId("user7");
//		user.setUserPhoneNum("01012121212");
//		user.setUserPw("1212");
//		user.setUserRegion("서울");
//		
//		dao.join(user);
//		
//		
//		rVo.setUserId("user5");
//		rVo.setRecordCount(5);
//		rVo.setRecordDate("2010.07.26");
//		rVo.setRecordExercise("벤치프레스");
//		rVo.setRecordNum(1);
//		rVo.setRecordTime(120);
		
//		if(dao.login("user4","0000")) {
//			System.out.println("확인");
//		}else {
//			System.out.println("실패");
//		}
//		rDao.insertRecord(rVo);
	
		
		// 마이페이지 회원 및 개인정보 조회 
//		user = dao.getMyInfo();
//		System.out.println("아이디: "+user.getUserId());
//		System.out.println("성별: "+user.getUserGender());
//		System.out.println("나이: "+user.getUserAge());
//		System.out.println("전화번호: "+user.getPhonNum());
//		// 생일을 나이로 계산
//		System.out.println(dao.getAge(user.getUserAge()));
		
		// 아이디 찾기
//		ArrayList<UserVO> users = new ArrayList<>();
//		ArrayList<UserRecordVO> records = new ArrayList<>();
//		users = dao.findId("01011112222");
		
//		for(UserVO v:users) {
//			System.out.println(v);
//		}
//		
//		 UserRecordDAO rDAO = new UserRecordDAO();
//		 UserRecordVO rVO= new UserRecordVO();
//		 // 로그인한 회원의 운동 전체기록 조회
//		 records = rDAO.getALLRecord("user2");
//		 for(UserRecordVO v:records) {
//			 System.out.println(v);
//		 }
		 
//		 System.out.println("운동"+rVO.getUserId());
//		System.out.println( rVO.getRecordCount());
		 
		
//		dao.sendNumber("01037325638");
//		System.out.println("성공");
		
		
		
		//로그인
		// 메뉴 -> 마이페이지
		// UserTable 조회 , UserRecordTable 조회 
		// 
		// 
		
		
		
	  // DB 연결테스트 
/*	  for (int i = 0; i < datas.size(); i++) {
			System.out.println(datas.get(i));
		}
		
		 
		for (String data:datas ) {
			System.out.println(data);
		}
		*/
		
		
	}
	
}
