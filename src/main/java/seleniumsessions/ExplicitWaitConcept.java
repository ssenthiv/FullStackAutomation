package seleniumsessions;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ExplicitWaitConcept {

	public static void main(String[] args) {

		ChromeOptions co = new ChromeOptions();
		co.addArguments("--headless");
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//BrowserDrivers//chromedriver.exe");
//		WebDriver driver = new ChromeDriver(co); // launch chrome
		WebDriver driver = new ChromeDriver(); // launch chrome

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

		driver.get("http://www.facebook.com");
		
		clickOn(driver, driver.findElement(By.xpath("//input[@value='Log In' and @type='submit']")), 20);//login button
		//driver.findElement(By.xpath("//a[@href='r.php?locale=en_GB']")).click();
		clickOn(driver, driver.findElement(By.xpath("//*[@id='u_0_2']//a")), 10); //create a page link
		
		
	}
	
	
	
	public static void clickOn(WebDriver driver, WebElement locator, int timeout) {
		new WebDriverWait(driver, timeout).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(locator));
		//new WebDriverWait(driver, timeout).ignoring(NoSuchElementException.class).until(ExpectedConditions.visibilityOf(locator));

		
		locator.click();
	}

}
