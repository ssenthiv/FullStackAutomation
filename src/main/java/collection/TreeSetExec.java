package collection;

import java.util.Iterator;
import java.util.TreeSet;

import org.apache.poi.hssf.record.chart.CategorySeriesAxisRecord;

public class TreeSetExec {

	public static void main(String[] args) {
		
		
		TreeSet<Car> carsTree=new TreeSet<>();
		
		
		for (int i=0; i< 11; i++){
			Car c=new Car("TN-"+i);
			c.setPrice((int)(Math.random()*100+1));
			//System.out.println(c.getPrice());
			
			carsTree.add(c);
			
		}
		System.out.println("Size ="+carsTree.size());
		System.out.println("1. Print TreeSet");
		
		Iterator<Car> carsItr=carsTree.iterator();
		
		while (carsItr.hasNext()){
			Car c=carsItr.next();
			System.out.println(c.getRegistrationNumber() + " Price ="+c.getPrice());
			
		}
		
		Car c1=new Car("TN-50");
		c1.setPrice(90);
		carsTree.add(c1);
		//c1.setPrice(1);				// we can break uniqueness of TreeSet
		
		//System.out.println(carsTree.add(c1));
		
		System.out.println("Size ="+carsTree.size());
		System.out.println("\n2. Print TreeSet after adding new node");
		
		 carsItr=carsTree.iterator();
		
		while (carsItr.hasNext()){
		 Car	 c=carsItr.next();
			System.out.println(c.getRegistrationNumber() + " Price ="+c.getPrice());
			
		}
		
		System.out.println("\nFirst element ="+carsTree.first());
		System.out.println("Last element ="+carsTree.last()+"\n");
		
		System.out.println("Head set ="+carsTree.headSet(c1));
		
		
		System.out.println("\n3. Print TreeSet with Head set");
		
		 carsItr=carsTree.headSet(c1).iterator();
		
		while (carsItr.hasNext()){
		 Car	 c=carsItr.next();
			System.out.println(c.getRegistrationNumber() + " Price ="+c.getPrice());
			
		}
		
		System.out.println("\n4. Print TreeSet with tail set");
		
		 carsItr=carsTree.tailSet(c1).iterator();
		
		while (carsItr.hasNext()){
		 Car	 c=carsItr.next();
			System.out.println(c.getRegistrationNumber() + " Price ="+c.getPrice());
			
		}
		
		System.out.println("\n5. equals/hashCode method is not used in TreeSet");
		int count=0;
		for (int i=0;i<10;i++){
		Car c=new Car("TN-"+i);
		c.setPrice(i);
		//System.out.println(carsTree.contains(c));
		if (carsTree.contains(c))
			count++;
		
		
		}
		System.out.println(count);
		
		System.out.println("\n6. NavigableSet  used in TreeSet");
		System.out.println(" ceiling " +carsTree.ceiling(c1));
		System.out.println(" floor " +carsTree.floor(c1));
		System.out.println(" higher " +carsTree.higher(c1));
		System.out.println(" lower " +carsTree.lower(c1));
		
		System.out.println("\n6. equals/hashCode method is not used in TreeSet (need to check)");
		
		TreeSet<Car> carsTree2=new TreeSet<>(new CustomComparator());
		carsTree2.addAll(carsTree);
		Car c3=new Car("TN-27");
		c3.setPrice(66);
		carsTree2.add(c3);
		c3.setPrice(67);
		carsTree2.add(c3);
		 carsItr=carsTree2.iterator();
			
			while (carsItr.hasNext()){
			 Car	 c=carsItr.next();
				System.out.println(c.getRegistrationNumber() + " Price ="+c.getPrice());
				
			}
		
		System.out.println("\n7. get comparator used in TreeSet");
		System.out.println(carsTree2.comparator());
	}
}
