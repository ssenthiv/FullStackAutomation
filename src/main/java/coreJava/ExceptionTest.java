package coreJava;
 public  class ExceptionTest {

	static int a=0;
	
	public  int returnCheck(){
		
		
		try{
			
			a=100/0;
			return a;
		}catch (Exception e){
			
			System.out.println("Catch called");
			a=200;
			return a;
		}
		finally{
			 
			a=300;
			System.out.println("finally called a = " + a);
			
			
			
			//a=300;
			
			// return a;
		}
	}
	
	public static void main(String[] args) {
		
		ExceptionTest et=new ExceptionTest();

		System.out.println("a = " + et.returnCheck());

		
		
	}

}
