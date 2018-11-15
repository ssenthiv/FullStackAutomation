package designpattern.templatemethod;

public class PrivateAccount extends AccountCreator{
	
	@Override
	public void generateAccountNumber() {
		System.out.println("Private Account Number Created");
		
	}

public void sendATMCard(){
		
		super.sendATMCard();
		System.out.println("Send a movie ticket");
	}

}
