package collection;

public class Car implements Comparable<Car> {
//	public class Car  {
	private String registrationNumber;
	private int price;
	public int instanceCount;


public Car(String str){
	this.registrationNumber=str;
}

public int getInstanceCount() {
	return instanceCount;
}
public void setInstanceCount(int instanceCount) {
	this.instanceCount = instanceCount;
}

public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}


public String getRegistrationNumber(){
	
	return this.registrationNumber;
}
public void setRegistrationNumber(String str){
	
	this.registrationNumber=str;
}

public String toString(){
	
	return this.registrationNumber + " Price = " +  this.price;
}

public boolean equals(Object obj){
	System.out.printf("\t\t\tElement %2s", instanceCount++);
	System.out.println(" -------------------inside equals---Car");
	if (obj !=null && obj instanceof Car){
		String regNum=((Car)obj).getRegistrationNumber();
		if (regNum != null && regNum.equals(this.registrationNumber))
			return true;
		
	}
	return false;
}

public int hashCode(){
	System.out.printf("\t\t\tElement %2s", instanceCount++);
	System.out.println("--------------------------------------inside hashCode---Car");
	return this.registrationNumber.hashCode();
	//return 5;
}

@Override
public int compareTo(Car obj){
	System.out.printf("\t\t\tElement %2s", instanceCount++);
	System.out.println("-----inside compareTo---CAR");
	
	
	if (this.price < obj.price)
		return 1;
	else if ( this.price == obj.price)
		return 0;
		else 
		return -1;
		
	//return this.registrationNumber.compareTo(obj.registrationNumber);

}

}
