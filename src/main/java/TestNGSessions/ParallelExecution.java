package TestNGSessions;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParallelExecution {
	
	/*
	 * launch browser
	    connect to DB
		delete cookies
			login to app
				home page title test
			logout app
			login to app
				home page tab test
			logout app
			login to app
				search test
			logout app
	deleteJunkCookies
	disconnectToDB
	Close browser
	 * 
	 */
	
	//1
	@BeforeSuite
	public void launchBrowser(){
		System.out.println("@BeforeSuite:- launch browser");
		long id = Thread.currentThread().getId();
        System.out.println(" Thread id is: " + id);
	}
	//2
	@BeforeTest
	public void connectToDB(){
		System.out.println("\t@BeforeTest:- connect to DB");
		long id = Thread.currentThread().getId();
        System.out.println(" Thread id is: " + id);
	}
	
	
	
	//3
	@BeforeClass
	public void deleteCookies(){
		System.out.println("\t\t@BeforeClass:- delete cookies");
		long id = Thread.currentThread().getId();
        System.out.println(" Thread id is: " + id);
	}
	
	//4 -- will be executed before each and every test case
	@BeforeMethod
	public void login(){
		System.out.println("\n\t\t\t@BeforeMethod:- login to app");
		long id = Thread.currentThread().getId();
        System.out.println(" Thread id is: " + id);
	}
	
	@Parameters({"browser"})
	@Test
	public void homePageTitleTest(String browser) throws InterruptedException{
		Thread.sleep(5000);
		System.out.println("\t\t\t\tpriority=1:- home page title test");
		System.out.println("\t\t\t"+browser);
		long id = Thread.currentThread().getId();
        System.out.println(" Thread id is: " + id);
	}
	
	@Test
	public void homePageTabTest() throws InterruptedException{
		Thread.sleep(5000);
		System.out.println("\t\t\t\tpriority=2:- tab test");
		long id = Thread.currentThread().getId();
        System.out.println(" Thread id is: " + id);
	}
	
	@Test
	public void searchTest() throws InterruptedException{
		Thread.sleep(5000);
		System.out.println("\t\t\t\tpriority=3:- search test");
		long id = Thread.currentThread().getId();
        System.out.println(" Thread id is: " + id);
	}
	
	@AfterMethod //-- will be executed after each and every test case
	public void logout(){
		System.out.println("\t\t\t@AfterMethod:- logout app");
		long id = Thread.currentThread().getId();
        System.out.println(" Thread id is: " + id);
	}
	
	@AfterClass
	public void deleteJunkCookies(){
		System.out.println("\n\t\t@AfterClass:- deleteJunkCookies");
		long id = Thread.currentThread().getId();
        System.out.println(" Thread id is: " + id);
	}
	
	@AfterTest
	public void disconnectToDB(){
		System.out.println("\t@AfterTest:- disconnectToDB");
		long id = Thread.currentThread().getId();
        System.out.println(" Thread id is: " + id);
	}
	
	@AfterSuite
	public void closeBrowser(){
		System.out.println("@AfterSuite:- Close browser");
		long id = Thread.currentThread().getId();
        System.out.println(" Thread id is: " + id);
	}
	

}
