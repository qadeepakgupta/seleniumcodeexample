package com.practiceCode;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

public class DisableFirefoxLog {

	WebDriver driver;

	@Test
	public void testDisableFirefoxLog() throws InterruptedException, IOException {
		LoggingPreferences pref = new LoggingPreferences();
		pref.enable(LogType.BROWSER, Level.OFF);
		pref.enable(LogType.CLIENT, Level.OFF);
		pref.enable(LogType.DRIVER, Level.OFF);
		pref.enable(LogType.PERFORMANCE, Level.OFF);
		pref.enable(LogType.PROFILER, Level.OFF);
		pref.enable(LogType.SERVER, Level.OFF);

		DesiredCapabilities cap = DesiredCapabilities.firefox();
		cap.setCapability(CapabilityType.LOGGING_PREFS, pref);
		cap.setCapability("marionette", true);
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/drivers/geckodriver.exe");
		driver = new FirefoxDriver(cap);
		driver.get("http://only-testing-blog.blogspot.in/2013/09/testing.html");
		List<WebElement> e = driver.findElements(By.xpath("//input[@type='checkbox']"));
		System.out.println("No. of check boxes: " + e.size());
		driver.quit();

	}

}
