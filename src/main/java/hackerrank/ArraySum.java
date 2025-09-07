package hackerrank;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class ArraySum {

    /*
     * Complete the simpleArraySum function below.
     */
    static int simpleArraySum(int[] ar) {
        int arrySum=0;
    	for(int i=0; i<ar.length;i++){
        	arrySum+= ar[i];
        }
    	return arrySum;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        
    	
    	//BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getProperty("user.dir")+"/test-output/hackerrank/hackerrank.out"));
    	BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
    	//System.out.println(System.getenv());
        int arCount = Integer.parseInt(scanner.nextLine().trim());
       
        int[] ar = new int[arCount];

        String[] arItems = scanner.nextLine().split(" ");

        for (int arItr = 0; arItr < arCount; arItr++) {
            int arItem = Integer.parseInt(arItems[arItr].trim());
            ar[arItr] = arItem;
        }

        int result = simpleArraySum(ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}