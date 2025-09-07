package designpattern.strategy;

public interface Route {

	
	public void getDirection();
	public int getDistance();
	public Enum<Traffic> getTraffic();
}
