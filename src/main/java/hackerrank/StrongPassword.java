package hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.stream.Collectors;

public class StrongPassword {

    // Complete the minimumNumber function below.
    static int minimumNumber(int n, String password) {
        int requiredLen=0;
        
        int mandatoryCount=0;
    	int length=password.length();
    	// 1. Length
    	if (length < 6)
    		mandatoryCount= 6-length;
    	
    	
    	//System.out.println("Man : " +mandatoryCount);	
    	//System.out.println("Req : " +requiredLen);
    	//2. one digit
    	List<Character> charList=password.chars().mapToObj(t-> (char)t).collect(Collectors.toList());
    	int digitCount= (int) charList.stream().filter(p->Character.isDigit(p)).count();
    	//System.out.println("digit : " +digitCount);
    	
    	if ( digitCount == 0)
    		requiredLen++;
    	
    	//System.out.println("Req : " +requiredLen);
    	// 3. Lowercase
    	int lowerCaseCount= (int) charList.stream().filter(p->Character.isLowerCase(p)).count();
    	//System.out.println("lower : " +lowerCaseCount);
    	
    	if ( lowerCaseCount == 0)
    		requiredLen++;
    	
    	//System.out.println("Req : " +requiredLen);
    	// 4. UpperCase
    	
    	int upperCaseCount= (int) charList.stream().filter(p->Character.isUpperCase(p)).count();
    	//System.out.println("upper : " +upperCaseCount);
    	
    	if ( upperCaseCount == 0) 
    		requiredLen++;
    	
    	//System.out.println("Req : " +requiredLen);
    	
    	// 5. Special char
    	//System.out.println("pattern = " +password.matches("(.*)[!|@|#|$|%|^|&|*|(|)|-|+](.*)"));
    	
    	
    	
    	
    	if (!password.matches("(.*)[!|@|#|$|%|^|&|*|(|)|-|+](.*)")){
    		
    		int splCharCount= (int) charList.stream().filter(p->{

    													if ( String.valueOf(p).matches("[-]")){
    													return true;	
    													}
    		
    													return false;
    													}).count();
    		//System.out.println("- count ="+splCharCount );
    		if ( splCharCount == 0){
    		requiredLen++;
    		//System.out.println("pattern Not matching");
    		}
    	}
    	
    	if (mandatoryCount >= requiredLen){
    		requiredLen=mandatoryCount;
    	}
    		
    	return requiredLen;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String password = scanner.nextLine();

        int answer = minimumNumber(n, password);

        bufferedWriter.write(String.valueOf(answer));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}