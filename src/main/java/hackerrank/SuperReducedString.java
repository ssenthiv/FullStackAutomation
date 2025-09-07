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

public class SuperReducedString {

    // Complete the superReducedString function below.
    static String superReducedString(String s) {
    	String result=new String();
    	
    	LinkedList<Character> charList=new LinkedList<>();
    	char[] charArray=s.toCharArray();
    	
    
    	for (char c : charArray){
    		
    	if (charList.isEmpty())
    	charList.add(c);
    	else{
    		if (charList.getLast() == c){
    			
    			charList.removeLast();
    		}else {
    			charList.add(c);
    		}
    		
    	}
    	
    	}
    	
    	System.out.println("1. Using toSting()" );
    	System.out.println(charList.toString().substring(1,3*charList.size() -1).replaceAll(", ", ""));
    	
    	
    	System.out.println("2. Using StringBuilder" );
    	StringBuilder strBuilder=new StringBuilder(charList.size());
    	//System.out.println("capacicy :"+ strBuilder.capacity());
    	
    	for (char c : charList){
    		
    		strBuilder.append(c);
    	}

    	result=strBuilder.toString();
    	if (result.isEmpty())
    	result="Empty Sting";
    	return result;
    	
    	
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        System.out.println("Enter a string(eg. aabcc)");
        String s = bufferedReader.readLine();

        String result = superReducedString(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}