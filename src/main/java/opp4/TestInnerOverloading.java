package opp4;


public class TestInnerOverloading {

		public static void main(String[] args) {
		
			
		Car c = new Car();
		
		
		System.out.println("1. Method call from super-->Car class, static bindings");
		c.printSound();
		c.printSound("From"," Outer"," Static");
		
		
		} 
		
}
