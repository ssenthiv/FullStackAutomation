package opp2;

import opp5.orderOfExecution.Hotel;

public class StarHotel extends Hotel {
		
		int bookings=20;
		 int rooms=50;
		 
		 String indent="";
		 
		  static String str="Since it is a sub class instance, sub class implementation is called\n";
		
		
		  static {
			  staticIndent=staticIndent+"\t"; 
			   int bookings=2000;
			   System.out.println(staticIndent+"Static block: Sub Class");
			   System.out.println(staticIndent+"-->bookings="+bookings+"\n");
			   
		   }
		   {
				// instance block
				indent=indent+"\t"; 
				   int bookings=200;
				   System.out.println(indent+"Instance block: Sub Class");
				   System.out.println(indent+"-->bookings="+bookings+"\n");
				   
				
			}
	 
		  
		// Constructor1
		public  StarHotel(){
			
			//this("Called using this");
			super(str);
			
			indent=indent+"\t";
			System.out.println(indent+"Sub Class : constructor -  StarHotel");
			System.out.println(indent+"--> bookings="+bookings + ", Rooms="+rooms);
			book();
		}
		// Constructor2
		public  StarHotel(String consStr){
			

			
			indent=indent+"\t";
			System.out.println(indent+"Sub Class : constructor -  StarHotel("+consStr+")");
			System.out.println(indent+"--> bookings="+bookings + ", Rooms="+rooms);
			book();
		}
		
	    public	 void  book() {
		bookings++;
		rooms=rooms-5;
		indent=indent+"\t";
		System.out.println(indent+"Sub Class: Inside StarHotel.book()");
		System.out.println(indent+"--> bookings="+ bookings + ", Rooms="+rooms);
		System.out.println(indent+"Sub Class: Inside StarHotel.book()");
		System.out.println(indent+"--> super.bookings="+ super.bookings +"\n");
		}

		public void book(int size) {
		bookings++;
		rooms=rooms-size;
		//super.book();

		System.out.println("Sub Class: Inside SuperHotel.book("+ size + ")-> bookings="+ bookings+" ,Rooms="+rooms );
		}
		public void book1(){
			System.out.println("Sub Class: Inside SuperHotel.book1()-> bookings="+ bookings);
			
		}
		
		public static void main(String args[]) {
			StarHotel shotel = new StarHotel();
		
		System.out.println("===============================\n");
		if (shotel instanceof StarHotel)  
			System.out.println("shotel is instance of "+ StarHotel.class);
		
		if (shotel instanceof Hotel) 
			System.out.println("shotel is instance of " + Hotel.class);
		
		String str2 = new String(new char[]{'a','b','c'});
		String str3 = new String("abc");
		String str = "StudyTonight";
		str=str.concat(".com");
		str = str.toUpperCase();
		str=str.replace("TONIGHT","today");
		System.out.println(str);
		System.out.println(str2);
		if (str2.equals(str3))
			System.out.println("Values are Equal");
		if (str2==str3)
			System.out.println("References are Equal");
		else
			System.out.println("References are NOT Equal");
		
		System.out.println("===============================\n");
		
		}

}
