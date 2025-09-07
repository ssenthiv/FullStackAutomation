package opp5.orderOfExecution;

import opp2.StarHotel;
import opp5.orderOfExecution.Hotel;

public class TestDynamicHotel {

	public static void main(String[] args) {
		
		
		String str="-->Since it is a sub class instance, sub class implementation is called\n";
		
		System.out.print("\n1.DynamicHotel: Sub Class instantiazation assigned to Super Class");
		System.out.println("  with explicit call to super constructor  ");
		Hotel hs=new StarHotel();
		System.out.println("\n2.DynamicHotel: calling Dynamic.book() ");
		hs.book();
		
		
		System.out.print("\n3.DynamicHotel: Sub Class instantiazation assigned to Super Class");
		System.out.println("  without explicit call to super constructor  ");
		Hotel hs5=new StarHotel(str);
		System.out.println("\n4.DynamicHotel: calling Dynamic.book() ");
		hs5.book();
		
	
	}

}
