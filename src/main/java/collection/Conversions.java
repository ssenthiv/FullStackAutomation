package collection;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

import com.gargoylesoftware.htmlunit.javascript.host.intl.Collator;

public class Conversions {
	
	public static void main(String[] args){
		
		System.out.println("1. Sorted list to Linked Hash set");
		
		List<Integer> intList = Arrays.asList(50,100,4,-34,100,10);
		System.out.println("Output unsorted: "+ intList);
		Collections.sort(intList);
		System.out.println("Output List: "+ intList);
		
		Set<Integer> intSet =new LinkedHashSet<>(intList);
		//Set<Integer> intSet =new HashSet<>(intList);
		//Set<Integer> intSet =new LinkedHashSet<>();
		
		//intSet=intList.stream().collect(Collectors.toCollection(LinkedHashSet::new));
		System.out.println("Output Set: "+ intSet);
		
		System.out.println("2. int[] to List");
		int[] intArray= {10,100,-34,50,4,100,10};
		//List<Long> longList;
		//long[] intArray= {10,-34,50,4,100,10};
		intList =Arrays.stream(intArray).boxed().collect(Collectors.toList());
		//longList=Arrays.stream(intArray).boxed().collect(Collectors.toList());
		System.out.println("Output List: "+ intList);
		
		
		
	}

}
