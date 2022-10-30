package Com.Homepage.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Com.Basepage.tests.BasePage;

public class HomePage extends BasePage{
	
	@FindBy(id = "userNav")WebElement name;
	@FindBy(xpath = "//*[@id=\"userNav-menuItems\"]/a[1]")WebElement myprofile;
	@FindBy(xpath = "//*[@id=\"userNav-menuItems\"]/a[2]")WebElement mysettings;
	@FindBy(xpath = "//*[@id=\"userNav-menuItems\"]/a[5]")WebElement logout;
	@FindBy(id = "userNavButton")WebElement usermenu;
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	public void clickName() {
		 waitUntilVisible(name);	
		 clickElement(name,"Name");
			
	 }
	public void clickMyProfile() {
		 waitUntilVisible(myprofile);	
		 clickElement(myprofile,"myProfile");
	}
	public void clickuserMenu() {
		 waitUntilVisible(usermenu);	
		 clickElement(usermenu,"UserMenu");
			
	 }
	
	
	
	
	
	public void logout() {
		clickName() ;
		waitUntilVisible(logout);	
		clickElement(logout,"logout");
	}
	/*public void dropdownselect() {
	
		clickLogout();		
	*/}
	


