package designpattern.dependencyinjection;

public class MyDIApplication implements Consumer{

	public MessageService service;
	
	public MyDIApplication(MessageService svc) {
		this.service=svc;
	}
	
	//@Override
	public void processMessages(String msg, String rec) {
		
	service.sendMessage(msg, rec);
		
	}

}
