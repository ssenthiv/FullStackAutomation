package opps.innerInterface;

import java.awt.image.SampleModel;

public  final class MultipleInheritance implements Interface1, Interface2{
	
	
	Integer i= new Integer(2);
	
	 public void sameMethod(){
		
		System.out.println("\tDefault_method - sameMethod-Overriden");
		
		
	}
	 
	 public void abstractMethod1(){
		 System.out.println("\tabstract_method - abstrackMethod1-Implemented"); 
		 
	 }

	public static void main(String[] args){
		//static {
		
		MultipleInheritance mi= new MultipleInheritance();

		System.out.println("1. default method with different names");
		mi.method1();
		mi.method2();
		System.out.println("2. default method with same names");
		System.out.println(" 	Need to override so as to make it one  ");
		mi.sameMethod();
		System.out.println("3. abstract method -has to be implemented in class");
		mi.abstractMethod1();
		//Interface1.abstractMethod1();	// will not work
		System.out.println("4. static method ");
		Interface1.staticMethod1();
		//mi.staticMethod1();				// will not work
		
		System.out.println("5. Instance variable different names");
		System.out.println("\tmi.INSTANCE_VAR1=" +mi.INSTANCE_VAR1);
		System.out.println("\tInterface1.INSTANCE_VAR1=" +Interface1.INSTANCE_VAR1);
		System.out.println("\tINSTANCE_VAR1=" +INSTANCE_VAR1);
		
		System.out.println("6. Instance variable  same names ");
		System.out.println("\tINSTANCE_VAR_SAME=" +Interface1.INSTANCE_VAR_SAME);
		System.out.println("\tINSTANCE_VAR_SAME=" +Interface2.INSTANCE_VAR_SAME);
		//System.out.println("\tINSTANCE_VAR_SAME=" +mi.INSTANCE_VAR_SAME);        // will not work ambigous
		
		System.out.println("7. static variable ");
		System.out.println("\tSTATIC_VAR=" +Interface1.STATIC_VAR);
		System.out.println("\tSTATIC_VAR=" +Interface2.STATIC_VAR);
		//System.out.println("\tSTATIC_VAR=" +mi.STATIC_VAR);							// will not work ambigous
		System.out.println("\tSTATIC_VAR_DIFFERENT=" +mi.STATIC_VAR_DIFFERENT);				// only warning to access in static way
	}
}
