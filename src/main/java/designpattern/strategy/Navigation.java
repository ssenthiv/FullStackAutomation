package designpattern.strategy;

public class Navigation {

	private Route route;
	
	Navigation(){
		
		route=this.getBestRoute();
	}
	
	public Route getBestRoute(){
		
		Route1 r1=new Route1();
		Route2 r2=new Route2();
		if (r1.getTraffic() == Traffic.LOW_TRAFFIC && r2.getTraffic() == Traffic.HIGH_TRAFFIC){
			System.out.println("Selecting Low Traffic route - Route1");
			return r1;
		}
		System.out.println("Selecting Route2");
		return r2;
	}
	public void navigate(){
		System.out.println("Distance : " +route.getDistance()+" KM");
		route.getDirection();
		
	}
	
}
