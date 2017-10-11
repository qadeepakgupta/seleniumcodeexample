package com.practiceCode;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.testng.annotations.Test;

/**
 * @ How to take the screen shot of webelement
 * 
 * @author Deepak Gupta
 * @Created Date 23-08-2017
 *
 */
public class TakeScreenShot extends SuperTestNG {

	@Test
	public void test() throws InterruptedException, IOException {
		try {
			driver.get("http://only-testing-blog.blogspot.in/2013/09/testing.html");
			File capture = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(capture, new File(System.getProperty("user.dir") + "/ScreenShot/TakeScreenshot.jpg"));
			System.out.println("Screenshot is captured and stored in your Project Folder");
		} catch (WebDriverException e) {
			e.printStackTrace();
		}
	}

}
