package com.practiceCode;

import org.testng.annotations.Test;

/**
 *
 * @author Deepak Gupta
 * @Created Date 23-08-2017
 *
 */
public class GetCurrentURL extends SuperTestNG {

	@Test
	public void testGetCurrentURLExample() {
		try {

			driver.get("http://www.google.com");
			System.out.println("Current URL: " + driver.getCurrentUrl());
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
