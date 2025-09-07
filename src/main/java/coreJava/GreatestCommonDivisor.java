package coreJava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GreatestCommonDivisor {

	int GCD(int m, int n){
		
		
	int	r= m % n;
		
	if (r==0){
		return n;
	}else
	{
		return GCD(n,r);
	}
		
	}
	
	public static void main(String args[]){
		
		
		GreatestCommonDivisor g=new GreatestCommonDivisor();
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		try {
	       int m =Integer.parseInt(br.readLine());
	       int n =Integer.parseInt(br.readLine());
	       
	       System.out.println("Values =" + m + " ," + n);
	       System.out.println("GCD =" + g.GCD(m,n));
		}catch (IOException io)
		{
			io.printStackTrace();
		}
	}
}
