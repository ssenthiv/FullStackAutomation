package Java8;

import java.util.Arrays;
import java.util.List;

public class ForEachIteration {

	public static void main(String[] args){
		
		List<Person> people= Arrays.asList(
							new Person("Charles","Dickens",60),
							new Person("Shivkumar","Vernekar",48),
							new Person("Abhijit","Chitale",50),
							new Person("Shirish","Ghatge",47 ),
							new Person("Ashfaq","Chataiwala",35));
		
		//1. Using for in loop (internal iteration
		System.out.println("1. Using for in loop (internal iteration)");
		for (Person p: people){
			System.out.println(p);
		}
		//2. Using lambda's forEach loop
		System.out.println("\n2. Using lambda's forEach loop");
		people.forEach(p->{
							if (p.getFirstName().startsWith("Sh"))
							System.out.println(p);});
		
		//3. Using lambda's with Method reference 
		System.out.println("\n3. Using lambda's with Method reference");
		people.forEach(System.out::println);	
	}
}
