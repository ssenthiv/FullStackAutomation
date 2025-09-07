package collection.comparison;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;



public class CollectionFactory implements DataStructureFactory {
	private Collection<Car> collection=null;
	Car temp;
	//Car car;
	public void createObject(String classname){
		
		Car.setLogging(true);
		System.out.println("-----------------------------------------------------------------------------");
		System.out.println("\n\t\t\tCreating Object ... ");

		try {
			
			Class<?> clazz= Class.forName(classname);
			collection=(Collection) clazz.newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		System.out.println("\nCollection \t: "+collection.getClass().getName()+"\n");
		System.out.println("Size \t\t: "+collection.size());
		//maxElementCount();
		System.out.println("-----------------------------------------------------------------------------");
	}
	public void addingBulkElements(int start){
		Car.setLogging(true);
		System.out.println("\n\t\t\tAding bulk Elements ... ");
		System.out.println("\nCollection \t: "+collection.getClass().getName()+"\n");
		for(int i=start;i<start+10;i++){
		//System.out.println("\tcount\t: "+i);
		int price=(int) (Math.random()*1000+1);	
		Car car=new Car("Skoda"+i);
		
		car.setPrice(price);
		
		
		boolean isAdded=collection.add(car);

		while(!isAdded){
		System.out.println("**************************************************************************************");
		System.out.println("isAdded "+ isAdded);
		System.out.println(car);
		
		price=(int) (Math.random()*1000+1);
		System.out.println("price : "+price);
		car.setPrice(price);
		car.setInstanceCountCompareTo(0);
		car.setInstanceCountEquals(0);
		car.setInstanceCountHashCode(0);
		isAdded=collection.add(car);
		}
		}
		System.out.println("Size \t\t: "+collection.size());
		maxElementCount();
		System.out.println("-----------------------------------------------------------------------------");
	}
	public void printCollection(){
		Car.setLogging(true);
		System.out.println("\t\t\tPrinting All Elements ...");
		System.out.println("\nCollection \t: "+collection.getClass().getName());
		System.out.println("Size \t\t: "+collection.size());
		
		for (Object obj : collection){
			System.out.println(obj);
			temp=(Car)obj;
		}
		
		maxElementCount();
		System.out.println("-----------------------------------------------------------------------------");
	}
	public void searchElement(){
		Car.setLogging(true);
		System.out.println("\t\t\tSearching Element ...");
		System.out.println("\nCollection \t: "+collection.getClass().getName());
		Car car=new Car("Skoda5");
		int price=(int)(Math.random()*100+1);
		car.setPrice(price);
		System.out.println("Searched\t: " +car);
		
		
		
		System.out.println("Contains\t: "+collection.contains(car));
		//System.out.println("Contains\t: "+collection.contains(temp));
		
		
		
		maxElementCount();
		System.out.println("Size \t\t: "+collection.size());
		System.out.println("-----------------------------------------------------------------------------");
	}
	public void removeElement(){
		Car.setLogging(true);
		System.out.println("\t\t\tRemoving Element ...");
		System.out.println("\nCollection \t: "+collection.getClass().getName());
		System.out.println("Size \t\t: "+collection.size());
		Car car=new Car("Skoda5");
		int price=(int)(Math.random()*100+1);
		car.setPrice(price);
		System.out.print("Searched\t: " +car);
		System.out.println("Removed\t: "+collection.remove(car));
		//System.out.println("Removed\t: "+collection.remove(temp));
		System.out.println("Size \t\t: "+collection.size());
		maxElementCount();
		System.out.println("-----------------------------------------------------------------------------");
	}
	public void addNewElement(){
		Car.setLogging(true);
		System.out.println("\t\t\tAdding new Element ...");
		System.out.println("\nCollection \t: "+collection.getClass().getName());
		System.out.println("Size \t\t: "+collection.size());
		Car car=new Car("Added5");
		
		int price=(int)(Math.random()*10000+1);
		car.setPrice(price);
		System.out.println(car+ " : "+collection.add(car));
		System.out.println("Size \t\t: "+collection.size());
		maxElementCount();
		System.out.println("-----------------------------------------------------------------------------");
	}
	public void addExistingElement(){
		Car.setLogging(true);
		System.out.println("\t\t\tAdding existing Element ...");
		System.out.println("\nCollection \t: "+collection.getClass().getName());
		Car car;
		if (collection instanceof List  ){
			car=((List<?extends Car>)collection).get(0);
			System.out.println("Before\t\t: "+car);
			car=new Car("Modified0");
			((List<Car>)collection).add(0,car);
			System.out.println("After\t\t: "+((List<?extends Car>)collection).get(0));
		}
		else if(collection instanceof NavigableSet) {
			car=new Car("Skoda0");
			int price=(int)(Math.random()*1000+1);
			car.setPrice(price);
			car=((NavigableSet<Car>)collection).higher(car);
			System.out.println("Before\t\t: "+car);
			price=car.getPrice();

			car=new Car("Modified?");
			car.setPrice(price);
//			car.setRegistrationNumber("Skoda6");
			
			System.out.println(car + " : " + collection.add(car));
			
		}
		else if (collection instanceof Queue  ){
			car=((Queue<?extends Car>)collection).peek();
			System.out.println("Before\t\t: "+car);
			int price=car.getPrice();
			car=new Car("Skoda0");
			//price=(int)(Math.random()*100+1);
			car.setPrice(price);
			
			
			System.out.println(car + " : "+((Queue<?super Car>)collection).offer(car));
		}
		
		else{
			car=new Car("Skoda0");
			int price=(int)(Math.random()*100+1);
			car.setPrice(price);
			System.out.println(car + " : " + collection.add(car));
			//System.out.println(car + " : " + collection.add(temp));
		}
		maxElementCount();
		System.out.println("Size \t\t: "+collection.size());
		System.out.println("-----------------------------------------------------------------------------");
	}
	public void removeElementsQueue(){
		Car.setLogging(true);
		System.out.println("\t\t\tRemoving All Elements ...");
		System.out.println("\nCollection \t: "+collection.getClass().getName());
		Car car=new Car("Added5");
		int price=(int)(Math.random()*1000+1);
		car.setPrice(price);
		int size=collection.size();
				
		for(int i=0;i< size;i++)
		System.out.println("Removed "+i+ " : "+((Queue<Car>)collection).remove());
		System.out.println("Size \t\t: "+collection.size());
		System.out.println("-----------------------------------------------------------------------------");
	}
	public void maxElementCount(){
		Car.setLogging(true);
		//System.out.println("\t\t\tMethods invoked count on Car ...");
		//System.out.println("\nCollection \t: "+collection.getClass().getName());
		try{
			
		
		int count=collection.stream().max((c,d)->{
												if (c.getInstanceCountCompareTo()== d.getInstanceCountCompareTo()){
													return 0;
												}else if (c.getInstanceCountCompareTo()> d.getInstanceCountCompareTo()){
													return 1;
												}else 
													return -1;
												}).get().getInstanceCountCompareTo();
		
		
		System.out.println("\nMax Instance Count compareTo\t: "+count);
		
		count=collection.stream().max((c,d)->{
			if (c.getInstanceCountEquals()== d.getInstanceCountEquals()){
				return 0;
			}else if (c.getInstanceCountEquals()> d.getInstanceCountEquals()){
				return 1;
			}else 
				return -1;
			}).get().getInstanceCountEquals();


		System.out.println("Max Instance Count Equals\t: "+count);
		
		count=collection.stream().max((c,d)->{
			if (c.getInstanceCountHashCode()== d.getInstanceCountHashCode()){
				return 0;
			}else if (c.getInstanceCountHashCode()> d.getInstanceCountHashCode()){
				return 1;
			}else 
				return -1;
			}).get().getInstanceCountHashCode();


		System.out.println("Max Instance Count HashCode\t: "+count);
		
		// Reset Car Counters
		collection.stream().forEach((c)->c.initCounters());
		}catch (NoSuchElementException e){
			System.out.println("Elements are not yet added");
			e.printStackTrace();
		}
		
		
		
	}
	
}
