package opp4InnerClass;

public class TestStaticNested {
	
	public static void main(String[] args){
		
		
		
		System.out.println("1.Calling static nested  class methods");
		StaticNested.Wheel w=new StaticNested.Wheel();		// Non Enclosing class
		
		w.display();
		StaticNested cp=new StaticNested();
		//CarParts.Wheel w1=cp.new Wheel();   	// will not work as Wheel is static nested class
		cp.wheel.display();						// using Enclosing class instance
		w.innerStatic();
		//cp.new Wheel().display();            	// Non static inner class
		
		System.out.println("\n2.Accessing private  static variable/methods");
		w.display("No Access to Non static");
		
		System.out.println("\n3.Accessing Inner static methods");
		StaticNested.Wheel.innerStatic();
		
		System.out.println("\n4.calling Non static inner method from outer class");
		cp.callingInnerMethod();
		
		
	}

}
