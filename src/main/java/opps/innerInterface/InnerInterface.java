package opps.innerInterface;

public interface InnerInterface {
	
	StaticInterface sInterface=new StaticInterface(){
		/*
		public void innerMethod(){
			
		}  */
	};
	public default void outerDefaultMethod(){
		System.out.println("From outer Default Method");
		//StaticInterface.innerMethod();
		sInterface.innerMethod();
	}
	
	public void abstractMethod();
	
	public static interface StaticInterface{
		
		public default void innerMethod(){
			System.out.println("inner-default method");
			//outerDefaultMethod();
		}
		
		
	}

}
