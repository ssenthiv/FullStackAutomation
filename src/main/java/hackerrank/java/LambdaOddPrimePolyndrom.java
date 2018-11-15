package hackerrank.java;

import java.io.*;
import java.util.*;
interface PerformOperation {
 boolean check(int a);
}
class MyMath {
	 public  boolean checker(PerformOperation p, int num) {
	  return p.check(num);
	 }
	 
	 public PerformOperation isOdd(){
		 return t-> {
			 			if (t%2 == 1)
			 				return true;
			 			else
			 				return false;
		 				};
	}
	 
	 public PerformOperation isPrime(){
		 return t-> {
			 			for (int i=2;i<t;i++){
			 				
			 			
			 				if ( t%i == 0)
			 					return false;
			 			}
			 			return true;
		 				};
	}
	 
	 
	 
	 public PerformOperation isPalindrome(){
		 return t-> {
			 		int i=t;
			 		int r;
			 		LinkedList<Integer> listDigit=new LinkedList<>();
			 		while (i>0){
			 			r=i % 10;
			 			listDigit.addLast(r);
			 			i=i / 10;
			 		}
			 		//Iterator<Integer> linkedItr=listDigit.iterator();
			 		while (listDigit.size()>1) {
					
					if (listDigit.pollFirst() != listDigit.pollLast()){            // peek(), poll() from Queue interface
					
					return false;
					}
					
			 		}
			 		return true;
		 				};
	}
}
   // Write your code here

public class LambdaOddPrimePolyndrom {

 public static void main(String[] args) throws IOException {
  MyMath ob = new MyMath();
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  int T = Integer.parseInt(br.readLine());
  PerformOperation op;
  boolean ret = false;
  String ans = null;
  while (T--> 0) {
   String s = br.readLine().trim();
   StringTokenizer st = new StringTokenizer(s);
   int ch = Integer.parseInt(st.nextToken());
   int num = Integer.parseInt(st.nextToken());
   if (ch == 1) {
    op = ob.isOdd();
    ret = ob.checker(op, num);
    ans = (ret) ? "ODD" : "EVEN";
   } else if (ch == 2) {
    op = ob.isPrime();
    ret = ob.checker(op, num);
    ans = (ret) ? "PRIME" : "COMPOSITE";
   } else if (ch == 3) {
    op = ob.isPalindrome();
    ret = ob.checker(op, num);
    ans = (ret) ? "PALINDROME" : "NOT PALINDROME";

   }
   System.out.println(ans);
  }
 }

 
}
 

