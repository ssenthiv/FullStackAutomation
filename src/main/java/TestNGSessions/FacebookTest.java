package TestNGSessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FacebookTest {
	
WebDriver driver;
	
	@BeforeMethod
	//@BeforeTest
	public void setUp(){
		System.out.println("setup method");
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") +"/BrowserDrivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://www.facebook.com");
	}
	
	@Test(priority=1)
	public void facebookTitleTest(){
		System.out.println("test 2 method");
		String title = driver.getTitle();
		System.out.println("site title is: "+ title);
		Assert.assertNotEquals(title, "Facebook");
	}
	
	@Test(priority=1)
	public void test1() {
		System.out.println("test 1 method");
		Assert.assertTrue(true);
	}
	
	@AfterMethod
	//@AfterTest
	public void tearDown(){
		System.out.println("close the browser");
		driver.quit();
	}

}
