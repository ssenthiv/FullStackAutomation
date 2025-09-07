package TestNGSessions;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;


public class RetryAnalyzer implements IRetryAnalyzer{
	private int counter=0;
	@Override
	public boolean retry(ITestResult testResult) {
		
		
		RetryCountIfFailed annotation=testResult.getMethod().getConstructorOrMethod().getMethod().getAnnotation(RetryCountIfFailed.class);
		
		if (annotation!=null && counter < annotation.value()){
			counter++;
			return true;
		}
		return false;
	}
	

}
