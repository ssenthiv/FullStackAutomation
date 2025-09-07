package opp.inheritanceAccessibility;
import opp2.*;

public class TestImproperDynamicOverloading {

	public static void main(String[] args) throws Exception
{
	
		Car c1=new opp2.BMW();
	
		//1. Improper dynamic overload ,sub class is not in the same package,  so parent implementation will be called
		//	  This is equivalent to static bound 
		System.out.println("1.No access to parent default method,from sub class, as parent is in different package"
						+ "\n  Visiblity in sub class is not Reduced");
		c1.ABS();
		
		Car c2=new BMW();
		
		//2. Improper overload , as same signature is not present in sub class	
		System.out.println("\n2. Improper overload , method is overridden in subclass, but same signature is not present in sub class");
		c2.start(" Improper", " overloading from same package");
		c1.start(" Improper", " Overloading from another package");
		
		
		//3. Compilation Error due to reduced visibility in child class
		//   but no visibility from parent to child, so parent class method will be called
		System.out.println("\n3a. Compilation Error due to reduced visibility in child class");
		System.out.println("   Since Child is private, parent class method will be called");
		
		c2.ABS();
		
		System.out.println("\n3b. NO  Error due to reduced visibility in child class");
		System.out.println("   Since Child is protected in another class, parent class method will be called");
		
		c1.defaultMethod();
		
		//4. Method is not present(not overloaded) in child class, so static binding
		//   Parent method will be called
		// repeated in TestStaticBound
		System.out.println("\n4. Method is not present(not overloaded) in child class, so static binding");
		System.out.println("  Parent method will be called");
		c2.defaultMethod();
		
		
		
}
}
