package designpattern.decorator;

public class Exec {

	public static void main(String[] args) {
		
		
		System.out.println("\1. Sports Package");
		SatelliteTv sports=new ESPN(new CartoonNetwork(new TataSky()));

		System.out.println("Subcription price ="+ sports.subscriptionPrice());
		sports.show(99);
		sports.show(120);
		sports.show(250);
		sports.show(380);
		
		System.out.println("\n2. Discovery Package");
		SatelliteTv discovery=new Discovery(new CartoonNetwork(new TataSky()));
		
		System.out.println("Subcription price ="+ discovery.subscriptionPrice());
		discovery.show(99);
		discovery.show(120);
		discovery.show(250);
		discovery.show(380);
		
		System.out.println("\n3. Combo Package");
		SatelliteTv combo=new Discovery(new ESPN(new CartoonNetwork(new TataSky())));
		
		System.out.println("Subcription price ="+ combo.subscriptionPrice());
		combo.show(99);
		combo.show(120);
		combo.show(250);
		combo.show(380);
	}

}
