package Java8.methodreference;

interface Sayable{
	
	public void say();
}
public class MethodReference {
	
	
	public static void saySomething(){
		System.out.println("This is static method");
	}
	
	public  void saySomethingNonStatic(){
		System.out.println("This is Non Static method");
	}
	public static void main(String[] args){
		
		System.out.println("1.Without using Method Reference");
		Sayable s1=new Sayable(){
		
			public void say(){
				saySomething();
			}
		};
		
		s1.say();
		System.out.println("\n2.Static Method Reference");
		Sayable s2=MethodReference::saySomething;
		s2.say();
		
		System.out.println("\n3.Non Static Method Reference");
		Sayable s3=new MethodReference()::saySomethingNonStatic;
		s3.say();
	}
}

