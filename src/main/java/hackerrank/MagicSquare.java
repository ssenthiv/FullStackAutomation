package hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MagicSquare {

    // Complete the formingMagicSquare function below.
    static int formingMagicSquare(int[][] s) {
    	
    	int sum1, sum2;
    	int cost=0;
 
    	int[] rowPositive=new int[3];
    	int[] rowNegative=new int[3];
    	int[] colPositive=new int[3];
    	int[] colNegative=new int[3];
    	

    	for (int i=0; i<3; i++){
    		sum1=0;
    		sum2=0;

    		for (int j =0; j<3; j++){
    			
    			sum1+=s[i][j];
    			sum2+=s[j][i];
    			
    		}
    		if ((15 -sum1) > 0)
    		rowPositive[i]= 15-sum1;
    		else if ((15 -sum1) < 0)
    		rowNegative[i]= sum1-15;
    		
    		if ((15 -sum2) > 0)
        		colPositive[i]= 15-sum2;
        		else if ((15 -sum2) < 0)
        		colNegative[i]= sum2-15;
    		
    		System.out.print(" rowP["+i+"] ="+ rowPositive[i]);
    		System.out.print(" rowN["+i+"] ="+ rowNegative[i]);
    		System.out.print(" colP["+i+"] ="+ colPositive[i]);
    		System.out.print(" colN["+i+"] ="+ colNegative[i]);
    		System.out.println();
    	}
    	int sumRowPositive=0;
    	int sumRowNegative=0;
    	int sumColPositive=0;
    	int sumColNegative=0;
    	int div=0;
    	int rem=0;
    	for (int i=0;i<3;i++){
    		sumRowPositive+=rowPositive[i];
    		sumRowNegative+=rowNegative[i];
    		sumColPositive+=colPositive[i];
    		sumColNegative+=colNegative[i];
    		
    		
    	}
    	
    	System.out.println("sumRow Positive = " + sumRowPositive);
    	System.out.println("sumRow negative = " + sumRowNegative);
    	System.out.println("sumCol Positive = " + sumColPositive);
    	System.out.println("sumCol negative = " + sumColNegative);
    	
    	div=(sumRowPositive+sumColPositive)/2;
    	rem=(sumRowPositive+sumColPositive) % 2;
    	
    	System.out.println("Div : "+div);
    	System.out.println("rem : "+rem);
    	
    	div=div + (sumRowNegative + sumColNegative)/2;
    	rem=rem + (sumRowNegative + sumColNegative) % 2;
    	
    	System.out.println("Div : "+div);
    	System.out.println("rem : "+rem);
    	
    	cost= div +rem;
    	
    	return cost;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int[][] s = new int[3][3];
        
         //int[][]s1={{4,9,2},{3,5,7},{8,1,5}};
         
         //int[][]s1={{4,8,2},{4,5,7},{6,1,6}};
         
         //int[][]s1={{5,3,4},{1,5,8},{6,4,2}};
         
         int[][]s1={{4,5,8},{2,4,1},{1,9,7}};
         
        /* 
        for (int i = 0; i < 3; i++) {
            String[] sRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int sItem = Integer.parseInt(sRowItems[j]);
                s[i][j] = sItem;
            }
        }
        */
        
        int result = formingMagicSquare(s1);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}