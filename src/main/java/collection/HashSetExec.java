package collection;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetExec {
	
	public static void main(String[] args){
		
		Set<Car> carsSet=new HashSet<>();
		Car c=null;
		for (int i=0; i<5;i++){
			
			carsSet.add(new Car("PY-"+i));
		}
		
		System.out.println("1. Retrieve from HashSet ( No order)");
	
		Iterator<Car> carsItr=carsSet.iterator();
		while ( carsItr.hasNext()){
			
			c=carsItr.next();
			System.out.println(c);
		}
		
	}

}
