package seleniumsessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class demoPOMPage {

WebDriver driver;
	
//@FindBy(xpath="//*[@id='nav-link-shopall']/span[2]")
@FindBy(how=How.XPATH,using="//*[@id='nav-link-shopall']/span[2]")
WebElement search;

public demoPOMPage(WebDriver ldriver){
	
	this.driver=ldriver;
}
//@BeforeTest
public void invokeBrowser(){
	
	
	
	driver.get("https://www.amazon.in/");
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
	driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
	
}	

//@Test
public void navigateCommands(){
		
		try {
			
			System.out.println("Step #1");
			//Thread.sleep(2000);
		    search.click();
			System.out.println("Step #2");
			Thread.sleep(2000);
			driver.navigate().back();
			System.out.println("Step #3");
			//Thread.sleep(2000);
			driver.navigate().forward(); 
			driver.navigate().refresh();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
	}
}
