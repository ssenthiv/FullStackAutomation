package opp.Interface;

public class IndianBank implements USBank,UKBank{
	
	String AcNumber;
	
	IndianBank(){
		
		System.out.println("super constructor called");
		AcNumber="1000";
		
		
	}
	
	IndianBank(String str){
		
		System.out.println("super constructor(String) called");
		AcNumber="2000";
		
		
	}
	
	static void name(){
		
		System.out.println("static - IndianBank");
	}
	
	public void showAc(){
		
		System.out.println("Super AcNumber : "+ AcNumber);
		
	}
	public void debit(){
		System.out.println("debit--USBank");
	}
	
	public void credit(){
		System.out.println("credit--USBank");
	}
	
	public void transferMoney(){
		System.out.println("tr money--USBank");
	}
	
	
	public void mutualFunds(){
		System.out.println("mutual funds--USBank");
	}
	
	public void educationLoan(){
		System.out.println("edu loan --UKBank");
	}
	
	
	public void loan(){
		System.out.println("loan--IndianBank");
	}
	
	
	
	

}
