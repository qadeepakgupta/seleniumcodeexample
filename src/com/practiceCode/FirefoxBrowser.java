package com.practiceCode;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 *
 * @author Deepak Gupta
 * @Created Date 23-08-2017
 *
 */
public class FirefoxBrowser {

	WebDriver driver;

	@BeforeTest
	public void testFirefoxBrowser() {
		try {

			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/drivers/geckodriver.exe");
			System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
			driver = new FirefoxDriver();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGooglePageTitleInFirefoxBrowser() {
		driver.navigate().to("http://www.google.com");
		String strPageTitle = driver.getTitle();
		System.out.println("Page title: - " + strPageTitle);
		Assert.assertTrue(strPageTitle.equalsIgnoreCase("Google"), "Page title doesn't match");
	}

	@AfterTest
	public void tearDown() throws InterruptedException {

		driver.quit();

	}
}
