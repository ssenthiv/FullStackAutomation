package designpattern.decorator;

public class Discovery extends ChannelDecorator {


	public Discovery(SatelliteTv satellite){
		super(satellite);
		
	}
	
	public void show(int channel){
		if ( channel > 200 && channel < 300){
			System.out.println("Enjoy Discovery");
		}else {
			this.getSatelliteTv().show(channel);
		}
		
	}
	


	@Override
	public int subscriptionPrice() {
		
		return this.getSatelliteTv().subscriptionPrice()+15 ;
	}
}
