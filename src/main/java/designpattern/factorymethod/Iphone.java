package designpattern.factorymethod;

public class Iphone implements Mobile{

	private int ramSize;

	private String processor;

	private String GPU;

	public Iphone(int ramSize, String processor, String GPU){

		this.ramSize = ramSize;

		this.processor = processor;

		this.GPU = GPU;

	}
public void display(){
		
		System.out.println("Mobile : IPhone");
		System.out.println("Processor :"+ this.processor);
		System.out.println("Memory :"+ this.ramSize);
	}
}
