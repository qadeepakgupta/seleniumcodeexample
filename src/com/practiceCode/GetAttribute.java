package com.practiceCode;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

/**
*
* @author Deepak Gupta
* @Created Date 23-08-2017
*
*/

public class GetAttribute extends SuperTestNG {

	@Test
	public void testGetAttributeValue() throws InterruptedException {
		try {

			driver.get(
					"file:///D:/Office/Eclipse_Projects/Project_Neon/SeleniumCodeExampleBlog/WebPage/Practice%20Form.htm");
			driver.findElement(By.id("text2")).sendKeys("Gupta");

			String value = driver.findElement(By.id("text2")).getAttribute("value");
			System.out.println("Entered value is: " + value);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
