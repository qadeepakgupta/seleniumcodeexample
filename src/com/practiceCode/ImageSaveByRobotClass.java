package com.practiceCode;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;


/**
 *
 * @author Deepak Gupta
 * @Created Date 29-09-2017
 *
 */

public class ImageSaveByRobotClass extends SuperTestNG {


	@Test
	public void testImageSaveByRobotClass() throws IOException, InterruptedException, AWTException {
		System.out.println("========= Starting testImageSaveByRobotClass() ============");
		try {
			driver.get("http://only-testing-blog.blogspot.in/2014/09/selectable.html");
			// Locate Image
			WebElement Image = driver.findElement(By.xpath("//img[@border='0']"));
			// Rihgt click on Image using contextClick() method.
			Actions action = new Actions(driver);
			action.contextClick(Image).build().perform();

			StringSelection file = new StringSelection("D:\\TestingSaveImage.jpg");
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(file, null);

			Robot rb = new Robot();
			for (int i = 1; i <= 7; i++) {
				// Arrow down
				rb.keyPress(KeyEvent.VK_DOWN);
				Thread.sleep(100);
			}

			// To press Enter key.
			rb.keyPress(KeyEvent.VK_ENTER);

			// Similar to thread.sleep
			rb.setAutoDelay(1000);

			rb.keyPress(KeyEvent.VK_CONTROL);
			rb.keyPress(KeyEvent.VK_V);

			rb.keyRelease(KeyEvent.VK_CONTROL);
			rb.keyRelease(KeyEvent.VK_V);

			rb.setAutoDelay(1000);

			// To press Enter key.
			rb.keyPress(KeyEvent.VK_ENTER);
			rb.keyRelease(KeyEvent.VK_ENTER);
			System.out.println("File Save Successfully.");
			System.out.println("========= Ending testImageSaveByRobotClass() ============");
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
}