package Com.Steps;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Utilities.CommonUtilities;
import Com.Basepage.tests.BasePage;
import Com.Homepage.tests.HomePage;
import Com.loginpage.ForgotPassword;
import Com.loginpage.LoginPage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
// extends TestNGRunCucumberTest ---------->if you capublic class firebaseloginTeckarchStepDefinition {
	
public class SalesforceloginStepDefinition{
	WebDriver driver;
	BasePage bp = new BasePage(driver);
	LoginPage login;
	HomePage home;
	ForgotPassword fpwd;
	CommonUtilities CU = new CommonUtilities();
    Properties applicationPropertiesFile = CU.loadfile("applicationProperties");
    String url = CU.getApplicationProperty("url",applicationPropertiesFile);
    String usrname = CU.getApplicationProperty("usrname",applicationPropertiesFile);
	String passwrd = CU.getApplicationProperty("passwrd",applicationPropertiesFile);
	String invalidusername = CU.getApplicationProperty("invalid-usrname",applicationPropertiesFile);
	String invalidpasswrd = CU.getApplicationProperty("invalid-passwrd",applicationPropertiesFile);
	@Before(order=0)
	public void setUp1() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		
	}
	@Before(order=1) // we can have multiple befores and afters using order parameter mention order sequence
	public void setUp2() {
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.manage().window().maximize();

}

@Given("User open Salesforce application")
public void user_open_salesforce_application() {
	driver.get(url);
}

@When("user on {string}")
public void user_on(String page) {
	 if(page.equalsIgnoreCase("loginpage"))
	    	login=new LoginPage(driver);
	    else if(page.equalsIgnoreCase("homepage"))
	    	home=new HomePage(driver);
}

@When("User enters username into text box")
public void user_enters_username_into_text_box() {
	
	login.enterIntoUsername(usrname);
	
	System.out.println("user name entered");
}

@When("user clear textbox password")
public void user_clear_textbox_password() throws Exception {
   login.clearPassword();
   System.out.println("Password field cleared!");
}
@When("User enters wrongpaswd into text box")
public void user_enters_wrongpaswd_into_text_box() {
  	
	 login.enterIntoPassword(invalidpasswrd);

}
@When("User enters wrongusername into text box")
public void user_enters_wrongusername_into_text_box() {
	login.enterIntoUsername(invalidusername);
	
}
  	



@When("click on login button")
public void click_on_login_button() {
	login.clickLoginButton();
	System.out.println("PASS: Log in button clicked.");
} 
@When("User enters paswd into text box")
public void user_enters_paswd_into_text_box() {
   login.enterIntoPassword(passwrd);

}
@When("User clicks on {string}")
public void user_clicks_on(String Remembermecheckbox) {
	login.clickrememberme();
}

@When("user menu")
public void user_menu() {
	home.clickuserMenu();
	
}

@When("user logout")
public void user_logout() {
	home.logout();
	
}
@When("user clicks on forgot password")
public void user_clicks_on_forgot_password() {
	login.clickforgotpassword();
}

@When("click on continue" )
public void click_on_continue() {
	fpwd.clickContinue();
}




@Then("verify {string} {string} displayed")
public void verify_displayed(String expected,String id) throws Exception {
	 WebElement actuala = driver.findElement(By.id(id));
	    String actual = actuala.getText();
	    bp.assertEquals(actual, expected);
}


	
	
	

	
	@After
	public void tearDown() {
		driver.quit();
	}

	
	
}
