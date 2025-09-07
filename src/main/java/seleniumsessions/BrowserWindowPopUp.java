package seleniumsessions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.internal.ExitCode;

public class BrowserWindowPopUp {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//BrowserDrivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://www.popuptest.com/goodpopups.html");
		
		driver.findElement(By.xpath("//a[text()='Good PopUp #1']")).click();
		driver.findElement(By.xpath("//*[text()='Good PopUp #2']")).click();
		//driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/td/font/b/a[3]")).click();
		driver.findElement(By.cssSelector("html>body>table+br+br+br+table>tbody>tr>td>font>b a+br+br+a+br+br+a")).click();
		driver.findElement(By.xpath("//*[text()='Good PopUp #4']")).click();
		
		Thread.sleep(3000);
		
		Set<String> handles = driver.getWindowHandles();
		
		Iterator<String> it = handles.iterator();
		String parentWin=driver.getWindowHandle();
		driver.switchTo().window(it.next());
		
		while (it.hasNext()){
		
			driver.switchTo().window(it.next());
			System.out.println("title of  window is: "+ driver.getTitle());
			System.out.println("URL of  window is: "+ driver.getCurrentUrl());
			driver.close(); //close the pop up window
		}
		
		/*
		 	
		System.out.println("title of parent window is: "+ driver.getTitle());
		
			*/
		
		driver.switchTo().window(parentWin);
		driver.close();
		
		
		
		
		
		
		
	}

}
