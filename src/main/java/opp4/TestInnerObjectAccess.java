package opp4;


public class TestInnerObjectAccess {

		public static void main(String[] args) {
		
		
		Car c=new Car();
		System.out.println("1. Compilation Error: Inner Object variable accessing outer members and methods ");
		//System.out.println(c.b.privateStr);
		c.b.printSoundPrivate();
		
		} 
		
}
