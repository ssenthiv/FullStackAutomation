package designpattern.factorymethod;

public class Exec {

	public static void main(String[] args) {

		Mobile mobile = MobileFactory.createMobile(Mobile.SAMSUNG);
		mobile.display();
		mobile = MobileFactory.createMobile(Mobile.IPHONE);
		mobile.display();
		mobile = MobileFactory.createMobile(Mobile.SONY);
		mobile.display();

	}
}
