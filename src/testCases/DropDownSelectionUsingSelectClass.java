package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownSelectionUsingSelectClass {

	public static WebDriver driver;

	public static void main(String[] args) {
		ChromeOptions option = new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(option);

		driver.get("https://practice.expandtesting.com/dropdown");

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		WebElement countrytitle = driver.findElement(By.xpath("//div//h2[text()='Country selection']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", countrytitle);

		WebElement countrydropdown = driver.findElement(By.id("country"));

		Select selectcountry = new Select(countrydropdown);

//		selectcountry.selectByValue("IN");

		selectcountry.selectByVisibleText("India");

		System.out.println("Successfully selected country ");
		
		driver.quit();
		
		// DropDown Handling By Using Select Class Methods
		// Select By method 1.Index 2.By Value 3.By VisibleText

	}
}
