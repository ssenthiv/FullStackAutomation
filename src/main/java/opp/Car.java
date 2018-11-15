package opp;

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
		
		System.out.println("Car--ABS for Reduced visibility");
		
	}

	public void ABS2(){
		
		System.out.println("Car--ABS2 for Reduced visibility");
		
	}
	
}
