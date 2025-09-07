package Threading;

import java.util.concurrent.atomic.AtomicInteger;

import org.apache.xml.dtm.ref.IncrementalSAXSource;

public class RunnableExe implements Runnable{
		//private  static volatile AtomicInteger count=new AtomicInteger(0);             // thread safe , synchronization is not required
		private  static  int count=0;  
	        public void run(){
	                
	                for(int i=1; i < 5; i++){
	                        //System.out.println("\t\tChild Thread : " + i);
	                        increment("\t\t",i);
	                        try{
	                                Thread.sleep(50);
	                        }
	                        catch(InterruptedException ie){
	                                System.out.println("Child thread interrupted! " + ie);
	                        }
	                }
	                
	                System.out.println("\t\t\t"+Thread.currentThread().getName()+" finished!");
	        }
	        
	          synchronized static void increment(String indent, int i) {
	    		//count.incrementAndGet();
	        	count++;
	    		System.out.println("count ="+ count+ indent + Thread.currentThread().getName() +" : " + i );
	    		}
	        public static void main(String[] args) throws InterruptedException {
	                
	                
	                
	                Thread t1 = new Thread(new RunnableExe(), "  Chd1");
	                Thread t2 = new Thread(new RunnableExe(), "\t\tChd2");
	                
	                
	                t1.start();
	                t2.start();
	                t1.join();							// main thread has to wait till the given thread die
	                t2.join();
	                for(int i=1; i < 5; i++){
	                        
	                        //System.out.println("Main thread : " + i);
	                       //increment("\t",i);
	                        try{
	                                Thread.sleep(50);
	                        }
	                        catch(InterruptedException ie){
	                                System.out.println("Child thread interrupted! " + ie);
	                        }
	                }
	                
	                System.out.println("\t\t"+Thread.currentThread().getName()+ " finished!");
	        }
	}
