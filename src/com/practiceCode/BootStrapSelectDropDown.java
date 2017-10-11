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
public class BootStrapSelectDropDown extends SuperTestNG {

	@Test
	public void testBootStrapSelectDropDown() throws InterruptedException {

		try {
			driver.get("http://seleniumpractise.blogspot.in/2016/08/bootstrap-dropdown-example-for-selenium.html");
			driver.findElement(By.xpath(".//*[@id='menu1']")).click();
			Thread.sleep(2000);
			List<WebElement> list = driver.findElements(By.xpath("//ul[@class='dropdown-menu']//li/a"));
			for (WebElement ele : list) {
				System.out.println("Values " + ele.getAttribute("innerHTML"));
				if (ele.getAttribute("innerHTML").contains("JavaScript")) {
					ele.click();
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}