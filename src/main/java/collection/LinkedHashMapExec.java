package collection;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapExec {

	public static void main(String[] args) {
		
		LinkedHashMap<Car,Owner> carsOwner=new LinkedHashMap<>();
		
		for (int i=0;i<10 ;i++){
			carsOwner.put(new Car("MH-"+i), new Owner());
		}
		System.out.println("1. Print linkedHashMap");
		// Collections.sort(carsOwner);         sort will not work
		
		//for (Map.Entry<Car,Owner> carsEnty : carsOwner.entrySet()){
			carsOwner.forEach((K,V)->System.out.println(K.getRegistrationNumber().toString() +V.getOwnerName() ));
			
		
	}

}
