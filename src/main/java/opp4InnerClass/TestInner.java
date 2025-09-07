package opp4InnerClass;

public class TestInner {
	
	public static void main(String[] args){
		
		
		
		System.out.println("1.Calling  inner class methods");
		InnerClass.Wheel w=new InnerClass().new Wheel();
		
		w.display();
		InnerClass i=new InnerClass();
		InnerClass.Wheel w1=i.new Wheel();   
		i.wheel.display();
		w1.display();
		i.new Wheel().display();            
		
		System.out.println("2.Accessing private   variable/methods of outer class through inner class methods\n");
		w.display("Access to  static/NonStaic");
		
		System.out.println("\n3. Cannot Access any   variable/methods of outer class with inner class instance\n");
		//System.out.println(w.publicNonStaticVar );
		
		System.out.println("\n4.Accessing Inner static variables");   // inner static method is not allowed
		System.out.println("Inner Static final variable = " +InnerClass.Wheel.wheelSize);
		System.out.println("Inner variable = " +i.wheel.wheelSizeNonStatic);
		
		System.out.println("\n5.calling Non static inner method from outer class");
		i.callingInnerMethod();
		
	}

}
