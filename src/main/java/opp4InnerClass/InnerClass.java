package opp4InnerClass;

import org.openqa.selenium.interactions.internal.DisplayAction;

public class InnerClass {
	
	Wheel wheel=new Wheel();
	private String pVar="Private variable -CarParts";
	private static String pStaticVar="Private static variable -CarParts";
	String publicNonStaticVar="public NonStatic Variable";
	private static void print(){
		
		System.out.println("CarPart - private static method " );
		//Wheel.innerStatic();
		
	}
	
	private  void printNonStatic(){
		
		System.out.println("CarPart - private NonStatic method " );
		//Wheel.innerStatic();
		
	}
	public void callingInnerMethod(){
		System.out.println("CarPart - non static method " );
		//Wheel.innerStatic();
		wheel.display();
		
		
	}
	 class Wheel{
		public static final int  wheelSize=16;		// static final is allowed
		public  int  wheelSizeNonStatic=20;
		public void display(){
			System.out.println("Wheel");
		}
		
		public void display(String str){
			
			System.out.println("Wheel " + str);
			System.out.println("Wheel - Private Static Variabe = "+ pStaticVar);
			System.out.println("Wheel - Private  Variabe = "+ pVar);
			print();
			printNonStatic();
		}
		// static method is Not allowed in inner class
		/*
		public static void innerStatic(){
			System.out.println("Wheel- static method");
			System.out.println("Accessing inner static variable wheelSize = "+wheelSize);
		} */
	}

}
