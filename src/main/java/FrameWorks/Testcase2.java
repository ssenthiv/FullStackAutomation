package FrameWorks;

import java.util.Arrays;
import java.util.Properties;

import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Listeners(FrameWorks.ScreenshotUtility.class )
//@Listeners(FrameWorks.ExtentReporterNG.class)
public class Testcase2 extends ModuleBase{

	private String methodName;
@Parameters({"browser","remoteURL"})	
@BeforeTest
public void beforeTest(String browser, String URL){
	System.out.println("Calling @Before Test");
	System.out.println("browser : "+browser);
	methodName=Thread.currentThread().getStackTrace()[1].getMethodName();	
	Add_Log.info("Executing - "+  this.getClass().getSimpleName()+"."+methodName );
	checkCaseToRun("Method2");
	//loadBrowser(browser);
	loadBrowserRemote(browser,URL);
	
	//System.out.println(Arrays.asList(TestDataToRun));
}

@DataProvider(name = "TestDataToRunTest")
public Object[][] TestDataToRun() {
	System.out.println("Calling @DataProvider");
	methodName=Thread.currentThread().getStackTrace()[1].getMethodName();	
	Add_Log.info("Executing - "+  this.getClass().getSimpleName()+"."+methodName );
	TestCaseName = this.getClass().getSimpleName();
	Add_Log.info("TestCaseName:"+TestCaseName);
	return moudle1Excel.retrieveTestData("Method2");

}

@Test(dataProvider = "TestDataToRunTest")
public void Method2(String FirstName, String LastName, String Email, String MobileNo,
		String Address, String Suburb, String State, String PostCode, String Dob, String TermsAndCondition,
		String Submit){
	System.out.println("Calling @Test");
	methodName=Thread.currentThread().getStackTrace()[1].getMethodName();
	Add_Log.info("Executing - "+this.getClass().getSimpleName()+"."+methodName);	

	dataSet++;
	testFail=false;
	softAssert=new SoftAssert();


	if (!TestDataToRun[dataSet].equalsIgnoreCase("Y")) {
		// If DataToRun = "N", Set Testskip=true.
		testSkip = true;
		throw new SkipException(
				"DataToRun for row number " + dataSet + " Is No Or Blank. So Skipping Its Execution.");
	}
	Add_Log.info(this.getClass().getSimpleName() + " : dataset :"+ dataSet +" : ****** Testing Testcase1 description ******");
	try{
		//Testcase1Page page=new Testcase1Page();
		SuiteLoginPage loginPage= new SuiteLoginPage(driver, TestCaseName);
		SuiteModule1Page module1Page;
		loginPage.submitLoginPage();
		module1Page=loginPage.navigateToModule(param.getProperty("URL"));
		
		
		
		module1Page.sendKeysToFirstName(FirstName);
		module1Page.sendKeysToLastName(LastName);
		module1Page.sendKeysToEmail(Email);
		module1Page.sendKeysToMobileNo(MobileNo);
		module1Page.sendKeysToAddress(Address);
		module1Page.sendKeysToSuburb(Suburb);
		module1Page.selectState(State);
		module1Page.sendKeysToPostCode(PostCode);
		module1Page.sendKeysToDob(Dob);
		module1Page.clickOnTermsAndCondition(TermsAndCondition.trim());
		module1Page.clickOnSubmit(Submit);
		module1Page.verifyTestingFormSubmission(); 
		if (testFail) {
			reportFailures("Testcase - Method1  '" + "'  --> 'FAIL'");

		} else {
			//System.out.println("Testcase - Method1  '" + "'  --> 'PASS'");
			Add_Log.info(this.getClass().getSimpleName() + " --> 'PASS'");
		}

	}catch(Throwable e){

		e.printStackTrace();
		reportFailures("Testcase - Method1  '" + "'  --> 'FAIL'");
	}finally{
		if (testFail) {
			softAssert.assertAll();
		}
	}

}


@AfterMethod
void writeExcel(){
	System.out.println("Calling @AfterMethod");
	methodName=Thread.currentThread().getStackTrace()[1].getMethodName();
	Add_Log.info("\tExecuting - "+this.getClass().getSimpleName()+"."+methodName);	
	updateResultExcel("Method2");
	
}

@AfterTest
void endTest(){
	System.out.println("Calling @AfterTest");
	methodName=Thread.currentThread().getStackTrace()[1].getMethodName();
	Add_Log.info("\tExecuting - "+this.getClass().getSimpleName()+"."+methodName);	
	
	testClosure("Method2");
	closeWebBrowser();
}
}
