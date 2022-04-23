package com.qa.tasks.tests;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.tasks.TestBase.TestBase;
import com.qa.tasks.pages.ShahzadAutomationAssessmentPage;

public class ShahzadAutomationTestCases extends TestBase {

	ShahzadAutomationAssessmentPage shahzadAutomationAssessmentPage;


	public ShahzadAutomationTestCases()
	{
		super();
	}


	@BeforeMethod
	public void setUp() throws TimeoutException
	{
		initialization();
		shahzadAutomationAssessmentPage = new ShahzadAutomationAssessmentPage();
	}


	@Test(priority=1)
	public void validateUrlHitProcessFtn() throws InterruptedException
	{
		boolean value=shahzadAutomationAssessmentPage.urlHitProcessFtn();
		Assert.assertTrue(value);		
	}


	@Test(priority=2)
	public void validatePlaceHolderTextForEmailAndPassword() throws InterruptedException
	{
		shahzadAutomationAssessmentPage.verifyPlaceHolderText();
		System.out.println("Assertions are passed");
	}


	@Test(priority=3)
	public void validateLocationOfKeepMeSignedInCheckBox() throws InterruptedException
	{
		shahzadAutomationAssessmentPage.verifyLocationOfKeepMeSignedInCheckBox();
	}


	@Test(priority=4)
	public void validateLocationOfForgotYourPasswordLink()
	{
		shahzadAutomationAssessmentPage.verifyLocationOfForgotYourPasswordLink();

	}


	@Test(priority=5)
	public void validateVisibleFieldsNotOverlapOnMinimumwindowSize()
	{
		shahzadAutomationAssessmentPage.verifyFieldsViewInMinimumWidthSize();

	}


	@Test(priority=6)
	public void validateErrorMessageOnInvalidCredentials() throws InterruptedException
	{
		shahzadAutomationAssessmentPage.verifyIncorrectEmailErrorMessage();
	}	
	
	@AfterMethod
	public void tearDown()throws IOException
	{
		shahzadAutomationAssessmentPage = null;
	}
	
}




