package com.practiceCode;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 *
 * @author Deepak Gupta
 * @Created Date 23-08-2017
 *
 */
public class GetDropDownOptions extends SuperTestNG {

	@BeforeClass
	public void enterURL() {
		driver.get("http://only-testing-blog.blogspot.in/2013/09/testing.html");
	}

	@Test()
	public void printDropDownOptions() {
		try {
			WebElement ele = driver.findElement(By.name("FromLB"));
			Select select = new Select(ele);
			List<WebElement> options = select.getOptions();

			/**
			 * Option 1- for loop
			 */

			System.out.println("Number of Options:" + options.size());
			System.out.println("@@@@@@@ for loop @@@@@@@ ");
			for (int i = 0; i < options.size(); i++) {
				System.out.println(options.get(i).getText());
			}

			/**
			 * Option 2- for each loop
			 */
			System.out.println("@@@@@@@ for each loop @@@@@@@ ");
			for (WebElement a : options) {
				System.out.println(a.getText());
			}

			/**
			 * Option 3- Iterator loop
			 */

			System.out.println("@@@@@@@ Iterator loop @@@@@@@ ");
			Iterator<WebElement> it = options.iterator();
			while (it.hasNext()) {
				System.out.println(it.next().getText());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
