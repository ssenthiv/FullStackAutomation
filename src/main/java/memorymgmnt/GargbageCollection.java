package memorymgmnt;

public class GargbageCollection {

	public static void main(String[] args) throws InterruptedException {
		
		
		Runtime runtime=Runtime.getRuntime();
		
		System.out.println("Available Momory 	:" + runtime.totalMemory()/(1024*1024) + " MB");
		System.out.println("Free Momory 		:" + runtime.freeMemory()/(1024*1024) + " MB");
		
		
		for (int i=1;i<=100000;i++){
			
			Customer c;
			c=new Customer("John");
		}
		// Thread.sleep(5000);
		System.gc();			// it should be infrequent as it stops further execution until gc completes
		System.out.println("Available Momory	:" + runtime.totalMemory()/(1024*1024) + " MB");
		System.out.println("Free Momory 		:" + runtime.freeMemory()/(1024*1024) + " MB");
	}

}
