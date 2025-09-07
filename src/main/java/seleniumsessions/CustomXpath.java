package seleniumsessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CustomXpath {
	WebDriver driver;
	
	@BeforeClass
	public  void invokeBrowser() {

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "/BrowserDrivers/chromedriver.exe");
		
		 driver = new ChromeDriver(); //launch chrome
		
		driver.manage().window().maximize(); //maximize window
		driver.manage().deleteAllCookies(); //delete all the cookies
		
		//dynamic wait
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		 //enter URL

		//absolute xpath: not recommended
		//*[@id='headersearchbar']/div/div[2]/table/tbody/tr/td[2]/input
		//1. performance issue
		//2. not reliable
		//3. can be changed at any time in future
		
		//driver.findElement(By.xpath("//input[@class='actextbox']")).sendKeys("Java");
		
		//driver.findElement(By.xpath("//input[@name='query']")).sendKeys("Java");
		
		//driver.findElement(By.xpath("//input[contains(@class,'actextbox')]")).sendKeys("Java");
		
		//dynamic id: input
		//id = test_123
		//By.id("test_123")
		
		//starts-with
		//id = test_456
		//id = test_789
		//id = test_test_7890_test
		
		//ends-with
		//id = 1234_test_t
		//id = 23456_test_t
		//id = 6789_test_t
		
	//	driver.findElement(By.xpath("//input[contains(@id,'test_')]")).sendKeys("Test");
//		driver.findElement(By.xpath("//input[starts-with(@id,'test_')]")).sendKeys("Test");
//		driver.findElement(By.xpath("//input[ends-with(@id,'_test_t')]")).sendKeys("Test");
		
		//for links: custom xpath:
		//all the links are represented by <a> html tag:
	//	driver.findElement(By.xpath("//a[contains(text(),'My Account')]")).click();
		
		
		
		
	}

@Test
public void ebayXpath() throws InterruptedException{
	
	driver.get("http://www.half.ebay.com");
	
	driver.findElement(By.xpath("//input[contains(@placeholder,'Search for anything')]")).sendKeys("men's fashion");
	driver.findElement(By.xpath("//input[@type='submit'][@value='Search']")).click();
	//Thread.sleep(3000);
	WebElement divElement=driver.findElement(By.xpath("//img[contains(@alt,'Ripped Skinny Jeans')]"));
	System.out.println(divElement.getAttribute("alt"));
	System.out.println("you are here");
	//System.out.println("1. Parent = " +divElement.findElement(By.xpath("parent::a")).getAttribute("href"));
	System.out.println("2. Ancestor = " +divElement.findElement(By.xpath("ancestor::a")).getAttribute("href"));
	System.out.println("3. Ancestor = " +divElement.findElement(By.xpath("ancestor::li")).getAttribute("id"));
	System.out.println("4. Following = " +divElement.findElement(By.xpath("ancestor::li/following::li")).getAttribute("id"));
	System.out.println("5. Following = " +divElement.findElement(By.xpath("ancestor::li/following::li[5]")).getAttribute("id"));
	System.out.println("6. Sibling = " +divElement.findElement(By.xpath("ancestor::li/following-sibling::li[5]//a")).getAttribute("href"));
	System.out.println("7. preceding-sibling = " +divElement.findElement(By.xpath("ancestor::li/following-sibling::li[5]/preceding-sibling::li[1]//a")).getAttribute("href"));
	//System.out.println("8. AND  = " +divElement.findElement(By.xpath("//li[@id='srp-river-results-listing1']or ancestor::li ")).getAttribute("id"));

	
	
}
}
