package opp2;
import opp.inheritanceAccessibility.*;


public class BMW extends Car{
	
	
	public void start(){
		System.out.println("opp2.BMW--start");
	}
	
	 public void ABS(){
		
		System.out.println("opp2.BMW--No access to parent ABS");
		
	}
	
	  void ABS2(){
			
			System.out.println("opp2.BMW--ABS2 for Reduced visibility");
			
		}
	  
	   protected void defaultMethod(){
			
			System.out.println("opp2.BMW-- default method");
			
		}
	

}
