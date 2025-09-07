package Java8;

import java.util.ArrayList;
import java.util.Arrays;
//import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
//import Java8.Exercise1Java7.Condition;

public class Exercise1Java8 {
	
	public static void main(String[] args){
		
		List<Person> people =Arrays.asList(
							new Person("Charles","Dickens",60),
							new Person("Shivkumar","Vernekar",48),
							new Person("Abhijit","Chitale",50),
							new Person("Shirish","Ghatge",47 ),
							new Person("Ashfaq","Chataiwala",35)
							);
		
		
			
		
		// 1. Sort list by lastName
		
		people.sort((o1,o2)-> o1.getLastName().compareToIgnoreCase(o2.getLastName()));
		
		
		// 2. Print all elements in the list
		System.out.println("\n2. Print all elements in the list");
		printConditionally(people,(p)-> true);
		
		// 3. Print all name which starts lastName as 'C'
		
		System.out.println("\n3. Print all name which starts lastName as 'C'");
		printLastNameBeginningWith(people,"C");
		
		// 4. Print all with condition LastName starts with 'V'
		System.out.println("\n4. Print all with condition LastName starts with 'V'");
		printConditionally(people,p->p.getLastName().startsWith("V"));
		
		
		// 5. Print all with condition firstName starts with 'S'
		
		System.out.println("\n5. Print all with condition firstName starts with 'S'");
		printConditionally(people,(p)-> p.getFirstName().startsWith("S"));
				
				
		// 6. Perform using Consumer functional interface   with condition firstName starts with 'A'
				
		System.out.println("\n6. Perform using Consumer functional interface   with condition firstName starts with 'A'");
		performConditionally(people,(p)-> p.getFirstName().startsWith("A"),p->System.out.println(p.getFirstName()));		
		
		
		// 7. Perform using Method Reference
		
		System.out.println("\n7. Perform using instance  Method Reference");
		
		Exercise1Java8 e=new Exercise1Java8();
		performConditionally(people,(p)-> p.getFirstName().startsWith("A"),e::print);		

	}

	
	private static void printLastNameBeginningWith(List<Person> pList, String str) {
		for (Person p : pList)
			if (p.getLastName().startsWith(str))
			System.out.println(p);
		
	}


	//Functional Interface Predicate is used
	
	private static void printConditionally(List<Person> pList, Predicate<Person> pr) {
		for (Person p : pList)
			if (pr.test(p))
			System.out.println(p);
		
	}
	
	// Functional Interface Consumer is used
	private static void performConditionally(List<Person> pList, Predicate<Person> pr, Consumer<Person> consumer) {
		for (Person p : pList)
			if (pr.test(p))
			consumer.accept(p);
		
	}
	
	public   void print(Person p){
		System.out.println("custom: "+p);
	}
	// Removed as Functional interface Predicate is used
	/*
	 public interface Condition{
		
		public boolean test(Person p);
	}
	*/
}
//interface created outside the class- used in Exercise1Java7
	
	  interface Condition{
		
		public boolean test(Person p);
	}
	
