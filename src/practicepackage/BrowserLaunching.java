package practicepackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserLaunching {

	public static void main(String[] args) {

		// browser setup after selenium 4 implementataion
		ChromeOptions chrome = new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(chrome);

		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		System.out.println("Browser Launching successfully");

		driver.manage().window().maximize();
		driver.navigate().refresh();
		driver.close();

	}

}
