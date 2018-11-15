package Java8;

public class MultipleInheritance implements Vehicle.Car, Vehicle.Bike {
	
	/*public void start(){
		System.out.println("MI- started");
	}*/
	public void ABS(){
		System.out.println("MI- ABS");
	}
	public void stop(){
		System.out.println("MI- stopped");
	}
	public static void main(String[] args){
		
		MultipleInheritance m=new MultipleInheritance();
		
		m.start();
		
		
		//Vehicle.Car.start();
		//Vehicle.Bike.start();
		
		
	}

}
