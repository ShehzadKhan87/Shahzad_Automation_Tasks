package com.qa.tasks.tests;


import java.util.concurrent.TimeoutException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.tasks.TestBase.TestBase;
import com.qa.tasks.pages.calculatorTask;

public class calculatorTaskTestCases extends TestBase{
	
	calculatorTask calculatorTask;
	
	
	public calculatorTaskTestCases()
	{
		super();
	}
	
	
	@BeforeMethod
	public void setUp() throws TimeoutException
	{
		initialization();
		calculatorTask = new calculatorTask();
	}

	@Test (priority = 1)
	public void validateSumCalculator()
	{
		int value = calculatorTask.sumCalculation();
		Assert.assertEquals(value, 1776);	
	}
	
	@Test (priority = 2)
	public void validatediffCalculator()
	{
		int value = calculatorTask.differenceCalculation();
		Assert.assertEquals(value, 196);	
	}
	
	@Test (priority = 3)
	public void validatemultCalculator()
	{
		int value = calculatorTask.multCalculation();
		Assert.assertEquals(value, 778743);	
	}
	
	@Test (priority = 4)
	public void validatedivCalculator()
	{
		float value = calculatorTask.divCalculation();
		Assert.assertEquals(value, 1.250950574874878);	
	}


}
