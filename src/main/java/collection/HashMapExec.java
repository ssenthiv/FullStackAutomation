package collection;

import java.net.CacheResponse;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.apache.commons.net.ftp.parser.MacOsPeterFTPEntryParser;

import net.bytebuddy.description.modifier.Ownership;

public class HashMapExec {

	public static void main(String[] args) {
		HashMap<Car,Owner> carOwners=new HashMap<>();
		
		Car c;
		Owner o;
		
		System.out.println("0. hashCode is been called on Key(Car) when put is used");
		for (int i=0;i<5;i++){
			c=new Car("KL-"+i);
			//c.setPrice((int)(Math.random()*100+1));
			o=new Owner();
			carOwners.put(c,o);     // hashcode of Car is been called
			
			
		}
		
		System.out.println("1. print HashMap without entrySet()");
		
		Iterator<Car> carItr=carOwners.keySet().iterator();
		
		//carOwners.remove(new Car("KL-3"));				// ConcurrentModificationException
		while (carItr.hasNext()){
			c=carItr.next();
			//carItr.remove();
			//carOwners.remove(new Car("KL-3")); 				// hasCode is called on Key (Car)
			System.out.println("Car ="+ c + " Owner ="+ carOwners.get(c));  // hasCode is called on Key (Car)
			//carOwners.containsValue(new Owner());			// no hashCode called
			//carOwners.remove(carOwners.get(c));           // hashcode is called on Value(Owner) 
			
		}
		
		System.out.println("\n2. print HashMap with entrySet()");
		
		
		
		for (Map.Entry<Car,Owner> carOwnerEntry : carOwners.entrySet()){
			c=carOwnerEntry.getKey();
			//carOwnerEntry.setValue(new Owner("shun"));				// working
			//carOwners.replace(c,new Owner("shun"));					// working
			//carOwners.replace(new Car("KL-3"),new Owner("shun"));   	// working
			//carOwners.put(c,new Owner("shun"));						// working 
			//carOwners.put(new Car("TN"),new Owner("shun"));			//ConcurrentModificationException
			//carOwners.remove(c);										//ConcurrentModificationException
			o=carOwnerEntry.getValue();
			//carOwners.replace(new Car("KL-3"),new Owner("shun"));		// working 
			//carOwners.replace(c,new Owner("shun"));					// working
			//carOwners.put(new Car("TN"),new Owner("shun"));			// ConcurrentModificationException
			//carOwners.put(c,new Owner("shun"));						// working 
			//carOwnerEntry.setValue(new Owner("shun"));				// working
			System.out.println("Car :"+ c + " Owner:"+ o);
		}
		
		System.out.println("\n3. Map.Entry outside the iterator loop");
		System.out.println("\n. Car(Mutable) object is modified");
		
		Iterator<Map.Entry<Car, Owner>> setItr =carOwners.entrySet().iterator();
		
		while (setItr.hasNext()){
			Map.Entry<Car, Owner> mapEntry = setItr.next();
			
			//setItr.remove();		// working
			c= mapEntry.getKey();
			if ( c.equals(new Car("KL-2")))
			c.setRegistrationNumber(c.getRegistrationNumber().replaceAll("KL", "TN"));	// working
			
			System.out.println("Map.Entry : "+ mapEntry);
		}
		//mapEntry.getKey()  // Not working
		
		System.out.println("\n4. print HashMap usgin lambda");
		carOwners.forEach((K,V)->System.out.println(K.toString() +"  "+ V.toString()));
		
		System.out.println("\n5. Map as key for Map");
		//Map<String,Map<Car,Owner>> societyMap=new HashMap<>();
		Map<Map<Car,Owner>,String> societyMap=new HashMap<>();
		societyMap.put(carOwners, "Shikharam");
		
		for ( Map.Entry<Map<Car,Owner>,String> societyEntry : societyMap.entrySet() ){
			
			System.out.println(societyEntry.getValue());
		}
		
	}

	
	
}
