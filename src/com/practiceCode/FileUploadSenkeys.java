package com.practiceCode;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
/**
*
* @author Deepak Gupta
* @Created Date 23-08-2017
*
*/
public class FileUploadSenkeys extends SuperTestNG {

	@Test
	public void testFileUploadBySendkeys() {
		try {
			driver.get("http://only-testing-blog.blogspot.in/2013/09/testing.html");
			driver.findElement(By.name("img")).sendKeys("D:\\FileDownload\\Testing Text.txt");
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
