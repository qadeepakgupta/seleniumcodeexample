package com.practiceCode;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
/**
*
* @author Deepak Gupta
* @Created Date 23-08-2017
*
*/
public class BreadCrumb extends SuperTestNG {

	@Test
	public void testBreadCrumb() {

		driver.get("http://www.etouch.net/home/index.html");
		WebElement service = driver.findElement(By.xpath("//a[text()='Services']"));
		Actions act = new Actions(driver);
		act.moveToElement(service).perform();
		driver.findElement(By.xpath("//li[a[text()='Services']]//a[text()='Enterprise Web']")).click();

		String breadcrumb = driver.findElement(By.xpath("//div[@class='breadcrumb']")).getText();
		System.out.println(breadcrumb);

		String lastBreadcrumb = driver.findElement(By.xpath("//div[@class='breadcrumb']/span[last()]")).getText();
		System.out.println(lastBreadcrumb);
		if (lastBreadcrumb.equals("Enterprise Web")) {
			System.out.println("bread crumb is in correct order.");
		} else {
			System.out.println("bread crumb is not in correct order.");
		}
	}
}
