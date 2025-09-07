package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BackAndForwardButtonSimulation {

	public static void main(String[] args) {
	

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//BrowserDrivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver(); // launch chrome
		
		driver.get("https://www.google.com/");//Enter URL
		driver.manage().window().maximize();
		
		driver.navigate().to("http://www.rediff.com/");
		
		driver.navigate().back();
		
		driver.navigate().forward();
		
		driver.navigate().back();
		
		driver.navigate().refresh();
		
		
		
		
		
	}

}
