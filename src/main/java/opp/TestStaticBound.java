package opp;

public class TestStaticBound {

	public static void main(String[] args) throws Exception
{
	
		Car c1=new Car();
	
		//1. static bound from Car		
		c1.staticBound();
		c1.engine();
		
		//2. static bound from car even sub class instance is assigned
		Car c2=new BMW();
			
			c2.stop();
			
		
		
}
}
