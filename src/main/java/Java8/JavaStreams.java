package Java8;

import java.nio.file.Paths;
import java.security.KeyStore.Entry.Attribute;
import java.util.Arrays;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.io.IOException;
//import com.google.common.io.Files;
import java.nio.file.*;

public class JavaStreams {
	
	public static void main(String[] args) throws IOException{
		
		System.out.println("1. Integer Stream");
		IntStream.range(1,11).filter((i)->{
			                             if ( i % 2 ==0)
			                            	 return true;
			                             else
			                            	 return false;
			                             }).
			                            	  forEach(System.out::print);
		
		
		System.out.println("\n2. with skip");
		IntStream.range(10, 15).skip(2).forEach((i)->System.out.println(i));
		

		System.out.println("\n3. with sum");
		System.out.println("Sum: " +IntStream.range(10, 15).sum());
		

		
		System.out.println("\n4. Stream.of sorted");
		Stream.of("Shun","Abraham","Murugan").sorted().findFirst().ifPresent(System.out::print);
		//Stream.of("Shun","Abraham","Murugan").sorted().anyMatch(x->x.startsWith("S"));
		
		
		
		System.out.println("\n5. Array Stream filter ");
		String[] strArray ={"Shun","Abraham","Murugan", "Shiva"};
		Arrays.stream(strArray).filter(i-> i.startsWith("S")).sorted().forEach(System.out::println);
		
		
		System.out.println("\n6. Avg of int array ");
		Arrays.stream(new int[]{1,2,3,4,5}).map(x-> x*x).average().ifPresent(System.out::println);;
		

		System.out.println("\n7. stream from List  ");
		List<String> strList=Arrays.asList("Shun","murugan","Ambrose","Kumar", "Shiva");
		strList.stream().map(String::toUpperCase).filter(x-> x.startsWith("S")).forEach(System.out::println);


		
		System.out.println("\n8. stream rows from text file  ");
		Stream<String> strStream = Files.lines(
				Paths.get(System.getProperty("user.dir") + "\\src\\main\\resources\\inputData\\FileHandlingInput.txt"));
		strStream.filter(x -> x.length() > 5).forEach(System.out::println);
		strStream.close();
		

		
		System.out.println("\n9. text file lines to List<String> ");
		List<String> str3List= Files.
				lines(Paths.get(System.getProperty("user.dir")+ "\\src\\main\\resources\\inputData\\FileHandlingInput.txt")).
				filter(x-> x.contains("line")).
				collect(Collectors.toList());
		
		str3List.forEach(System.out::println);
		

		
		System.out.println("\n10.  CSV text file lines to String[] ");
		Stream<String> strStream2= Files.
				lines(Paths.get(System.getProperty("user.dir")+ "\\src\\main\\resources\\inputData\\csvfile.csv"));
	
		int rowCount = (int) strStream2.map(x -> x.split(",")).
															filter(x -> x.length >= 0).count();
		strStream2.close();
		System.out.println("Row Count : " + rowCount);
	

		
		System.out.println("\n11.  parsing CSV  file  ");
		Stream<String> strStream3 = Files
				.lines(Paths.get(System.getProperty("user.dir") + "\\src\\main\\resources\\inputData\\csvfile.csv"));
		strStream3.map(x -> x.split(",")).
				filter(x -> x.length == 3).
				filter(x -> Integer.parseInt(x[1]) > 0).
				forEach(x -> System.out.println(x[0] + " " + x[1] + " " + x[2]));
		strStream3.close();
		
		
		System.out.println("\n11a.  File list  ");
		Files.list(Paths.get(System.getProperty("user.dir") + "\\src\\main\\resources"))
				.forEach(x -> System.out.println(x));

		System.out.println("\n11b.  Depth first directory  walk  ");
		Files.walk(Paths.get(System.getProperty("user.dir") + "\\src\\main\\resources"))
				.forEach(x -> System.out.println(x));
		 
		System.out.println("\n12.  parsing CSV  file to Map ");
		Stream<String> strStream4 = Files
				.lines(Paths.get(System.getProperty("user.dir") + "\\src\\main\\resources\\inputData\\csvfile.csv"));
		Map<String,Integer> map=new HashMap<>();
		
			map=strStream4.map(x -> x.split(",")).
				filter(x -> x.length == 3).
				filter(x -> Integer.parseInt(x[1]) > 0).
				collect(Collectors.toMap(x->x[0],x->Integer.parseInt(x[1])));
		strStream4.close();
		
		for(Map.Entry<String, Integer> entry: map.entrySet()){
			System.out.println(entry.getKey()+ "=" + entry.getValue());
		}
		

		
		
		
		System.out.println("\n13.  reduce - sum ");	
		double sum=Stream.of(1.5,2.5,2.0).
											reduce(0.0,(Double a,Double b)-> a+b);
		System.out.println("Sum ="+ sum);
	
	

		
		System.out.println("\n14.  Reduction - summary statistics ");
	
		IntSummaryStatistics summary= IntStream.of(1,2,3,4,5,6).summaryStatistics();
		System.out.println(summary);

		System.out.println("\n15.  Stream from generate() ");
		Stream.generate(()->(int)(Math.random()*100)).limit(3).forEach(System.out::println);
		
		
		System.out.println("\n16.  Stream from iterate() ");
		Stream.iterate(100, i-> i+10).limit(3).forEach(System.out::println);
		
		
		
		System.out.println("\n17.  Stream builder() ");
		Stream.builder().add("shun").add("Murugan").add("Shiva").build().forEach(System.out::println);
	
	
		System.out.println("\n18.  print source code  ");
		String classFile =JavaStreams.class.getName().replace(".","/")+".java";
		Path workingDir=Paths.get(System.getProperty("user.dir"));
		int maxDepth=10;
		Files.find(workingDir,maxDepth,(filename,attribute)->filename.endsWith(classFile))
				.forEach(
						path->{
								try {
									Files.lines(path).forEach(System.out::println);
								} catch (Exception e) {
									
									e.printStackTrace();
								}
					
							}
				           );
				
	
	}
}


