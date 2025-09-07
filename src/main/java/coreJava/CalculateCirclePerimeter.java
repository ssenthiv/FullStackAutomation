package coreJava;


import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class CalculateCirclePerimeter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int radius=0;
		System.out.println("enter the radius");
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		try
		{
		radius=Integer.parseInt(br.readLine());
		}
		catch (NumberFormatException ne){
		System.out.println("Invalid radius vale"+ ne);	
		System.exit(0);
		}
		catch (IOException ioe)
		{
			System.out.println("Input read error"+ ioe);
			System.exit(0);
		}
		
		double perimeter=2 * Math.PI * radius ;
		System.out.println("Perimeter is "+ perimeter);
	}

}

