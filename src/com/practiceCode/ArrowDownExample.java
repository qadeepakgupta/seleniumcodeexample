package com.practiceCode;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ArrowDownExample extends SuperTestNG {

	@Test(priority = 0)
	public void handleArrowDown() throws InterruptedException {

		driver.get("https://www.google.co.in/");
		WebElement oWE = driver.findElement(By.id("lst-ib"));
		System.out.println("Text: " + oWE.getText());
		// right click on webpage and arrow down then press enter
		Actions oAction = new Actions(driver);
		// action.contextClick(oWE).build().perform();

		oAction.moveToElement(oWE);
		oAction.contextClick(oWE).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build()
			.perform();

		Thread.sleep(5000);

	}

}