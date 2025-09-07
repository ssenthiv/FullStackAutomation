package TestNGSessions;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import org.testng.Assert;
import org.testng.annotations.Test;

@Retention(RetentionPolicy.RUNTIME)
@interface RetryCountIfFailed{
	
	int value() default 1;
}
public class RetryFailedTest {
	
	
	@Test
	public void test1() {
		System.out.println("test 1 method");
		//Assert.assertTrue(false);
	}
	
	//@Test(dependsOnGroups = {"preState"})
	//@Test(retryAnalyzer=RetryAnalyzer.class)
	@Test
	@RetryCountIfFailed(2)
	public void test2() {
		System.out.println("test 2 method");
		//Assert.assertTrue(false);
		Assert.assertEquals(false, true);
	}
	
	

}
