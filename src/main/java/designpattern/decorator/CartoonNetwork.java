package designpattern.decorator;

public class CartoonNetwork extends ChannelDecorator {
	

	public CartoonNetwork(SatelliteTv satellite){
		super(satellite);
		
	}
	
	public void show(int channel){
		if ( channel > 300 && channel < 400){
			System.out.println("Enjoy Cartoon Network");
		}else {
			this.getSatelliteTv().show(channel);
		}
		
	}
	


	@Override
	public int subscriptionPrice() {
		
		return this.getSatelliteTv().subscriptionPrice()+10 ;
	}

}
