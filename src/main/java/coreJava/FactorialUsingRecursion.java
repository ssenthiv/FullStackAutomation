package coreJava;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class FactorialUsingRecursion {
	
	static public void main(String[] args) throws IOException{
		
		System.out.println("Enter the value");
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int b=Integer.parseInt(br.readLine());
		FactorialUsingRecursion f = new FactorialUsingRecursion();
		int result=f.fact(b);
		
		System.out.println("Factorial of "+ b +" is "+ result);
	}

	 public int fact(int b){
		if ( b <= 1){
			return b;
		}
		System.out.println("b = "+ b);
		return  b * fact(b-1); 
	}
}
