package collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class LinkedHashSetExec {
	
	public static void main(String[] args){
		
		LinkedHashSet<Car> carsSet=new LinkedHashSet<>();
		
		for (int i=0; i<100;i++){
			
			carsSet.add(new Car("PY-"+i));
		}
		
		System.out.println("1. Retrieve from LinkedHashSet ( maintain order)");
		
		Iterator<Car> carsItr=carsSet.iterator();
		while ( carsItr.hasNext())
			System.out.println(carsItr.next());
		
		System.out.println("2. Add duplicate object");
		System.out.println(carsSet.add(new Car("PY-30")));
	}

}
