package collection;

import java.util.ArrayList;
import java.util.Collection;


public class FactoryMethod {
	private Collection<Car> collection=null;
	public void createObject(String classname){
		
		
		System.out.println("-----------------------------------------------------------------------------");
		System.out.println("\n\t\t\tAdding elements ... ");
		try {
			
			Class<?> clazz= Class.forName(classname);
			collection=(Collection) clazz.newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		System.out.println("\nCollection \t: "+collection.getClass().getName()+"\n");
		for(int i=0;i<10;i++){
		System.out.println("\tcount\t: "+i);
		int price=(int) (Math.random()*100+1);	
		Car car=new Car("Skoda"+i);
		car.setInstanceCount(1);
		car.setPrice(price);
		boolean isAdded=collection.add(car);
		System.out.println("isAdded "+ isAdded);
		while(!isAdded);
		System.out.println("**********************************************************");
		price=(int) (Math.random()*100+1);	
		isAdded=collection.add(car);
		}
		System.out.println("Size \t\t: "+collection.size());
		System.out.println("-----------------------------------------------------------------------------");
	}
	public void printCollection(){
		System.out.println("\t\t\tPrinting Elements ...");
		System.out.println("\nCollection \t: "+collection.getClass().getName());
		System.out.println("Size \t\t: "+collection.size());
		
		for (Object obj : collection){
			System.out.println(obj);
		}
		System.out.println("-----------------------------------------------------------------------------");
	}
	public static void main(String[] args){
		FactoryMethod fm=new FactoryMethod();
		
		String name;
		//name="java.util.HashSet";
		name="java.util.TreeSet";
		//name="java.util.ArrayList";
		//name="java.util.LinkedList";
		//name="java.util.Vector";

		
		fm.createObject(name);
		fm.printCollection();
		
		
	}
}
