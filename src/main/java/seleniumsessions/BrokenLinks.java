package seleniumsessions;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks {

	
	public static void main(String[] args) throws InterruptedException, MalformedURLException, IOException{
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//BrowserDrivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	
		
		driver.get("http://www.freecrm.com/");
		//driver.findElement(By.name("username")).sendKeys("naveenk");
		//driver.findElement(By.name("password")).sendKeys("test@123");
		driver.findElement(By.name("username")).sendKeys("ssenthiv");
		driver.findElement(By.name("password")).sendKeys("0smSSms#");
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.switchTo().frame("mainpanel");
		Thread.sleep(2000);
		
		
		// 1. Get list of all links and images
		
		List<WebElement> linksList=driver.findElements(By.tagName("a"));
		linksList.addAll(driver.findElements(By.tagName("img")));
		
		List<WebElement> activeLinks= new ArrayList<WebElement>();
		
		// 2. Iterate linksLinst
		
		for(int i=0;i<linksList.size();i++)
		{
		
			if (( linksList.get(i).getAttribute("href") != null ) && (! linksList.get(i).getAttribute("href").contains("javascript"))){
				
				activeLinks.add(linksList.get(i));
			}
		}

		//  get the size of activelinks
		
		System.out.println("size of active links and images" + activeLinks.size());
		
		// 3. Connect the href url with HttpURLConnection api
		
		// 200 -- OK
		// 404 -- not found
		// 500 -- internal error
		for (int i=0;i<activeLinks.size();i++){
			
	
		HttpURLConnection connection=(HttpURLConnection) new URL(activeLinks.get(i).getAttribute("href")).openConnection();
		
		System.out.println(activeLinks.get(i).getAttribute("href"));
		try {
			connection.connect();
			String response=connection.getResponseMessage();
			connection.disconnect();
			
			if (! response.contains("OK"))
			System.out.println(activeLinks.get(i).getAttribute("href") + "--->" +response );
			
		}catch (UnknownHostException ue) {
			System.out.println("ignoring UnKnownException");
		} 
		catch (Exception e) {
			System.out.println("ignoring Exception");
		}
		
		}
	}
	
}
