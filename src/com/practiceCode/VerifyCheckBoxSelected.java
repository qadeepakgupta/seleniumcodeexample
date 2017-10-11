package com.practiceCode;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
/**
*
* @author Deepak Gupta
* @Created Date 23-08-2017
*
*/
public class VerifyCheckBoxSelected extends SuperTestNG {

	@Test
	public void testCheckBoxIsSelected() {
		driver.get("http://only-testing-blog.blogspot.in/2013/09/testing.html");

		WebElement checkBox = driver.findElement(By.name("vehicle"));
		if (checkBox.isSelected()) {
			System.out.println(checkBox.getAttribute("value") + " checkbox is already selected.");
		} else {
			// Select the checkbox
			checkBox.click();
			System.out.println(checkBox.getAttribute("value") + " checkbox is selected.");
		}
	}

}
