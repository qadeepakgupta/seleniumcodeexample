package com.practiceCode;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

/**
 *
 * @author Deepak Gupta
 * @Created Date 23-08-2017
 *
 */
public class FindNoOfTextFields extends SuperTestNG {

	@Test
	public void testNoOfTextFields() {
		try {
			driver.get("http://only-testing-blog.blogspot.in/2013/09/testing.html");
			List<WebElement> e = driver.findElements(By.xpath("//input[@type='text']"));
			System.out.println("No. of Text Field is: " + e.size());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
