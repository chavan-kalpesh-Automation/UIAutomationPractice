package testCases;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import BaseTest.TestBase;

public class Pop_Up_Handeling_Test extends TestBase {

	public void popuppage() {
		WebElement popupbtn = driver.findElement(By.xpath("//a[text()='Popups']"));
		popupbtn.click();

	}

	public void simpleAlertPopup() {
		WebElement popuptitle = driver.findElement(By.xpath("//h1[text()='Popups']"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(popuptitle));

		WebElement alertpopupbtn = driver.findElement(By.xpath("//button[@id='alert']"));
		alertpopupbtn.click();

		Alert alertpopup = wait.until(ExpectedConditions.alertIsPresent());
		if (alertpopup != null) {
			System.out.println("Alert Text :" + alertpopup.getText());
			alertpopup.accept();

		} else
			System.out.println("No Alert Present");
	}

	public void comfirmPopup() {
		WebElement confirmpopupbtn = driver.findElement(By.id("confirm"));
		confirmpopupbtn.click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		Alert alertpopup = wait.until(ExpectedConditions.alertIsPresent());
		if (alertpopup != null) {
			System.out.println("Alert Text :" + alertpopup.getText());
			// alertpopup.accept();
			// alder cancel
			alertpopup.dismiss();
			WebElement confirmationresult = driver.findElement(By.xpath("//p[@id='confirmResult']"));
			String resulttext = confirmationresult.getText();
			if (resulttext.equals("OK it is!")) {
				System.out.println("Confirmation popup Accepted ");

			} else {
				System.out.println("Confirmation popup Cancel");
			}

		} else
			System.out.println("No Alert Present");

	}

	public void promptPopup() {
		WebElement promptPopupbtn = driver.findElement(By.id("prompt"));
		promptPopupbtn.click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Alert alertpopup = wait.until(ExpectedConditions.alertIsPresent());

		
		
		if(alertpopup !=null) {
			String name =" Test Name";
			driver.switchTo().alert().sendKeys(name);
			driver.switchTo().alert().accept();
			 
			WebElement confirmmsg=driver.findElement(By.xpath("//p[@id='promptResult']"));
			String msg=confirmmsg.getText();
			if(msg.equals("Nice to meet you,"+name+"!")) {//Nice to meet you,Test Name!
				System.out.println("Message Succefully saved ");
				System.out.println(msg);
			}
			else
				System.out.println("Message not Getting ");
		}
		else
			System.out.println("No Alert Is Present");
		
	}

	public static void main(String[] args) {
		Pop_Up_Handeling_Test obj = new Pop_Up_Handeling_Test();
		obj.initialisation();
		obj.popuppage();
//		obj.simpleAlertPopup();//First poup
		//obj.comfirmPopup();// second popup
		
		obj.promptPopup();
	}
}
