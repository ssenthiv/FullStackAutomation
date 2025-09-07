package designpattern.factorymethod;

public class Sony implements Mobile{

	private int ramSize;

	private String processor;

	

	public Sony(int ramSize, String processor){

		this.ramSize = ramSize;

		this.processor = processor;

	}
public void display(){
		
		System.out.println("Mobile : Sony");
		System.out.println("Processor :"+ this.processor);
		System.out.println("Memory :"+ this.ramSize);
	}
}
