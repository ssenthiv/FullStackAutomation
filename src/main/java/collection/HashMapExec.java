package collection;

import java.net.CacheResponse;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapExec {

	public static void main(String[] args) {
		HashMap<Car,Owner> carOwners=new HashMap<>();
		
		Car c;
		Owner o;
		
		for (int i=0;i<100;i++){
			c=new Car("KL-"+i);
			//c.setPrice((int)(Math.random()*100+1));
			o=new Owner();
			carOwners.put(c,o);
			
		}
		
		System.out.println("1. print HashMap without entrySet()");
		
		Iterator<Car> carItr=carOwners.keySet().iterator();
		
		while (carItr.hasNext()){
			c=carItr.next();
			System.out.println("Car ="+ c + " Owner ="+ carOwners.get(c));
		}
		
		System.out.println("\n2. print HashMap with entrySet()");
		
		
		
		for (Map.Entry<Car,Owner> carOwnerEntry : carOwners.entrySet()){
			c=carOwnerEntry.getKey();
			o=carOwnerEntry.getValue();
			System.out.println("Car :"+ c + " Owner:"+ o);
		}
		
		System.out.println("\n3. print HashMap usgin lambda");
		carOwners.forEach((K,V)->System.out.println(K.toString() + V.toString()));
		
	}

}
