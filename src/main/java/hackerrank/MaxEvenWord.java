package hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.stream.Collectors;

public class MaxEvenWord {

    // Complete the minimumNumber function below.
    static String minimumNumber(String sentence) {
        
    	String[] strArry=null;
    	String result="";
    	strArry=sentence.split("\\s+");
    	
    	List<String> strList= new ArrayList<>();
    	
    	int max=0;
    	
    	for ( String s :strArry ){
    		if ( (s.length() % 2) == 0){
    			if (s.length() > max){
    				
    			if (strList.isEmpty()){
    				strList.add(s);
    			}else
    				strList.set(0, s);
    			
    			max=s.length();
    			}
    		}
    	}
    	
    	
    	
    	if ( !strList.isEmpty())
    		result=strList.get(0);

    	return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
/*
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String password = scanner.nextLine();
*/
        int n=0;
        //String str="hey";
        String str="his is the first line hey";
        String answer = minimumNumber(str);

        
        bufferedWriter.write(String.valueOf(answer));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}