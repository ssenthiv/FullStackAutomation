package memorymgmnt.softleak;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CustomerManager {
	public List<Customer> customers=new ArrayList<>();
	private int nextId=0;
	
	public void addCustomer(Customer customer){
		
		synchronized (this){
			customer.setId(nextId);
			nextId++;
		}
		customers.add(customer);
		
	}
	public Customer getNextCustomer(){
		
		return customers.get(0);
		//return customers.remove(0);
	}
	
	public void howmanyCustomers(){
		
		int size;
		size=customers.size();
		System.out.println(""+ new Date()+ " : "+ size);
		//return size;
	}

}
