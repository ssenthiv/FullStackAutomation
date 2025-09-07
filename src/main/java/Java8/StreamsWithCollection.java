package Java8;

import java.util.Arrays;
import java.util.List;

public class StreamsWithCollection {
public static void main(String[] args){
		
		List<Person> people= Arrays.asList(
							new Person("Charles","Dickens",60),
							new Person("Shivkumar","Vernekar",48),
							new Person("Abhijit","Chitale",50),
							new Person("Shirish","Ghatge",47 ),
							new Person("Ashfaq","Chataiwala",35));
		
		//List<Integer> sum=Arrays.asList( 10,23,17);
		
		//System.out.println("Sum = " +sum.stream().mapToInt(t->t.intValue()).sum());
		
		
		//1. Using streams
		System.out.println("\n1. Using streams");
		people.stream().
		filter(t->t.getLastName().endsWith("e")).
		forEach(p->System.out.println(p.getFirstName()));
		
		
		//2. Count Using streams
		System.out.println("\n2. Count Using streams");
		long count = people.stream().
		filter(t->t.getLastName().startsWith("C")).
		count();
				
		System.out.println("Count ="+count);
		//3. Count Using parallel streams
		System.out.println("\n3. Count Using parallel streams");
		 count = people.parallelStream().
		filter(t->t.getLastName().startsWith("C")).
		count();
						
		System.out.println("Count ="+count);
}


}
