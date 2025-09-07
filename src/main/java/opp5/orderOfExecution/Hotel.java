package opp5.orderOfExecution;

import opp2.StarHotel;

public class Hotel {
	   public static int bookings=10;
	   public String indent="";
	   static public String staticIndent="";
	   static {
		   staticIndent=staticIndent+"\t";
		   int bookings=1000;
		   System.out.println(staticIndent+"Static block: Super Class");
		   System.out.println(staticIndent+"-->bookings="+bookings+"\n");
		   
	   }
	   
	   {
			// instance block
			indent=indent+"\t"; 
			   int bookings=100;
			   System.out.println(indent+"Instance block: Super Class");
			   System.out.println(indent+"-->bookings="+bookings+"\n");
			   
			
		}
	   
	   	  // constructor 1
	      public Hotel(String str){
		   
	    	  bookings++;  
	    	//bookings=20;
	    	indent=indent+"\t";
		   System.out.println(indent+"Super Class : constructor -  Hotel(String) ");
		   System.out.println(indent+"-->bookings="+bookings);
		   
		   
		   String localStr="Below method called from Super Class : constructor -  Hotel.book().";
					
		   System.out.println("\n"+indent+localStr);
		   System.out.println(indent+str);
		   //indent=indent+"\t";
		   book();
		   
	   }
	     
	  // constructor 2
	      public Hotel(){
	    	  bookings++;  
	    	  indent=indent+"\t";
	    	//bookings=30;
			System.out.println(indent+"Super Class : constructor -  Hotel()");
			System.out.println(indent+"--> bookings="+bookings);
	   }
	   // Constructor end
	    
	      public  void book() {
			bookings++;
			indent=indent+"\t";
			System.out.println(indent+"Super Class : Inside Hotel.book() ");
			System.out.println(indent+"--> bookings="+ bookings);
			}
	     private void book2(){
	    	// book();
	     }
	     
	public static void main(String arg[]){
		

		
		
		
		System.out.println("1.Hotel: main() : Initial value : bookings="+bookings );
		System.out.println("\n2.Hotel: this Class instantiazation ");
		Hotel h=new Hotel();
		System.out.println("\n3.Hotel: calling Hotel.book() ");
		h.book();
	
	}
}
