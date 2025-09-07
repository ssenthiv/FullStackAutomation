package streams;

import java.util.Scanner;

public class ScannerExample {

	public static void main(String[] args){
		System.out.println("1. Scanner example");
		
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter a number");
		int read= sc.nextInt();
		System.out.print("\nEnter a String");
		String input= sc.next();
		System.out.println("int : "+ read);
		System.out.println("String : "+ input);
		sc.close();
	}
}
