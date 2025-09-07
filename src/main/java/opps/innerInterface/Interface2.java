package opps.innerInterface;

public interface Interface2 {
	
	public  int INSTANCE_VAR_SAME=25;
	public static int STATIC_VAR=200;
	 
	public default void  method2(){
	
		System.out.println("\tDefault_method Method2");
	}
	
	default public void sameMethod(){
		
		System.out.println("\tDefault_method - sameMethod");
		
	}
	 
	 

}
