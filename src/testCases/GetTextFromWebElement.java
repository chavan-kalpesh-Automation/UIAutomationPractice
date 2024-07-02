package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import BaseTest.TestBase;

public class GetTextFromWebElement extends TestBase {

	public static void main(String[] args) {
		GetTextFromWebElement object = new GetTextFromWebElement();

		object.initialisation();

		WebElement title = driver.findElement(By.xpath("//h1[@class='wp-block-heading']"));

		String titleText = title.getText();
		if (titleText.equalsIgnoreCase("Welcome to your software automation practice website!")) {
			System.out.println("Test case passed Expected Text Matched with Actual Text");
			System.out.println("Given Text of Title:- " + titleText);
			
			

		}

		driver.close();

	}

}
