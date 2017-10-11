package com.practiceCode;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author Deepak Gupta
 * @Created Date 29-09-2017
 *
 */
public class FileDownloadByRobotClass extends SuperTestNG {

	@Test
	public void testFileDownloadByRobotClass() {
		System.out.println("==========starting testFileDownloadByRobotClass() =========");
		try {
			driver.get("http://only-testing-blog.blogspot.in/2014/05/login.html");

			// Download Text File
			driver.findElement(By.linkText("Download Text File")).click();
			System.out.println("Download Text File link is clicked");

			// downloadByRobotClass() method
			downloadByRobotClass();
			// press enter key of keyboard to perform above selected action
			System.out.println("File Download successfully.");
			System.out.println("==========ending testFileDownloadByRobotClass() =========");

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}


	public void downloadByRobotClass() throws AWTException, InterruptedException {
		Robot robot = new Robot();

		// For clicking on the Arrow Down on the dialog box
		robot.keyPress(KeyEvent.VK_DOWN);

		// For clicking on the Ok button on the dialog box
		robot.keyPress(KeyEvent.VK_ENTER);
		//robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
	}

}