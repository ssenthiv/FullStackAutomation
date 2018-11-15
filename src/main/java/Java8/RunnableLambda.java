package Java8;

import org.openqa.selenium.support.ui.Wait;

public class RunnableLambda {

	public static void main(String[] args) throws InterruptedException{
		
		Thread myThread=new Thread(()->{
				for (int i=0;i<=20;i++){
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println("Inside the thread ="+i);
				}
				});
	
		myThread.start();
		for (int i=0;i<=20;i++){
			Thread.sleep(500);
			System.out.println("Main thread ********************* "+i);
		}
		
		myThread.join();
		System.out.println("Main thread End ");
	}
	
}
