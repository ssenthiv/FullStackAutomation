package stringhandling;

public class StringPool {

	public static void main(String[] args) {
		
		
		String one="hello";
		String one1="hel";
		String one2="lo";
		String two=(one1+one2).intern();
		
		System.out.println(two);
		if (one == two){
			System.out.println("both are same");
		}else {
			System.out.println("both are different");
		}

		
		String three=new Integer(70).toString().intern();
		System.out.println(three);
		String four ="70";
		System.out.println(four);
		
		if (three == four){
			System.out.println("both are same");
		}else {
			System.out.println("both are different");
		}
		
	}

}
