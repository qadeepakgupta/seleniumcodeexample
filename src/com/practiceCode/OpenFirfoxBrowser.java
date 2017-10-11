package com.practiceCode;

import java.io.IOException;

import org.testng.annotations.Test;

/**
 * @ How to open firefox browser without using FirefoxDriver;
 * 
 * @author Deepak Gupta
 *
 */
public class OpenFirfoxBrowser {

	@Test
	public void testBrowser() throws IOException {
		Runtime.getRuntime().exec("C:\\Program Files\\Mozilla Firefox\\firefox.exe");

	}

}
