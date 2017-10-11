package com.practiceCode;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

/**
 *
 * @author Deepak Gupta
 * @Created Date 23-08-2017
 *
 */
public class FireFoxSetHomePage {

	WebDriver driver;

	@Test
	public void testFireFoxProfile() throws InterruptedException {

		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/drivers/geckodriver.exe");
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("browser.startup.homepage", "http://www.google.com");
		driver = new FirefoxDriver(profile);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("lst-ib")).sendKeys("100");

	}

	@AfterTest
	public void end() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}

}
