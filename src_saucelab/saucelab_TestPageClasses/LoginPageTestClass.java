package saucelab_TestPageClasses;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import BaseTest.Saucelab_TestBase;
import saucelab_PageClasses.LoginPageClass;

public class LoginPageTestClass extends Saucelab_TestBase{

	LoginPageClass loginpg;
	
	public LoginPageTestClass() {
		super();
	}
	@BeforeMethod
	public void setup() {
		sauceLab_initialization();
		 loginpg=new LoginPageClass();
	}
	
	@Test (dataProvider="data")
	public void logintosaucelab(String username,String passwod ) {
		loginpg.verifyLoginPage( username, passwod);
	}
	@DataProvider(name="data")
	public Object[][] dataSet1(){
		
		
		return new Object[][] {
			{"standard_user","secret_sauce"},
			{"locked_out_user","secret_sauce"},
			{"problem_user","secret_sauce"},
			{"performance_glitch_user","secret_sauce"}
		
		};
		
	}
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
	
}
