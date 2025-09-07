package opp.inheritanceAccessibility;

public class Car extends Truck {
	
	
	public void start(){
		System.out.println("Car--start");
	}
	
	public void start(String s1, String s2){
		System.out.println("Car--start"+s1+s2);
	}
	public void stop(){
		System.out.println("Car--stop");
	}
	
	public void refuel(){
		System.out.println("Car--refuel");
	}
	
	private void changeSeat(){
		
		System.out.println("Car--Change Seat order");
	}
	
	public void staticBound(){
		
		System.out.println("Car--static bound");
	}
	
	   void ABS(){
		
		System.out.println("Car-- default ABS");
		
	}

	public void ABS2(){
		
		System.out.println("Car--ABS2 for Reduced visibility");
		
	}
	
	public static void main(String[] args){
		
		
		Car c1 =new BMW();
		
		c1.ABS();
		//c1.ABS2();
		opp2.BMW c2=new opp2.BMW();
		//c2.defaultMethod();
	}
	
	
	   void defaultMethod(){
			
			System.out.println("Car-- default method");
			
			
		}

}
