package designpattern.decorator;

public class TataSky implements SatelliteTv{
	
	public void show(int channel){
		
		if ( channel < 100)
			System.out.println("Enjoy basic news channel");
		else
			System.out.println("you are not subscribed for this channel");
		
	}

	public int subscriptionPrice(){
		return 100;
	}
}
