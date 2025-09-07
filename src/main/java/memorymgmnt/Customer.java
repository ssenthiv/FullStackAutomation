package memorymgmnt;

public class Customer implements CustomerReadOnly {

	private String name;
	
	public Customer(String cName) {
		
		this.name=cName;
	}
	
	public Customer(Customer oldCustomer){
		
		this.name=oldCustomer.name;
	}
	/* (non-Javadoc)
	 * @see memorymgmnt.CustomerReadOnly#getName()
	 */
	@Override
	public String getName(){
		return this.name;
		
	}
	public void setName(String name){
		
		this.name=name; 
	}
	/* (non-Javadoc)
	 * @see memorymgmnt.CustomerReadOnly#toString()
	 */
	@Override
	public String toString(){
		return this.name;
	}
	
	public void finalize(){
		System.out.println("This object is being gc' d");
	}
	
}
