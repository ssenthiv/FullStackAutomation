package Java8;

public class Closure {
	static int a=20;
	 
	public static void main(String[] args) {
		 int b=10;
		 a=21;
		 a=22;
		 // b=15; //cannot change as lamdba supports only final local variable
		  
		doProcess(a,i-> {
		 	
		System.out.println(i+b);
		});
		 
	}
	
	public static void doProcess(int a, Process p){
		
		p.process(a);
	}

}

interface Process{
	
	public void process(int i);
}
