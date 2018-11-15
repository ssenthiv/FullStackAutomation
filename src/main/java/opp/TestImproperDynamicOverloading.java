package opp;
import opp2.*;

public class TestImproperDynamicOverloading {

	public static void main(String[] args) throws Exception
{
	
		Car c1=new opp2.BMW();
	
		//1. Improper dynamic overload , so parent implementation will be called
		//	  This is equivalent to static bound 
		c1.ABS();
		
		//2. Proper dynamic binding
		c1.start();
		//3. Improper overload , as same signature is not present in sub class	
		c1.start(" Improper", " Overloading");
}
}
