package seleniumsessions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class handlingFrames {

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
	public void switchToFrames(){
		
		try {
				String url = "http://toolsqa.com/iframe-practice-page/";
				
				driver.get(url);
				System.out.println("Browser Title : " + driver.getTitle());
				System.out.println("Current URL :" + driver.getCurrentUrl());
				
				List<WebElement> frameList=driver.findElements(By.tagName("iframe"));
				 
				System.out.println("Total frame ="+ frameList.size());
				
				for ( WebElement frame : frameList ){
					
					driver.switchTo().frame(frame);
					List<WebElement> iTags=driver.findElements(By.tagName("iframe"));
					driver.switchTo().defaultContent();
					System.out.println(frame.getAttribute("name")+" =" + iTags.size());
					
					
				}
				
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
