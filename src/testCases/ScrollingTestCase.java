package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import BaseTest.TestBase;

public class ScrollingTestCase extends TestBase {
	public static void main(String[] args) {

		ScrollingTestCase object =new ScrollingTestCase();
		object.initialisation();
		
		WebElement spinnersbutton =driver.findElement(By.xpath("//a[text()='Spinners']"));
		
		JavascriptExecutor js =(JavascriptExecutor)driver;
		
		js.executeScript("arguments[0].scrollIntoView();", spinnersbutton);
		
		
	}
}
