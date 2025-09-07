package opp.inheritanceAccessibility;

public class TestStaticOverloading {

	public static void main(String[] args) throws Exception
{
	
		
		
		//1. Static overloading is possible,even if sub class signature is not in parent
		BMW b=new BMW();
		System.out.println("1. Static overloading is possible,even if sub class signature is not in parent");
		b.start(" static"," overlading");

		System.out.println("\n2. static binding");	
		b.start("Static binding");
		b.start(5);
		
		
}
}
