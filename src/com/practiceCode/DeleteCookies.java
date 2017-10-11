package com.practiceCode;

import org.testng.annotations.Test;

/**
 *
 * @author Deepak Gupta
 * @Created Date 30-08-2017
 *
 */

public class DeleteCookies extends SuperTestNG {

	@Test
	public void testDeleteCookies() {
		try {
			driver.get("https://www.google.co.in/");
			System.out.println("Before cookies delete: " + driver.manage().getCookies());
			driver.manage().deleteAllCookies(); //
			System.out.println("After cookies delete: " + driver.manage().getCookies());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}