package designpattern.observer;

public class Exec {

	public static void main(String[] args) {
	
		IBM ibm=new IBM();
		Microsoft micro=new Microsoft();
		Apple apple=new Apple();
		
		Mobile mobile=new Mobile();
		DisplayBoard db=new DisplayBoard();
		
		ibm.registerObserver(mobile);
		ibm.registerObserver(db);
		
		micro.registerObserver(mobile);
		micro.registerObserver(db);
		
		apple.registerObserver(mobile);
		apple.registerObserver(db);
		
		// Update price
		
		for(int i=0;i<100; i++){
			
			ibm.updateStockPrice((int)(Math.random()*100+1));
			micro.updateStockPrice((int)(Math.random()*100+1));
			apple.updateStockPrice((int)(Math.random()*100+1));
		}

	}

}
