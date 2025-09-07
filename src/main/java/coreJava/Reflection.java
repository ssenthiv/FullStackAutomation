package coreJava;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Reflection {

	public static void main(String[] args) {
		
		
		Person p=null;
		
		
		
		
		
		try {
		
		System.out.println(" Instantiating private constructor");
			Constructor<Person> cons= Person.class.getDeclaredConstructor(String.class,String.class,int.class);
			cons.setAccessible(true);
			p=cons.newInstance("shunmgam","senth",4);
		
		System.out.println("\n1.Accessing private non static variable");
			Class<?> clazz=p.getClass();
			Field field=clazz.getDeclaredField("firstName");
			field.setAccessible(true);
			System.out.println("FirstName 	:"+ field.get(p));
		
		System.out.println("\n2. Accessing private static variable");
		
			field=Person.class.getDeclaredField("age");
			field.setAccessible(true);
			System.out.println("Age 	: "+ field.getInt(null));  // since static variable null is passed
		
		System.out.println("\n3. Accessing private non static method");
		
			Method method=clazz.getDeclaredMethod("setFirstName", String.class);
			method.setAccessible(true);
			method.invoke(p, "Shunmugasundaram");
			method=clazz.getDeclaredMethod("getFirstName");
			method.setAccessible(true);
			System.out.println("getFirstName 	: "+method.invoke(p));
		System.out.println("\n4. Accessing private  static method");
			method=Person.class.getDeclaredMethod("getAge");
			method.setAccessible(true);
			System.out.println("getAge 	: "+method.invoke(null));
			
		} catch (NoSuchFieldException | SecurityException | NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			
			e.printStackTrace();
		} catch (InstantiationException e) {
			
			e.printStackTrace();
		} 
	}

/*
 ...
 		if you are using methods/fields from inherited , then replace
 		getDeclaredMethod 	-> getMethod
 		getDeclaredField	-> getField
 */


}
