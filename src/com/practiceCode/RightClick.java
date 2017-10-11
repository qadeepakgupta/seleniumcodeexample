package com.practiceCode;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

/**
 *
 * @author Deepak Gupta
 * @Created Date 23-08-2017
 *
 */
public class RightClick extends SuperTestNG {

	@Test
	public void testRightClick() throws InterruptedException {
		try {
			driver.navigate().to("http://only-testing-blog.blogspot.in/2013/09/testing.html");
			Thread.sleep(2000);

			WebElement test = driver.findElement(By.id("navbar"));
			Actions myAction = new Actions(driver);
			myAction.contextClick(test).build().perform();

			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}