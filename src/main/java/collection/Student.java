package collection;

public class Student {

	private String registrationNumber;
	
	public Student(String num){
		
		this.registrationNumber=num;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}
	
	public boolean equals(Object obj){
		
		//System.out.println("From equals-----Student ");
		if (obj != null && obj instanceof Student){
			
			String regNum=((Student) obj).getRegistrationNumber();
			if ( regNum != null && regNum.equals(this.getRegistrationNumber()))
				return true;
			
				
		}
			
		return false;
		
	}
	
	public int hashCode(){
		//System.out.println("From hashCode");
		return this.registrationNumber.hashCode();
		//return 5;
	}
	
}
