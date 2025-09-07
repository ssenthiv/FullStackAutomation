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

public class ParallelExecution2 {
	
	 private String methodName;
	 private String indent="";
	
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
	synchronized public void getMethodName(String tab, long id){
		methodName=this.getClass().getSimpleName();
		methodName=methodName+"."+Thread.currentThread().getStackTrace()[2].getMethodName();
		System.out.println(indent+tab+"t"+id+":"+methodName+"()");
	}
	//1
	//@BeforeSuite
	public void beforeSuite(){
		long id = Thread.currentThread().getId();
		getMethodName("",id);
		System.out.println(""+indent+"t"+id+":"+"- launch browser");
		
		
	}
	//2
	//@BeforeTest
	public void beforeTest(){
		long id = Thread.currentThread().getId();
		getMethodName("\t",id);
		System.out.println(""+indent+"t"+id+":"+"- connect to DB");
		
	}
	
	
	
	//3
	//@BeforeClass
	public void beforeClass(){
		long id = Thread.currentThread().getId();
		getMethodName("\t\t",id);
		System.out.println(""+indent+"t"+id+":"+"- delete cookies");
		
	}
	
	//4 -- will be executed before each and every test case
	@BeforeMethod
	public void beforeMethod(){
		long id = Thread.currentThread().getId();
		getMethodName("\t\t\t",id);
        System.out.println(""+indent+"t"+id+":"+"- login");
	}
	
	@Parameters({"browser"})
	//@Test(invocationCount=2,threadPoolSize=2,timeOut=2050)
	@Test
	public void method1(String browser) {
		long id = Thread.currentThread().getId();
		getMethodName("\t\t\t\t",id);
		try{
			Thread.sleep(2000);	
		}catch(InterruptedException ie){
			ie.printStackTrace();
		}
		System.out.println("\t\t\t\t"+indent+"t"+id+":"+browser);

	}
	
	@Test
	public void method2() throws InterruptedException{
		long id = Thread.currentThread().getId();
		getMethodName("\t\t\t\t",id);
       
	}
	
	@Test
	public void method3() throws InterruptedException{
		long id = Thread.currentThread().getId();
		getMethodName("\t\t\t\t",id);
	}
	
	@AfterMethod //-- will be executed after each and every test case
	public void afterMethod(){
		long id = Thread.currentThread().getId();
		getMethodName("\t\t\t",id);
		System.out.println(""+indent+"t"+id+":"+"- logout");
	}
	
	//@AfterClass
	public void afterClass(){
		long id = Thread.currentThread().getId();
		getMethodName("\t\t",id);
		System.out.println(""+indent+"t"+id+":"+"- deleteJunkCookies");
	}
	
	//@AfterTest
	public void afterTest(){
		long id = Thread.currentThread().getId();
		getMethodName("\t",id);
		System.out.println(""+indent+"t"+id+":"+"- disconnectToDB");
	}
	
	//@AfterSuite
	public void afterSuite(){
		long id = Thread.currentThread().getId();
		getMethodName("",id);
		System.out.println(""+indent+"t"+id+":"+"- closeBrowser");
	}
	

}
