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
public class DragAndDrop extends SuperTestNG {

	public void handleFrame() {
		WebElement ele = driver.findElement(By.className("demo-frame"));
		driver.switchTo().frame(ele);

	}

	@Test
	public void testDragAndDrop() {
		try {
			driver.get("https://jqueryui.com/droppable/");
			handleFrame();
			WebElement src = driver.findElement(By.xpath("//*[@id='draggable']/p"));
			WebElement tar = driver.findElement(By.id("droppable"));

			Actions act = new Actions(driver);
			act.dragAndDrop(src, tar).perform();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}