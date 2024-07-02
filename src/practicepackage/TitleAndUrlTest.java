package practicepackage;

import BaseTest.TestBase;

public class TitleAndUrlTest extends TestBase {

	public static void main(String []args) {
		TitleAndUrlTest object =new TitleAndUrlTest();
		object.initialisation();
		String title=driver.getTitle();
		if(title.equalsIgnoreCase("Learn and Practice Automation | automateNow")) {
			System.out.println("Title Test case passed");
			System.out.println("Current Page Title is:- "+title);
		}
		
		
		String currenturl=driver.getCurrentUrl();
		if(currenturl.equalsIgnoreCase("https://practice-automation.com/")){
			System.out.println("Current URL Test case passed");
			System.out.println("Current Page URL is :- "+currenturl);
		}
		else {
		System.out.println("Test Case Failed ");
		}
		driver.close();
	
	
	
	}
}
