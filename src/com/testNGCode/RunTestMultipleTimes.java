package com.testNGCode;

import org.testng.annotations.Test;

public class RunTestMultipleTimes {
	@Test(invocationCount = 5)
	public void runMultipleTimes() {
		System.out.println("run this test");
	}
}