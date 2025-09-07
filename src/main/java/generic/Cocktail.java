package generic;

public class Cocktail<U,V> extends Juice {
	
	/*public  <A,B> void mix(A water, B juice){
		
		System.out.print("Cocktail with");
		
		((Juice) juice).print();
	}*/
	
U water;
V juice;
 Cocktail(U w,V j){
	water=w;
	juice=j;
}


public String taste(){
	return "tastes Cocktail Sweet";
}
}
