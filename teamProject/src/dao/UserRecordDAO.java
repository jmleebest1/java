package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vo.UserRecordVO;


public class UserRecordDAO {
	
	   Connection conn;
	   PreparedStatement pstm;
	   ResultSet rs;
	   
	
	      //회원의 모든 운동기록 가져오기
	   public ArrayList<UserRecordVO>  getALLRecord(String userId) {
	         String query = "SELECT recordNum,userId,recordTime,recordDate,recordExercise,recordCount FROM UserRecordTable WHERE userId = ?";
	         ArrayList<UserRecordVO> records = new ArrayList<>();
	         UserRecordVO record =null;
	           
	            try {
	               conn = DBConnecter.getConnection();
	               pstm = conn.prepareStatement(query);
	               pstm.setString(1, userId);
	               rs = pstm.executeQuery();
	               
	               
	               
	               while(rs.next()) {
	            	   record = new UserRecordVO();
	            	   record.setRecordNum((rs.getInt(1))); 
	            	   record.setUserId(rs.getString(2)); 
	            	   record.setRecordTime(rs.getInt(3)); 
	            	   record.setRecordDate(rs.getString(4)); 
	            	   record.setRecordExercise(rs.getString(5)); 
	            	   record.setRecordCount(rs.getInt(6)); 
	            	   records.add(record);
	               }
	            } catch (Exception e) {
	               System.out.println("getALLRecord() SQL 오류");
	            }finally {
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
	                return records;
	             }   

	   	
	   			// 운동 기록 추가 메소드 (운동 기록 수정,삭제 보류) 
	   			
	   
	   public void insertRecord(UserRecordVO record) {
/*	         String query = "INSERT UserRecordTable"
	               + "(recordNum, userId, recordTime, recordDate, recordExercise, recordCount) "
	               +"VALUES(SEQ_userRecord.NEXTVAL, ?, ?, ?, ?, ?)";*/
	         String query = "INSERT INTO UserRecordTable values(UserRecordTable_SEQ.NEXTVAL,?,?,to_char(sysdate,'yyyy.mm.dd hh24:mi'),?,?)";
	         
	         
	            try {
	               conn = DBConnecter.getConnection();
	               pstm = conn.prepareStatement(query);
	               pstm.setString(1, record.getUserId());
	               pstm.setInt(2, record.getRecordTime());               
	               pstm.setString(3, record.getRecordExercise());
	               pstm.setInt(4, record.getRecordCount());
	               
	               pstm.execute();
	               
	            } catch (SQLException e) {
	            	
	               System.out.println("insertRecord() SQL 오류");
	               
	            } catch (Exception e) {
	               System.out.println("insertRecord() 알 수 없는 오류");
	               
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
	      
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   			// 
	   			//  위에서 변경할 객체를 선택하고 
	   			//  세터로 객체를 변경한다
	   			// 	그 이후 변경된 객체를 updateRecord()에 넘겨주어 그래도 업데이트를 한다.
	   			// 운동기록 수정
	   			// recordTime  recordDate  recordExercise  recordCount 수정
	   			// view에서 수정할 운동기록을 선택받고 그후에 진행 한다. 
	   			// 
	      public void updateRecord(UserRecordVO record) {
	            String query = "UPDATE UserTable "
	                  + "SET recordTime = ?, recorDate = ?, recordExercise = ?, recordCount = ? "
	                  + "WHERE userId = ?";
	            
	            try {
	               conn = DBConnecter.getConnection();
	               pstm = conn.prepareStatement(query);
	               pstm.setInt(1, record.getRecordTime());
	               pstm.setString(2, record.getRecordDate() );
	               pstm.setString(3, record.getRecordExercise());
	               pstm.setInt(4, record.getRecordCount());
	               pstm.executeUpdate();
	               
	            } catch (SQLException e) {
	               System.out.println("updateRecord() SQL 오류");
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
	   			
	   
	   
	   
	   
	   
	   		//  운동기록  전체 삭제 
	   			
	
	
	
	
	
}
