package generic;

public class Bartender {
	
	public  <A,B> void mix(A water, B juice){
		
		System.out.print("Cocktail with");
		
		((Juice) juice).print();
	}

}
