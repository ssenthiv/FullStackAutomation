package opp.inheritanceAccessibility;

public class TestCar {

	public static void main(String[] args) {

		
		BMW b = new BMW();
		
		b.start(); //compile time polymorphism
		b.stop();
		b.refuel();
		b.theftSafety();
		b.engine();
		System.out.println();
		
		Car c = new Car();
		c.start();
		c.stop();
		c.refuel();
		c.engine();
		System.out.println();
		
		//type casting:
		Car c1 = new BMW(); //child class object can be referred by parent class ref variable
		c1.start(); //run time polymorphism
		c1.stop();
		c1.engine();
		System.out.println("Complilation Error: Dynamic Overloading not possible when"
				+ " super class does't have same method");
		//c1.theftSafety();
		
		
		
		
	}

}
