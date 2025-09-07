package collection;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapExec {

	public LinkedHashMap<Car,Owner> carsOwner;
	
	
	public void createObject(){
		
		carsOwner=new LinkedHashMap<>  (10,2.1f,true);
		//carsOwner=new LinkedHashMap<>(10,2.1f);
		
		for (int i=0;i<10 ;i++){
			carsOwner.put(new Car("MH-"+i), new Owner());
		}
	}
	
	public void printElements(){
		carsOwner.forEach((K,V)->System.out.println(K.getRegistrationNumber().toString() +V.getOwnerName() ));
	}
	
	public void getElement(){
		Car car=new Car("MH-5");
		System.out.println("Owner : "+carsOwner.get(car));
	}
	public static void main(String[] args) {
		
		LinkedHashMapExec lh =new LinkedHashMapExec();
		
		 
		System.out.println("1. Create LinkedHashMap ");
		lh.createObject();
		
		System.out.println("\n2. Print linkedHashMap");
		lh.printElements();	
			
		System.out.println("\n3.Get an Element");
		lh.getElement();
		
		System.out.println("\n4. Print linkedHashMap");
		System.out.println("LRU (least recently used) will be last in the order");
		lh.printElements();	
		
		
		
	}

}
