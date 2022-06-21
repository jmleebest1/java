package view;

import java.util.Scanner;

import dao.UserDAO;
import vo.UserVO;

public class View {
   public static void main(String[] args) {
      UserDAO dao = new UserDAO();
      UserVO vo = new UserVO();
      
      
      int i = (3 + '0');
		
		System.out.println(i);
//      dao.checkJoin("01012341234");
      
      //아이디 중복 검사
//      if(dao.checkId("hds1234") == -1) {
//    	  System.out.println("사용 가능한 아이디 입니다.");
//    	 }else {
//    		 System.out.println("사용 할 수 없는 아이디 입니다.");
//    	 }
      
    //아이디 중복 검사 
//      int status = dao.checkId("hds1234");
//      if(status == -1) {
//    	  System.out.println("사용 가능한 아이디 입니다.");
//      }else if (status == 0) {
//    	  System.out.println("중복된 아이디 입니다.");
//      }else {
//    	  System.out.println("사용할 수 없는 아이디 입니다.");
//      }
//
//      if (dao.checkId("seohyun") != -1) {
//			System.out.println("해당 아이디가 존재합니다.");
//		} else {
//			System.out.println("사용 가능한 아이디");
//		}

    //회원 탈퇴
//      if(dao.login("hds1111", "1111")==0) {
//    	  dao.delete("1111");
//    	  System.out.println(dao.selectUser());
//      }else {
//    	  System.out.println("로그인 실패");
//      }
      
//      dao.login("hds7777", "7777");
//      dao.delete("7777");

//      if(dao.login("hds1234", "1234") == 0) {
//    	  System.out.println("로그인 성공");
//      }else {
//    	  
//      }
//      if(dao.login("hds1111", "1111") == 0) {
//          System.out.println("로그인 성공");
//          
//       }else {
//          System.out.println("로그인 실패");
//       }
//       if (dao.delete("1111")) {
//       	System.out.println("회원 탈퇴 성공");
//       
//       }
//       else
//       	System.out.println("회원 탈퇴 실패");
//      }


    	  
      
      
      //정보 수정
//      Scanner sc = new Scanner(System.in);
//      String id = null;
//      String pw = null;
//      
//      System.out.print("아이디 : ");
//      id = sc.next();
//      
//      System.out.print("비밀번호 : ");
//      pw = sc.next();
//      
//      int status = dao.login(id, pw);
//      
//      if(status == 0) {//일반 계정
//         System.out.print("새로운 비밀번호 : ");
//         pw = sc.next();
//         
//         UserVO user = dao.selectUser();
//         user.setPw(pw);
//         dao.updateInfo(user);
//         System.out.println("수정 완료");
//         
//      }else if(status == 1) {//탈퇴 계정
//         System.out.println("복구를 하시려면 비밀번호를, 취소는 -1을 입력하세요");
//         pw = sc.next();
//         
//         if(!pw.equals("-1")) {
//            dao.restore();
//            System.out.println("복구 완료");
//            
//            System.out.print("새로운 비밀번호 : ");
//            pw = sc.next();
//            
//            UserVO user = dao.selectUser();
//            user.setPw(pw);
//            dao.updateInfo(user);
//            System.out.println("수정 완료");
//         }
//         
//      }else {
//         System.out.println("로그인 실패");
//         
//      }
      
      
      //비밀번호 찾기
//      Scanner sc = new Scanner(System.in);
//      String phone = null;
//      String id = null;
//      
//      System.out.print("아이디 : ");
//      id = sc.next();
//      
//      if(dao.checkId(id) != -1) {
//         System.out.print("핸드폰 번호 : ");
//         phone = sc.next();
//         
//         dao.sendTempPw(콜);
//         dao.updatePw(id);
//         
//      }else {
//         System.out.println("없는 아이디입니다.");
//      }
      
      //아이디 찾기
//      Scanner sc = new Scanner(System.in);
//      String number = "";
      
//      dao.sendNumber("01040625261");
//      System.out.print("인증번호 : ");
//      number = sc.next();
//      
//      if(number.equals(UserDAO.number)) {
//         dao.findId("01040625261").stream().forEach(user -> {
//            if(user.getStatus() == 1) {
//               System.out.println(user.getId() + "[X]");
//            }else {
//               System.out.println(user.getId());
//            }
//         });
//      }else {
//         System.out.println("인증번호 불일치");
//      }
      //회원가입
//      vo.setId("hds9999");
//      vo.setPw("9999");
//      vo.setName("홍길동");
//      vo.setPhoneNumber("01055559999");
//      vo.setAge(2);
//      
//      dao.join(vo);
      
//      //로그인
//      if(dao.login("hds1111", "abcd") == 0) {
//         System.out.println("로그인 성공");
//         
//      }else {
//         System.out.println("로그인 실패");
//      }
      
      
      //아이디 중복검사
//      if(dao.checkId("hds9")) {
//         System.out.println("중복된 아이디");
//         
//      }else {
//         System.out.println("사용 가능한 아이디");
//         
//      }
		
   }
}