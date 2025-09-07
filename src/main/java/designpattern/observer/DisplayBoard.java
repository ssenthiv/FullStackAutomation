package designpattern.observer;

public class DisplayBoard implements Observer{

public void update(Stock stock){
	
	System.out.println("DISPLAY BOARD:"+stock.getName() + " has been updated with new price :"+stock.getPrice());
}
	
}
