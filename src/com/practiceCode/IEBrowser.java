package com.practiceCode;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
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
public class IEBrowser {

	WebDriver driver;

	@BeforeTest
	public void openIEBrowser() {

		System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "/drivers/IEDriverServer.exe");

		DesiredCapabilities cap = DesiredCapabilities.internetExplorer();
		cap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);

		driver = new InternetExplorerDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void testGooglePageTitleInIEBrowser() throws InterruptedException {

		driver.navigate().to("https://seleniumcodeexample.blogspot.in/");
		String strPageTitle = driver.getTitle();
		System.out.println("Page title: - " + strPageTitle);
		Assert.assertTrue(strPageTitle.equalsIgnoreCase("Selenium WebDriver With Core Java Code Examples For Practice"),
				"Page title doesn't match");

	}

	@AfterTest
	public void closeIEBrowser() throws InterruptedException {
		driver.quit();
	}

}
