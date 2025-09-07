package hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.stream.Collectors;

public class CamelCase {

    // Complete the camelcase function below.
    static int camelcase(String s) {
    	
    	List<Character> charList=s.chars().mapToObj(t-> (char)t).collect(Collectors.toList());
    	int count=(int) charList.stream().filter(t-> Character.isUpperCase(t)).count();
    	count=count+1;
    	
    	
    	return count;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = scanner.nextLine();

        int result = camelcase(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}