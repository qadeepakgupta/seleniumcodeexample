package com.practiceCode;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class ScrollDown extends SuperTestNG {

	@Test
	public void testScrollDownByJavascriptExecutor() {

		try {
			driver.get("https://seleniumcodeexample.blogspot.in/");
			driver.manage().window().maximize();
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(0,4500)", "");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}