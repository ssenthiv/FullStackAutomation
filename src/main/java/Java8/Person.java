package Java8;

public class Person {

	private String firstName;
	private String lastName;
	private int age;
	
	//Constructor
	
	public Person(String fName, String lName, int age){
		
		this.firstName=fName;
		this.lastName=lName;
		this.age=age;
		
	}
	
	public String getFirstName(){
		
		return firstName;
	}
	
	public void setFirstName(String fName){
		
		this.firstName=fName;
	}
	
	public String getLastName(){
		
		return lastName;
	}
	
	public void setLastName(String lName){
		
		this.lastName=lName;
	}
	
	
	
	public int getAge(){
		
		return age;
	}
	
	public void setAge(int age){
		
		this.age=age;
	}
	
	public String toString(){
		
		return "Person[firstName=" +firstName+"lastName="+ lastName+ "age="+age +"]";
	}
	
}
