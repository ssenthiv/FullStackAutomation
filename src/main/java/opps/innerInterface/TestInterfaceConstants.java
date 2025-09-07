package opps.innerInterface;

import static opps.innerInterface.Constants.*;
public class TestInterfaceConstants {
	
	/*
	public static final  String _SAMSUNG="samsung TV";
	public static   String _NOKIA="nokia TV";
	public String _SONY="sony TV";
	String _IPHONE="Apple TV"; */
	
	void display(){
		
		System.out.println(Constants._SAMSUNG);
		System.out.println(Constants._NOKIA);
		System.out.println(Constants._SONY);
		System.out.println(Constants._IPHONE);
	}
	
	void displayTv(){
		
		System.out.println(_SAMSUNG);
		//_SAMSUNG="tv";
		System.out.println(_NOKIA);
		//_NOKIA="tv";
		System.out.println(_SONY);
		//_SONY="tv";
		System.out.println(_IPHONE);
		//_IPHONE="tv";
	}
	
	public static void main(String[] args){
		
		TestInterfaceConstants t=new TestInterfaceConstants();
		t.display();
		System.out.println("------------");
		t.displayTv();
	}

}
