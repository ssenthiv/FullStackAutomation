package FrameWorks;

import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReporterNG implements IReporter {

	private ExtentReports extent;



	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {

		extent = new ExtentReports(outputDirectory + File.separator + "Extent.html", true);



		for (ISuite suite : suites) {

			Map<String, ISuiteResult> result = suite.getResults();



			for (ISuiteResult r : result.values()) {

				ITestContext context = r.getTestContext();



				buildTestNodes(context.getPassedTests(), LogStatus.PASS);

				buildTestNodes(context.getFailedTests(), LogStatus.FAIL);

				buildTestNodes(context.getSkippedTests(), LogStatus.SKIP);

			}

		}



		extent.flush();

		extent.close();

	}



	private void buildTestNodes(IResultMap tests, LogStatus status) {

		ExtentTest test;



		if (tests.size() > 0) {

			for (ITestResult result : tests.getAllResults()) {

				test = extent.startTest(result.getMethod().getMethodName());



				test.setStartedTime(getTime(result.getStartMillis()));

				test.setEndedTime(getTime(result.getEndMillis()));



				for (String group : result.getMethod().getGroups())

					test.assignCategory(group);

				//printResults(test, result);
				//System.out.println(status + "Test " + status.toString().toLowerCase() + "ed");

				if (result.getThrowable() != null) {

					test.log(status, result.getThrowable());

				} else {

					test.log(status, "Test " + status.toString().toLowerCase()

							+ "ed");

				}



				extent.endTest(test);
				

			}

		}

	}



	private Date getTime(long millis) {

		Calendar calendar = Calendar.getInstance();

		calendar.setTimeInMillis(millis);

		return calendar.getTime();

	}
	
	private void printResults(ExtentTest eTest, ITestResult result){
		
		System.out.println("---------------------------------------------");
		System.out.println("-------------Extent Report Data--------------");
		System.out.println(eTest.getDescription().toString());
		System.out.println(eTest.toString());
		System.out.println(eTest.getTest().toString());
		System.out.println(eTest.getRunStatus());
		System.out.println(eTest.getStartedTime());
		System.out.println(eTest.getEndedTime());
		System.out.println("---------------------------------------------");
		System.out.println(result.getTestName());
		System.out.println(result.getName());
		System.out.println(result.getMethod());
	}
	
}
