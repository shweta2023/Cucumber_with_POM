package Com.loginpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Com.Basepage.tests.BasePage;

public class ForgotPassword extends BasePage {
	
	public ForgotPassword(WebDriver driver) {
		super(driver);
	}
	@FindBy(id = "un")WebElement username;
	@FindBy(name ="cancel")WebElement cancel;
	@FindBy(id = "continue")WebElement Continue;
	@FindBy(className = "primary")WebElement Returntologin;
	
	public void enterIntoUsername(String usrName) {
		enterText(username, usrName);
		
	}
	
	public void clickContinue() {
		 clickElement(Continue,"Continue");
	
	}
	public void clickCancel() {
		clickElement(cancel,"cancel");
	}
	
	public void clickReturntologin() {
		clickElement(Returntologin,"Return To Login");
		
	}
	
	
	
	

}
