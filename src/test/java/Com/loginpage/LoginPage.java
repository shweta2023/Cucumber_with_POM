package Com.loginpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Com.Basepage.tests.BasePage;

public class LoginPage extends BasePage{
	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

//@FindBy(id = "username")
WebElement username = driver.findElement(By.id("username"));
@FindBy(id = "password")WebElement password;
@FindBy(name ="rememberUn")WebElement rememberme;
@FindBy(name = "Login")WebElement loginbutton;
@FindBy(id = "forgot_password_link")WebElement forgotpassword;


public void enterIntoUsername(String usrName) {
	enterText(username, usrName);
	
}
public void enterIntoPassword(String passwrd) {
	enterText(password, passwrd);
}
public void clickLoginButton() {
	clickElement(loginbutton);
}
public void clickrememberme() {
	clickElement(rememberme);
}
public void clickforgotpassword() {
	clickElement(forgotpassword);
}


public String handleAlert() {

	return AcceptAlert();
}
public void clearPassword() throws Exception {
	if(password.isDisplayed()) {
		password.clear();
	}else {
		throw new Exception("Fail: Password Box not displayed");
	}
}




}
