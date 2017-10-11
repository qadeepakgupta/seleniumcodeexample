package com.practiceCode;

import org.testng.annotations.Test;

/**
 *
 * @author Deepak Gupta
 * @Created Date 23-08-2017
 *
 */
public class GetPageSource extends SuperTestNG {

	@Test
	public void testGetPageSourceExample() {
		try {

			driver.get("http://www.google.com");
			System.out.println("page source " + driver.getPageSource());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
