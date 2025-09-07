package opp.inheritanceAccessibility;

public class TestStaticBound {

	public static void main(String[] args) throws Exception
{
	
		Car c1=new Car();
	
		//static bound from Car		
		System.out.println("1. Only in super class, not in this class");
		c1.engine();
		
		System.out.println("\n2. Only in this class");
		c1.staticBound();
		
		
		
			
			
		
		
}
}
