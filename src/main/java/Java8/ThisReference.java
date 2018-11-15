package Java8;

public class ThisReference {

	public  void doProcess(int i, Process p){
		
		p.process(i);
		
	}
	public void invoke(){
		
		doProcess(25,i-> {
			System.out.println(i);	
			 System.out.println(this); 
			});
	}
	public String toString(){
		
		return "Class - this Reference";
	}
	public static void main(String[] args) {
		
		ThisReference thisRef=new ThisReference();
		
		System.out.println("1. this reference in annonymous inner class");
		thisRef.doProcess(10, new Process(){
			
			public void process(int i){
				System.out.println(i);
				System.out.println(this);
			}
			public String toString(){
				return "Inner class- this Reference";
			}
		});
		
		System.out.println("\n2. this reference in lambda static context");
		thisRef.doProcess(20,i-> {
		System.out.println(i);	
		// System.out.println(this); // This will not work as it is in static context
		});
		System.out.println("\n3. this reference in lambda");
		thisRef.invoke();
	}

}
