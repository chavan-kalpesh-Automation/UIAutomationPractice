package BaseTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Saucelab_TestBase {
	public static WebDriver driver;
	public static Properties prop;
	
	public void sauceLab_initialization() {

		ChromeOptions options=new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		 driver =new ChromeDriver(options);
		
		driver.get("https://www.saucedemo.com/v1/");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
	}
	
protected Saucelab_TestBase() {
	try {
		prop =new Properties();
		Path root=FileSystems.getDefault().getPath("").toAbsolutePath();
		
		Path filepath=Paths.get(root.toString(),"configue.properties");
		FileInputStream fis = new FileInputStream(filepath.toString());
		prop.load(fis);
		
	}
	catch (FileNotFoundException e) {
		e.getStackTrace();
	} catch (IOException e) {
		e.getStackTrace();

	}
		
	}
}

