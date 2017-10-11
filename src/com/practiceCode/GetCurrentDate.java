package com.practiceCode;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.Test;

/**
 *
 * @author Deepak Gupta
 * @Created Date 23-08-2017
 *
 */
public class GetCurrentDate {

	@Test
	public void testGetCurrentDate() {

		try {
			// "dd-MMM-YYYY hh:mm a"
			DateFormat dateFormat2 = new SimpleDateFormat("dd-MMM-YYYY hh:mm a");
			Date date2 = new Date();

			String today = dateFormat2.format(date2);
			System.out.println("Current date is :  " + today);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
