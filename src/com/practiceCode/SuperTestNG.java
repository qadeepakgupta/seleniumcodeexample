package com.practiceCode;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

/**
 *
 * @author Deepak Gupta
 * @Created Date 23-08-2017
 *
 */
public class SuperTestNG {
	public WebDriver driver;

	
	@BeforeClass
	public void setUp() {
		String log4jConfPath = "log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);
		selectBrowser("chrome");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	public void selectBrowser(String browser) {

		if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("disable-infobars");
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("credentials_enable_service", false);
			prefs.put("profile.password_manager_enabled", false);
			options.setExperimentalOption("prefs", prefs);
			driver = new ChromeDriver(options);
		} else if (browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/drivers/geckodriver.exe");
			System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
			driver = new FirefoxDriver();
		} else if (browser.equals("ie")) {
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "/drivers/IEDriverServer.exe");
			DesiredCapabilities dc = new DesiredCapabilities();
			dc.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			driver = new InternetExplorerDriver(dc);
		}

	}

	@AfterClass
	public void tearDown() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();

	}
}
