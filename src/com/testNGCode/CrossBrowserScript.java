package com.testNGCode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowserScript {
	private static String[]	links			= null;
	private static int		linksCount	= 0;
	WebDriver					driver;

	/**
	 * This function will execute before each Test tag in testng.xml
	 * 
	 * @param browser
	 * @throws Exception
	 */
	@BeforeClass
	@Parameters("browser")
	public void setup(String browser) throws Exception {
		// Check if parameter passed from TestNG is 'firefox'
		if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/drivers/geckodriver.exe");
			System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
			driver = new FirefoxDriver();

		}
		// Check if parameter passed as 'chrome'
		else if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("disable-infobars");
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("credentials_enable_service", false);
			prefs.put("profile.password_manager_enabled", false);
			options.setExperimentalOption("prefs", prefs);
			driver = new ChromeDriver(options);
		}

		else {
			// If no browser passed throw exception
			throw new Exception("Browser is not correct");
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test(invocationCount=4)
	public void testClickOnLinks() throws InterruptedException {
		try {
			driver.get("https://seleniumcodeexample.blogspot.in/");
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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@AfterSuite
	public void closeBrowser() {
		driver.quit();
	}
}

