package opp5.orderOfExecution;


	public class StarHotel5 extends Hotel {
			//int bookings=50;
		
		
		// constructor
		
		StarHotel5(){
			indent=indent+"\t";
			//bookings=100;
			System.out.println(indent+"Sub Class : constructor -  StarHotel5 = "+bookings);
			
			
			super.book();
		}
		
		
		//constructor end
		public    void  book() {
		
		indent=indent+"\t";
		bookings--;
		System.out.println(indent+"Inside StarHotel5 book()="+ bookings);
		}

		public void book(int size) {
		book();
		indent=indent+"\t";
		//super.book();
		bookings += size;
		System.out.println(indent+"Inside StarHotel5 book(int)="+ bookings);
		}
		public void book1(){
			indent=indent+"\t";
			System.out.println(indent+"Inside StarHotel5 book1()="+ bookings);
			
		}
 
		public static void main(String args[]) {
		
		System.out.println("1. StarHotel5: main() : Initial value : bookings="+bookings );
		System.out.println("2. StarHotel5: Sub Class instantiazation : StarHotel5() " );	
		StarHotel5 shotel = new StarHotel5();
		System.out.println("\n3.StarHotel5: calling StarHotel5.book() ");
		shotel.book(3);
		
		 System.out.println("main() : Final value : bookings="+bookings );
		}

}
