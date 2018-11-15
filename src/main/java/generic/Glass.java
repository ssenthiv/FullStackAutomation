package generic;

public class Glass<T > {

	T liquid;
	
	public  <U extends Liquid> String getLiquidTaste(U l){
		return l.taste();
	}
}