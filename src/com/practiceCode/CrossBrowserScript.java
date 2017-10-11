
package com.practiceCode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
/**
*
* @author Deepak Gupta
* @Created Date 23-08-2017
*
*/
public class CrossBrowserScript {

	WebDriver driver;
	private static String[] links = null;
	private static int linksCount = 0;

	@BeforeTest
	@Parameters("browser")
	public void setup(String browser) throws Exception {

		if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/drivers/geckodriver.exe");
			DesiredCapabilities dc = DesiredCapabilities.firefox();
			dc.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			FirefoxProfile profile = new FirefoxProfile();
			profile.setAcceptUntrustedCertificates(true);
			dc.setCapability(FirefoxDriver.PROFILE, profile);
			driver = new FirefoxDriver(dc);
		}

		else if (browser.equalsIgnoreCase("chrome")) {
			DesiredCapabilities handlSSLErr = DesiredCapabilities.chrome();
			handlSSLErr.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("disable-infobars");
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("credentials_enable_service", false);
			prefs.put("profile.password_manager_enabled", false);
			options.setExperimentalOption("prefs", prefs);
			driver = new ChromeDriver(options);

		} else if (browser.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "/drivers/IEDriverServer.exe");
			DesiredCapabilities dc = new DesiredCapabilities();
			dc.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			driver = new InternetExplorerDriver(dc);
		}

	}

	@Test
	public void testClickOnLinks() throws InterruptedException {

		driver.get("https://seleniumcodeexample.blogspot.in/");
		Thread.sleep(2000);
		List<WebElement> linksize = driver.findElements(By.tagName("a"));
		linksCount = linksize.size();
		System.out.println("Total no of links Available: " + linksCount);
		links = new String[linksCount];
		System.out.println("List of links Available: " + links);
		// print all the links from webpage
		for (int i = 0; i < linksCount; i++) {
			links[i] = linksize.get(i).getAttribute("href");
			System.out.println(linksize.get(i).getAttribute("href"));
		}
		// navigate to each Link on the webpage
		for (int i = 0; i < linksCount; i++) {
			if (links[i] != null && links[i].contains("https://seleniumcodeexample.blogspot.in"))
				driver.navigate().to(links[i]);

		}

	}

	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}

}