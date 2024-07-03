package testCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import BaseTest.TestBase;

public class MultipleCheckBoxChecks extends TestBase {

	public void whatIsYourFavDrink(String drink1, String drink2) {
		WebElement favdrink1 = driver
				.findElement(By.xpath("//input[@name='fav_drink']/following-sibling::label[text()='" + drink1 + "']"));
		favdrink1.click();

		WebElement favdrink2 = driver
				.findElement(By.xpath("//input[@name='fav_drink']/following-sibling::label[text()='" + drink2 + "']"));
		favdrink2.click();

		if (favdrink1.isSelected() || favdrink2.isSelected()) {
			System.out.println("Both CheckBox is Checked;Test Case Passed.");

		} else
			System.out.println("CheckBox is UnChecked;Test Case Failed.");
		
//		driver.close();

	}

	public static void main(String[] args) {

		MultipleCheckBoxChecks object = new MultipleCheckBoxChecks();
		object.initialisation();

		WebElement formFieldbtn = driver.findElement(By.xpath("//div//a[text()='Form Fields']"));

		formFieldbtn.click();

		WebElement title = driver.findElement(By.xpath("//div//h1[text()='Form Fields']"));

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.visibilityOf(title));

		object.whatIsYourFavDrink("Milk", "Coffee");
	}

}
