package hackerrank.java;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class SHA256 {

	
	public static void main(String[] args){
		
		Scanner sc =new Scanner(System.in);
		
		
		try {
			MessageDigest md=MessageDigest.getInstance("SHA-256");
			md.reset();
			md.update(sc.nextLine().getBytes());
	        for (byte i : md.digest()) {
	            System.out.print(String.format("%02x", i));
	        }
	        System.out.println();

			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			sc.close();
		}
		
	}
}
