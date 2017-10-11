package com.practiceCode;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 *
 * @author Deepak Gupta
 * @Created Date 23-08-2017
 *
 */
public class FileDownloadFirefox {

	WebDriver driver;

	@BeforeTest
	public void setUp() {

		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/drivers/geckodriver.exe");

		// Create object of FirefoxProfile in built class to access Its properties.
		FirefoxProfile fprofile = new FirefoxProfile();
		// Set Location to store files after downloading.
		fprofile.setPreference("browser.download.dir", "D:\\FileDownload\\");
		fprofile.setPreference("browser.download.folderList", 2);
		// Set Preference to not show file download confirmation dialogue using MIME
		// types Of different file extension types.
		fprofile.setPreference("browser.helperApps.neverAsk.saveToDisk",
				"application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;"// MIME types Of MS Excel File.
						+ "application/pdf;" // MIME types Of PDF File.
						+ "application/vnd.openxmlformats-officedocument.wordprocessingml.document;" 
						// MIME types Of MS doc File.
						+ "text/plain;"// MIME types Of text File.
						+ "application/zip;"// MIME types Of Zip File.
						+ "text/csv"); // MIME types Of CSV File.
		fprofile.setPreference("browser.download.manager.showWhenStarting", false);
		fprofile.setPreference("pdfjs.disabled", true);
		// Pass fprofile parameter In webdriver to use preferences to download file.
		driver = new FirefoxDriver(fprofile);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@AfterTest
	public void tearDown() throws InterruptedException {
		try {
			if (driver != null) {
				driver.quit();
			}
		} catch (Exception e) {
			System.out.println("Expection is :" + e);
		}
	}

	@Test(priority = 0)
	public void downloadTextFile() {
		try {
			driver.get("http://only-testing-blog.blogspot.in/2014/05/login.html");

			// Download Text File
			driver.findElement(By.linkText("Download Text File")).click();
			System.out.println("Download Text File link is clicked");

			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 1)
	public void downloadPDFFile() {
		try {

			// Download PDF File
			driver.findElement(By.linkText("Download PDF File")).click();
			System.out.println("Download PDF File link is clicked");
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 2)
	public void downloadCSVFile() {
		try {

			// Download CSV File
			driver.findElement(By.linkText("Download CSV File")).click();
			System.out.println("Download CSV File link is clicked");
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 3)
	public void downloadExcelFile() {
		try {

			// Download Excel File
			driver.findElement(By.linkText("Download Excel File")).click();
			System.out.println("Download Excel File link is clicked");
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 4)
	public void downloadDocFile() {
		try {

			// Download Doc File
			driver.findElement(By.linkText("Download Doc File")).click();
			System.out.println("Download Doc File link is clicked");
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
