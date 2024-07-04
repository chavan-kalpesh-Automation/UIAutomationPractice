package testCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import BaseTest.TestBase;

public class ActionsClassEventTestCase extends TestBase {

	public void keyBoardActionUsingActionsClass() {
		WebElement formfieldBtn = driver.findElement(By.xpath("//a[text()='Form Fields']"));
		formfieldBtn.click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Form Fields']")));

		Actions action = new Actions(driver);
		WebElement name = driver.findElement(By.id("name"));
		WebElement message = driver.findElement(By.id("message"));
		WebElement messagetitletext = driver.findElement(By.xpath("//label[@for='message']"));

		action.click(name).build().perform();
		// send name in text field and Select text
		action.sendKeys(name, "kalpesh").keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();
		// copy selected text
		action.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).build().perform();
		// scroll down upto message text field
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", messagetitletext);

		wait.until(ExpectedConditions.elementToBeClickable(By.id("message")));

		action.sendKeys(message).keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).build().perform();

	}

	public void mouseHoverActions() {
		
	}
	public static void main(String[] args) {
		ActionsClassEventTestCase object = new ActionsClassEventTestCase();

		object.initialisation();
		object.keyBoardActionUsingActionsClass();

	}

}
