package testCases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import BaseTest.TestBase;

public class FileDownloadTest extends TestBase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		FileDownloadTest obj = new FileDownloadTest();
		obj.initialisation();

		WebElement filedownloadbtn = driver.findElement(By.xpath("//a[text()='File Download']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", filedownloadbtn);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(filedownloadbtn));
		try {
			filedownloadbtn.click();
		} catch (ElementClickInterceptedException e) {
			filedownloadbtn.click();

		}

		WebElement fileDownloadBtn = driver
				.findElement(By.xpath("//a[@class='wpdm-download-link download-on-click btn btn-primary ']"));

		wait.until(ExpectedConditions.elementToBeClickable(fileDownloadBtn));

		fileDownloadBtn.click();
		try {
			Robot robot = new Robot();
			robot.setAutoDelay(2000);

			// Press the 'Down' arrow key to select the "Save" option in the download dialog
			robot.keyPress(KeyEvent.VK_DOWN);
			robot.keyRelease(KeyEvent.VK_DOWN);

			// Press the 'Enter' key to confirm the save action
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

			String fileDownloadPath = "C:/Users/kalpesh/Downloads";
			File filedownlaod = new File(fileDownloadPath + "test.pdf");

			if (filedownlaod.exists()) {
				System.out.println("File Download Successfully");

			}
		} catch (AWTException e) {
			e.printStackTrace();
		}

	}
}
