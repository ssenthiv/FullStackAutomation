package Java8;

public class Java8LamdaExpTest {
	
	final static String saluation="Hello  ";
	
	
	String saluation1="hi";
	
		
	@FunctionalInterface
	 interface MathOperation{
		
		public int operation(int a, int b);
		//public void operator(String s);
	}
	
	interface GreetingService{
		
		void sayMessage(String message);
	}

	int operate(int a, int b, MathOperation mo){
		
		return mo.operation(a, b);
	}
	
	
	public static void main(String arg[]){
		
		Java8LamdaExpTest jlamda =new Java8LamdaExpTest();
		
		
		
		// 1. Anonymous inner class implementation
		System.out.println("Addtion :"+ jlamda.operate(10, 15, new MathOperation(){
			public int operation(int a, int b){return a+b;}}));
		// 2. using lambda variable
		MathOperation subtraction= (int a, int b)-> a-b;
		System.out.println("Subtraction :"+ jlamda.operate(10, 5, subtraction));
		// 3. without variable
		System.out.println("Multiplication :"+ jlamda.operate(10, 5, (int a, int b)->{return  a*b;}));
		// 4. Type interface
		System.out.println("Multiplication :"+ jlamda.operate(10, 3, (a,b)-> {return a*b;}));
		// 5. without Return command
		System.out.println("Division :"+ jlamda.operate(10, 3, (a,b)-> a/b));
		// 6. Anonymous inner class for lambda variable
		MathOperation square= new MathOperation(){
			public int operation(int a, int b){return a*a;}};
		System.out.println("Square: "+ square.operation(50, 2));
		
		// 7. without parenthesis around the argument
		GreetingService gs1=m-> System.out.println("Hay ! "+ m);
		gs1.sayMessage("Murugan");
		GreetingService gs2=(str)-> System.out.println(saluation + str );
		gs2.sayMessage("Shums");
		
		
	}
}
