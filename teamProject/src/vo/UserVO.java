package vo;

import java.sql.Date;

public class UserVO {
	// equals 재정의 , hashcode 재정의 여부 결정
	private int userNum; 
	private String userId;  
	private String userPw;  
	private String userName;    
	private Date userAge;  
	private String userPhoneNum;
	private char userGender;
	private String userRegion;
	private int userStatus; //0 : 일반, 1 : 탈퇴
	
	
	
	public Date getUserAge() {
		return userAge;
	}
	public void setUserAge(Date userAge) {
		this.userAge = userAge;
	}
	public int getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(int userStatus) {
		this.userStatus = userStatus;
	}

	public String getUserPhoneNum() {
		return userPhoneNum;
	}
	public void setUserPhoneNum(String userPhoneNum) {
		this.userPhoneNum = userPhoneNum;
	}
	public int getUserNum() {
		return userNum;
	}
	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public char getUserGender() {
		return userGender;
	}
	public void setUserGender(char userGender) {
		this.userGender = userGender;
	}
	public String getUserRegion() {
		return userRegion;
	}
	public void setUserRegion(String userRegion) {
		this.userRegion = userRegion;
	}
	
	
	// equals, hashCode 재정의 
	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if(obj instanceof UserVO) {
			UserVO  vo = (UserVO) obj;
			if(this.getUserNum() == vo.getUserNum()) {
				return true;
			}
		}

		return false;
	}
	
	@Override
	public String toString() {
		return "["+userId+"]";
	}
	@Override
	public int hashCode() {
		
		return this.getUserNum();
	}
	
}
