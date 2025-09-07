package seleniumsessions;

import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class useElementLocators {

	WebDriver driver;
	JavascriptExecutor je;
	
	@BeforeClass
	public void invokeBrowser(){
		
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "\\BrowserDrivers\\chromedriver.exe");
		driver=new ChromeDriver();
		//driver.get("https://www.edureka.co/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
		
	}
	//@Test
	public void elementLocatorTechniquesAmazon(){
		
		String url="https://www.amazon.in/";
		driver.navigate().to(url);
		
		driver.findElement(By.linkText("Your Amazon.in")).click();
		driver.navigate().back();
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Lenova laptop");
		driver.findElement(By.className("nav-input")).submit();
		driver.navigate().back();
		driver.findElement(By.partialLinkText("Customer"));
		
		
		
		
	}
	//@Test
	public void elementLocatorTechniquesFacebook() throws InterruptedException{
		
		String url="https://www.facebook.com/";
		driver.navigate().to(url);
		//driver.findElement(By.name("firstname")).sendKeys("shunmugasundaram");
		driver.findElement(By.cssSelector("input[name=firstname]")).sendKeys("shunmugasundaram");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input[name=firstname]")).clear();
		driver.findElement(By.cssSelector("input[name=firstname]")).sendKeys("Senthivelu");
		driver.findElement(By.cssSelector("input#email")).sendKeys("abc@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input[id=email][name=email][type=email]")).clear();
		driver.findElement(By.cssSelector("input[id=email][name=email][type=email]")).sendKeys("zyz@gmail.com");
		//driver.findElement(By.cssSelector("input.inputtext")).sendKeys("abc@gmail.com");  // will not work as it is not identifying unique class
		driver.findElement(By.cssSelector("input#pass")).sendKeys("password");
		
		je=(JavascriptExecutor)driver;
		
		je.executeScript("scroll(0,1000)");
	}
	
	@Test
	public void reddifLogin() throws InterruptedException{
		
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");

		// css Selector -III
		 driver.findElement(By.cssSelector("input[type=submit][value=Go]")).click();
		 Thread.sleep(1000);
		 try{ 
		 Alert alert=driver.switchTo().alert();
		 alert.accept();
		 }catch (NoAlertPresentException nap){
			 
		 }

		// 6. partial link text: only for links -- not recommended -- V
		 driver.findElement(By.partialLinkText("Create a new")).click();
		 Thread.sleep(1000);
		 try{ 
		 Alert alert=driver.switchTo().alert();
		 alert.accept();
		 }catch (NoAlertPresentException nap){
			 
		 }
		
		 // 4. cssSelector - III
		 driver.findElement(By.cssSelector("input[name^=name]")).sendKeys("Shunmugasundaram");
		 driver.findElement(By.cssSelector("input[name^=login]")).sendKeys("ssenthiv");
		 driver.findElement(By.cssSelector("input[type=button][name^=btnchkavail][value='Check availability']")).click();
		 driver.findElement(By.cssSelector("input[type=password][name^=passwd]")).sendKeys("passwd");
		 driver.findElement(By.cssSelector("input[type=password][name^=confirm_passwd]")).sendKeys("passwd");
		 driver.findElement(By.cssSelector("input[type=checkbox][name^=chk_altemail]")).click();
		 
		 Select selectQuestion=new Select(driver.findElement(By.cssSelector("select[name^=hintq]")));
		 List<WebElement> optionList=selectQuestion.getOptions();
		 System.out.println("Total options : "+ optionList.size());
		 for(WebElement element : optionList)
			 System.out.println(element);
		 
		 selectQuestion. selectByIndex(1);
		 Thread.sleep(1000);
		 selectQuestion.selectByValue("What is your favourite food?");
		 Thread.sleep(1000);
		 selectQuestion.selectByVisibleText("What is your favourite pass-time?");
		 driver.findElement(By.cssSelector("input[type=password][name^=hint]")).sendKeys("Sendhu");
		 driver.findElement(By.cssSelector("input[name^=mothername]")).sendKeys("ssenthiv");
		 driver.findElement(By.cssSelector("input#mobno")).sendKeys("9899894244");
		 
		 Select selectDay=new Select(driver.findElement(By.cssSelector("select[name^=DOB_Day]")));
		 selectDay. selectByIndex(26);
		 Select selectMonth=new Select(driver.findElement(By.cssSelector("select[name^=DOB_Month]")));
		 selectMonth.selectByValue("02");
		 Select selectYear=new Select(driver.findElement(By.cssSelector("select[name^=DOB_Year]")));
		 selectYear.selectByVisibleText("1977");
		 
		 driver.findElement(By.cssSelector("input[type=radio][name^=gender][value=m]")).click();
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("//input[@type='radio'][@value='f'][starts-with(@name,'gender')]")).click();
		 
		 Select selectCountry=new Select(driver.findElement(By.cssSelector("select#country")));
		 selectCountry.selectByVisibleText("India");
		 
		 Select selectCity=new Select(driver.findElement(By.cssSelector("select[name^=city]")));
		 selectCity.selectByIndex(9);
		 // 1. id: -- I
		//driver.findElement(By.id("login1")).sendKeys("testNaveen@rediff.com");
		//driver.findElement(By.id("password")).sendKeys("test@1234");

		// WebElement username = driver.findElement(By.id("login1"));
		// username.sendKeys("test@rediff.com");
		//
		// WebElement password = driver.findElement(By.id("password"));
		// password.sendKeys("test@123");

		// 2. name: -- I, II
		// driver.findElement(By.name("login")).sendKeys("test@rediff.com");
		// driver.findElement(By.name("passwd")).sendKeys("test@123");

		// 3. xpath -- address of any web element -- III
		// driver.findElement(By.xpath("//*[@id='login1']")).sendKeys("test@rediff.com");
		// driver.findElement(By.xpath("//*[@id='password']")).sendKeys("test@123");

		// 4. cssSelector: -- III
		// driver.findElement(By.cssSelector("#login1")).sendKeys("test@rediff.com");
		// driver.findElement(By.cssSelector("#password")).sendKeys("test@123");
		
		// 5. linkText: only for links -- IV
		// driver.findElement(By.linkText("Create a new account")).click();

		// 6. partial link text: only for links -- not recommended -- V
		// driver.findElement(By.partialLinkText("Create a new")).click();

		// 7. className: not recommended, sometimes it may produce duplicate elements -- IV
		//driver.findElement(By.className("submitbtn")).click();
		
		
	
	}
}
