package com.practiceCode;

import org.testng.annotations.Test;

/**
 *
 * @author Deepak Gupta
 * @Created Date 23-08-2017
 *
 */
public class GetTitleName extends SuperTestNG {

	@Test
	public void testGetTitleName() {
		try {

			driver.get("http://www.google.com");
			System.out.println("Current Title Name: " + driver.getTitle());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
