package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import util.JavaScriptUtil;

public class JavaScriptExecutorConcept {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//BrowserDrivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://www.freecrm.com");
		driver.navigate().refresh();
		
//		JavascriptExecutor js = (JavascriptExecutor)driver;
//		js.executeScript(script, args);
		
		String title = JavaScriptUtil.getTitleByJS(driver);
		System.out.println(title);
		
		WebElement signUpLink = driver.findElement(By.linkText("Sign Up"));
		//JavaScriptUtil.clickElementByJS(signUpLink, driver);
		
		//JavaScriptUtil.generateAlert(driver, "Hey this is my code");
		
		//refreshBrowserByJS(driver);
		
		//String pageText = getPageInnerText(driver);
		//System.out.println(pageText);
		
		//scrollPageDown(driver);
		WebElement forgotPwd = driver.findElement(By.linkText("Forgot Password?"));
		JavaScriptUtil.scrollIntoView(forgotPwd, driver);
		
		WebElement login = driver.findElement(By.xpath("//input[@type='submit']"));
		//flash(login, driver);
		 Thread.sleep(5000);
		JavaScriptUtil.drawBorder(login, driver);
		JavaScriptUtil.drawBorder(driver.findElement(By.linkText("Sign Up")), driver);
		
		Thread.sleep(5000);
		JavaScriptUtil.changeColor("green", login, driver);
		JavaScriptUtil.changeColor("red", driver.findElement(By.linkText("Sign Up")), driver);
		/*
		Thread.sleep(5000);
		JavaScriptUtil.flash(login, driver);
		JavaScriptUtil.flash(driver.findElement(By.linkText("Sign Up")), driver);
		*/
	}
	
	

}
