package testCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import BaseTest.TestBase;

public class Sliders_DragnDrop extends TestBase {

	public void slidermethod(int moveupto) {

		Actions act = new Actions(driver);
		WebElement slidersbtn = driver.findElement(By.xpath("//a[text()='Sliders']"));
		act.click(slidersbtn).build().perform();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Slider']")));

		WebElement slider = driver.findElement(By.xpath("//input[@id='slideMe']"));

		int width = slider.getSize().getWidth();
//		System.out.println(width);
		int slidewidth = width / 2;
//		System.out.println(slidewidth);
//		System.out.println(slider.getSize().getWidth());

//		act.clickAndHold(slider).moveByOffset(slidewidth, 0).build().perform();
		act.clickAndHold(slider).moveToLocation(slidewidth, 0).build().perform();
	}

	public static void main(String[] args) {

		Sliders_DragnDrop obj = new Sliders_DragnDrop();
		obj.initialisation();
		obj.slidermethod(65);
	}

}
