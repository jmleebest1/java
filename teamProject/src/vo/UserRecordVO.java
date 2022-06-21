package vo;

public class UserRecordVO {
   private int recordNum;
   private String userId;
   private int recordTime;
   private String recordDate;
   private String recordExercise;
   private int recordCount; 
   
   public UserRecordVO() {;}

   public int getRecordNum() {
      return recordNum;
   }

   public void setRecordNum(int recordNum) {
      this.recordNum = recordNum;
   }

   public String getUserId() {
      return userId;
   }

   public void setUserId(String userId) {
      this.userId = userId;
   }

   public int getRecordTime() {
      return recordTime;
   }

   public void setRecordTime(int recordTime) {
      this.recordTime = recordTime;
   }

   public String getRecordDate() {
      return recordDate;
   }

   public void setRecordDate(String recordDate) {
      this.recordDate = recordDate;
   }

   public String getRecordExercise() {
      return recordExercise;
   }

   public void setRecordExercise(String recordExercise) {
      this.recordExercise = recordExercise;
   }

   public int getRecordCount() {
      return recordCount;
   }

   public void setRecordCount(int recordCount) {
      this.recordCount = recordCount;
   }
   
   
	// equals, hashCode 재정의
	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if(obj instanceof UserRecordVO) {
			UserRecordVO  vo = (UserRecordVO) obj;
			if(this.getRecordNum() == vo.getRecordNum()) {
				return true;
			}
		}

		return false;
	}
	
	@Override
	public int hashCode() {
		
		return this.getRecordNum();
	}

	@Override
	public String toString() {
		return "UserRecordVO [recordNum=" + recordNum + ", userId=" + userId + ", recordTime=" + recordTime
				+ ", recordDate=" + recordDate + ", recordExercise=" + recordExercise + ", recordCount=" + recordCount
				+ "]";
	}
   
   
   
}
