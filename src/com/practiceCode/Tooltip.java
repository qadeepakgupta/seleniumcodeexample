package com.practiceCode;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author Deepak Gupta
 * @Created Date 23-08-2017
 *
 */
public class Tooltip extends SuperTestNG {

	@Test
	public void testTooltip() throws InterruptedException {

		try {
			driver.navigate().to("http://only-testing-blog.blogspot.in/2015/03/chart.html");
			WebElement element = driver.findElement(By.linkText("Hover over me"));
			String toolTipText = element.getAttribute("title");
			System.out.println("Tooltip value is: " + toolTipText);
			Actions action = new Actions(driver);
			action.moveToElement(element).perform();
			Assert.assertEquals(toolTipText, "tooltip text!");

		} catch (Exception e) {
			System.out.println("Expection is : " + e);
		}
	}

}
