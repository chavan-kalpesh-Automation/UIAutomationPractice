package testNGFramework;

import org.testng.annotations.Test;

public class TestNGFramework {
	
	@Test(priority = 1)
	public void method1() {
		System.out.println("Test Case Method 1");
	}

	@Test
	public void Asmethod2() {
		System.out.println("Test case Method 2");
	}
}
