package practicepackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleWebTable {
	
		     public static void main(String[] args)
		{
	         WebDriver driver = new ChromeDriver();
			
			driver.get("file:///C:/Users/Mr%20Tester/Documents/Notes/new%203.html");
			
			for(int i=1;i<=4;i++)
			{
				for(int j=1;j<=4;j++)
				{
					if(i==1) {
						
					
					 String text=driver.findElement(By.xpath("//table[@border='1']/tr["+i+"] /th ["+j+"]")).getText();
				System.out.println(text+" ");
					}
				else
					{
						 String text=driver.findElement(By.xpath("//table[@border='1']/tr["+i+"] /td["+j+"]")).getText();
							System.out.println(text+" ");
							
								
								
				
					}
					}
				
			
			}

		}
	}

