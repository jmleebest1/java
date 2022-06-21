package com.jdbc.mysql.task;

public class MemberVO {
	private int memberNum;
	private String memberName;
	private String memberBirth;

	MemberVO(){;}

	public int getMemberNum() {
		return memberNum;
	}

	public void setMemberNum(int memberNum) {
		this.memberNum = memberNum;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberBirth() {
		return memberBirth;
	}

	public void setMemberBirth(String memberBirth) {
		this.memberBirth = memberBirth;
	}

	@Override
	public String toString() {
		return memberName + "," + memberBirth;
	}

	
	
	
}
