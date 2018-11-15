package collection;

public class Car implements Comparable<Car> {
private String registrationNumber;
private int price;

public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
public Car(String str){
	this.registrationNumber=str;
}
public String getRegistrationNumber(){
	
	return this.registrationNumber;
}
public void setRegistrationNumber(String str){
	
	this.registrationNumber=str;
}

public String toString(){
	
	return this.registrationNumber + "Price = " +  this.price;
}

public boolean equals(Object obj){
	//System.out.println("inside equals------------");
	if (obj !=null && obj instanceof Car){
		String regNum=((Car)obj).getRegistrationNumber();
		if (regNum != null && regNum.equals(this.registrationNumber))
			return true;
		
	}
	return false;
}

public int hashCode(){
	//System.out.println("inside hashCode------------");
	return this.registrationNumber.hashCode();
	
}

@Override
public int compareTo(Car obj){
	//System.out.println("inside compareTo------------");
	
	if (this.price < obj.price)
		return 1;
	else if ( this.price == obj.price)
		return 0;
		else 
		return -1;
		
	//return this.registrationNumber.compareTo(obj.registrationNumber);

}

}
