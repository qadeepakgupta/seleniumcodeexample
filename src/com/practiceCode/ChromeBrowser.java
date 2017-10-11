package com.practiceCode;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
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
public class ChromeBrowser {

	WebDriver driver;

	@BeforeTest
	public void testChromeBrowser() {
		try {

			// Handle https - Your connection is not private
			DesiredCapabilities dc = DesiredCapabilities.chrome();
			dc.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

			// Handle Set Chrome driver path and call
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");

			// Handle - disable the invalid Extension
			ChromeOptions options = new ChromeOptions();
			options.addArguments("disable-infobars");

			// Handle - disable the save password Extension
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("credentials_enable_service", false);
			prefs.put("profile.password_manager_enabled", false);
			options.setExperimentalOption("prefs", prefs);

			// Handle - Call the Chrome browser
			driver = new ChromeDriver(options);
			driver.get("https://www.google.co.in");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGooglePageTitleInChromeBrowser() {

		String strPageTitle = driver.getTitle();
		System.out.println("Page title: - " + strPageTitle);
		Assert.assertTrue(strPageTitle.equalsIgnoreCase("Google"), "Page title doesn't match");
	}

	@AfterTest
	public void tearDown() throws InterruptedException {

		driver.quit();

	}
}
