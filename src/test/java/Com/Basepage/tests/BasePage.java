package Com.Basepage.tests;

import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;



//import com.firebase.utility.GenerateReports;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
	protected WebDriver driver;
	protected static WebDriverWait wait;
	//public static WebDriverWait wait = null;
	public BasePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void closeDriver() {
		driver.close();
	}
	
	public void closeAllDriver() {
		driver.quit();
	}
	/* name of the method:   enterText
	 * BriefDescription  :   entering textvalue for textbox
	 * Arguments         :  element-->web element
	 *                      text--->to be entered 
	 *            
	 *  createdby        :  Automation team 
	 *  created date     :01/20/22 
	 *  LastModified Date:01/20/22          
	 */
	public void enterText(WebElement element,String text) {
		waitUntilVisible(element);
		if(element.isDisplayed()) {
			clearElement(element);
			element.sendKeys(text);
			System.out.println("pass: text entered");
			
		}
		else {
			System.out.println("fail: element not displayed");
		}
	}
	public void clickElement(WebElement element) {
		if(element.isDisplayed()) {
			element.click();
			System.out.println("pass: element clicked");
		}
		else {
			System.out.println("fail: element not displayed");
		}
	}
	
	public void clearElement(WebElement element) {
		if(element.isDisplayed()) {
			element.clear();
			System.out.println("pass: element cleared");
		}
		else {
			System.out.println("fail: element not displayed");
		}
	}
	
	public void waitUntilVisible(WebElement element) {
		wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	public void waitUntilAlertIsPresent1() {
		wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.alertIsPresent());
	}
	
	public void mouseOver(WebElement element) {
		waitUntilVisible(element);
		Actions action=new Actions(driver);
		action.moveToElement(element).build().perform();
	}
	
	public String AcceptAlert() {
		waitUntilAlertIsPresent1();
		Alert alert=driver.switchTo().alert();
		String text=alert.getText();
		alert.accept();
		return text; 
		
	}
	public void dissmisAlert() {
		waitUntilAlertIsPresent1();
		Alert alert=driver.switchTo().alert();
		alert.dismiss();
		
	}
	public void selectByTextData(WebElement element,String text) {
		Select selectCity = new Select(element);
		selectCity.selectByVisibleText(text);
		
	}
	public void selectByIndexData(WebElement element,int index) {
		Select selectCity = new Select(element);
		selectCity.selectByIndex(index);
	}
	public void selectByValueData(WebElement element,String text) {
		Select selectCity = new Select(element);
		selectCity.selectByValue(text);
	}
	
	public String getTitleOfThePage() {
		return driver.getTitle();
	}
	public void closeAllBrowser() {
		driver.quit();
	}
	public void goToUrl(String url) {
		driver.get(url);
		driver.manage().window().maximize();
	}
	/*public static void waitUntilVisibilityOf(WebElement locator,String objname)
	{
	     wait = new WebDriverWait(driver,Duration.ofSeconds(30));
	     wait.until(ExpectedConditions.visibilityOf(locator));
	     
	}
	public static void waitUntil(Duration dur) {
	     wait = new WebDriverWait(driver, dur);

	}
	public static void waitUntilVisible(WebElement element,String objname)
	{
	     wait = new WebDriverWait(driver,Duration.ofSeconds(30));
	     wait.until(ExpectedConditions.visibilityOf(element));
	     
	}
	public static void waitUntilAlertIsPresent()
	{
	     wait = new WebDriverWait(driver,Duration.ofSeconds(30));
	     wait.until(ExpectedConditions.alertIsPresent());
	}*/
	/*public static String readText(WebElement element,String objname) {
	waitUntilVisible(element,objname);
	String text = element.getText();
			return text;
	}*/
	
	public void clickElement(WebElement element,String objname) {
		try {
		Thread.sleep(2000);
		}catch(Exception e) {
			
		}
		element.click();
		
	}
	public void assertEquals(Object one, Object two) throws Exception {
		try {
		Assert.assertEquals(one, two);
		System.out.println("Validation Passed");
		}catch(Exception e) {
			throw new Exception("FAIL: Validation failed");

		}
	}
		
	
	

}
