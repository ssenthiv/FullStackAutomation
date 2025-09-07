package opps.innerInterface;

public  interface Interface1 {

	public int  INSTANCE_VAR1=10;
	public  int INSTANCE_VAR_SAME=15;
	public static int STATIC_VAR=100;
	public static int STATIC_VAR_DIFFERENT=200;
	default public void method1(){
		
		System.out.println("\tDefault_method Method1");
		
	}
	default public void sameMethod(){
		
		System.out.println("\tDefault_method - sameMethod");
		
	}
	
	 public void abstractMethod1();
	 
	 static public void staticMethod1(){
			
			System.out.println("\tstatic_method Method1");
			
		}
	
}
