package com.qa.tasks.tests;

import java.util.concurrent.TimeoutException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.tasks.TestBase.TestBase;
import com.qa.tasks.pages.flightBookingTaskPage;

public class flightBookingTaskTest extends TestBase {

	flightBookingTaskPage  flightBookingTaskPage;


	public flightBookingTaskTest()
	{
		super();
	}

	@BeforeMethod
	public void setUp() throws TimeoutException
	{
		initialization();
		flightBookingTaskPage = new flightBookingTaskPage();

	}

	@Test(priority=1)
	public void validateFlightBookingData() throws InterruptedException
	{
		flightBookingTaskPage.flightBooking();


	}

//	@AfterMethod
//	public void tearDown()throws IOException
//	{
//		driver.quit();
//	}


}
