package datadriven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import util.Xls_Reader;

public class FreeCrmSignUp {
	
	public static void main(String args[]){
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//BrowserDrivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.freecrm.com/index.html");
		
		Xls_Reader reader = new Xls_Reader(System.getProperty("user.dir")
				+ "/src/main/java/testdata/FreeCrmTestData.xlsx");
		
		String sheetName = "login";
		
		int rowCount = reader.getRowCount(sheetName);
		System.out.println("total num of rows: "+ rowCount);
	
		int row;
		for(int rowNum=2; rowNum<=rowCount; rowNum++){
			String username = reader.getCellData(sheetName, "username", rowNum);
			row=reader.getCellRowNum(sheetName, "username", username);
			System.out.print(row+ " .");
			System.out.println(username);
			
			String password = reader.getCellData(sheetName, "password", rowNum);
			System.out.println(password);
			
			driver.findElement(By.name("username")).clear();
			driver.findElement(By.name("username")).sendKeys(username);
			
			driver.findElement(By.name("password")).clear();
			driver.findElement(By.name("password")).sendKeys(password);
			
			
		}
		
		
		
		
		
	}
	
	//1. poi depend
	//2. xls_reader
	//3. recording
	//4. code
	//testng.xml
	
	
	
	
	

}
