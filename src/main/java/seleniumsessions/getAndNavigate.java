package seleniumsessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class getAndNavigate {
WebDriver driver;

@BeforeMethod
public void invokeBrowser(){
	
	
	System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//BrowserDrivers//chromedriver.exe");
	driver=new ChromeDriver();
	//driver.get("https://www.edureka.co/");
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
	driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
	
}
//@Test
public void getCommands(){
	
		try {
			String url = "https://www.amazon.in/";

			driver.get(url);
			System.out.println("Browser Title : " + driver.getTitle());
			driver.findElement(By.linkText("Today's Deals")).click();
			System.out.println("Browser Title : " + driver.getTitle());
			System.out.println("Current URL :" + driver.getCurrentUrl());
			// System.out.println(" Page source: " + driver.getPageSource());
		} catch (Exception e) {

			e.printStackTrace();
		}
}

@Test
public void navigateCommands(){
	
	try {
		String url = "https://www.amazon.in/";
		driver.navigate().to(url);
		System.out.println("Step #1");
		//Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='nav-link-shopall']/span[2]")).click();
		System.out.println("Step #2");
		//Thread.sleep(2000);
		driver.navigate().back();
		System.out.println("Step #3");
		//Thread.sleep(2000);
		driver.navigate().forward(); 
		Thread.sleep(2000);
		driver.navigate().back();
		
		Thread.sleep(2000);
		driver.navigate().forward(); 
		Thread.sleep(2000);
		driver.navigate().refresh();
	} catch (Exception e) {
		
		e.printStackTrace();
	}
	
	
}
//@AfterMethod
public void closeBrower(){
	
	System.out.println("close browser");
	driver.close();
	
}

}
