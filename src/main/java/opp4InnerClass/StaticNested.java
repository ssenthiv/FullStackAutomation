package opp4InnerClass;

import org.openqa.selenium.interactions.internal.DisplayAction;

public class StaticNested {
	
	Wheel wheel=new Wheel();				// instantiating static nested class in Enclosing class
	private String pVar="Private variable -CarParts";
	private static String pStaticVar="Private static variable -CarParts";
	
	private static void print(){
		
		System.out.println("CarPart - private static method " );
		Wheel.innerStatic();
		
	}
	public void callingInnerMethod(){
		System.out.println("CarPart - non static method " );
		Wheel.innerStatic();
		wheel.display();
		
		
	}
	static class Wheel{
		public static int  wheelSize=16;
		public int wheelSizeNonStati=20;
		public void display(){
			System.out.println("Wheel");
		}
		
		public void display(String str){
			
			System.out.println("Wheel " + str);
			System.out.println("Private Static Variabe = "+ pStaticVar);
			print();
		}
		public static void innerStatic(){
			System.out.println("Wheel- static method");
			System.out.println("Accessing inner static variable wheelSize = "+wheelSize);
		}
	}

}
