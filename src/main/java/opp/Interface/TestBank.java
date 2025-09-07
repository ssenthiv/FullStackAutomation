package opp.Interface;

public class TestBank {
	
	
	public static void main(String[] args) {

		
		System.out.println("1. Calling methods from sub class");
		IndianBank ib= new IndianBank();
		ib.credit();
		ib.debit();
		ib.transferMoney();
		ib.educationLoan();
		ib.mutualFunds();
		ib.loan();
		

		USBank us = new IndianBank();//child class object can be referred by parent interface ref variable
		System.out.println("\n2. Dynnamic binding");
		us.credit();
		
		System.out.println("\n3. Using super() and this() in constructors ");
		
		HDFC hd=new HDFC();
		hd.showAc();
		
		HDFC hd2=new HDFC("LOAN-");
		hd2.showAc();
		
		ib.showAc();
		ib=hd;
		ib.showAc();
		
		System.out.println("\n4. static method hiding ");
		IndianBank.name();
		HDFC.name();
		hd.name("dummy");
		
	}

}
