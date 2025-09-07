package seleniumsessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class mouseHoveringActions {

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
	
	@Test
	public void mouseHoverOnLink(){
		
		try {
				String url = "https://www.amazon.in/";
				
				driver.get(url);
				System.out.println("Browser Title : " + driver.getTitle());
				System.out.println("Current URL :" + driver.getCurrentUrl());
				
				 
				 WebElement category1 = driver.findElement(By.xpath("//div[@id='nav-shop']//span[@class='nav-line-2']"));
				 WebElement category2 =driver.findElement(By.xpath("//a[@id='nav-link-shopall']//span[@class='nav-line-2']"));
				 
	
				 
			
				
				
				Actions action=new Actions(driver);
				
				//action.moveToElement(category1).build().perform();
				action.moveToElement(category2).build().perform();
				
				WebElement mensFashion=driver.findElement(By.xpath("//div[@class='nav-template nav-flyout-content nav-tpl-itemList']//span[text()=\"Men's Fashion\"]"));
				action.moveToElement(mensFashion).build().perform();
				WebElement clothing=driver.findElement(By.xpath("//a[contains(@href,'Mens-Clothing')]//span[text()='Clothing']"));
				Thread.sleep(3000);
				action.moveToElement(clothing).click().build().perform();
				
				System.out.println("Browser Title : " + driver.getTitle());
				System.out.println("Current URL :" + driver.getCurrentUrl());
				
				
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
