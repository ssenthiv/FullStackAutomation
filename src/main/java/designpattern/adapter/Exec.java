package designpattern.adapter;

public class Exec {

	public static void main(String[] args) {

		OldCustomer oldCustomer = new OldCustomer();
		oldCustomer.setName("Tom");
		oldCustomer.setAge("35");
		oldCustomer.setAddress("GoldStreet,30,20021,New York");

		Customer customer = new CustomerAdapter(oldCustomer);
		//CustomerAdapter customer = new CustomerAdapter(oldCustomer);
		System.out.println(customer.getName());
		System.out.println(customer.getAge());
		System.out.println(customer.getAddress());

		}
}
