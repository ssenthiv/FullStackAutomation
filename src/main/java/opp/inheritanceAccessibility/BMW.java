package opp.inheritanceAccessibility;

public class BMW extends Car{
	
	
	//Method Overriding: when the same method is present in parent class as well as in child class with the same and same no. of parameters.
	public void start(){
		System.out.println("BMW--start");
	}
	
	public void start(String s){
		
		System.out.println("BMW--start--String " + s);
		
	}
	public int start(int s){
		
		System.out.println("BMW--start--int " + s);
		return s;
	}
	
	public void theftSafety(){
		System.out.println("BMW--theftSafety");
	}
	
	
	public void infotainment(){
		System.out.println("BMW--Infotainment");
	}
	
	 private void ABS(){
		
		System.out.println("BMW--ABS for Reduced visibility");
		
	}
	
	  void ABS2(){
			
			System.out.println("BMW--ABS2 for Reduced visibility");
			
		}
	  void breaking(){
			
			System.out.println("BMW--break for accessing super class method");
			stop();
			//changeSeat();
			
		}
	  
	   
}
