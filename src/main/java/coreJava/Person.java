package coreJava;

public class Person {

	private String firstName;
	private String lastName;
	private static int age;
	
	//Constructor
	
	private Person(String fName, String lName, int age){
		
		this.firstName=fName;
		this.lastName=lName;
		this.age=age;
		
	}
	
	public String getFirstName(){
		
		return firstName;
	}
	
	private void setFirstName(String fName){
		
		this.firstName=fName;
	}
	
	private String getLastName(){
		
		return lastName;
	}
	
	private void setLastName(String lName){
		
		this.lastName=lName;
	}
	
	
	
	private static int getAge(){
		
		return age;
	}
	
	private void setAge(int age){
		
		this.age=age;
	}
	
	public String toString(){
		
		return "Person[firstName=" +firstName+"lastName="+ lastName+ "age="+age +"]";
	}
	
}
