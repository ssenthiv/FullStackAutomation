package opp.Interface;

public class HDFC extends IndianBank{

	HDFC(){
		
		
		AcNumber="HDFC-"+AcNumber;
	}
	
	HDFC(String str){
		
		super(str);
		//this();
		AcNumber=str +AcNumber;
	}
	
	static void name(){
		
		System.out.println("static - HDFCBank");
		
	}
	public void showAc(){
		//super.showAc();
		
		System.out.println("AcNumber : "+ AcNumber);
		
	}
	
	public void name(String str){
		System.out.println("Name from Non static method ");
		name();
		IndianBank.name();
		
	}
}
