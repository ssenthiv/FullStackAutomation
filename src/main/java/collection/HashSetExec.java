package collection;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;

public class HashSetExec {
	
	public static void main(String[] args){
		
		HashSet<Car> carsSet=new HashSet<>();
		
		for (int i=0; i<100;i++){
			
			carsSet.add(new Car("PY-"+i));
		}
		
		System.out.println("1. Retrieve from HashSet ( No order)");
		
		Iterator<Car> carsItr=carsSet.iterator();
		while ( carsItr.hasNext())
			System.out.println(carsItr.next());
		
	}

}
