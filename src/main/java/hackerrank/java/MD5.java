package hackerrank.java;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class MD5 {

	
	public static void main(String[] args){
		
		Scanner sc =new Scanner(System.in);
		String str=sc.next();
		sc.close();
		System.out.println("Str :"+str);
		
		try {
			MessageDigest md=MessageDigest.getInstance("MD5");
			md.update(str.getBytes(), 0, str.length());
			System.out.println((new BigInteger(1,md.digest())).toString(16));
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
