package memorymgmnt.softleak;

public class CustomerHarness {

	public static void main(String[] args) {
		CustomerManager cm=new CustomerManager();
		GenerateCustomerTask task=new GenerateCustomerTask(cm);
		
		for (int i=0; i<10; i++){
			
			Thread t=new Thread(task);
			t.start();
		}
		
		while(true){
			
			try{
				Thread.sleep(5000);
			}
			catch(InterruptedException ie){
				ie.printStackTrace();
			}
			
			cm.howmanyCustomers();
			System.out.println("Avail memory : "+ Runtime.getRuntime().totalMemory()/(1024*1024) + " MB");
			System.out.println("Free memory : "+ Runtime.getRuntime().freeMemory()/(1024*1024) + " MB");
		}
	}

}
