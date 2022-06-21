package com.jdbc.mysql.task;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {
	Connection conn;
	   PreparedStatement pstm;
	   ResultSet rs;
	   
	   //이름으로 생일인 사람 검색하기
	   public List<MemberVO> getInfo(String name) {
		  String query = "select memberName, memberBirth from member where memberName = ?";
		  MemberVO member = new MemberVO();
		  ArrayList<MemberVO> members = new ArrayList<>();
	      try {
	         conn = DBConnecter.getConnection();
	         pstm = conn.prepareStatement(query);
	         pstm.setString(1, name);
	         rs = pstm.executeQuery();
	         while(rs.next()) {//이름은 중복이 있을 수 있으니 while로 다 가져와야 한다.
	         member.setMemberName(rs.getString(1));
	         member.setMemberBirth(rs.getString(2));
	         members.add(member);
	         }
	      } catch (SQLException e) {
	         System.out.println("getInfo(String) SQL 오류");
	         e.printStackTrace();
	      }
	     return members;
	   }
}
	   