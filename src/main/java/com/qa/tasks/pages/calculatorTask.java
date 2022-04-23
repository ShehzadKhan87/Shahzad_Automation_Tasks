package com.qa.tasks.pages;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;

import com.qa.tasks.TestBase.TestBase;

public class calculatorTask extends TestBase {





	public calculatorTask()
	{
		PageFactory.initElements(driver, this);
	}


//	ChromeOptions options = new ChromeOptions()
//	options.addArgument("headless");
//	ChromeDriver driver = new ChromeDriver(options);


	public int sum,diff,mult;
	public float div;
	public int sumCalculation()
	{
		int a=987,b=789;
		sum= a+b;

		System.out.println("The result for the sum of the two numbers is: "+ sum);
		return sum;


	}

	public int differenceCalculation()
	{
		int a=987,b=789;
		diff= a-b;

		System.out.println("The result for the diff of the two numbers is: "+ diff);
		return diff;


	}

	public int multCalculation()
	{
		int a=987,b=789;
		mult= a*b;

		System.out.println("The result for the mult of the two numbers is: "+ mult);
		return mult;


	}

	public float divCalculation()
	{
		float a=987,b=789;
		div= a/b;

		System.out.println("The result for the div of the two numbers is: "+ div);
		return div;


	}





}
