package testCases;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import BaseTest.TestBase;

public class ActionsClassEventTestCase extends TestBase {
	public static WebDriverWait wait;
	Actions action;

	public void keyBoardActionUsingActionsClass() {
		WebElement formfieldBtn = driver.findElement(By.xpath("//a[text()='Form Fields']"));
		formfieldBtn.click();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Form Fields']")));

		WebElement name = driver.findElement(By.id("name"));
		WebElement message = driver.findElement(By.id("message"));
		WebElement messagetitletext = driver.findElement(By.xpath("//label[@for='message']"));
		action = new Actions(driver);
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

		wait.until(ExpectedConditions.elementToBeClickable(By.id("submit-btn")));
		try {
			driver.findElement(By.id("submit-btn")).click();
		} catch (ElementClickInterceptedException e) {
			driver.findElement(By.id("submit-btn")).click();

		}
		String alertmessage = wait.until(ExpectedConditions.alertIsPresent()).getText();
		if (alertmessage.equalsIgnoreCase("Message received!")) {
			driver.switchTo().alert().accept();
			System.out.println("Message received! ;Test Case Passed");
			driver.navigate().back();

		} else
			System.out.println("Test Case Failed");
	}

	public void dragAndDropActionsUsingActionsClass() {
		WebElement slidersbtn = driver.findElement(By.xpath("//a[text()='Sliders']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", slidersbtn);

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Sliders']")));
		try {
		slidersbtn.click();
		}
		catch(ElementClickInterceptedException e) {
			slidersbtn.click();

		}
		WebElement sliderTitleText = driver.findElement(By.xpath("//h1[text()='Slider']"));

		wait.until(ExpectedConditions.visibilityOf(sliderTitleText));

		List<WebElement> elements = driver.findElements(By.xpath("//input[@id='slideMe']"));
		WebElement source = elements.get(25);

		WebElement target = elements.get(19);

		action.dragAndDrop(source, target).build().perform();

	}

	public static void main(String[] args) {
		ActionsClassEventTestCase object = new ActionsClassEventTestCase();

		object.initialisation();
		object.keyBoardActionUsingActionsClass();
		object.dragAndDropActionsUsingActionsClass();
	}

}
