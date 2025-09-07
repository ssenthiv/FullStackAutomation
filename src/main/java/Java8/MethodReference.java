package Java8;

public class MethodReference {

	public static void main(String[] args) {
		
		Thread t=new Thread(System.out::println);
		
		t.start();

	}
	public static void printMessage(){
		System.out.println("Hello");
	}
}
