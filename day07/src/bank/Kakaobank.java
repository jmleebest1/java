package bank;

public class Kakaobank extends Bank{
		public Kakaobank() {
			
		}
		// 잔액 조회시 재산 반토막
		@Override
		void show() {
			this.money *= 0.5;
			 super.show();
		}
	}


