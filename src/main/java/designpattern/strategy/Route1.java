package designpattern.strategy;

import java.util.Random;

public class Route1 implements Route{


	public void getDirection() {
		System.out.println("Turn left after 100 meters");
		
	}


	public int getDistance() {
		
		return 50;
	}

	
	public Enum<Traffic> getTraffic() {
		Random r=new Random();
		if (r.nextBoolean() == true){
			System.out.println("High traffic in Route1");
			return Traffic.HIGH_TRAFFIC;
		}
		System.out.println("Low traffic in Route1");
		return Traffic.LOW_TRAFFIC;
	}

}
