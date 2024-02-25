package BaseTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public static WebDriver driver;

	public void initialisation() {
		ChromeOptions option = new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(option);

		driver.get("https://practice-automation.com/");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

	}

	public static void main(String[] args) {
		TestBase obj = new TestBase();
		obj.initialisation();

	}
}
