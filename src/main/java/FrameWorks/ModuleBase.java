package FrameWorks;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.SkipException;
import org.testng.annotations.BeforeSuite;



public class ModuleBase extends Base{

	private String methodName;
	
@BeforeSuite
void checkSuiteToRun(){
	System.out.println("Calling @BeforeSuite");
	methodName=Thread.currentThread().getStackTrace()[1].getMethodName();
	System.out.println("\tExecuting - "+  this.getClass().getSuperclass().getSimpleName()+"."+methodName );
	init();
	initModule1ReadXLS();
	
	//System.out.println("globalModulesExcel : "+ globalModulesExcel); 
	
	if (!globalModulesExcel.retrieveToRunFlag("ModuleList", "SuiteToRun", "Module1").equalsIgnoreCase("y")){
		
		System.out.println("\tToRun for Module1 = N ");
		globalModulesExcel.writeResult("ModuleList", "Skipped/Executed", "Module1" , "Skipped");
		throw new SkipException(
				"Module1" + "'s SuiteToRun Flag Is 'N' Or Blank. So Skipping Execution Of " + "Module1");
	}
	System.out.println("\tToRun for Module1 = Y ");
	globalModulesExcel.writeResult("ModuleList", "Skipped/Executed", "Module1", "Executed");
	
}


void checkCaseToRun(String TestCase){
	
	methodName=Thread.currentThread().getStackTrace()[1].getMethodName();	
	Add_Log.info("Executing - "+  this.getClass().getSuperclass().getSimpleName()+"."+methodName );
	try {
	if (!moudle1Excel.retrieveToRunFlag("TestCasesList", "CaseToRun", TestCase).equalsIgnoreCase("y")){
		
		System.out.println("\tToRun for" + TestCase +" = N ");
		moudle1Excel.writeResult("TestCasesList", "Pass/Fail/Skip", TestCase , "Skipped");
		throw new SkipException(
				TestCase + "'s CaseToRun Flag Is 'N' Or Blank. So Skipping Execution Of " + TestCase);
	}
	}catch(Exception e){
		e.printStackTrace();
	}
	TestDataToRun=moudle1Excel.retrieveToRunFlagTestData(TestCase, "DataToRun");
	System.out.println(this.getClass().getSuperclass().getSimpleName()+" : TestDataToRun =" +TestDataToRun);
}
void loadBrowserRemote(String browser, String URL){
	System.out.println("\tLoad BrowserRemote");
	DesiredCapabilities caps=null;
	switch(browser) {
	
	case "Chrome" : 
	ChromeOptions options = new ChromeOptions();
	options.addArguments("chrome.switches", "--disable-extensions");
	//options.addArguments("--headless");
	new DesiredCapabilities();
	caps = DesiredCapabilities.chrome();
	//DesiredCapabilities caps = DesiredCapabilities.firefox();
	caps.setCapability(ChromeOptions.CAPABILITY, options);
	caps.setPlatform(Platform.WIN10);
	caps.setBrowserName("chrome");
	break;
	
	case "IE" :
		
		//new DesiredCapabilities();
		caps = DesiredCapabilities.internetExplorer();
		
		caps.setPlatform(Platform.WINDOWS);
		caps.setBrowserName("internet explorer");
		//DesiredCapabilities cap = new DesiredCapabilities();
		//cap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		//cap.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL, param.getProperty("URL"));
		//DesiredCapabilities.internetExplorer().setCapability("ignoreProtectedModeSettings", true);
		//cap.setCapability("IE.binary", "C:/Program Files (x86)/Internet Explorer/iexplore.exe");
		//cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		//cap.setJavascriptEnabled(true);
		//cap.setCapability("requireWindowFocus", true);
		//cap.setCapability("enablePersistentHover", false);
		//driver = new InternetExplorerDriver(cap);
		//
		
		break;
	case "Mozilla" :
		//new DesiredCapabilities();
		caps = DesiredCapabilities.firefox();
		caps.setPlatform(Platform.WIN10);
		caps.setBrowserName("firefox");

		
		break;
	default :
		Add_Log.error("No such Browser " + browser);
		//reportFailures("No such Browser " + browser);
		break;
	}
	
	try {
		driver=new RemoteWebDriver(new URL(URL),caps);
	} catch (MalformedURLException e) {
		
		e.printStackTrace();
	}
	
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
	driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
	
}

public void loadBrowser(String browser){
	methodName=Thread.currentThread().getStackTrace()[1].getMethodName();
	Add_Log.info("Executing - "+ this.getClass().getSuperclass().getSimpleName()+"."+methodName);
	//System.out.println("\tExecuting - " +TestCaseName +"-> "+ ModuleBase.class.getName()+".loadBrowser()");
	//String browser= param.getProperty("testBrowser");
	switch(browser) {
	
	case "Chrome" : 

		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "//BrowserDrivers//chromedriver.exe");
		ChromeOptions options = new ChromeOptions();

		options.addArguments("chrome.switches", "--disable-extensions");
		// options.addArguments("--headless");
		new DesiredCapabilities();
		DesiredCapabilities caps = DesiredCapabilities.chrome();
		caps.setCapability(ChromeOptions.CAPABILITY, options);

		driver = new ChromeDriver(caps);
		// driver=new ChromeDriver();
		
		break;
		
	case "IE" :
		System.setProperty("webdriver.ie.driver",
				System.getProperty("user.dir") + "//BrowserDrivers//IEDriverServer.exe");
		
		//DesiredCapabilities cap = new DesiredCapabilities();
		//cap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		//cap.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL, param.getProperty("URL"));
		//DesiredCapabilities.internetExplorer().setCapability("ignoreProtectedModeSettings", true);
		//cap.setCapability("IE.binary", "C:/Program Files (x86)/Internet Explorer/iexplore.exe");
		//cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		//cap.setJavascriptEnabled(true);
		//cap.setCapability("requireWindowFocus", true);
		//cap.setCapability("enablePersistentHover", false);
		//driver = new InternetExplorerDriver(cap);
		//
		driver =new InternetExplorerDriver();
		break;
	case "Mozilla" :
		System.setProperty("webdriver.gecko.driver",
				System.getProperty("user.dir") + "//BrowserDrivers//geckodriver.exe");

		driver = new FirefoxDriver();
		break;
	default :
		Add_Log.error("No such Browser " + browser);
		//reportFailures("No such Browser " + browser);
		break;
	}
	
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
	driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
}


public void updateResultExcel(String testcase) {
	
	methodName=Thread.currentThread().getStackTrace()[1].getMethodName();
	Add_Log.info("\tExecuting - "+this.getClass().getSimpleName()+"."+methodName);	
	try {
		if (testSkip) {
			
			moudle1Excel.writeResult(testcase, "Pass/Fail/Skip", dataSet +1 , "SKIP");
			
			//Add_Log.info(TestCaseName + " :- Reporting test data set line '" + (DataSet + 1) + "' as SKIP In excel.");

			//Add_Log.info(TestCaseName + " :- *************************************************");
		} else if (testFail) {
			// To make object reference null after reporting In report.
			softAssert = null;
			
			testCaseStatus = false;
			moudle1Excel.writeResult(testcase, "Pass/Fail/Skip",  dataSet +1, "FAIL");
			
			//Add_Log.info(
				//	TestCaseName + " :- Reporting test data set line '" + (DataSet + 1) + "' as FAIL In excel.");

			//Add_Log.info(TestCaseName + " :- *************************************************");
		} else {
			
			moudle1Excel.writeResult(testcase, "Pass/Fail/Skip",  dataSet +1, "PASS");
			//Add_Log.info(
				//	TestCaseName + " :- Reporting test data set line '" + (DataSet + 1) + "' as PASS In excel.");

			//Add_Log.info(TestCaseName + " :- *************************************************");
		}
	} catch (Exception e) {
		System.out.println("Do Nothing");
	} finally {
		// At last make both flags as false for next data set.
		testSkip = false;
		testFail = false;
		//step_Number++;
	}
}

}
