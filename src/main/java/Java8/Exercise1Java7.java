package Java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Exercise1Java7 {
	
	public static void main(String[] args){
		
		List<Person> people =Arrays.asList(
							new Person("Charles","Dickens",60),
							new Person("Shivkumar","Vernekar",48),
							new Person("Abhijit","Chitale",50),
							new Person("Shirish","Ghatge",47 ),
							new Person("Ashfaq","Chataiwala",35)
							);
		
		// 1. Sort list by lastName
		
		people.sort(new Comparator<Person>() {
			
			public int compare(Person o1, Person o2){
				return o1.getLastName().compareToIgnoreCase(o2.getLastName());
			}
			
		});
		
		
		
		
		// 2. Print all elements in the list
		System.out.println("2. Print all elements in the list");
		printAll(people);
		
		// 3. Print all name which starts lastName as 'C'
		
		System.out.println("3. Print all name which starts lastName as 'C'");
		printLastNameBeginningWith(people,"C");
		
		// 4. Print all with condition LastName starts with 'V'
		System.out.println("4. Print all with condition LastName starts with 'V'");
		printConditionally(people,new Condition(){

			@Override
			public boolean test(Person p) {
				
				return p.getLastName().startsWith("V");
			}
		
		
		});
		
		
		// 5. Print all with condition firstName starts with 'S'
		
				System.out.println("5. Print all with condition firstName starts with 'S'");
				printConditionally(people,new Condition(){

					@Override
					public boolean test(Person p) {
						
						return p.getFirstName().startsWith("S");
					}
				
				
				});
	}

	
	private static void printLastNameBeginningWith(List<Person> pList, String str) {
		for (Person p : pList)
			if (p.getLastName().startsWith(str))
			System.out.println(p);
		
	}


	public static void printAll(List<Person> pList){
		for (Person p : pList)
		System.out.println(p);
	}
	
	private static void printConditionally(List<Person> pList, Condition c) {
		for (Person p : pList)
			if (c.test(p))
			System.out.println(p);
		
	}
	// same interface is created in Exercise1Java8
	/*
	public interface Condition{
		
		public boolean test(Person p);
	}
	*/
}
