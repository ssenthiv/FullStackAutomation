package designpattern.factorymethod;

public class Samsung implements Mobile{

	private int ramSize;

	private String processor;

	public String name = Mobile.SAMSUNG;

	public Samsung(int ramSize){

		this.ramSize = ramSize;

	}

	

	public Samsung(String processor){

		this.processor = processor;

		this.ramSize =2;

	}
	public void display(){
		
		System.out.println("Mobile : Samsung");
		System.out.println("Processor :"+ this.processor);
		System.out.println("Memory :"+ this.ramSize);
	}
}
