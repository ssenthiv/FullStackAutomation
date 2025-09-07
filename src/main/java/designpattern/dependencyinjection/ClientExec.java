package designpattern.dependencyinjection;

public class ClientExec {
	
	public static void main(String[] args){
		
		String msg="Hello Shunmugam";
		String email="ssenthiv@mail.com";
		String phone="9890064444";
		
		MessageServiceInjector injector;
		Consumer app;
		
		// Email
		
		injector=new EmailServiceInjector();
		app=injector.getConsumer();
		
		app.processMessages(msg, email);
		
		// SMS
		
		injector=new SMSServiceInjector();
		app=injector.getConsumer();
		app.processMessages(msg, email);
		
		
	}

}
