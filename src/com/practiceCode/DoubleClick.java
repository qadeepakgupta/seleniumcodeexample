package com.practiceCode;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

/**
 *
 * @author Deepak Gupta
 * @Created Date 10-08-2017
 *
 */

public class DoubleClick extends SuperTestNG {

	@Test
	public void testDoubleClick() {
		try {
			driver.get("http://only-testing-blog.blogspot.in/2013/09/testing.html");
			WebElement ele = driver.findElement(By.xpath("//*[text()='Saturday, 21 September 2013']"));
			Actions act = new Actions(driver);
			act.doubleClick(ele).build().perform();
			Thread.sleep(3000);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
