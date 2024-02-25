package TestCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import BaseTest.TestBase;

public class FillForm extends TestBase {

	public void formfillup() {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement formfieldbtn = driver.findElement(By.xpath("//a[text()='Form Fields']"));

		formfieldbtn.click();

		
		
		// Waiting till the page load for that check web page title

		WebElement formfieldstitle = driver.findElement(By.xpath("//div//h1[text()='Form Fields']"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(formfieldstitle));

		// form fill up start

		// Name Field
		WebElement name = driver.findElement(By.xpath("//input[@name='name']"));
		name.sendKeys("John smith");

		// What's your fav. drink selection check box (check specific check box)

		WebElement waterchkbox = driver.findElement(By.xpath("//input[@value='Water']"));

		WebElement winechkbox = driver.findElement(By.xpath("//input[@value='Wine']"));

		waterchkbox.click();

		winechkbox.click();

		// What is your favorite color?
		WebElement redclrradiobtn = driver.findElement(By.xpath("//input[@value='Red']"));
		redclrradiobtn.click();

		// Do you have any siblings?
		// Drop down selection

		WebElement sibling = driver.findElement(By.xpath("//select[@name='siblings']"));

		Select siblingdropdown = new Select(sibling);

		siblingdropdown.selectByValue("yes");

		// email field
		WebElement email = driver.findElement(By.xpath("//input[@name='email']"));
		email.sendKeys("john@yopmail.com");

		// Message
		WebElement message = driver.findElement(By.xpath("//textarea[@name='message']"));
		message.sendKeys("This is Test Message ");

		// after filling all the information we have to wait for clicking submit button

		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// submit button
		WebElement submit = driver.findElement(By.xpath("//button[@id='submit-btn']"));

		js.executeScript("window.scrollTo(0, arguments[0].offsetTop);", submit);

		Actions act=new Actions(driver);
		act.moveToElement(submit).click().build().perform();

//		wait.until(ExpectedConditions.elementToBeClickable(submit));
//		submit.click();

		// after successful submission one success alert pop there to accept

		driver.switchTo().alert().accept();

		System.out.println("Test Successfully Passed!!!");
		
	}

	public static void main(String[] args) {
		FillForm obj = new FillForm();
		obj.initialisation();
		obj.formfillup();

	}

}
