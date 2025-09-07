package collection.comparison;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;



public class MapFactory implements DataStructureFactory {
	private Map<Car,Owner> map=null;
	Car temp;
	//Car car;
	public void createObject(String classname){
		
		Car.setLogging(true);
		System.out.println("-----------------------------------------------------------------------------");
		System.out.println("\n\t\t\tCreating Object ... ");

		try {
			
			Class<?> clazz= Class.forName(classname);
			map=(Map) clazz.newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		System.out.println("\nMap \t\t: "+map.getClass().getName()+"\n");
		System.out.println("Size \t\t: "+map.size());
		//maxElementCount();
		System.out.println("-----------------------------------------------------------------------------");
	}
	
	public void addingBulkElements(int start){
		Car.setLogging(true);
		System.out.println("\n\t\t\tAding bulk Elements ... ");
		System.out.println("\nMap \t\t: "+map.getClass().getName()+"\n");
		
		for(int i=start;i<start+10;i++){
		//System.out.println("\tcount\t: "+i);
		int price=(int) (Math.random()*10+1);	
		Car car=new Car("Skoda"+i);
		car.setPrice(price);
		
		Owner owner=new Owner();
		
		 map.put(car,owner);

		}
		
		System.out.println("Size \t\t: "+map.size());
		maxElementCount();
		System.out.println("-----------------------------------------------------------------------------");
	}
	
	public void printCollection(){
		Car.setLogging(true);
		System.out.println("\t\t\tPrinting All Elements ...");
		System.out.println("\nMap \t\t: "+map.getClass().getName());
		System.out.println("Size \t\t: "+map.size());
		
		for (Object obj : map.entrySet()){
			System.out.println(obj);
			temp=((Map.Entry<Car, Owner>)obj).getKey();
		}
		
		maxElementCount();
		System.out.println("-----------------------------------------------------------------------------");
	}
	public void searchElement(){
		Car.setLogging(true);
		System.out.println("\t\t\tSearching Element ...");
		System.out.println("\nMap \t\t: "+map.getClass().getName());
		Car car=new Car("Skoda5");
		int price=(int)(Math.random()*10+1);
		car.setPrice(price);
		System.out.println("Searched\t: " +car);
		
		System.out.println("Contains\t: "+map.containsKey(car));
		//System.out.println("Owner\t: "+map.get(car));
		//System.out.println("Contains\t: "+map.containsKey(temp));
		//System.out.println("Owner\t: "+map.get(temp));
		maxElementCount();
		System.out.println("Size \t\t: "+map.size());
		System.out.println("-----------------------------------------------------------------------------");
	}
	public void removeElement(){
		Car.setLogging(true);
		System.out.println("\t\t\tRemoving Element ...");
		System.out.println("\nMap \t\t: "+map.getClass().getName());
		System.out.println("Size \t\t: "+map.size());
		Car car=new Car("Skoda5");
		int price=(int)(Math.random()*10+1);
		car.setPrice(price);
		System.out.print("Searched\t: " +car);
		System.out.println("Removed\t: "+map.remove(car));
		//System.out.println("Removed\t: "+map.remove(temp));
		System.out.println("Size \t\t: "+map.size());
		maxElementCount();
		System.out.println("-----------------------------------------------------------------------------");
	}
	public void addNewElement(){
		Car.setLogging(true);
		System.out.println("\t\t\tAdding new Element ...");
		System.out.println("\nMap \t\t: "+map.getClass().getName());
		System.out.println("Size \t\t: "+map.size());
		
		Car car=new Car("Added5");
		int price=(int)(Math.random()*10000+1);
		car.setPrice(price);
		
		Owner owner=new Owner();
	
		System.out.println("Previous Element: "+map.put(car,owner));
		System.out.println("Size \t\t: "+map.size());
		maxElementCount();
		System.out.println("-----------------------------------------------------------------------------");
	}
	public void addExistingElement(){
		Car.setLogging(true);
		System.out.println("\t\t\tAdding existing Element ...");
		System.out.println("\nMap \t\t: "+map.getClass().getName());
		Car car;
		Owner owner;
				
			car=new Car("Skoda0");
			int price=(int)(Math.random()*10+1);
			car.setPrice(price);
			
			owner=new Owner();
			//System.out.println("Old Owner : " + map.get(car));
			System.out.println("Old Owner : " + map.replace(car,owner));
			//System.out.println("Old Owner : " + map.replace(temp,owner));
	
		maxElementCount();
		System.out.println("Size \t\t: "+map.size());
		System.out.println("-----------------------------------------------------------------------------");
	}
	public void maxElementCount(){
		Car.setLogging(true);
		//System.out.println("\t\t\tMethods invoked count on Car ...");
		//System.out.println("\nCollection \t: "+collection.getClass().getName());
		try{
			
		
		int count=map.keySet().stream().max((c,d)->{
												if (c.getInstanceCountCompareTo()== d.getInstanceCountCompareTo()){
													return 0;
												}else if (c.getInstanceCountCompareTo()> d.getInstanceCountCompareTo()){
													return 1;
												}else 
													return -1;
												}).get().getInstanceCountCompareTo();
		
		
		System.out.println("\nMax Instance Count compareTo\t: "+count);
		
		count=map.keySet().stream().max((c,d)->{
			if (c.getInstanceCountEquals()== d.getInstanceCountEquals()){
				return 0;
			}else if (c.getInstanceCountEquals()> d.getInstanceCountEquals()){
				return 1;
			}else 
				return -1;
			}).get().getInstanceCountEquals();


		System.out.println("Max Instance Count Equals\t: "+count);
		
		count=map.keySet().stream().max((c,d)->{
			if (c.getInstanceCountHashCode()== d.getInstanceCountHashCode()){
				return 0;
			}else if (c.getInstanceCountHashCode()> d.getInstanceCountHashCode()){
				return 1;
			}else 
				return -1;
			}).get().getInstanceCountHashCode();


		System.out.println("Max Instance Count HashCode\t: "+count);
		
		// Reset Car Counters
		map.keySet().stream().forEach((c)->c.initCounters());
		}catch (NoSuchElementException e){
			System.out.println("Elements are not yet added");
			e.printStackTrace();
		}
		
		
		
	}
	
}
