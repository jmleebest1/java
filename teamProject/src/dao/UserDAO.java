package dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

import org.json.simple.JSONObject;

import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;
import vo.UserVO;


public class UserDAO {
	
	   public static int userNumber= 2; //테스트를 위한 임의에 회원번호 
	   public static String number;
	   public static String tempPw;
	   private static final int KEY = 3;
	   Connection conn;
	   PreparedStatement pstm;
	   ResultSet rs;

	 
	   //로그인
	   public boolean login(String id, String pw) {
	      String query = "SELECT USERNUM, USERSTATUS FROM USERTABLE WHERE userId = ? AND userPw = ? ";
	      
	      int status = 0;
	      boolean flag = false;
	      try {
	         conn = DBConnecter.getConnection();
	         pstm = conn.prepareStatement(query);
	         pstm.setString(1, id);
//	         pstm.setString(2, encrypt(pw));
	         pstm.setString(2, pw);
	         rs = pstm.executeQuery();
	         
	         if(!rs.next()) { //로그인 실패
	            status = -1;
	            userNumber = -1;
	         }else { //로그인 성공(STATUS가 0(일반) 또는 1(탈퇴))
	            status = rs.getInt(2);
	            userNumber = rs.getInt(1);
	            if (status == 0) {
					// 일반
	            	flag = true;
				}else if(status == 1) {
					// 탈퇴 
					flag = false;
				}
	            
	            
	         }
	         
	      } catch (SQLException e) {
	         System.out.println("login() SQL 오류");
	         
	      } finally {
	         try {
	            if(rs != null) {
	               rs.close();
	            }
	            if(pstm != null) {
	               pstm.close();
	            }
	            if(conn != null) {
	               conn.close();
	            }
	         } catch (SQLException e) {
	            throw new RuntimeException(e.getMessage());
	         }
	      }
	      return flag;
	   }

	   // 중복검사 
		public int checkId(String id) {
			String query = "SELECT USERSTATUS  FROM USERTABLE WHERE USERID = ?";
			int status = 0;
			try {
				conn = DBConnecter.getConnection();
				
				pstm = conn.prepareStatement(query);
				
				pstm.setString(1, id);
				
				rs = pstm.executeQuery();
				
				if(!rs.next()) { 
					status = -1;
				}else { 
					
					status = rs.getInt(1);
				}
				
			} catch (SQLException e) {
				System.out.println("checkId() SQL 오류");
				
			} finally {
				
				try {
					if(rs != null) {
						rs.close();
					}
					if(pstm != null) {
						pstm.close();
					}
					if(conn != null) {
						conn.close();
					}
				} catch (SQLException e) {
					
					throw new RuntimeException(e.getMessage());
				}
			}
			//아이디 중복검사 결과를 리턴한다(-1 : 사용 가능한 아이디, 0 : 중복된 아이디, 1 : 사용할 수 없는 아이디)
			return status;
		}
	   
	   
	   
	   
	   // 회원가입
	   //회원가입
	   public void join(UserVO user) {
	            String query = "INSERT INTO USERTABLE (userNum, userId, userPw, userName,userAge, userPhonNum, userRegion) VALUES(UserTable_SEQ.NEXTVAL, ?, ?, ?, to_date(?), ?, ?)";
	            try
	            {
	              conn = DBConnecter.getConnection();
	              pstm = conn.prepareStatement(query);
	              pstm.setString(1, user.getUserId());
//	              pstm.setString(2, encrypt(user.getUserPw()));
	              pstm.setString(2, user.getUserPw());
	              pstm.setString(3, user.getUserName());
	              pstm.setDate(4,  user.getUserAge());
	              pstm.setString(5, user.getUserPhoneNum());
	              System.out.println("확인1");
	              pstm.setString(6, user.getUserRegion());
	              System.out.println("확인1");

	              pstm.executeUpdate();
	            }
	            catch (SQLException e)
	            {		
	            	System.out.println(e);
	                   System.out.println("join() SQL 오류");
	            }
	            catch (Exception e)
	            {		System.out.println(e);
	                    System.out.println("join() 알 수 없는 오류");
	            }
	            finally
	            {
	               try
	               {
	            if(pstm != null) {
	               pstm.close();
	            }
	            if(conn != null) {
	               conn.close();
	            }
	         } catch (SQLException e) {
	            throw new RuntimeException(e);
	         }
	      }
	   }

	   
	   

	  
	   
	   
		// 마이페이지는 로그인이 상태에서만 사용가능
		// 마이페이지 내정보 조회
		public UserVO getMyInfo() {
			UserVO vo = new UserVO();
			String query ="SELECT userId, userPw, userName, userAge, userPhonNum, userGender, userRegion, userStatus FROM UserTable WHERE UserNum = ?";
			
			
			if (userNumber == 0) {return null;} // 0 이면 로그인이 되지않은 상태로 null을 리턴한다. 
			try {
				conn = DBConnecter.getConnection();
				pstm = conn.prepareStatement(query);
				pstm.setInt(1, userNumber);
				rs = pstm.executeQuery();
				
				
				if(rs.next()) {
					vo.setUserNum(userNumber); 
					vo.setUserId(rs.getString(1));
					vo.setUserPw(rs.getString(2));
					vo.setUserName(rs.getString(3));
					vo.setUserAge(rs.getDate(4)); // date타입으로 생일이 저장된 생일을 계산하여 나이로 변환하여 나타내주어야한다.  
					vo.setUserPhoneNum(rs.getString(5));
					vo.setUserGender(rs.getString(6).charAt(0));
					vo.setUserRegion(rs.getString(7));
					vo.setUserStatus(rs.getInt(8));
				}
				
			} catch (SQLException e) {
				System.out.println("getMyInfo() 오류");
			}
			
			return vo;
			
			
		}
		
		// DB age에 있는 생일을 만나이로 계산
		 public int getAge(Date date){
			 
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			System.out.println(calendar.getTime());
			int birthYear = calendar.get(Calendar.YEAR);
			int birthMonth = calendar.get(Calendar.MONTH);
			int birthDay = calendar.get(Calendar.DAY_OF_MONTH);
			
	        Calendar current = Calendar.getInstance();
	        int currentYear  = current.get(Calendar.YEAR);
	        int currentMonth = current.get(Calendar.MONTH) + 1;
	        int currentDay   = current.get(Calendar.DAY_OF_MONTH);
	      
	        int age = currentYear - birthYear;
	        // 생일 안 지난 경우 -1
	        if (birthMonth * 100 + birthDay > currentMonth * 100 + currentDay) 
	            age--;
	      
	        return age;
			
	        // 만 나이로 계산 --> 네이버 생일 나이 검색과 동일함

		 }
		 	
		 	// 전화번호로 인증번호를 sms전송
			public void sendNumber(String phoneNumber) {
				String data = "0123456789";
				Random r = new Random();
				number = "";
				
				//6번 반복
				for (int i = 0; i < 6; i++) {
				
					number += data.charAt(r.nextInt(data.length()));
					
				}
				
				String api_key = "NCSTFZGSGACJE9SI";
			    String api_secret = "WW3ZOL6NAB2G0XATZRY0OFNXJDZBRAMF";
			    Message coolsms = new Message(api_key, api_secret);

			
			    HashMap<String, String> params = new HashMap<String, String>();
			    params.put("to", phoneNumber);
			    params.put("from", "01037325638");
			    params.put("type", "SMS");
			    params.put("text", "인증번호 [" + number + "] 본인확인을 위해 입력해주세요.");
			    params.put("app_version", "test app 2.2"); // application name and version
			    try {
			      JSONObject obj = (JSONObject) coolsms.send(params);
			      System.out.println(obj.toString());
			    } catch (CoolsmsException e) {
			      System.out.println(e.getMessage());
			      System.out.println(e.getCode());
			    }
			}
			
			// sendNumber()메소드로 전송한 인증번호 체크를 하는 메소드 구현
			public boolean checkNumber(String number) {

	            
	            if(this.number.equals(number)) {
	               	return true;
	            }
	            return false;
	         }
			
			
			
			
			
			
			
			
			
			
			
			
			
			// 인증이 성공적으로됬다면 전화번호로 등록된 아이디를 전부 조회
			public ArrayList<UserVO> findId (String phoneNumber) {
				String query = "SELECT userId, userStatus FROM USERTABLE WHERE userPhonNum = ?";
				ArrayList<UserVO> users = new ArrayList<>();
				UserVO user = null;
				try {
					conn = DBConnecter.getConnection();
					pstm = conn.prepareStatement(query);
					pstm.setString(1, phoneNumber);
					rs = pstm.executeQuery();
					
					while(rs.next()) {
						user = new UserVO();
						user.setUserId(rs.getString(1));
						user.setUserStatus(rs.getInt(2));
						users.add(user);
					}
					
				} catch (SQLException e) {
					System.out.println("findId() SQL 오류");
				} finally {
					try {
						if(rs != null) {
							rs.close();
						}
						if(pstm != null) {
							pstm.close();
						}
						if(conn != null) {
							conn.close();
						}
					} catch (SQLException e) {
						throw new RuntimeException(e);
					}
				}
				return users;
			}
			
			
			//폰번호로 비밀번호 찾기
		      public void sendTempPw(String phoneNum) {
		         String data = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		         Random r = new Random();
		         tempPw = "";
		         
		         for (int i = 0; i < 6; i++) {
		            tempPw += data.charAt(r.nextInt(data.length()));
		         }
		         
		         String api_key = "NCS6JPJHXZSKSYWS";
		          String api_secret = "K8ZJKEAMDEVCXOLWRSECDPJFA7YOSGAI";
		          Message coolsms = new Message(api_key, api_secret);

		          // 4 params(to, from, type, text) are mandatory. must be filled
		          HashMap<String, String> params = new HashMap<String, String>();
//		          params.put("to", phoneNumber);
		          params.put("to", "01089087253");
		          params.put("from", "01089087253");
		          params.put("type", "SMS");
		          params.put("text", "임시비밀번호 [" + tempPw + "] 로그인 후 비밀번호를 변경해주세요.");
		          params.put("app_version", "test app 2.2"); // application name and version

		          try {
		            JSONObject obj = (JSONObject) coolsms.send(params);
		            System.out.println(obj.toString());
		          } catch (CoolsmsException e) {
		            System.out.println(e.getMessage());
		            System.out.println(e.getCode());
		          }
		      }
		      
		      // 임시 비밀번호 업데이트
		      public void updateTempPw(String id) {
		         String query = "UPDATE USERTABLE SET USERPW = ? WHERE USERID = ?";
		         
		         try {
		            conn = DBConnecter.getConnection();
		            pstm = conn.prepareStatement(query);
		            pstm.setString(1, encrypt(tempPw));
		            pstm.setString(2, id);
		            pstm.executeUpdate();
		         } catch (SQLException e) {
		            System.out.println("updateTempPw() SQL 오류");
		         } finally {
		            try {
		               if(pstm != null) {
		                  pstm.close();
		               }
		               if(conn != null) {
		                  conn.close();
		               }
		            } catch (SQLException e) {
		               throw new RuntimeException(e);
		            }
		         }
		      }
		      
		      // 로그인이후 진행되는 메소드 
		      // 마이 페이지에서 비밀번호 변경
		      public void updatePw(String id,String pw) {
			         String query = "UPDATE USERTABLE SET USERPW = ? WHERE USERID = ?";
			         
			         try {
			            conn = DBConnecter.getConnection();
			            pstm = conn.prepareStatement(query);
			            pstm.setString(1, encrypt(pw));
			            pstm.setString(2, id);
			            pstm.executeUpdate();
			         } catch (SQLException e) {
			            System.out.println("updatePw() SQL 오류");
			         } finally {
			            try {
			               if(pstm != null) {
			                  pstm.close();
			               }
			               if(conn != null) {
			                  conn.close();
			               }
			            } catch (SQLException e) {
			               throw new RuntimeException(e);
			            }
			         }
			      }
		      
		      
		 
			
		      
		      // 전체 테스트가 끝난후에 적용 
		      public String encrypt(String pw) {
		          String en_pw = "";
		          for(int i = 0; i<pw.length(); i++) {
		             en_pw += pw.charAt(i)*3;
		          }
		          return en_pw;
		       }

			
	   
		      
	   
}
