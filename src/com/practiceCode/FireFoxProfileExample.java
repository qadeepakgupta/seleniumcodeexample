package com.practiceCode;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 *
 * @author Deepak Gupta
 * @Created Date 23-08-2017
 *
 */
public class FireFoxProfileExample {

	WebDriver driver;

	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/drivers/geckodriver.exe");
		// Create object of webdriver's inbuilt class ProfilesIni to access Its method
		// getProfile.
		ProfilesIni firProfiles = new ProfilesIni();
		// Get access of newly created profile WebDriver_Profile.
		FirefoxProfile wbdrverprofile = firProfiles.getProfile("WebDriver_Profile");
		// Pass wbdrverprofile parameter to FirefoxDriver.
		driver = new FirefoxDriver(wbdrverprofile);
	}

	@Test
	public void OpenURL() {
		driver.get("http://only-testing-blog.blogspot.in/2014/05/login.html");
	}

	@AfterTest
	public void tearDown() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}

}
