package TestNGSessions;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class AnnotationTransformer implements IAnnotationTransformer{

	@Override
	public void transform(ITestAnnotation annotation, Class arg1, Constructor arg2, Method method) {
		
		annotation.setRetryAnalyzer(RetryAnalyzer.class);
		//annotation.setEnabled(false);
	
		//annotation.setInvocationCount(3);
		
	}

}
