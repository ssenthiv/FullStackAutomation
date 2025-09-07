package TestNGSessions;

import org.testng.SkipException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class InvocationCount {
	
	
	@Test(invocationCount=4,threadPoolSize=2,invocationTimeOut=1050, timeOut=2050,groups={"preState"})
	public void createDataTest(){
		System.out.println("hello");
		SoftAssert sAssert= new SoftAssert();
		sAssert.fail();
		sAssert.assertAll();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			
			throw new SkipException("Failed");
		}
	}
	
	
	

}
