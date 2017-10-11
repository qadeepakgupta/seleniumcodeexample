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
public class VerifyCheckBoxIsDeselect extends SuperTestNG {

	@Test
	public void testCheckBoxIsDeselect() throws InterruptedException {
		driver.get("http://only-testing-blog.blogspot.in/2013/09/testing.html");

		WebElement checkBox = driver.findElement(By.name("vehicle"));
		checkBox.click();
		Thread.sleep(2000);

		if (checkBox.isSelected()) {
			// De-select the checkbox
			checkBox.click();
			System.out.println(checkBox.getAttribute("value") + " check box is now deselected");
			Thread.sleep(2000);
		} else {
			System.out.println(checkBox.getAttribute("value") + " check box is not selected");
		}
	}

}
