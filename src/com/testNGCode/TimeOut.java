package com.testNGCode;

import org.testng.annotations.Test;

/**
 *
 * @author Deepak Gupta
 * @Created Date 30-08-2017
 *
 */
public class TimeOut {

	/**
	 * time is in milliseconds, here this test case will execute for max 3sec if it
	 * will not complete in 3sec then it will be failed.
	 * 
	 */
	@Test(timeOut = 3000)
	public void testShouldPass() throws InterruptedException {
		System.out.println("This test case should pass");
		Thread.sleep(1000); // wait for 1 sec
	}

	/**
	 * here this test case will execute for max 5sec if it will not complete in 5sec
	 * then it will be failed.
	 */
	@Test(timeOut = 5000)
	public void testShouldFail() {
		System.out.println("This test case should fail");
		while (true)
			;
		// this loop is never going to end as condition is always true
	}
}