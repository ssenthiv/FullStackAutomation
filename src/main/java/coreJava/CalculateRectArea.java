package coreJava;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class CalculateRectArea {

	
	public static void main(String[] arg) throws IOException{
		
	   int length;
	   int width;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("enter the length of the rectangle");
		length=Integer.parseInt(br.readLine());
		
		System.out.println("enter the width of the rectangle");
		width=Integer.parseInt(br.readLine());
	
	double area=length * width;
	System.out.println("Area of rectangle "+ area);
	}
}
