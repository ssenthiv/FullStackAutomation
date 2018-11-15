package memorymgmnt.softleak;

import java.util.UUID;

public class GenerateCustomerTask implements Runnable{
	
	private CustomerManager cm=new CustomerManager();
	private int totalCustomersGenerated=0;
	
	public GenerateCustomerTask(CustomerManager cm){
		this.cm=cm;
	}

	@Override
	public void run() {
		while(true){
			
			try{
				Thread.sleep(1);
			}
			catch(InterruptedException ie){
				ie.printStackTrace();
			}
		
			
			String name=new UUID(1l,10l).toString();
			Customer c=new Customer(name);
			//if (cm.customers.size() <200){
			cm.addCustomer(c);
			totalCustomersGenerated++;
			//}
			cm.getNextCustomer();
			
		}
	}
	
	

}
