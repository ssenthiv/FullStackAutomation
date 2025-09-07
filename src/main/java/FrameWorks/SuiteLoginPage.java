/* This is Page class for Testing Form */

package FrameWorks;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;





public class SuiteLoginPage extends Base {
	String methodName;
	String TestCaseName;
	static {
		 Add_Log.info("\tExecuting - Static block -"+ SuiteLoginPage.class.getName());

	 }
	
	public SuiteLoginPage(WebDriver driver, String testCase){
		this.TestCaseName=testCase;
		this.driver=driver;
		methodName=Thread.currentThread().getStackTrace()[1].getMethodName();
		Add_Log.info("\tExecuting SuiteLoginPage constructor- "+ this.getClass().getSimpleName()+"."+methodName);
		PageFactory.initElements(driver, this);
		
	}
	
	//Object repositories
	/*
	@FindBy(id="firstname")
	WebElement TestingForm_FirstName;
	*/
		
	
	public void submitLoginPage(){
		
		Add_Log.info(TestCaseName + ":- Submitted Login Page ");
				
	}
	public SuiteModule1Page navigateToModule(String url){
		
		driver.get(url);
	
		Add_Log.info(TestCaseName + ":- navigated to url : "+ url);
		return new SuiteModule1Page(driver,TestCaseName);		
	}
	
	
	
	
	
	

}
