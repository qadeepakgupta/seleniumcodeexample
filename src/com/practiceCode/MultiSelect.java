package com.practiceCode;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 *
 * @author Deepak Gupta
 * @Created Date 22-08-2017
 *
 */

public class MultiSelect extends SuperTestNG {

	@BeforeClass
	public void enterURL() {
		driver.get("http://only-testing-blog.blogspot.in/2013/09/testing.html");
	}

	@Test(description = "Options Selected By selectByVisibleText(),selectByValue(),selectByIndex()")
	public void testMultipleSelect() throws InterruptedException {
		try {
			WebElement element = driver.findElement(By.name("FromLB"));
			Select dropDown = new Select(element);

			// Option select By VisibleText
			dropDown.selectByVisibleText("USA");

			// Option select By Value
			dropDown.selectByValue("India");

			// Option select By Index
			dropDown.selectByIndex(7);

			List<WebElement> options = dropDown.getAllSelectedOptions();
			for (WebElement value : options) {
				System.out.println("Multple Selected value is: " + value.getText());
			}
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}

	}

}