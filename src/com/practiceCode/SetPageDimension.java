package com.practiceCode;

import org.openqa.selenium.Dimension;
import org.testng.annotations.Test;

/**
 *
 * @author Deepak Gupta
 * @Created Date 30-08-2017
 *
 */

public class SetPageDimension extends SuperTestNG {

	@Test
	public void testDimension() {
		try {
			driver.manage().window().setSize(new Dimension(360, 640));
			driver.get("http://www.only-testing-blog.blogspot.in/2013/09/testing.html");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
