/**
 * 
 */
package Threading;

import java.util.concurrent.atomic.AtomicInteger;


public class ThreadExample extends Thread {

	long timeout;
	
	private  static volatile AtomicInteger count=new AtomicInteger(1);
	//private  static volatile int count=1;
	
	public ThreadExample(String str, long t) {
		super(str);
		timeout=t;
	}

	
	
	
	
	/* void increment(int i) {
		count.incrementAndGet();
		System.out.println(getName() +" : " + i + " count ="+ count);
		} */
	public void run() {
		
		try {
		for (int i=0; i<6;i++){
			
			synchronized (count){
		//	increment(i);
		//	count=count +1;
			count.incrementAndGet();
			System.out.println(getName() +" : " + i + " count ="+ count);
			}
			
			Thread.sleep(timeout);
		}
		}
		catch (Exception e){
			
			System.out.println("exception");
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args){
		
		ThreadExample t= new ThreadExample("Thread1", 1);
		t.start();
	}
	
}
