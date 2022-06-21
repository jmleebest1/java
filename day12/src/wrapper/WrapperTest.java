package wrapper;

public class WrapperTest {
	public static void main(String[] args) {
		int data_i = 10;
		
		//boxing
//		Integer data_I = new Integer(data_i);
		//auto boxing
		Integer data_I = data_i;
		//unboxing
//		data_i = data_I.intValue();
		//auto unboxing
		data_i = data_I;
		
		//auto만 알면 되는데 생략이 안되는 경우가 있기 때문에
		//기본 방법도 알고 있어야 한다.
		
	}

}
