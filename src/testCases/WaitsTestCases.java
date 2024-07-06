package testCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import BaseTest.TestBase;

public class WaitsTestCases extends TestBase {
	WebDriverWait wait;

	public void implicitWait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		for (int i = 0; i <= 5; i++) {
			System.out.println("appear after 10 seconds");
		}

	}

	public void explicitWait() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@class='wp-block-heading']")));
	}

	public void fluentWait() {
		
		WebElement javaScriptDelayBtn = driver
				.findElement(By.xpath("//a[text()='JavaScript Delays']"));

		try {
			javaScriptDelayBtn.click();
		} catch (ElementClickInterceptedException e) {
			javaScriptDelayBtn.click();
		}
		
		
		
		
	}

	public static void main(String[] args) {
		WaitsTestCases object = new WaitsTestCases();
		object.initialisation();
//		object.implicitWait();
		object.fluentWait();
	}
}
