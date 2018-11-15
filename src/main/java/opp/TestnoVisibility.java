package opp;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestnoVisibility {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
{
	
		Car c1=new BMW();
	
		// 1. No visibility as it is from  sub class (not in parent class)
		System.out.println("\n1. No visibility as it is from  sub class (not in parent class)");

		//	c1.infotainment();  
	
		// 2. No visibility as it is private method of parent class Car(sub class instance is assigned)
		System.out.println("\n2. No visibility as it is private method of parent class Car(sub class instance is assigned)");
		//	c1.changeSeat();	 
		
		
		
		Car c2=new Car();
	
		// 3. No visibility as it is private method from Car.
		System.out.println("\n3. No visibility as it is private method from Car(this).");
		//	c2.changeSeat();	
		

		// 4. But using reflection we can still access private method
		System.out.println("\n4. But using reflection we can still access private method");
		Class<?> clazz=c2.getClass();   
		Method method= clazz.getDeclaredMethod("changeSeat") ;
		method.setAccessible(true);
		method.invoke(c2);
		
		BMW b=new BMW();
		//5. private method of super class is not accessible through subclass 
		
		System.out.println("\n5. private method of super class is not visible through subclass");
		//b.changeSeat();
			
		
		
		}
}
