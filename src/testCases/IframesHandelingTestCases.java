package testCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import BaseTest.TestBase;

public class IframesHandelingTestCases extends TestBase {

	public void iframeHandeling() {

		WebElement iframesbtn = driver.findElement(By.xpath("//a[text()='Iframes']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", iframesbtn);
		try {
			iframesbtn.click();
		} catch (ElementClickInterceptedException e) {
			iframesbtn.click();

		}
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Iframes']")));

		//Switching to i-frame
		WebElement firstIframe = driver.findElement(By.xpath("//iframe[@id='iframe1']"));
		driver.switchTo().frame(firstIframe);

		
		WebElement getStartedBtn = driver.findElement(By.xpath("//a[text()='Get started']"));
		js.executeScript("arguments[0].scrollIntoView();", getStartedBtn);

		wait.until(ExpectedConditions.visibilityOf(getStartedBtn));
		try {
			getStartedBtn.click();
		} 
		catch (ElementClickInterceptedException e) {
			getStartedBtn.click();

		}
		WebElement title = driver.findElement(By.xpath("//h1[text()='Installation']"));

		wait.until(ExpectedConditions.visibilityOf(title));
		String titleText = title.getText();
		if (titleText.equalsIgnoreCase("Installation")) {
			System.out.println("iframe Handeling is completed ");
		}
		driver.close();

	}

	public static void main(String[] args) {
		IframesHandelingTestCases object = new IframesHandelingTestCases();
		object.initialisation();
		object.iframeHandeling();
	}

}
