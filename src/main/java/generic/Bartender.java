package generic;

public class Bartender {
	
	/*public  <A,B> void mix(A water, B juice){
		
		System.out.print("Cocktail with");
		
		((Juice) juice).print();
	}*/
	public  <A,B> Cocktail mix(A water, B juice){
		
		System.out.print("Bartender mix ");
		
		return new <A,B> Cocktail(water,juice);
	}

}
