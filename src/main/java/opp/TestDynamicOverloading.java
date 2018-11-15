package opp;

public class TestDynamicOverloading {

	public static void main(String[] args) throws Exception
{
	
		Car c1=new BMW();
	
		//1. Dynamic binding from subclass	
		c1.start();
		
		
		
		//2. Dynamic overloading is not possible, if sub class signature is not in parent 
		
		System.out.println(" No visibility :- Compilation Error - Dynamic overloading is not possible, if sub class signature is not in parent");
		//c1.start("OL");
			
		
}
}
