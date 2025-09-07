package designpattern.observer;

public class Mobile implements Observer {
	
	public void update(Stock stock){
		System.out.println("MOBILE :"+ stock.getName()+" has been updated with new price :"+stock.getPrice());
	}

}
