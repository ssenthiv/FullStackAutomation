package opp4InnerClass;


public class TestInnerInheritance {

		public static void main(String[] args) {
		
		Vehicle vc = new Car();

		System.out.println("\n1. Method call from super<--SubInner, bind to subclass");
		vc.printSound();
		
		
		Vehicle v2 = new Vehicle();
		System.out.println("\n2. Method call from this bind to this (Static binding)");
		v2.printSound();
		
		System.out.println("\n3. Method call from this.innerObject bind to inner class(Static binding)");
		Car c =new Car();
		c.b.printSound();
		
	
		
		
		System.out.println("\n4. Method call from Super<--innerBike class bind to inner class (Dynamic binding)");
		Vehicle vcb = (Vehicle) c.b;
		vcb.printSound();
		c.new Bike().printSound();
		 Car.Bike cb=c.new Bike();
		 //Car.Bike cb2=new Car.Bike();      // will not work as Bike is not a static inner
		 cb.printSound();
		
		Bike bo= new Bike();
		System.out.println("\n5. Method call from outer Bike (Static binding) ");
		bo.printSound();
		
		Car cbo= new Bike();
		System.out.println("\n6. Method call from Car.InnerObj <--outer bike, bind to inner class ");
		cbo.b.printSound();
		//cbo.printSound();
	
		
		
		} 
		
}
