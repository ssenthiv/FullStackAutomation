package opp.inheritanceAccessibility;

public class TestReducedVisibility {

	public static void main(String[] args) throws Exception
{
	
		Car c1=new BMW();
	
		
		//1. Compilation Error due to reduced visibility in child class
		//   and Compilation Error from calling class also
		System.out.println("\n1. Compilation Error due to reduced visibility in child class");
		System.out.println("Since Child is Non private, ");
		System.out.println("compilation Error from calling class also \n");
				
		//c1.ABS2();	
		
		
		//2. Compilation Error due to reduced visibility in child class from another package
				//   and Compilation Error from calling class also
		Car c2=new opp2.BMW();
		System.out.println("\n2. Compilation Error due to reduced visibility in child class from another package");
		System.out.println("Since Child is Non private, ");
		System.out.println("compilation Error from calling class also \n");
						
		c2.ABS2();	
		
		
		
}
}
