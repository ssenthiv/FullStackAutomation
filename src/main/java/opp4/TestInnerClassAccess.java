package opp4;


public class TestInnerClassAccess {

		public static void main(String[] args) {
		
		
		Car c=new Car();
		System.out.println("1. Inner class accessing private member, method from outer using getter method ");
		c.b.printSound(" From inner Bike");
		
		System.out.println("\n8. Overlading methods from inner and outer classes  ");
		System.out.println("Compilation Error : bike-inner method accessing outer method which is "
				+ "overloaded with inner");
		
		c.b.printSound("From", "Inner");
		
		
		//c.b.printSoundPrivate();
		
		} 
		
}
