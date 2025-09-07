package opps.innerInterface;

import opps.innerInterface.InnerInterface.StaticInterface;


public class StaticInterfaceImpl implements InnerInterface {

		
	
	public static void main(String[] args){
		
		System.out.println("1. Calling outer defaul method");
		StaticInterfaceImpl s=new StaticInterfaceImpl();
		s.outerDefaultMethod();
		//InnerInterface.StaticInterface.innerMethod();
		s.sInterface.innerMethod();
		
		System.out.println("\n2. Instantiating Inner Interface");
		InnerInterface.StaticInterface i =new InnerInterface.StaticInterface() {
		};
		
		i.innerMethod();
		System.out.println("\n3. Instantiating outer Interface with anonymous class ");
		InnerInterface i2= new InnerInterface(){
			public void abstractMethod(){
				
		};
		};
		
		 i2.outerDefaultMethod();
	}

	@Override
	public void abstractMethod() {
		System.out.println("Abstract method implemention");
		
	}

	

}
