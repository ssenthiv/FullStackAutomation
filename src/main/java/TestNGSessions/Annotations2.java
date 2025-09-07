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

public class Annotations2 {
	
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
		System.out.println("@BeforeSuite:- launch browser2");
	}
	
	
	
	//2
	@BeforeTest
	public void connectToDB2(){
			System.out.println("	@BeforeTest:- connect to DB2");
		}
	//3
	@BeforeClass
	public void deleteCookies(){
		System.out.println("		@BeforeClass:- delete cookies2");
	}
	
	
	//4 -- will be executed before each and every test case
	@BeforeMethod
	public void login2(){
			System.out.println("\n			@BeforeMethod:- login2 to app2");
		}
	@Parameters({"browser"})
	@Test(priority=2)             
	//public void homePageTitleTest2(String str){
	public void homePageTitleTest2(){
		System.out.println("				priority=2:- home page title test2");
		//System.out.println("\t\t\t"+str);
	}
	
	@Test(priority=2)			
	public void homePageTabTest2(){
		System.out.println("				priority=2:- tab test2");
	}
	
	@Test(priority=2)			
	public void searchTest2(){
		System.out.println("				priority=2:- search test2");
	}
	
	@AfterMethod //-- will be executed after each and every test case
	public void logout(){
		System.out.println("			@AfterMethod:- logout app2");
	}
	
	@AfterClass
	public void deleteJunkCookies(){
		System.out.println("\n		@AfterClass:- deleteJunkCookies2");
	}
	
	@AfterTest
	public void disconnectToDB(){
		System.out.println("	@AfterTest:- disconnectToDB2");
	}
	
	@AfterSuite
	public void closeBrowser(){
		System.out.println("@AfterSuite:- Close browser2");
	}
	

}
