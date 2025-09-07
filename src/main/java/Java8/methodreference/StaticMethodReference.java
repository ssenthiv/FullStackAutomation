package Java8.methodreference;



public class StaticMethodReference {
	

	public static void main(String[] args) {
		
		Thread t=new Thread(StaticMethodReference::printMessage);
		
		t.start();

	}
	public static void printMessage(){
		System.out.println("Hello");
	}
}

 