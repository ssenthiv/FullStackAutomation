package seleniumsessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class demoPOMTest {

	WebDriver driver;
	

	
	@Test
	public void clickAzaonPage(){
		
		System.setProperty("webdriver.chrome.driver", "F:\\Installable\\SightLine\\Workspace\\LearningSeleniumTestNg\\BrowserDrivers\\chromedriver.exe");
		driver=new ChromeDriver();
		
		demoPOMPage demoPage= PageFactory.initElements(driver, demoPOMPage.class);
		demoPage.invokeBrowser();
		demoPage.navigateCommands();
		
	}
	
	
}
