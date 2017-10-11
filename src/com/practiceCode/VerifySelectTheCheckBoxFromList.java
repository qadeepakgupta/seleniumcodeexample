package com.practiceCode;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
/**
*
* @author Deepak Gupta
* @Created Date 23-08-2017
*
*/
public class VerifySelectTheCheckBoxFromList extends SuperTestNG {

	@Test
	public void testSelectTheCheckBoxFromList() throws InterruptedException {
		try {
			driver.get("http://only-testing-blog.blogspot.in/2013/09/testing.html");
			List<WebElement> allOptions = driver.findElements(By.tagName("input"));
			for (WebElement option : allOptions) {
				if ("Boat".equals(option.getAttribute("value"))) {
					if (!option.isSelected()) {
						option.click();
						System.out.println(option.getAttribute("value") + " - checkbox is checked");
						break;
					} else {
						System.out.println(option.getAttribute("value") + " - checkbox is already checked");
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}

	}

}
