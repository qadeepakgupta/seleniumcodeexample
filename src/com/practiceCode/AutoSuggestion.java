package com.practiceCode;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
/**
*
* @author Deepak Gupta
* @Created Date 23-08-2017
*
*/
public class AutoSuggestion extends SuperTestNG {

	@Test
	public void testAutoSuggestion() {
		try {
			driver.navigate().to("https://www.google.co.in/");
			driver.findElement(By.id("lst-ib")).sendKeys("and");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//b[text()='roid']")).click();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
