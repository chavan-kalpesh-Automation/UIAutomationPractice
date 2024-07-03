package testCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import BaseTest.TestBase;

public class CheckBoxHandeling extends TestBase {

	public static void main(String[] args) {

		CheckBoxHandeling object = new CheckBoxHandeling();
		object.initialisation();

		
		WebElement formFieldbtn=driver.findElement(By.xpath("//div//a[text()='Form Fields']"));
		
		formFieldbtn.click();
		
		WebElement title =driver.findElement(By.xpath("//div//h1[text()='Form Fields']"));
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		
		wait.until(ExpectedConditions.visibilityOf(title));
		
		//Single Click in check box 
		WebElement checkbox=driver.findElement(By.xpath("//input[@id='drink1']"));
		
		checkbox.click();
		
		if(checkbox.isSelected()) {
			System.out.println("CheckBox is Checked;Test Case Passed.");
		}
		else
			System.out.println("CheckBox is Not Checked;Test Case Failed.");	
		
		driver.close();
		
	
	}

		
	
	
}
