package com.practiceCode;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.testng.annotations.Test;

public class ScrollUp extends SuperTestNG {

	@Test
	public void testScrollUpByRobotClass() {

		try {
			driver.get("https://seleniumcodeexample.blogspot.in/");
			driver.manage().window().maximize();
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_PAGE_DOWN);
			robot.keyPress(KeyEvent.VK_PAGE_DOWN);
			robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
			Thread.sleep(5000);
			robot.keyPress(KeyEvent.VK_PAGE_UP);
			robot.keyPress(KeyEvent.VK_PAGE_UP);
			robot.keyRelease(KeyEvent.VK_PAGE_UP);
			Thread.sleep(5000);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}