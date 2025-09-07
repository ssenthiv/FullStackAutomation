package collection.comparison;

public class Car implements Comparable<Car> {

//	public class Car  {
	private String registrationNumber;
	private int price;
	private int instanceCountCompareTo;
	private int instanceCountHashCode;
	private int instanceCountEquals;
	private static boolean log=true;

public Car(String str){
	this.registrationNumber=str;
	instanceCountCompareTo=0;
	instanceCountHashCode=0;
	instanceCountEquals=0;
}
public void initCounters(){
	instanceCountCompareTo=0;
	instanceCountHashCode=0;
	instanceCountEquals=0;
}
public static void setLogging(boolean log){
	Car.log=log;
}
public int getInstanceCountCompareTo() {
	return instanceCountCompareTo;
}
public void setInstanceCountCompareTo(int instanceCountCompareTo) {
	this.instanceCountCompareTo = instanceCountCompareTo;
}
public int getInstanceCountHashCode() {
	return instanceCountHashCode;
}
public void setInstanceCountHashCode(int instanceCountHashCode) {
	this.instanceCountHashCode = instanceCountHashCode;
}
public int getInstanceCountEquals() {
	return instanceCountEquals;
}
public void setInstanceCountEquals(int instanceCountEquals) {
	this.instanceCountEquals = instanceCountEquals;
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
	instanceCountEquals++;
	if (log){
	System.out.printf("\n\t\t\tElement%2s", instanceCountEquals);
	System.out.println("  ------------------->inside equals---Car");
	
	System.out.println("\t\t\t\t"+"obj\t\t: " +obj);
	System.out.println("\t\t\t\t"+"this\t\t: " +this);
	System.out.println("\t\t\t\tequals count\t: "+this.getInstanceCountEquals());
	}
	if (obj !=null && obj instanceof Car){
		String regNum=((Car)obj).getRegistrationNumber();
		if (regNum != null && regNum.equals(this.registrationNumber))
			return true;
			
	}
	return false;
}


public int hashCode(){
	instanceCountHashCode++;
	if (log){
	System.out.printf("\n\t\t\tElement%2s", instanceCountHashCode);
	System.out.println("  -------------------------------------->inside hashCode---Car");
	System.out.println("\t\t\t\t"+"this\t\t: " +this);
	System.out.println("\t\t\t\thashCode count\t: "+this.getInstanceCountHashCode());
	}
	return this.registrationNumber.hashCode();
	//return 5;
	//return (int)(Math.random()*10000);
}

@Override
public int compareTo(Car obj){
	instanceCountCompareTo++;
	if (log){
	System.out.printf("\n\t\t\tElement%2s", instanceCountCompareTo);
	System.out.println("  ----->inside compareTo---CAR");

	System.out.println("\t\t\t\t"+"obj\t\t: " +obj);
	System.out.println("\t\t\t\t"+"this\t\t: " +this);
	System.out.println("\t\t\t\tcompareTo count\t: "+this.getInstanceCountCompareTo());
	}
	
	if (this.price < obj.price)
		return 1;
	else if ( this.price == obj.price)
		return 0;
		else 
		return -1;
		
	//return this.registrationNumber.compareTo(obj.registrationNumber);
	
}

}
