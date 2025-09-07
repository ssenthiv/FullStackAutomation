package stringhandling;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSplit {

	
	public void splitStr(String str){
		
		String[] strArray=null;
		
		strArray= str.split("\\s+");		// regexp for one or more space
		
		for (String s : strArray){
		System.out.println( s);	
		}
		
	}
	
	public static void main(String args[]){
		
		System.out.println("Enter the line");
		String str="Split  the given  line";
		Scanner sc=new Scanner(System.in);
		str=sc.nextLine();
		sc.close();
		StringSplit sr=new StringSplit();
		System.out.println("1.line splitting using str.split() ");
		sr.splitStr(str);
		
		
	}
}
