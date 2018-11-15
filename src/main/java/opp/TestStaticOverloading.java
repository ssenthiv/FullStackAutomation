package opp;

public class TestStaticOverloading {

	public static void main(String[] args) throws Exception
{
	
		
		
		//1. Static overloading is possible,even if sub class signature is not in parent
		BMW b=new BMW();
			
		b.start("Static overloading");
		b.infotainment();
		
		b.start(" static"," overlading");
}
}
