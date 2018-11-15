package memorymgmnt;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CustomerRecords implements Iterable<Customer> {
	
	private HashMap<String,Customer> records;
	
	public CustomerRecords(){
		
		records=new HashMap<>();
	}

	public void addCustomer(Customer cust){
		
		this.records.put(cust.getName(),cust);
		
	}
	
	public Map<String,Customer> getCustomers(){
		
		return  Collections.unmodifiableMap(this.records);
	}
	
	public Customer getCustomerByNameCopyConst(String name){
		
		return new Customer(records.get(name));
	}

	public CustomerReadOnly getCustomerByName(String name){
		
		return records.get(name);
	}
	
	@Override
	public Iterator<Customer> iterator() {
		return records.values().iterator();
	}
}
