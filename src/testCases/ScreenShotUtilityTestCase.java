package testCases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import BaseTest.TestBase;

public class ScreenShotUtilityTestCase extends TestBase {

	public static void main(String[] args) {
		ScreenShotUtilityTestCase object = new ScreenShotUtilityTestCase();
		object.initialisation();

		// TypeCaste the driver into TakesScreenshot class
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		// Define Source output type
		File Source = screenshot.getScreenshotAs(OutputType.FILE);
		// Define Destination path where screenshot needs to be save
		
		String  timestamp=new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		
		//Copy source file to destination folder using FileHandler.copy
		File destination = new File(
				"C:\\Users\\KALPESH\\eclipse-workspace\\practice_automation\\Screenshots\\screenshot_"+timestamp+".png");
		try {
			FileHandler.copy(Source, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
		driver.quit();

	}

}
