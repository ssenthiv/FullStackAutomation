package hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ClimbingLeaderBoard {

    // Complete the climbingLeaderboard function below.
    static int[] climbingLeaderboard(int[] scores, int[] alice) {

    	Set<Integer> scoresSet=Arrays.stream(scores).boxed().collect(Collectors.toSet());
    	List<Integer> scoresList= new ArrayList<>(scoresSet);
    	//Vector<Integer> scoresList= new Vector<>(scoresSet);
    	//TreeSet<Integer> scoresTree= new TreeSet<>(scoresSet);
    	//TreeSet<Integer> scoresList= new TreeSet<>(scoresSet);
    	//scoresList= (TreeSet<Integer>) scoresList.descendingSet();
    	
    	int[] result=new int[alice.length];

    		for (int i=0; i<alice.length;i++){
    			int current=alice[i];
    			scoresList.add(current);
    		
    		scoresList.sort((x,y)-> {if (x > y) {
    									return -1;
    									}else if (x < y){
    									return 1;
    									}else
    										return 0;
    			                        
    		});
    		
    		
    			
    		
    		result[i]=scoresList.indexOf(current) + 1;
    		//result[i]=scoresList.headSet(current).size()+1;
    		}
    		
    		
    		
    		return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

       /*
        int scoresCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] scores = new int[scoresCount];
        
        String[] scoresItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < scoresCount; i++) {
            int scoresItem = Integer.parseInt(scoresItems[i]);
            scores[i] = scoresItem;
        }

        int aliceCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] alice = new int[aliceCount];

        String[] aliceItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < aliceCount; i++) {
            int aliceItem = Integer.parseInt(aliceItems[i]);
            alice[i] = aliceItem;
        }

        int[] alice = new int[5];
 */
        int[] scores={100,100,50,40,40,20,10};
        //int[] scores={100,90,80,75,60};
        int[] alice={5,25,50,120};
        //int[] alice={50,65,77,90,102};
        int[] result = climbingLeaderboard(scores, alice);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}