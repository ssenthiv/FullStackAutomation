package seleniumsessions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DynamicWebTableHandle {

	public static void main(String[] args) throws InterruptedException {

		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "/BrowserDrivers/chromedriver.exe");
		ChromeOptions co =new ChromeOptions();
		co.addArguments("--Headless");
		//WebDriver driver = new ChromeDriver(co); // launch chrome
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize(); // maximize window
		driver.manage().deleteAllCookies(); // delete all the cookies

		// dynamic wait
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://www.freecrm.com/"); // enter URL
		
		driver.findElement(By.name("username")).sendKeys("naveenk");
		driver.findElement(By.name("password")).sendKeys("test@123");
		Thread.sleep(3000);

		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		driver.switchTo().frame("mainpanel");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[contains(text(),'Contacts')]")).click();
		
		
		//Method-1:
		//String before_xpath = "//*[@id='vContactsForm']/table/tbody/tr[";
		//String after_xpath = "]/td[3]/a";
		//WebElement htmlTable=driver.findElement(By.xpath("//*[@id='vContactsForm']/table/tbody"));
		WebElement htmlTable=driver.findElement(By.cssSelector("[id='vContactsForm']>table tbody"));
		List<WebElement> rowList= htmlTable.findElements(By.tagName("tr"));
		List<WebElement> colList;
		for (int i=4; i< (rowList.size()-1); i++)
		{
			//System.out.print(i+rowList.get(i).getText()+ "--->");
			System.out.printf("%-5s",i+ ".");
			colList=rowList.get(i).findElements(By.tagName("td"));
			
		for (int j=1; j< 3; j++)
		//for (WebElement element : colList)
		{
			System.out.printf("%-20s",colList.get(j).getText());
			//System.out.printf("%-20s",element.getText());
			
		}
		System.out.println();
		}
		

		
		
		
		//Method-2:
		//driver.findElement(By.xpath("//a[contains(text(),'Amit')]//parent::td//preceding-sibling::td//input[@name='contact_id']")).click();
		//driver.findElement(By.xpath("//a[contains(text(),'Agnimitra')]//parent::td//following::tr/td//input[@name='contact_id']")).click();
		
		
		
		
		
		
		
		
		
		
	}

}
