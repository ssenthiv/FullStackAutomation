package designpattern.templatemethod;

public class Exec {

	public static void main(String[] args) {
		
		AccountCreator ba=new BuisinessAccount();
		ba.createAccount();
		
		AccountCreator pa=new PrivateAccount();
		pa.createAccount();

	}

}
