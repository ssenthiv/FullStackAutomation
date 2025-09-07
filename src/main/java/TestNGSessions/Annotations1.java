package TestNGSessions;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Annotations1 {
	
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
	}
	//2
	@BeforeTest
	public void connectToDB(){
		System.out.println("\t@BeforeTest:- connect to DB");
	}
	
	
	
	//3
	@BeforeClass
	public void deleteCookies(){
		System.out.println("\t\t@BeforeClass:- delete cookies");
	}
	
	//4 -- will be executed before each and every test case
	@BeforeMethod
	public void login(){
		System.out.println("\n\t\t\t@BeforeMethod:- login to app");
	}
	
	//@Parameters({"browser"})
	@Test(priority=1)
	//public void homePageTitleTest(@Optional String browser){
	public void homePageTitleTest(){
		System.out.println("\t\t\t\tpriority=1:- home page title test");
		//System.out.println("\t\t\t"+browser);
	}
	
	@Test(priority=2)
	public void homePageTabTest(){
		System.out.println("\t\t\t\tpriority=2:- tab test");
	}
	
	@Test(priority=3)
	public void searchTest(){
		System.out.println("\t\t\t\tpriority=3:- search test");
	}
	
	@AfterMethod //-- will be executed after each and every test case
	public void logout(){
		System.out.println("\t\t\t@AfterMethod:- logout app");
	}
	
	@AfterClass
	public void deleteJunkCookies(){
		System.out.println("\n\t\t@AfterClass:- deleteJunkCookies");
	}
	
	@AfterTest
	public void disconnectToDB(){
		System.out.println("\t@AfterTest:- disconnectToDB");
	}
	
	@AfterSuite
	public void closeBrowser(){
		System.out.println("@AfterSuite:- Close browser");
	}
	

}
