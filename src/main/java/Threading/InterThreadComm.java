package Threading;

import java.util.Scanner;

public class InterThreadComm {

	public static void main(String[] args){
		
		final Customer c=new Customer();
		
		Thread t1=new Thread(){
			
			public void run(){
				c.withdraw(1500);
			}
		};
		
		Thread t2=new Thread(){
			
			public void run(){
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				c.deposit(200);
				
				Scanner sc=new Scanner(System.in);
				while (t1.isAlive()){
				
				if (!Thread.holdsLock(c)){
				
				System.out.println("For another deposit, Press enter ...");
				
				sc.nextLine();
				c.deposit(100);
				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				}
				sc.close();
				
			}
		};
		
		t1.start();
		t2.start();
	}
}

class Customer {
	private int amount=1000;
	
	synchronized public void withdraw(int amount){
		
		System.out.println("Withdrawing money ...");
		while (this.amount < amount) {
			System.out.println("\tNot having enough balance. Waiting for deposit...");
			try {
				this.wait();
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			
		}
			this.amount-=amount;
			System.out.println("Amount withdrown ="+ amount);
			System.out.println("Balance amount   ="+this.amount);
		}

	
	synchronized public void deposit(int amount){
		System.out.println("Depositting money ...");
		this.amount+=amount;
		System.out.println("Deposit completed");
		System.out.println("\tNotify withdra ...");
		this.notify();
	}
	
}
