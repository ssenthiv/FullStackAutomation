package opp;

public class TestReducedVisibility {

	public static void main(String[] args) throws Exception
{
	
		Car c1=new BMW();
	
		//1. Compilation Error due to reduced visibility in child class
		//   but parent class method will be called
		System.out.println("Compilation Error due to reduced visibility in child class");
		System.out.println("but parent class method will be called \n");
		
		c1.ABS();
		
		//2. Compilation Error due to reduced visibility in child class
		//   and Compilation Error from calling class also
		System.out.println("\nCompilation Error due to reduced visibility in child class");
		System.out.println("and Compilation Error from calling class also \n");
				
		c1.ABS2();	
		
}
}
