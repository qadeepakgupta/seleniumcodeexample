package com.testNGCode;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.practiceCode.SuperTestNG;

public class DataProviderExample extends SuperTestNG {

	@Test(dataProvider = "DataInput")
	public void login(String userName, String pass, String expTitle) throws InterruptedException {
		driver.get("https://in.yahoo.com/");
		Actions act = new Actions(driver);
		// login
		act.moveToElement(driver.findElement(By.xpath("//em[text()='Sign In']"))).perform();
		driver.findElement(
				By.xpath("//span//a[@class='login-svc ylogin login-btn-purple rapid-noclick-resp login-btn-small']"))
				.click();
		driver.findElement(By.id("username")).sendKeys(userName);
		driver.findElement(By.id("passwd")).sendKeys(pass);
		driver.findElement(By.xpath("//button[contains(text(),'Sign in')]")).click();

		Thread.sleep(2000);
		String actTitle = driver.getTitle();
		try {
			Assert.assertEquals(actTitle, expTitle);
			driver.close();
		} catch (Exception e) {
			driver.close();
		}

	}

	@DataProvider(name = "DataInput")
	public static Iterator fetchData() throws InvalidFormatException, IOException {
		ArrayList myData = new ArrayList();
		FileInputStream fis = new FileInputStream("./InputData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet4");
		int numOfRows = sh.getLastRowNum();
		String userName, pass, expTitle;
		for (int i = 0; i < numOfRows; i++) {
			userName = sh.getRow(i).getCell(0).getStringCellValue();
			pass = sh.getRow(i).getCell(1).getStringCellValue();
			expTitle = sh.getRow(i).getCell(2).getStringCellValue();
			myData.add(new Object[] { userName, pass, expTitle });
		}
		return myData.iterator();
	}
}