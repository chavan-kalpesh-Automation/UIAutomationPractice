package testCases;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import BaseTest.TestBase;

public class TabSwitchCodingProblem extends TestBase {

	public static void main(String[] args) {

		TabSwitchCodingProblem object = new TabSwitchCodingProblem();
		object.initialisation();

		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement tablesButton = driver.findElement(By.xpath("//a[text()='Tables']"));

		js.executeScript("arguments[0].scrollIntoView();", tablesButton);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement windowOperationbutton = driver.findElement(By.xpath("//a[text()='Window Operations']"));

		wait.until(ExpectedConditions.elementToBeClickable(windowOperationbutton));
		try {
			windowOperationbutton.click();
		} catch (ElementClickInterceptedException e) {
			windowOperationbutton.click();
		}
		List<WebElement> urls = driver.findElements(By.xpath("//button[@class='custom_btn btn_hover']//b"));

		for (WebElement url : urls) {
			if (url.getText().contains("New Tab")) {
				url.click();

			}
		}

		Set<String> windows = driver.getWindowHandles();
		for (String actual : windows) {
			driver.switchTo().window(actual);
			if (driver.getTitle().contains("Home | automateNow")) {
				driver.switchTo().window(actual);
			}
		}
		WebElement postmantutorial = driver
				.findElement(By.xpath("//a[@href='https://automatenow.io/postman-tutorials/']//img"));

		wait.until(ExpectedConditions.elementToBeClickable(postmantutorial));

		postmantutorial.click();

		WebElement titleofnextpage = driver.findElement(By.xpath("//a[text()='Jump to tutorial list']"));

		wait.until(ExpectedConditions.visibilityOf(titleofnextpage));

		driver.close();

	}

}
