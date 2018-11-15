package collection;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapExec {

	public static void main(String[] args) {
		
		TreeMap<Car,Owner> carsTreeMap=new TreeMap<>();
		Car c, c2;
		
		for(int i=0; i<100;i++){
		c=new Car("TL-"+i);
		c.setPrice((int)(Math.random()*100+1));
		carsTreeMap.put(c, new Owner());
			
		}

		System.out.println("1. print Tree map");
		
		for (Map.Entry<Car, Owner> carsEntry : carsTreeMap.entrySet()){
		
			System.out.println(carsEntry.getKey().toString() +" "+ carsEntry.getValue());
		}
	
		System.out.println("2. print Tree map between using tailMap and headMap");
		
		c=new Car("TL-50");
		c.setPrice(50);
		c2=new Car("TL-51");
		c2.setPrice(30);
		Map<Car,Owner> filterCar=carsTreeMap.tailMap(c).headMap(c2);
		System.out.println(carsTreeMap.containsKey(c));
		
		
		for (Map.Entry<Car, Owner> carsEntry : filterCar.entrySet()){
			
			System.out.println(carsEntry.getKey().toString() +" "+ carsEntry.getValue());
		}
	}

}
