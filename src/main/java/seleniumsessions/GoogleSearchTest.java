package seleniumsessions;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleSearchTest {

	public static void main(String[] args) throws MalformedURLException, IOException {

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//BrowserDrivers//chromedriver.exe");

		WebDriver driver = new ChromeDriver(); // launch chrome

		driver.manage().window().maximize(); // maximize window
		driver.manage().deleteAllCookies(); // delete all the cookies

		// dynamic wait
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("http://www.google.com");
		
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Java");
		//WebElement listBox=driver.findElement(By.xpath("//ul[@role='listbox']//li/descendant::div[@class='sbqs_c']"));
		//WebDriverWait wait=(WebDriverWait) new WebDriverWait(driver,10).ignoring(WebDriverException.class).
					//					until(ExpectedConditions.elementToBeClickable(listBox));
		
		List<WebElement> list = driver.findElements(By.xpath("//ul[@role='listbox']//li/descendant::div[@class='sbtc']"));
		
		System.out.println("total number of suggestions in search box:::===>" + list.size());
		
		for(int i=0; i<list.size(); i++){
			System.out.println(list.get(i).getText());
			if(list.get(i).getText().contains("java tutorial")){
				list.get(i).click();
				break;
			}
			
		}
		String html=driver.findElement(By.tagName("body")).getText();
		
		System.out.println(html.contains("java programming"));
		
		// WebElement navDiv=driver.findElement(By.id("navcnt"));
		
				List<WebElement>	linksList=		driver.findElement(By.id("navcnt")).findElement(By.xpath("/descendant::tr")).findElements(By.tagName("a"));
				List<String> hrefList=new ArrayList<>();
				for (WebElement link: linksList){
					
					String href= link.getAttribute("href");
					System.out.println(href);
					hrefList.add(href);
					
				}
		
				for (String link : hrefList){
					/*
					HttpURLConnection httpUrl=(HttpURLConnection)new URL(link).openConnection(); 
					httpUrl.connect();
					html=httpUrl.getContent().toString();
					System.out.println(html);
					httpUrl.disconnect();
					*/
					driver.get(link);
					System.out.println(driver.findElement(By.tagName("body")).getText().contains("Java programming"));
					
				}
		
		
	}

}
