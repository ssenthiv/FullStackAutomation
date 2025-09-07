package designpattern.decorator;

public class ESPN extends ChannelDecorator{
	
	
	public ESPN(SatelliteTv satellite){
		super(satellite);
		
	}
	
	public void show(int channel){
		if ( channel > 100 && channel < 200){
			System.out.println("Enjoy Football match");
		}else {
			this.getSatelliteTv().show(channel);
		}
		
	}
	


	@Override
	public int subscriptionPrice() {
		
		return this.getSatelliteTv().subscriptionPrice()+20 ;
	}
}
