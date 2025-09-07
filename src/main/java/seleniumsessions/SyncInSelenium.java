package seleniumsessions;

import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.Function;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SyncInSelenium {
	WebDriver driver;
	
	@BeforeClass
	public void invokingBrowser(){
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "/BrowserDrivers/chromedriver.exe");
		 driver = new ChromeDriver();
		
		
	}
	
	//@Test
	public  void usingFreeCRM() throws InterruptedException {

		
		
		driver.get("http://www.freecrm.com");
		
		driver.manage().window().maximize();
		
		//only for browser page loading
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS); 
		
		//for all the elements -- global wait -- implicit wait
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//explicit wait:
		//used for the specific element
		
		
		WebElement username = driver.findElement(By.name("username"));
		sendKeys(driver, username, 5, "naveenk");
		
		
		long startTime=0;
		long elapsedTime=0;
		try{
			
		//Date dt= Calendar.getInstance().getTime();
		 startTime=System.currentTimeMillis();
			new WebDriverWait(driver, 3).ignoring(WebDriverException.class).
		until(ExpectedConditions.presenceOfElementLocated(By.name("passwor")));
		elapsedTime =( System.currentTimeMillis() - startTime);
		System.out.println("Elapsed Time for presenceOfElement : "+ elapsedTime + " milliseconds" );
		
		
		}catch (org.openqa.selenium.TimeoutException e){
		elapsedTime =( System.currentTimeMillis()-startTime);
		System.out.println("Elapsed Time  : "+ elapsedTime/1000 );
		//e.printStackTrace();
		
		try{
		startTime=System.currentTimeMillis();
		new WebDriverWait(driver, 3).ignoring(WebDriverException.class).
		until(ExpectedConditions.visibilityOfElementLocated(By.name("assword")));
		elapsedTime =( System.currentTimeMillis() - startTime);
		System.out.println("Elapsed Time for visibility : "+ elapsedTime + " milliseconds" );
		}catch (org.openqa.selenium.TimeoutException e2){
		elapsedTime =( System.currentTimeMillis()-startTime);
		System.out.println("Elapsed Time  : "+ elapsedTime/1000 );
		//e2.printStackTrace();
		
		try{
			startTime=System.currentTimeMillis();
			new WebDriverWait(driver, 3).ignoring(WebDriverException.class).
			until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(By.name("password"))));
			elapsedTime =( System.currentTimeMillis() - startTime);
			System.out.println("Elapsed Time for clickable : "+ elapsedTime + " milliseconds" );
			}catch (org.openqa.selenium.TimeoutException e3){
			elapsedTime =( System.currentTimeMillis()-startTime);
			System.out.println("Elapsed Time  : "+ elapsedTime/1000 );
			e3.printStackTrace();
			}
		
		}
		}
		
		//WebElement signUp = driver.findElement(By.linkText("Sign Up"));
		
		
		//Thread.sleep(5000);
		//clickOn(driver, signUp,5);
		
	}
	
	

	public static void clickOn(WebDriver driver, WebElement element, int timeout) {
	
		/*
		@SuppressWarnings("deprecation")
		Wait wait=new FluentWait(driver).withTimeout(timeout,TimeUnit.SECONDS).
						pollingEvery(1, TimeUnit.SECONDS).
						ignoring(WebDriverException.class);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		*/
		 new WebDriverWait(driver, timeout).ignoring(WebDriverException.class).
		until(ExpectedConditions.elementToBeClickable(element));
		System.out.println("Wait is over");
		element.click();
	}
	
	public static void sendKeys(WebDriver driver, WebElement element, int timeout, String value) {
		new WebDriverWait(driver, timeout).
		until(ExpectedConditions.visibilityOf(element));
		
		
		element.sendKeys(value);
	}
	
	public static String getElementText(WebDriver driver, WebElement element, int timeout) {
		new WebDriverWait(driver, timeout).
		until(ExpectedConditions.visibilityOf(element));
		return element.getText();
	}
	
	
	
	//@Test(priority=1)
	public void usingWebDriverWait() throws InterruptedException{
		
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");

		
		driver.manage().window().maximize();
		
		//only for browser page loading
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS); 
		
		//for all the elements -- global wait -- implicit wait
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.manage().timeouts().setScriptTimeout(-1, TimeUnit.SECONDS);
		//-------------------------------
		
		//    1. alertIsPresent() 
		// click on submit
		 driver.findElement(By.cssSelector("input[type=submit][value=Go]")).click();
		 //Thread.sleep(1000);
		 
		new WebDriverWait(driver,50).ignoring(WebDriverException.class).
		until(ExpectedConditions.alertIsPresent());
		
		
		 Alert alert=driver.switchTo().alert();
		 alert.accept();
		 
		 
		 // 2. presenceOfElementLocated
		//  partial link text: only for links -- not recommended -- V
		 driver.findElement(By.partialLinkText("Create a new")).click();
		 
		 driver.findElement(By.cssSelector("input[name^=name]")).sendKeys("Shunmugasundaram");
		 driver.findElement(By.cssSelector("input[name^=login]")).sendKeys("ssenthiv");
		 
		
		 long startTime=0;
			long elapsedTime=0;
			try{
				
			
			 startTime=System.currentTimeMillis();
				new WebDriverWait(driver, 3).ignoring(WebDriverException.class).
			until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[type=button][name^=btnchkavail][value='heck availability']")));
			elapsedTime =( System.currentTimeMillis() - startTime);
			System.out.println("Elapsed Time for presenceOfElement : "+ elapsedTime + " milliseconds" );
			
			
			}catch (org.openqa.selenium.TimeoutException e){
			elapsedTime =( System.currentTimeMillis()-startTime);
			System.out.println("Elapsed Time for presenceOfElement  : "+ elapsedTime/1000 );
			
			
			// 3. visibilityOfElementLocated
			try{
			startTime=System.currentTimeMillis();
			new WebDriverWait(driver, 3).ignoring(WebDriverException.class).
			until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type=button][name^=tnchkavail][value='Check availability']")));
			
			elapsedTime =( System.currentTimeMillis() - startTime);
			System.out.println("Elapsed Time for visibility : "+ elapsedTime + " milliseconds" );
			}catch (org.openqa.selenium.TimeoutException e2){
			elapsedTime =( System.currentTimeMillis()-startTime);
			System.out.println("Elapsed Time for visibility  : "+ elapsedTime/1000 );
			
			
			// 4. elementToBeClickable
			try{
				startTime=System.currentTimeMillis();
				new WebDriverWait(driver, 3).ignoring(WebDriverException.class).
				until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type=button][name^=btnchkavail][value='Check availability']"))));
			
				elapsedTime =( System.currentTimeMillis() - startTime);
				System.out.println("Elapsed Time for clickable : "+ elapsedTime + " milliseconds" );
				}catch (org.openqa.selenium.TimeoutException e3){
				elapsedTime =( System.currentTimeMillis()-startTime);
				System.out.println("Elapsed Time for clickable : "+ elapsedTime/1000 );
				}
			
			}
			}
		 driver.findElement(By.cssSelector("input[type=button][name^=btnchkavail][value='Check availability']")).click();
		
		 
		 
		// 5. elementSelectionStateToBe		 
				 
		 WebElement chkAltEmail=driver.findElement(By.cssSelector("input[type=checkbox][name^=chk_altemail]"));
		 try {
			 startTime=System.currentTimeMillis();
			 
			 new WebDriverWait(driver,6).ignoring(WebDriverException.class).
			 until(ExpectedConditions.elementSelectionStateToBe(chkAltEmail, true));	 
		 }catch (org.openqa.selenium.TimeoutException e){
			 elapsedTime =( System.currentTimeMillis()-startTime);
			 System.out.println("Elapsed Time for elementSelectionStateToBe : "+ elapsedTime/1000 );
			 
			 driver.findElement(By.cssSelector("input[type=checkbox][name^=chk_altemail]")).click(); 
		 }
		  
		 
		 // 6. elementToBeSelected
		 
		 try {
			 startTime=System.currentTimeMillis();
			 new WebDriverWait(driver,6).ignoring(WebDriverException.class).
			 until(ExpectedConditions.elementSelectionStateToBe(By.cssSelector("select[id=country] option[label=India]"), false));

			 elapsedTime =( System.currentTimeMillis()-startTime);
			 System.out.println("Elapsed Time for elementToBeSelected : "+ elapsedTime + " milliseconds" );
		 }catch (org.openqa.selenium.TimeoutException e){
			 elapsedTime =( System.currentTimeMillis()-startTime);
			 System.out.println("Elapsed Time for elementToBeSelected : "+ elapsedTime/1000 );
		 }
		 Select selectCountry=new Select(driver.findElement(By.cssSelector("select#country")));
		 selectCountry.selectByVisibleText("India");
		 System.out.println("Selected entry in country : " + selectCountry.getFirstSelectedOption().getText());
	}

//@Test(priority=2)
public void usingFluentWait() throws InterruptedException{
		
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");

		
		driver.manage().window().maximize();
		
		//only for browser page loading
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS); 
		
		//for all the elements -- global wait -- implicit wait
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//-------------------------------
		
		//    1. alertIsPresent() 
		// click on submit
		 driver.findElement(By.cssSelector("input[type=submit][value=Go]")).click();
		 //Thread.sleep(1000);
		 
		 new FluentWait(driver).ignoring(WebDriverException.class)
								.withTimeout(3, TimeUnit.SECONDS).pollingEvery(1, TimeUnit.SECONDS).
									until(ExpectedConditions.alertIsPresent());
		
		
		 Alert alert=driver.switchTo().alert();
		 alert.accept();
		 
		 
		 // 2. presenceOfElementLocated
		//  partial link text: only for links -- not recommended -- V
		 driver.findElement(By.partialLinkText("Create a new")).click();
		 
		 driver.findElement(By.cssSelector("input[name^=name]")).sendKeys("Shunmugasundaram");
		 driver.findElement(By.cssSelector("input[name^=login]")).sendKeys("ssenthiv");
		 
		
		 long startTime=0;
			long elapsedTime=0;
			try{
				
			
			 startTime=System.currentTimeMillis();
				new FluentWait(driver).ignoring(org.openqa.selenium.NoSuchElementException.class).
								withTimeout(3, TimeUnit.SECONDS).pollingEvery(1, TimeUnit.SECONDS).
								until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[type=button][name^=btnchkavail][value='heck availability']")));
			elapsedTime =( System.currentTimeMillis() - startTime);
			System.out.println("Elapsed Time for presenceOfElement : "+ elapsedTime + " milliseconds" );
			
			
			}catch (org.openqa.selenium.TimeoutException e){
			elapsedTime =( System.currentTimeMillis()-startTime);
			System.out.println("Elapsed Time for presenceOfElement  : "+ elapsedTime/1000 );
			
			
			// 3. visibilityOfElementLocated
			try{
			startTime=System.currentTimeMillis();
			new FluentWait(driver).ignoring(org.openqa.selenium.NoSuchElementException.class).
										withTimeout(3, TimeUnit.SECONDS).pollingEvery(1, TimeUnit.SECONDS).
										until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type=button][name^=tnchkavail][value='Check availability']")));
										//until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("input[type=button][name^=tnchkavail][value='Check availability']"))));
			elapsedTime =( System.currentTimeMillis() - startTime);
			System.out.println("Elapsed Time for visibility : "+ elapsedTime + " milliseconds" );
			}catch (org.openqa.selenium.TimeoutException e2){
			elapsedTime =( System.currentTimeMillis()-startTime);
			System.out.println("Elapsed Time for visibility  : "+ elapsedTime/1000 );
			
			
			// 4. elementToBeClickable
			try{
				startTime=System.currentTimeMillis();
				new FluentWait(driver).
											withTimeout(3, TimeUnit.SECONDS).pollingEvery(1, TimeUnit.SECONDS).
											until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("input[type=button][name^=btnchkavail][value='Check availability']")))));
			
				elapsedTime =( System.currentTimeMillis() - startTime);
				System.out.println("Elapsed Time for clickable : "+ elapsedTime + " milliseconds" );
				}catch (org.openqa.selenium.TimeoutException e3){
				elapsedTime =( System.currentTimeMillis()-startTime);
				System.out.println("Elapsed Time for clickable : "+ elapsedTime/1000 );
				}
			
			}
			}
		 driver.findElement(By.cssSelector("input[type=button][name^=btnchkavail][value='Check availability']")).click();
		
		 
		 
		// 5. elementSelectionStateToBe		 
				 
		 WebElement chkAltEmail=driver.findElement(By.cssSelector("input[type=checkbox][name^=chk_altemail]"));
		 try {
			 startTime=System.currentTimeMillis();
			 
			 new FluentWait(driver).ignoring(WebDriverException.class).
			 			withTimeout(3, TimeUnit.SECONDS).pollingEvery(1, TimeUnit.SECONDS).
			 			until(ExpectedConditions.elementSelectionStateToBe(chkAltEmail, true));	 
		 }catch (org.openqa.selenium.TimeoutException e){
			 elapsedTime =( System.currentTimeMillis()-startTime);
			 System.out.println("Elapsed Time for elementSelectionStateToBe : "+ elapsedTime/1000 );
			 
			 driver.findElement(By.cssSelector("input[type=checkbox][name^=chk_altemail]")).click(); 
		 }
		 
		 
		 // 6. elementToBeSelected
		 
		 try {
			 startTime=System.currentTimeMillis();
			 new FluentWait(driver).ignoring(WebDriverException.class).
			 							withTimeout(3, TimeUnit.SECONDS).pollingEvery(1, TimeUnit.SECONDS).
			 							until(ExpectedConditions.elementSelectionStateToBe(By.cssSelector("select[id=country] option[label=India]"), false));

			 elapsedTime =( System.currentTimeMillis()-startTime);
			 System.out.println("Elapsed Time for elementToBeSelected : "+ elapsedTime + " milliseconds" );
		 }catch (org.openqa.selenium.TimeoutException e){
			 elapsedTime =( System.currentTimeMillis()-startTime);
			 System.out.println("Elapsed Time for elementToBeSelected : "+ elapsedTime/1000 );
		 }
		 Select selectCountry=new Select(driver.findElement(By.cssSelector("select#country")));
		 System.out.println("Selected entry in country : " + selectCountry.getFirstSelectedOption().getText());
		 selectCountry.selectByVisibleText("Italy");
		 	
	
	}

@Test(priority=3)
public void usingW3schools() throws InterruptedException{
		
		driver.get("https://www.w3schools.com/xml/tryit.asp?filename=tryajax_callback");

		
		driver.manage().window().maximize();
		
		//only for browser page loading
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS); 
		
		//for all the elements -- global wait -- implicit wait
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//-------------------------------
		
		
		List<WebElement> frameList=driver.findElements(By.tagName("iframe"));
		Iterator<WebElement> itrElement=frameList.iterator();
		/*
		System.out.println("size : "+ frameList.size());
		while ( itrElement.hasNext()){
			System.out.println(itrElement.next().getAttribute("name"));
		}
		*/
		// 1. frameToBeAvailableAndSwitchToIt
		new FluentWait(driver).ignoring(WebDriverException.class).
								withTimeout(5, TimeUnit.SECONDS).pollingEvery(1, TimeUnit.SECONDS).
								until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("iframeResult")));
		
		WebElement button = driver.findElement(By.xpath("//div[@id='demo']"));
		System.out.println("Button text : "+ button.getText().trim());
		button.findElement(By.xpath("//button[@type='button']")).click();
		
		// 2. visibilityOf
		
		 long startTime=0;
			long elapsedTime=0;
		
				
			
		startTime=System.currentTimeMillis();
		try {
		new FluentWait(driver).ignoring(WebDriverException.class).
				withTimeout(6, TimeUnit.SECONDS).pollingEvery(1, TimeUnit.SECONDS).
				//until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@id='demo']/p[2]")));
				until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//div[@id='demo']/p[1]"))));
		 elapsedTime =( System.currentTimeMillis()-startTime);
		 System.out.println("Elapsed Time for visibility : "+ elapsedTime + " milliseconds" );
		}catch (Exception e){
			
			elapsedTime =( System.currentTimeMillis()-startTime);
			System.out.println("Elapsed Time for visibility : "+ elapsedTime/1000  );
			//e.printStackTrace();
			
			
			//3. FluentWait with Function<WebElement,String>
			startTime=System.currentTimeMillis();
			try {
			new FluentWait<WebElement>(driver.findElement(By.xpath("//div[@id='demo']/p[2]"))).
					withTimeout(6, TimeUnit.SECONDS).pollingEvery(1, TimeUnit.SECONDS).
					 until(new Function<WebElement,Boolean>(){
						@Override
						public Boolean apply(WebElement element){
							int len=element.findElement(By.xpath("//div[@id='demo']/p[2]")).getText().trim().length();
							if (len==50)
								return true;
							else
								return false;
							
						}
					});
					
			 elapsedTime =( System.currentTimeMillis()-startTime);
			 System.out.println("Elapsed Time for Function : "+ elapsedTime + " milliseconds" );
			}catch (Exception e2){
				
				elapsedTime =( System.currentTimeMillis()-startTime);
				System.out.println("Elapsed Time for Function : "+ elapsedTime/1000  );
				//e2.printStackTrace();
				
				
				//4. FluentWait with Lambda Function<WebElement,String>
				startTime=System.currentTimeMillis();
				try {
				new FluentWait<WebElement>(driver.findElement(By.xpath("//div[@id='demo']/p[2]"))).
						withTimeout(6, TimeUnit.SECONDS).pollingEvery(1, TimeUnit.SECONDS).
						 until((x)->  {
							 int len=x.findElement(By.xpath("//div[@id='demo']/p[2]")).getText().trim().length();
								if (len==62)
									return true;
								else
									return false;
						 });
						
				 elapsedTime =( System.currentTimeMillis()-startTime);
				 System.out.println("Elapsed Time for Function lambda : "+ elapsedTime + " milliseconds" );
				}catch (Exception e3){
					
					elapsedTime =( System.currentTimeMillis()-startTime);
					System.out.println("Elapsed Time for Function : "+ elapsedTime/1000  );
					//e3.printStackTrace();
				}
			}
		}
		
		System.out.println("Para text : "+ driver.findElement(By.xpath("//div[@id='demo']//following::p[3]")).getText().trim());
		System.out.println("Para text : "+ driver.findElement(By.xpath("//div[@id='demo']//p/following::*")).getText().trim().length());
		System.out.println("Para text : "+ driver.findElement(By.xpath("//div[@id='demo']/p[3]/preceding::p[1]")).getText().length());
		

}
	
}
