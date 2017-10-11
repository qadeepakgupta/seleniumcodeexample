package com.practiceCode;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

/**
 *
 * @author Deepak Gupta
 * @Created Date 23-08-2017
 *
 */
public class IEUntrustedConnection {

	WebDriver driver;

	@Test
	public void testIEUntrustedConnection() {

		System.setProperty("webdriver.ie.driver", "./Browser_Driver/IEDriverServer.exe");
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		driver = new InternetExplorerDriver(dc);
		driver.get("https://192.168.13.102:8081/JobSpot");
		String js = "javascript:document.getElementById('overridelink').click();";
		driver.navigate().to(js);
	}

	@AfterClass
	public void end() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}

}
