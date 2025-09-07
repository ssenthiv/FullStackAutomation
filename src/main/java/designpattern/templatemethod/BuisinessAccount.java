package designpattern.templatemethod;

public class BuisinessAccount extends AccountCreator{

	@Override
	public void generateAccountNumber() {
		System.out.println("Business Account Number Created");
		
	}

	public void sendATMCard(){
		
		super.sendATMCard();
		System.out.println("Send a gift voucher");
	}
	
}
