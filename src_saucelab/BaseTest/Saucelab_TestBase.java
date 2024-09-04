package BaseTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Saucelab_TestBase {
	public static WebDriver driver;
	public void sauceLab_initialization() {

		ChromeOptions options=new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		 driver =new ChromeDriver(options);
		
		driver.get("https://www.saucedemo.com/v1/");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
	}

}
