package memorymgmnt;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;



public class Main {

	public static void main(String[] args) {
		
		CustomerRecords record=new CustomerRecords();
		record.addCustomer(new Customer("shun"));
		record.addCustomer(new Customer("shiva"));
		//record.getCustomers().clear();  			// java.lang.UnsupportedOperationException
		//record.getCustomers().put("new", new Customer("new")); // java.lang.UnsupportedOperationException
		
		record.getCustomerByNameCopyConst("shiva").setName("AShfaq");  	// this will confuse as it changes the state
																		// but not reflecting in original object 
		
		//record.getCustomerByName("shiva").setName("AShfaq")				// setname is not allowed, because it returns interface CustomerReadOnly
		for (CustomerReadOnly c : record.getCustomers().values()){
			System.out.println(c);
		}
		
		
	}

}
