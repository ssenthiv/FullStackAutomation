package Java8;

public class Vehicle  {

	public interface Car{
		
		public  default void start(){
			System.out.println("Car- started");
		}
		public void ABS();
	}
	
public interface Bike{
		
		public  default void start(){
			System.out.println("Bike- started");
		}
		public  void stop();
	}
}
