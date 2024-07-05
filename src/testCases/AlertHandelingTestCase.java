package testCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import BaseTest.TestBase;

public class AlertHandelingTestCase extends TestBase {

	WebDriverWait wait;

	public void SimpleAlertHandeling() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@class='container pt-1 pb-1']//h1[text()='Popups']")));

		WebElement alertPopup = driver.findElement(By.xpath("//button[@id='alert']//b[text()='Alert Popup']"));
		alertPopup.click();

		String alertText = driver.switchTo().alert().getText();
		if (alertText.equalsIgnoreCase("Hi there, pal!")) {
			System.out.println("Simple Alert is visible ;Test Case Passed");
			driver.switchTo().alert().accept();

		} else
			System.out.println("Simple Alert Test Case Failled ");
	}

	public void confirmPopupHandeling() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@class='container pt-1 pb-1']//h1[text()='Popups']")));

		WebElement confirmAlertPopup = driver
				.findElement(By.xpath("//button[@id='confirm']//b[text()='Confirm Popup']"));
		confirmAlertPopup.click();

		String alertText = driver.switchTo().alert().getText();
		if (alertText.equalsIgnoreCase("OK or Cancel, which will it be?")) {
			System.out.println("Confirm Alert is visible ;Test Case Passed");
			// accept popup
			driver.switchTo().alert().accept();
			// cancel popup
//			driver.switchTo().alert().dismiss();

		} else
			System.out.println("Confirm Alert Test Case Failled ");
	}

	public void promptAlertHandeling() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@class='container pt-1 pb-1']//h1[text()='Popups']")));

		WebElement promptalertPopup = driver
				.findElement(By.xpath("//button[@id='prompt']//b[text()='Prompt Popup']"));
		promptalertPopup.click();

		String alertText = driver.switchTo().alert().getText();
		if (alertText.equalsIgnoreCase("Hi there, what's your name?")) {
			driver.switchTo().alert().sendKeys("kalpesh");
			System.out.println("Confirm Alert is visible ;Test Case Passed");
			// accept popup
			driver.switchTo().alert().accept();
			// cancel popup
//			driver.switchTo().alert().dismiss();

		} else
			System.out.println("Confirm Alert Test Case Failled ");
	}

	public static void main(String[] args) {
		AlertHandelingTestCase object = new AlertHandelingTestCase();
		object.initialisation();
		WebElement popups = driver.findElement(By.xpath("//a[text()='Popups']"));
		popups.click();

//		object.SimpleAlertHandeling();
//		object.confirmPopupHandeling();
		object.promptAlertHandeling();

	}

}
