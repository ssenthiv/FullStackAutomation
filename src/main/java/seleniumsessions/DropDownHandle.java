package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownHandle {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//BrowserDrivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.facebook.com/");
		
		Select select1 = new Select(driver.findElement(By.id("day")));
		select1.selectByVisibleText("5");
		select1.selectByIndex(4);
		
		Select select2 = new Select(driver.findElement(By.id("month")));
		select2.selectByVisibleText("Feb");
		//select2.selectByValue("Feb"); 
		select2.selectByIndex(1);
		
		Select select3 = new Select(driver.findElement(By.id("year")));
		select3.selectByVisibleText("1990");
		
		List<WebElement> days = select1.getOptions();
		System.out.println("total number of days: "+ (days.size()-1));
		
		for(int i=1; i<days.size(); i++){
			System.out.println(days.get(i).getText());
		}
		
		System.out.println("******");
		
		List<WebElement> months = select2.getOptions();
		System.out.println("total number of months: "+ (months.size()-1));
		
		for(int i=1; i<months.size(); i++){
			System.out.println(months.get(i).getText());
		}
		
		
		
		
		
		
	}

}
