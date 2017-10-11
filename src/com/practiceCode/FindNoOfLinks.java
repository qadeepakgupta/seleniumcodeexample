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
public class FindNoOfLinks extends SuperTestNG {

	@Test
	public void test() throws InterruptedException {
		try {
			driver.get("https://seleniumcodeexample.blogspot.in/");
			List<WebElement> no = driver.findElements(By.tagName("a"));
			int nooflinks = no.size();
			System.out.println("Number of Links : " + nooflinks);
			for (WebElement pagelink : no) {
				String linktext = pagelink.getText();
				String link = pagelink.getAttribute("href");
				System.out.println(linktext + " ->");
				System.out.println(link);
			}
		} catch (Exception e) {
			System.out.println("error " + e);
		}

	}

}
