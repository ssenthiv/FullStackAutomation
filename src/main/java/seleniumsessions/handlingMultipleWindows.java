package seleniumsessions;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class handlingMultipleWindows {
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
public void getCommands(){
	
		try {
			String url = "https://www.amazon.in/";
			
			driver.get(url);
			System.out.println("Browser Title : " + driver.getTitle());
			System.out.println("Current URL :" + driver.getCurrentUrl());
			
			// String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,"t");
			// driver.findElement(By.linkText("Today's Deals")).sendKeys(Keys.CONTROL,"t");    //Not working for chrome , because send keys are directly sent to rederprocess bypassing browser process
			String linkUrl=driver.findElement(By.linkText("Today's Deals")).getAttribute("href");
			String linkUrl2=driver.findElement(By.linkText("Your Amazon.in")).getAttribute("href");
			System.out.println("linkURL1 : "+linkUrl);
			System.out.println("linkURL2 : "+linkUrl2);
			String parentWinHandle=driver.getWindowHandle();
			System.out.println("Parent Handle :"+parentWinHandle);
			
			JavascriptExecutor js= (JavascriptExecutor) driver;
			js.executeScript("window.open(arguments[0],'_blank');", linkUrl);
			//js.executeScript("window.open(arguments[0],'_blank');", linkUrl2);
			js.executeScript("window.open(arguments[0]);", linkUrl2);
			Set<String> winSet =driver.getWindowHandles();
			
			for( String win : winSet){
				
				if (!win.equals(parentWinHandle)){
				driver.switchTo().window(win);
				System.out.println("New window Title : " + driver.getTitle());
				//System.out.println("New window URL :" + driver.getCurrentUrl());
				System.out.println("close Window");
				driver.close();
				}
			}
			driver.switchTo().window(parentWinHandle);
			
			
			//Thread.sleep(3000);
			

			//driver.findElement(By.linkText("Your Amazon.in")).sendKeys(Keys.CONTROL,"t");
			
			// System.out.println(" Page source: " + driver.getPageSource());
		} catch (Exception e) {

			e.printStackTrace();
		}
}


@AfterMethod
public void closeBrower(){
	
	System.out.println("close browser");
	driver.close();
	
}

}
