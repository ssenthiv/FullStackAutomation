package collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import seleniumsessions.CalendarSelectTest;

public class ArrayListExec {

	public static void main(String[] args) {
		
		List<Car> carsList=new ArrayList<>();
		Car car=new Car("KA2359");
		
		carsList.add(car);
		
		// Add more elements
		
		for (int i=0; i<5; i++){
			carsList.add(new Car("TN "+i));
		}
		carsList.add(5,new Car("MH4413"));
		//carsList.clear();
		System.out.println("Total Size = " +carsList.size());
		
		//1. Use Iterator from Collection
		System.out.println("\n1. Use Iterator from Collection");
		Iterator<Car> carsItr = carsList.iterator();
		while (carsItr.hasNext()){
			
			System.out.println(carsItr.next());
		}
		
		System.out.println("\n2. iterate through cloned one");
		
		@SuppressWarnings("unchecked")
		ArrayList<Car> carsList2 = (ArrayList<Car>) ((ArrayList<Car>) carsList).clone();
		
		car.setRegistrationNumber("MH3044");        // clone is shallow copy
		
		carsItr = carsList2.iterator();
		while (carsItr.hasNext()){
			
			System.out.println(carsItr.next());
		}
		System.out.println("\n3. contains method");
		// contains execute equals 
		System.out.println(carsList.contains(new Car("MH4413")));
		
		System.out.println("\n4. get method using index");
		System.out.println(carsList.get(4));
		
		System.out.println("\n5 indexOf method");
	
		System.out.println(carsList.indexOf(new Car("TN " + 4))); // not working if we use  regNum == (this.registrationNumber))
		System.out.println(carsList.indexOf(new Car("KA2359")));
		System.out.println(carsList.indexOf(new Car(carsList.get(3).getRegistrationNumber())));
		
		System.out.println("\n6 ensureCapacity method");
		
		List<Car> carsList3 =new ArrayList<>();
		((ArrayList<Car>) carsList3).ensureCapacity(120);
		
		long startTime=System.nanoTime();
		
		for(int i=0;i<=100;i++){
			carsList3.add(new Car("PY " +i));
		}
		long endTime=System.nanoTime();
		System.out.println("Elapsed Time = "+ (endTime - startTime) +" nano milli Seconds");
		
		System.out.println("\n7 ListIterator");
		List<Car> carsList4=new LinkedList<>(carsList);
		ListIterator<Car> listItr=carsList4.listIterator();
		
		System.out.println("--------------");
		while (listItr.hasNext()){
			System.out.println(listItr.next());
			
		}
		System.out.println("--------------");
		while (listItr.hasPrevious()){
			System.out.println(listItr.previous());
		}
		
		
		
	}

}
