package com.practiceCode;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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
public class TestLoginForm {

	WebDriver driver;

	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/drivers/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://github.com/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test
	public void verifyInvalidCredentials() throws InterruptedException {

		driver.findElement(By.id("login_field")).sendKeys("deepak");
		driver.findElement(By.id("password")).sendKeys("testing");
		driver.findElement(By.name("commit")).click();

		String actual = driver.findElement(By.xpath("//*[@id='js-flash-container']/div")).getText();
		System.out.println("Actual Error message is: " + actual);
		// Verify the actual and expected error message.
		Assert.assertEquals(actual, "Incorrect username or password.");
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
