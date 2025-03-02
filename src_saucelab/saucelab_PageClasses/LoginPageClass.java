package saucelab_PageClasses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseTest.Saucelab_TestBase;

public class LoginPageClass extends Saucelab_TestBase {

	@FindBy(xpath = "//input[@id='user-name']")
	WebElement username;

	@FindBy(xpath = "//input[@id='password']")
	WebElement password;

	@FindBy(xpath = "//input[@id='login-button']")
	WebElement login_btn;

	// initialization of web element using pagefactory

	public LoginPageClass() {
		PageFactory.initElements(driver, this);
	}

//Page Actions 
	public HomePageClass verifyLoginPage(String usrname, String pass) {
		username.sendKeys(usrname);
		password.sendKeys(pass);
		login_btn.click();

		return new HomePageClass();

	}
	public void loginwiithstduser(String usrname,String pass) {
		username.sendKeys(usrname);
		password.sendKeys(pass);
		login_btn.click();
		
	}
}
