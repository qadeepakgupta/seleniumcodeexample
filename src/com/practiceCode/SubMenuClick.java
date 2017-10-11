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
public class SubMenuClick extends SuperTestNG {

	@Test
	public void testSubMenuClick() {

		driver.get("http://executeautomation.com/blog/");
		subMenuClickExample1();
	}

	/**
	 * Method 1
	 */
	public void subMenuClickExample1() {
		Actions actions = new Actions(driver);
		WebElement mainMenu = driver.findElement(By.xpath("//*[@id='menu-item-1885']/a"));
		actions.moveToElement(mainMenu);

		WebElement subMenu = driver.findElement(By.xpath(".//*[@id='menu-item-1887']/a"));
		actions.moveToElement(subMenu).click().build().perform();
	}

	/**
	 * Method 2
	 */
	public void subMenuClickExample2() {
		Actions action = new Actions(driver);
		WebElement mainMenu = driver.findElement(By.xpath("//*[@id='menu-item-1885']/a"));
		action.moveToElement(mainMenu).moveToElement(driver.findElement(By.xpath(".//*[@id='menu-item-1887']/a"))).click().build().perform();
	}

}
