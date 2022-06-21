package inter;

public abstract class PetAdapter implements Pet {
								//Adapter를 만든 후 부모 인터페이스를 지정해준다.
	@Override
	public void sitDown() {}

	@Override
	public void stop() {}

	@Override 
	public void poop() {}

	@Override
	public void 빵야() {}
}
