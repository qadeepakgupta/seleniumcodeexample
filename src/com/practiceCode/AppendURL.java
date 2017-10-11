package com.practiceCode;

import org.testng.annotations.Test;

/**
 *
 * @author Deepak Gupta
 * @Created Date 26-09-2017
 *
 */

public class AppendURL extends SuperTestNG {

	@Test
	public void testAppendURL() {
		driver.get("https://seleniumcodeexample.blogspot.in/");
		String beforeURL = driver.getCurrentUrl();
		System.out.println("Before append url : " + beforeURL);
		String newURL = beforeURL + "2017/08/code-for-handling-get-current-url.html";
		driver.navigate().to(newURL);
		System.out.println("After  append url : " + driver.getCurrentUrl());

	}
}
