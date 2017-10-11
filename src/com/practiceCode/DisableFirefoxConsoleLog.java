package com.practiceCode;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

/**
 * @ Disable Firefox Console Log
 * 
 * @author Deepak Gupta
 * @Created Date 23-08-2017
 *
 */
public class DisableFirefoxConsoleLog {

	WebDriver driver;

	@Test
	public void testDisableFirefoxConsoleLog() {
		try {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/drivers/geckodriver.exe");
			System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.get("https://seleniumcodeexample.blogspot.in/");
			String title = driver.getTitle();
			System.out.println("Title Name is : " + title);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}


	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
