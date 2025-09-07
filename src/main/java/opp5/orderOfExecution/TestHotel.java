package opp5.orderOfExecution;

import opp2.StarHotel;
import opp5.orderOfExecution.Hotel;

public class TestHotel {

	public static void main(String[] args) {
		
		
		String superStr="Since it is a super class instance, super class implementation is called\n";
		
		System.out.println("\n1.TestHotel: Super Class instantiazation ");
		Hotel h=new Hotel(superStr);

		System.out.println("\n2.TestHotel: calling Hotel.book() ");
		h.book();
		System.out.println("\n3.TestHotel: calling Hotel.book() ");
		h.book();
		System.out.println("\n4.TestHotel: Super Class instantiazation ");
		Hotel h1=new Hotel();
		System.out.println("\n5.TestHotel: calling Hotel.book() ");
		h1.book();
		
		
		
	}

}
