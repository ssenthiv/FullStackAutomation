package opp.inheritanceAccessibility;

public class TestDynamicOverloading {

	public static void main(String[] args) throws Exception
{
	
		Car c1=new BMW();
		
		//1. Dynamic binding from subclass	
		System.out.println("1. Dynamic binding from subclass");
		c1.start();
		
		//2. Sub class from different package
		Car c2=new opp2.BMW();
		System.out.println("\n2. Dynamic binding from another package subclass");		
		c2.start();
		
		//3. static bound from car even sub class instance is assigned
		//   stop() is not overridden in BMW
		System.out.println("\n3. static bound from car even sub class instance is assigned");
		System.out.println("   stop() is not overridden in BMW");
		Car c3=new BMW();

		c3.stop();
		
		
		
}
}
