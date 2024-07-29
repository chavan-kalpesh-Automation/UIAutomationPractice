package testNGFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BaseTest.TestBase;

public class DataProvidersTestCases extends TestBase{

	DataProvidersTestCases object;
	@BeforeMethod
	public void initialisationMethod() {
		object=new DataProvidersTestCases();
		object.initialisation();
		
	}
	@Test
	public void fillFormPageTest() {
		WebElement fillform =driver.findElement(By.xpath("//a[text()='Form Fields']"));
		
	}
	@AfterMethod
	public void tearDown() {
//		driver.quit();
		
	}
}
