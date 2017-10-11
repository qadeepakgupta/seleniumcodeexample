package com.practiceCode;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
/**
*
* @author Deepak Gupta
* @Created Date 23-08-2017
*
*/
public class AlertPopUp extends SuperTestNG {

	/**
	 * Handling 3 types of Alert popups
	 * 
	 */
	@Test(priority = 0, enabled = true)
	public void javascriptAlertConfirm() throws InterruptedException {

		try {
			driver.navigate().to("file:///C:/Users/Deepak%20Gupta/Desktop/WebPage/Practice%20Form.htm");
			driver.findElement(By.cssSelector("input[value='Show Me Alert']")).click();
			WebDriverWait wait = new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions.alertIsPresent());
			// Alert condition
			Alert alrt = driver.switchTo().alert();
			Thread.sleep(2000);
			alrt.accept();
		} catch (Exception e) {
			System.out.println("Expection is : " + e);
		}
	}

	@Test(priority = 1, enabled = true)
	public void JavascriptAlertConfirmation() throws InterruptedException {

		try {
			driver.findElement(By.xpath("//button[text()='Show Me Confirmation']")).click();

			WebDriverWait wait = new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions.alertIsPresent());
			// Alert condition
			Alert alrt = driver.switchTo().alert();
			Thread.sleep(2000);
			// alrt.accept();
			alrt.dismiss();
			String text = driver.findElement(By.id("demo")).getText();
			if (text.equalsIgnoreCase("You pressed OK!")) {
				System.out.println("Ok button is clicked");
			} else {
				System.out.println("Cancel button is clicked");
			}
		} catch (Exception e) {
			System.out.println("Expection is : " + e);
		}
	}

	@Test(priority = 2, enabled = true)
	public void alertExampleForPromptBox() throws InterruptedException {

		try {
			driver.findElement(By.xpath("//button[text()='Show Me Prompt']")).click();

			WebDriverWait wait = new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions.alertIsPresent());

			// Alert condition
			Alert alrt = driver.switchTo().alert();
			System.out.println("Alert popup inner text is >> " + alrt.getText());
			Thread.sleep(2000);

			driver.switchTo().alert().sendKeys("Helllo");

			// alrt.accept();
			alrt.dismiss();

		} catch (Exception e) {
			System.out.println("Expection is : " + e);
		}
	}

	public static void handleAlert(WebDriver driver) {

		if (isAlertPresent(driver)) {
			Alert alert = driver.switchTo().alert();
			System.out.println(alert.getText());
			alert.accept();

		}

	}

	public static boolean isAlertPresent(WebDriver driver) {

		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException ex) {
			return false;

		}

	}
}