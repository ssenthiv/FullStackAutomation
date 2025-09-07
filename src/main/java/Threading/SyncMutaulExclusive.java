package Threading;

public class SyncMutaulExclusive {
	public static void main(String[] args){
		final AtomicCounter ac=new AtomicCounter();
		
		Thread t1=new Thread(){
			
			public void run(){
                
                for(int i=1; i < 5; i++){
                        //System.out.println("\t\tChild Thread : " + i);
                        try {
							ac.incrementBlockSync("\t\t",i);
						} catch (Throwable e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
                        try{
                                Thread.sleep(100);
                        }
                        catch(InterruptedException ie){
                                System.out.println("Child thread interrupted! " + ie);
                        }
                }
                
                System.out.println("\t\t\t"+Thread.currentThread().getName()+" finished!");
        }
		};
		
		
		Thread t2=new Thread(){
			
			public void run(){
                
                for(int i=1; i < 5; i++){
                        //System.out.println("\t\tChild Thread : " + i);
                        try {
							ac.incrementBlockSync("\t\t",i);
						} catch (Throwable e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
                        try{
                                Thread.sleep(100);
                        }
                        catch(InterruptedException ie){
                                System.out.println("Child thread interrupted! " + ie);
                        }
                }
                
                System.out.println("\t\t\t"+Thread.currentThread().getName()+" finished!");
        }
		};
		
		System.out.println("1. No differenes for Static/Non static variables/methods");
		System.out.println("   If counter is atomic,final count is consistent.");
		System.out.println("   If counter is Not atomic,final count may be inconsistent.");
		System.out.println("   If method is synchronizd, counter and total is consistent\n");
		t1.start();
		t2.start();
		
	}

}
