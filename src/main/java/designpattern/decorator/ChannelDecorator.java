package designpattern.decorator;

public abstract class ChannelDecorator implements SatelliteTv{
	
	private SatelliteTv satellite;
	
	public ChannelDecorator(SatelliteTv satellite){
	this.satellite=satellite;
	}
	
	public SatelliteTv getSatelliteTv(){
		return this.satellite;
	}
}
