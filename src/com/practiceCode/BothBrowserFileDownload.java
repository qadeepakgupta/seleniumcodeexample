package com.practiceCode;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class BothBrowserFileDownload {
	ProfilesIni		listProfiles	= new ProfilesIni();
	FirefoxProfile	profile			= listProfiles.getProfile("default");
	WebDriver		driver;
dd
	@Test
	public void login() throws InterruptedException, AWTException, IOException {


		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/drivers/geckodriver.exe");
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
		driver = new FirefoxDriver(profile);


		driver.get("http://only-testing-blog.blogspot.in/2014/05/login.html");

		// Download Text File
		driver.findElement(By.linkText("Download Text File")).click();
		System.out.println("Download Text File link is clicked");
		Thread.sleep(2000);
		
		Robot robot = new Robot();
		
		// For clicking on the Arrow Down on the dialog box
		robot.keyPress(KeyEvent.VK_DOWN);
		
		// For clicking on the Ok button on the dialog box
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);

		// For clicking on Ok button on the dialog box which appears(not necessary) while saving file in a specific location.
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);


		// For navigating to Yes button,if a prompt says that the file already exists in the location
		robot.keyPress(KeyEvent.VK_LEFT);
		robot.keyRelease(KeyEvent.VK_LEFT);
		Thread.sleep(2000);

		// For clicking on Ok button
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	@AfterTest
	public void close() {
		driver.quit();
	}
}
