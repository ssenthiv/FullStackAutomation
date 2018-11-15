package opp4;


public class Car extends Vehicle {

	Bike b=new Bike();
	private String privateStr="PVariable car";
	
	public void printSound() {
		System.out.println("car");
		
		}
	
	public void printSound(String s1, String s2, String s3){
		
		System.out.println("car" + s1+s2+s3);
	
	}
	private void printSoundPrivate(String s){
		
		System.out.println("Private car-"+ s);
	
	}
	
	public void printSoundPrivate(){
		
		System.out.println("Private car-");
	
	}
	
	
	class Bike extends Vehicle {
		public void printSound() {
		System.out.println("bike-inner");
		
		}
		public void printSound(String s){
		System.out.println( "bike-inner accessing Private variable  " + privateStr+ "- "+ s);
		printSoundPrivate(s);
		}
	
		public void printSound(String s1, String s2){
			
			//System.out.println("Compilation Error : bike-inner method accessing outer method which is "
			//		+ "overloaded in inner");
		printSound(s1,s2, "Bike");
		}
	}
	
	
	 
	
	
}
		


