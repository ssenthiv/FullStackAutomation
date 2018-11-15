package designpattern.templatemethod;

public abstract class AccountCreator {
	
	public void verifyApplicationDetails(){

		System.out.println("Verify Account details");

	}

	

	public void verifyIdentificationDetails(){

		System.out.println("Verify the Identification Details");

	}

	

	public void receivePayment(int payment){

		System.out.println("PaymentReceived");

	}

	

	public abstract void generateAccountNumber();

	

	public void sendATMCard(){

		System.out.println("ATM Card dispatched");

	}

	

	public void sendATMPin(){

		System.out.println("ATM Pin dispatched");

	}

	

	public void createAccount(){

		this.verifyApplicationDetails();

		this.verifyIdentificationDetails();

		this.receivePayment(10);

		this.generateAccountNumber();

		this.sendATMCard();

		this.sendATMPin();

	}
}
