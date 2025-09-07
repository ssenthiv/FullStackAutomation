/**
 * 
 */
package coreJava;

/**
 * @author ssenthiv
 *
 */
public class TwoMainMethods {

	/**
	 * 
	 */
	public TwoMainMethods() {
		// TODO Auto-generated constructor stub
	}

		/**
		 * @param args
		 */
		 protected void method1(){
			
			System.out.println("Private method");
			
		}
	
	public static void main(String[] args) {
				// TODO Auto-generated method stub
		System.out.println("Hello World");
		
		System.out.println("Total Memory = " +Runtime.getRuntime().totalMemory());
		//Runtime.getRuntime().exit(2);
		String A="Test";
		String B= new String("Test");
		
		System.out.print(" A == B : ");
		if (A==B){
			System.out.println("Yes"
					);	
			}
		else {
			System.out.println("No");
		}
		
		System.out.print(" A.equls(B) : ");
		if (A.equals(B)){
			System.out.println("Yes"
					);	
			}
		else {
			System.out.println("No");
		}	
		
		System.out.println("A="+A);
		System.out.println("B="+B);	

		int	i=1;
		while (i<=5){
			i++;
			System.out.println(i);
			
			} 
		
	TwoMainMethods t = new TwoMainMethods();
	t.method1();
	main("2nd main");
	}
	
	public static void main(String str){
		System.out.println(str);
	}
}
