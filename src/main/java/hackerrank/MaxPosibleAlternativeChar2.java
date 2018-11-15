package hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class MaxPosibleAlternativeChar2 {

    // Complete the alternate function below.
    static int alternate(String s) {
    	int maxAlt=0;
    	List<Character> charList=s.chars().mapToObj(f->((char)f)).collect(Collectors.toList());
    	Set<Character> uniqSet= new HashSet<>(charList);
    	List<Character> uniqL= new ArrayList<>(uniqSet);
    	
    	// original list
    	System.out.print("Original List : ");
    	for (Character c : charList)
    		System.out.print(c);
    	
    	
    	// unique list
    	System.out.print("\nUnique  List  : ");
    	for (Character c : uniqL)
    		System.out.print(c);

    	// Finding all combinations
    	
    	List<List<Character>> allCombL =new ArrayList<>();
    	
    	for (int i=0; i<uniqL.size();i++)
    	{
    		for ( int j=i+1; j<uniqSet.size();j++){
    			List<Character> tmpList=new ArrayList<>();
    			tmpList.add(uniqL.get(i));
    			tmpList.add(uniqL.get(j));
    			allCombL.add(tmpList);
    			
    		}
    		
    	}
    	System.out.print("\nChar 2 X 2    : ");
    	for (List<Character>  list : allCombL){
    		System.out.print( list.toString());
    	}
    	
    	// remove other elements than the selected pair.
    	
    	//Set<Character> tempUniqCharSet = new HashSet<>(uniqSet);
    	for ( List<Character> list : allCombL){
    		
    		Set<Character> tempPairRemovedSet = removePair(uniqSet, list);
    		System.out.println("\n Pair :"+ list.toString());
        	System.out.print("\t Pair removed uniq set : ");
        	for (Character c: tempPairRemovedSet){
        		System.out.print(c);
        	}
    		
        	List<Character> altList = new ArrayList<>(charList);
        	altList.removeAll(tempPairRemovedSet);
        	
        	System.out.print("\n\t alt list : ");
        	for ( Character  c : altList )
        		System.out.print(c);
        	boolean isAlt = isAlternate(altList);
        	if ((isAlt) && (altList.size()> maxAlt)){
        	System.out.println("\n\t isAlt : " +isAlt);
        	System.out.print("\t\t Alt list : " );

        	for ( Character c : altList)
        	System.out.print(c);

        	maxAlt=altList.size();
        	}
        	
    	}
    	System.out.println();
    	
    	
    	
    	return maxAlt;
    }
    public static boolean isAlternate(List<Character> localAltCharList){
    	
    	boolean result=true;
    	
    
    	for ( int i=1; i< localAltCharList.size();i++){
    		
    		if (localAltCharList.get(i)==  localAltCharList.get(i-1))
    			result=false;
    			
    			
    	}
    	
    	return result;
    }
    public static Set<Character> removePair(Set<Character> uniqCharSet,List<Character> pairList ){
    	
    	Set<Character> tempPairRemovedSet= new HashSet<>(uniqCharSet);
    	
    	
    	
    	tempPairRemovedSet.removeAll(pairList);
    	
    	return tempPairRemovedSet;
    }
    
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        //int l = Integer.parseInt(bufferedReader.readLine().trim());

        //String s = bufferedReader.readLine();
        
        String s ="assbiocjljd";
        //String s ="abccddabcdeaa";
        //String s="beabeefeab";
        int result = alternate(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
