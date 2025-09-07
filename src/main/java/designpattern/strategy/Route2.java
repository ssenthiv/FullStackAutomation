package designpattern.strategy;

import java.util.Random;

public class Route2 implements Route{

	

	public void getDirection() {
		System.out.println("Turn right after 50 meters");
		
	}


	public int getDistance() {
		
		return 40;
	}

	
	public Enum<Traffic> getTraffic() {
		Random r=new Random();
		if (r.nextBoolean() == true){
			System.out.println("High traffic in Route2");
			return Traffic.HIGH_TRAFFIC;
		}
		System.out.println("Low traffic in Route2");
		return Traffic.LOW_TRAFFIC;
	}

}
