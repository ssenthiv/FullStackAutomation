package stringhandling;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class DuplicateChars {

	public static void main(String[] args){
		
		String str="abcdefghijABCDEFGHIJ klmnopq rstabcdef";
		DuplicateChars d=new DuplicateChars();
		d.removeDuplicate(str);
		d.printDuplicate(str);
		d.duplicateCount(str);
	}
	public void removeDuplicate(String str){
		
		Set<Character> charSet= str.chars().mapToObj(i->Character.toLowerCase(((char)i))).collect(Collectors.toSet());  // toconsider all lowercase
		//Set<Character> charSet= str.chars().mapToObj(i->((char)i)).collect(Collectors.toSet());
		List<Character> charList=str.chars().mapToObj(i->Character.toLowerCase((char)i)).collect(Collectors.toList());
		//List<Character> charList=str.chars().mapToObj(i->(char)i).collect(Collectors.toList());

		
		System.out.println("Original List	: "+charList);
		System.out.println("Unique Set	: " +charSet);
		
	}
	
	public void printDuplicate(String str){
		
		Set<Character> charSet= str.chars().mapToObj(i->Character.toLowerCase(((char)i))).collect(Collectors.toSet());  // toconsider all lowercase
		//Set<Character> charSet= str.chars().mapToObj(i->(char)i).collect(Collectors.toSet());
		List<Character> charList=str.chars().mapToObj(i->Character.toLowerCase((char)i)).collect(Collectors.toList());
		//List<Character> charList=str.chars().mapToObj(i->(char)i).collect(Collectors.toList());


		System.out.println("Original list 	: " +charList);
		charList.removeIf(i->charSet.remove(i));
		System.out.println("Duplicate char	: " +charList);
		Set<Character> uniqDupSet=new HashSet<Character>(charList);
		System.out.println("Unique Dup char	: " +uniqDupSet);
	}
	
	public void duplicateCount(String str){
		
		Map<Character,Integer> charCountMap=new HashMap<>();
		char[] charArray=str.toCharArray();
		
		for (char c: charArray){
			if (!charCountMap.containsKey(c)){
				charCountMap.put(c, 1);
			}else{
				charCountMap.put(c, charCountMap.get(c)+1);
			}
		}
		System.out.print("Char count 	: ");
		for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()){
		System.out.print(entry.getKey()+ " : "+entry.getValue()+", ");
		}
	}
}
