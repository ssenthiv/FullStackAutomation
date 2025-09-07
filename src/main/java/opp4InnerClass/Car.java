package opp4InnerClass;


public class Car extends Vehicle {

	Bike b=new Bike();
	private String privateStr="PVariable car";
	static private String privateStaticStr="privateStaticStr Car";
	
	public void printSound() {
		System.out.println("car");
		
		}
	
	public void printSound(String s1, String s2, String s3){
		
		System.out.println("car" + s1+s2+s3);
		//System.out.println(b.innerVar);
		//b.printSound("From"," Outer");
	
	}
	private void printSoundPrivate(String s){
		
		System.out.println("\tPrivate method car-"+ s);
	
	}
	
	private static void printSoundPrivateStatic(String s){
		
		System.out.println("\tPrivate static method car-"+ s);
	
	}
	public void printSoundPrivate(){
		
		System.out.println("Public car-");
	
	}
	
	
	 class Bike extends Vehicle {
		String innerVar="Bike.innerVar";
		public void printSound() {
		System.out.println("bike-inner");
		
		}
		public void printSound(String s){
		System.out.println( "bike-inner accessing");
		System.out.println( "\t\tPrivate variable = " + privateStr+ "- "+ s);
		System.out.println("\t\tprivate Static variable = "+ privateStaticStr);
		printSoundPrivate(s);
		printSoundPrivateStatic(s);
		
		}
		
		public void printSound(String s1, String s2){
			
			System.out.println("Compilation Error : bike-inner method accessing outer method which is "
					+ "overloaded in inner");
		//printSound(s1,s2, "Bike");
		
		}
		public void innerMethod(){
			System.out.println("Accessing inner method without using inner reference");
		}
	}
	
	
	 
	
	
}
		


