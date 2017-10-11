package com.practiceCode;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
/**
*
* @author Deepak Gupta
* @Created Date 23-08-2017
*
*/
public class ClickOnAllLinks extends SuperTestNG {

	private static String[] links = null;
	private static int linksCount = 0;

	@Test
	public void testClickOnLinks() throws InterruptedException {

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

	}
}
