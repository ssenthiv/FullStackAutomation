package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class SortingExec {
	
	public static void main(String[] args){
		
		ArrayList<Car> carsArrList=new ArrayList<>();
		Car c1;
		
		for (int i=0; i<100;i++){
			Car c=new Car("Py-"+i);
			c.setPrice((int)(Math.random()*100)+1);
			carsArrList.add(c);
		}
		
		System.out.println("1. Retrieve price before sorting ");
		
		Iterator<Car> carsItr=carsArrList.iterator();
		while ( carsItr.hasNext()){
			c1=carsItr.next();
			System.out.println("No = "+c1.getRegistrationNumber()+ "price =  " +c1.getPrice());
		}
		Collections.sort(carsArrList);
		
		System.out.println("\n2. Retrieve price after sorting ");
		
		 carsItr=carsArrList.iterator();
		while ( carsItr.hasNext())
			System.out.println("price =  " +carsItr.next().getPrice());
			
		System.out.println("\n3. Retrieve price after custom sorting Odd first with (DESC) ");
		Collections.sort(carsArrList,new CustomComparator());
		 carsItr=carsArrList.iterator();
		while ( carsItr.hasNext())
			System.out.println("price =  " +carsItr.next().getPrice());
	}

}
