package opp.inheritanceAccessibility;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestnoVisibility {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
{
	
		
		Car c1=new Car();
		
		// 1. No visibility as it is private method from Car.
		System.out.println("\n1. No visibility as it is private method from Car(this).");
		//	c1.changeSeat();
		
		Car c2=new BMW();
		
		// 2. No visibility as it is from  sub class (not in parent class)
		System.out.println("\n2. No visibility as it is from  sub class (not in parent class)");
		System.out.println("   The method is undefined for the super class ");
		//c2.infotainment();  


		//3. Dynamic overloading is not possible, if sub class signature is not in parent 

		System.out.println("\n3. No Access :- Compilation Error - Dynamic overloading is not possible, if sub class signature is not in parent");
		//c2.start("OL");		
		
		// 4. No visibility as it is private method of parent class Car(sub class instance is assigned)
		System.out.println("\n4. No visibility as it is private method of parent class Car\n  (sub class instance assigned here has no significance)");
		//c2.changeSeat();	 
		   
	
		
		BMW b=new BMW();
		//5. private method of super class is not accessible through subclass 
		
		System.out.println("\n5. private method of super class is not visible through subclass");
		//b.changeSeat();

		// 6. But using reflection we can still access private method
		System.out.println("\n6. But using reflection we can still access private method");
		Class<?> clazz=c1.getClass();   
		Method method= clazz.getDeclaredMethod("changeSeat") ;
		method.setAccessible(true);
		method.invoke(c1);
		
		
		
			
		
		
		}
}
