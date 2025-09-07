package generic;

public class Exec {
	public static void main(String[] args){
		
		Glass<Orange> glass=new Glass<>();
		Juice juice=new Juice();
		Orange orange=new Orange();
		Water water=new Water();
		glass.liquid=orange;
		//glass.liquid=water;
		Juice j=  glass.liquid;
		//Water j=  glass.liquid;
//		j.print();
		System.out.println(glass.getLiquidTaste(orange));
		
		Bartender bt=new Bartender();
		//System.out.println(glass.liquid.taste());
		
		//@SuppressWarnings("unchecked")
		Cocktail<Water,Orange> ct=bt.mix(water, orange);
		
		
		
		
		//Cocktail ct=new Cocktail(water, juice);
		System.out.println(ct.taste());
		
	}
}
