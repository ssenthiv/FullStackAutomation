package Threading;

import java.util.concurrent.atomic.AtomicInteger;

import org.apache.xml.dtm.ref.IncrementalSAXSource;

public class AtomicCounter {
		private  static volatile AtomicInteger countStaticAtomic=new AtomicInteger(0);             // thread safe , synchronization is not required
		private   volatile AtomicInteger countAtomic=new AtomicInteger(0);					// volatile indicates to fetch from main memory not from local stack as other thread may update it
		private  static  volatile int countStatic=0; 
		private    volatile int count=0;  
	        
	        
	           static void incrementStatic(String indent, int i) {
	    		countStaticAtomic.incrementAndGet();
	        	countStatic++;
	    		System.out.println("countStatic \t="+ countStatic+ " countStaticAtomic \t=" + countStaticAtomic + indent + Thread.currentThread().getName() +" : " + i+ " Method : " +Thread.currentThread().getStackTrace()[1].getMethodName() );
	    		}
	           void increment(String indent, int i) throws InterruptedException {
	        	   //countStaticAtomic.incrementAndGet();
	        	   countAtomic.incrementAndGet();
		    		//Thread.sleep(10);
		        	//countStatic++;
		    		count++;
		        	//Thread.sleep(10);
		    		System.out.println("count \t\t="+ count+ " countAtomic \t\t=" + countAtomic + indent + Thread.currentThread().getName() +" : " + i + " Method : " +Thread.currentThread().getStackTrace()[1].getMethodName());
		    		
	          }
	           
	           synchronized void incrementSync(String indent, int i) throws InterruptedException {
	        	   
	        	    countAtomic.incrementAndGet();
		    		count++;
		    		System.out.println("count \t\t="+ count+ " countAtomic \t\t=" + countAtomic + indent + Thread.currentThread().getName() +" : " + i + " Method : " +Thread.currentThread().getStackTrace()[1].getMethodName() );

	          }
	            void incrementBlockSync(String indent, int i) throws InterruptedException {
	        	   
	        	    countAtomic.incrementAndGet();
		    		synchronized (this) {
		    			count++;
		    			System.out.println("count \t\t="+ count+ " countAtomic \t\t=" + countAtomic + indent + Thread.currentThread().getName() +" : " + i + " Method : " +Thread.currentThread().getStackTrace()[1].getMethodName() );
		    		}
	          }
	       
	}
