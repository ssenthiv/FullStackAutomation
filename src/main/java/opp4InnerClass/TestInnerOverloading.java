package opp4InnerClass;

import opp4InnerClass.Car.Bike;

public class TestInnerOverloading {

		public static void main(String[] args) {
		
			
		Car c = new Car();
		
		
		System.out.println("1. Method call from super-->Car class, static bindings");
		c.printSound();
		c.printSound("From"," Outer"," StaticBinding");
		//c.printSound("From"," Outer");               //will not work as Overloading methods from outer and inner classes  (Not sure.. need to check)
		//c.printSound("From"); 					   //will not work as Overloading methods from outer and inner classes
		//c.innerMethod();							   // cannot call inner method directly
		Car.Bike bike=c.new Bike();
		
		System.out.println("\n2. Overloading methods from inner and outer classes  ");
		System.out.println("Compilation Error : bike-inner method accessing outer method which is "
				+ "overloaded with inner");
		
		bike.printSound("From", "Inner");
		
		} 
		
}
