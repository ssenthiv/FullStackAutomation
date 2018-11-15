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
		
		bt.mix(water, orange);
		
		System.out.println(glass.liquid.taste());
	}
}
