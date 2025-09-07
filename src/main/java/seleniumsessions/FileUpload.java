package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUpload {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//BrowserDrivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://encodable.com/uploaddemo/");
		
//		driver.findElement(By.id("uploadname1")).sendKeys("/Users/NaveenKhunteta/Documents/myJS/package.json");
		
		driver.findElement(By.id("uploadname1")).click();      // Use sendKeys to select file 
															   // this will work when <input type="file"   

		
	}

}
