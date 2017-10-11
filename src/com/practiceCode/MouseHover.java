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
public class MouseHover extends SuperTestNG {

	@Test
	public void testMouseHover() throws InterruptedException {

		try {
			driver.navigate().to("http://only-testing-blog.blogspot.in/2015/03/chart.html");
			WebElement element = driver.findElement(By.linkText("Hover over me"));
			Actions action = new Actions(driver);
			action.moveToElement(element).build().perform();

		} catch (Exception e) {
			System.out.println("Expection is : " + e);
		}
	}

}