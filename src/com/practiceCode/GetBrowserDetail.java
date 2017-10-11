package com.practiceCode;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 *
 * @author Deepak Gupta
 * @Created Date 23-08-2017
 *
 */
public class GetBrowserDetail {

	WebDriver driver;

	@BeforeTest
	public void setup() {

		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/drivers/geckodriver.exe");
		driver = new FirefoxDriver();
		// Check and print Firefox browser and OS detail.
		CheckBrowserOS();
		driver.close();

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		// Check and print Chrome browser and OS detail.
		CheckBrowserOS();
		driver.close();

		System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "/drivers/IEDriverServer.exe");
		driver = new InternetExplorerDriver();
		// Check and print IE browser and OS detail.
		CheckBrowserOS();
		driver.close();
		driver.quit();
	}

	public void CheckBrowserOS() {
		// Get Browser name and version.
		Capabilities caps = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = caps.getBrowserName();
		String browserVersion = caps.getVersion();

		// Get OS name.
		String os = System.getProperty("os.name").toLowerCase();
		System.out.println("\n OS = " + os + ", Browser = " + browserName + " " + browserVersion);
	}

	@Test
	public void testBrowserOS() {
		System.out.println("\n==============================================");
	}
}
