package testCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import BaseTest.TestBase;

public class Calendars_Selection extends TestBase {

	public void date_Of_Birth_Selection(String monthYear, String date) {
		WebElement calendarbtn = driver.findElement(By.xpath("//div//a[text()='Calendars']"));

		// Scrolling up to calendar button because btn not showing on page we have to
		// scroll
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView();", calendarbtn);

		// wait till the page scroll and element visibility
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(calendarbtn));

		Actions act = new Actions(driver);
		act.click(calendarbtn).build().perform();

		WebElement calendartitle = driver.findElement(By.xpath("//section//h1[text()='Calendars']"));

		wait.until(ExpectedConditions.visibilityOf(calendartitle));

		WebElement calendar = driver.findElement(
				By.xpath("//label[text()='Select or enter a date (YYYY-MM-DD)']//following-sibling::input"));

		act.click(calendar).build().perform();

		
		while (true) {
			String monthYearPicker = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
			
			if ((monthYearPicker.equals(monthYear))) {
				break;
			
			} 
			else {
				WebElement click = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']"));
			click.click();
			}
		}
		
		driver.findElement(By.xpath("//a[text()='" + date + "']")).click();

	}

	public static void main(String[] args) {
		Calendars_Selection obj = new Calendars_Selection();
		obj.initialisation();
		obj.date_Of_Birth_Selection("January 1995", "2");

	}

}
