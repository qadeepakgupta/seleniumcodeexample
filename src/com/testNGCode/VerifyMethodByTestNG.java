package com.testNGCode;

import org.testng.annotations.Test;

public class VerifyMethodByTestNG {
	@Test
	public void testLoginValid() {
		System.out.println("testLoginValid() Method");
	}

	@Test
	public void testLoginInValid() {
		System.out.println("testLoginInValid() Method");
	}

	@Test
	public void testLoginBlank() {
		System.out.println("testLoginBlank() Method");
	}

	@Test
	public void testDemo() {
		System.out.println("testDemo() Method");
	}
}