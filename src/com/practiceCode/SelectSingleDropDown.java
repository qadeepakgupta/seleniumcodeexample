package com.practiceCode;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 *
 * @author Deepak Gupta
 * @Created Date 22-08-2017
 *
 */

public class SelectSingleDropDown extends SuperTestNG {

	String xpathValue = ".//*[@id='post-body-7114928646577071695']/div[1]/div[1]/select";

	@BeforeClass
	public void enterURL() {
		driver.get("http://only-testing-blog.blogspot.in/2013/09/testing.html");
	}

	@Test(priority = 0, description = "1 - Method - SelectByVisibleText()")
	public void testSelectByVisibleText() throws InterruptedException {

		WebElement element = driver.findElement(By.xpath(xpathValue));
		Select dropDown = new Select(element);
		dropDown.selectByVisibleText("Audi");

		WebElement option = dropDown.getFirstSelectedOption();
		System.out.println("SelectByVisibleText() Selected value is: " + option.getText());

	}

	@Test(priority = 1, description = "2 - Method - SelectByValue()")
	public void testSelectByValue() throws InterruptedException {
		Thread.sleep(1000);
		WebElement element = driver.findElement(By.xpath(xpathValue));
		Select dropDown = new Select(element);
		dropDown.selectByValue("UK");

		WebElement option = dropDown.getFirstSelectedOption();
		System.out.println("SelectByValue() Selected value is: " + option.getText());

	}

	@Test(priority = 2, description = "3 - Method - SelectByIndex()")
	public void testSelectByIndex() throws InterruptedException {
		Thread.sleep(1000);
		WebElement element = driver.findElement(By.xpath(xpathValue));
		Select dropDown = new Select(element);
		dropDown.selectByIndex(2);

		WebElement option = dropDown.getFirstSelectedOption();
		System.out.println("SelectByIndex() Selected value is: " + option.getText());

	}

}