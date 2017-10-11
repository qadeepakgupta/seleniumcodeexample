package com.testNGCode;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class PassInputThruXML {
	@Test
	@Parameters({ "para1", "para2" })
	public void passInput(String para1, double para2) {
		System.out.println(para1);
		System.out.println(para2);
	}
}
