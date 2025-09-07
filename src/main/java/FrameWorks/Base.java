package FrameWorks;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.SkipException;
import org.testng.asserts.SoftAssert;

//import com.company1.utility.SuiteUtility;

//import com.company1.utility.SuiteUtility;

//import com.company1.utility.Read_XLS;

public class Base {
	private String methodName;
	 Read_XLS globalModulesExcel;
	 static Read_XLS moudle1Excel;
	 String[] TestDataToRun;
	 int dataSet=-1;
	 static boolean testFail=false;
	 boolean testSkip=false;
	 boolean testCaseStatus=true;
	 static SoftAssert softAssert;
	  WebDriver driver;
	 //static RemoteWebDriver driver;
	 static Logger Add_Log=null;
	 public static Properties param;
	 public static String TestCaseName;
	void init(){
		methodName=Thread.currentThread().getStackTrace()[1].getMethodName();
		System.out.println("\tExecuting - "+ this.getClass().getSuperclass().getSuperclass().getSimpleName()+"."+methodName);
		
		Date date=Calendar.getInstance().getTime();
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy_hh-mm-ss");
		
		System.setProperty("logfile.name",
				System.getProperty("user.dir") + "\\src\\main\\resources\\Logging\\applog_" + sdf.format(date));
		//PropertyConfigurator.configure("src\\main\\resources\\config\\log4j.properties");
		System.out.println("\tLogfile=" +System.getProperty("logfile.name"));
		Add_Log = Logger.getLogger("rootLogger");
		
		param=new Properties();
		FileInputStream fis;
		try {
			 fis=new FileInputStream(System.getProperty("user.dir")+ 
					"\\src\\main\\resources\\config\\Param.properties");
			param.load(fis);
			fis.close();
		} catch (FileNotFoundException  e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}

		
		globalModulesExcel=new Read_XLS(
				System.getProperty("user.dir") + "\\src\\main\\resources\\ExcelFiles\\Global.xls");
	}
	
	void initModule1ReadXLS(){
		methodName=Thread.currentThread().getStackTrace()[1].getMethodName();
		//System.out.println("\tExecuting - "+ this.getClass().getSuperclass().getSuperclass().getSimpleName()+"."+methodName);
		Add_Log.info("Executing - "+ this.getClass().getSimpleName()+"."+methodName);
		moudle1Excel=new Read_XLS(
				System.getProperty("user.dir") + "\\src\\main\\resources\\ExcelFiles\\Module1.xls");

	}
	
	public void reportFailures(String msg) {
		testFail = true;
		Add_Log.info(this.getClass().getSimpleName() + ":- " + msg);
		//System.out.println(msg);
		softAssert.fail("\n" + msg);
	}
	
	public void testClosure(String testCase) {
		methodName=Thread.currentThread().getStackTrace()[1].getMethodName();
		Add_Log.info("\tExecuting - "+this.getClass().getSimpleName()+"."+methodName);	
		try {
			Add_Log.info("******************************** End of Execution for :- " + TestCaseName
					+ " *************************************");

			if (testCaseStatus) {
				moudle1Excel.writeResult("TestCasesList", "Pass/Fail/Skip", testCase, "PASS");
				
			} else {
				moudle1Excel.writeResult("TestCasesList", "Pass/Fail/Skip", testCase, "FAIL");
			}
		} catch (Exception e) {
			System.out.println("Do Nothing");
		} finally {
			// Reset all flags and counters to default value.
			dataSet = -1;
			softAssert = null;
			testCaseStatus = true;
			//step_Number = 1;
			testFail = false;

			// To Close the web browser at the end of test.
			System.out.println("/tClosing Browser");;
		}
	}
	
	// Call this function to close the browser
			public void closeWebBrowser() {
				methodName=Thread.currentThread().getStackTrace()[1].getMethodName();
				Add_Log.info("\tExecuting - "+ this.getClass().getSuperclass().getSimpleName()+"."+methodName);
				try {
					try {
						driver.close();
					} catch (Exception e) {
						Add_Log.info("Exception in Close browser code. ");
						Add_Log.info("Details of failure are:- " + e.getLocalizedMessage());
					} finally {
						//browserLoaded = false;
						driver=null;
					}

					// To kill the browser processes
					try {
						// To close the browser instance.
						if (param.getProperty("testBrowser").equals("Chrome")) {
							Runtime.getRuntime().exec("taskkill /F /IM chrome.exe");
						} else if (param.getProperty("testBrowser").equals("IE")) {
							Runtime.getRuntime().exec("taskkill /F /IM iexplore.exe");
						} else if (param.getProperty("testBrowser").equals("Mozilla")) {
							Runtime.getRuntime().exec("taskkill /F /IM firefox.exe");
						}
						Thread.sleep(5000);
					} catch (Throwable e) {
						Add_Log.info("Exception in Kill browser code. ");
						Add_Log.info("Details of failure are:- " + e.getLocalizedMessage());
					}

				} catch (Throwable e) {
					Add_Log.info("Exception in closeWebBrowser function ");
					Add_Log.info("Details of failure are:- " + e.getLocalizedMessage());
				} finally {
					// null browser Instance when close.
					//ExistingchromeBrowser = null;
					//ExistingmozillaBrowser = null;
					//ExistingIEBrowser = null;
					driver=null;
				}
			}
	
}
