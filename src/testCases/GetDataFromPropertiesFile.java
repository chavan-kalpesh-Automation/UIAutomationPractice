package testCases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebElement;

import BaseTest.TestBase;

public class GetDataFromPropertiesFile extends TestBase {

	public void readDatFromPropertiesFile() {
		WebElement popups = driver.findElement(By.xpath("//a[text()='Popups']"));

		try {
			popups.click();

		} catch (ElementClickInterceptedException e) {
			popups.click();

		}
		WebElement promptalert = driver.findElement(By.id("prompt"));
		promptalert.click();

		try {
			FileInputStream fileinput = new FileInputStream(
					"C:\\Users\\KALPESH\\eclipse-workspace\\practice_automation\\configue.properties");
			Properties prop = new Properties();
			prop.load(fileinput);
			driver.switchTo().alert().sendKeys("kaleps");

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("test");
	}

	public static void main(String[] args) {
		GetDataFromPropertiesFile object = new GetDataFromPropertiesFile();
		object.initialisation();
		object.readDatFromPropertiesFile();
	}

}
