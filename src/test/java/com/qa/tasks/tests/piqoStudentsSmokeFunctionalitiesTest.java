package com.qa.tasks.tests;

import java.util.concurrent.TimeoutException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.tasks.TestBase.TestBase;
import com.qa.tasks.pages.piqoStudentsSmokeFunctionalitiesPage;

public class piqoStudentsSmokeFunctionalitiesTest extends TestBase {

	piqoStudentsSmokeFunctionalitiesPage PiqoStudentsSmokeFunctionalitiesPage; 

	public piqoStudentsSmokeFunctionalitiesTest()
	{
		super();
	}
	
	
	@BeforeMethod
	public void setUp() throws TimeoutException
	{
		initialization();
		PiqoStudentsSmokeFunctionalitiesPage = new piqoStudentsSmokeFunctionalitiesPage();

	}
	
	@Test(priority = 1)
	public void validateExistingStudentLogin() throws InterruptedException {
		PiqoStudentsSmokeFunctionalitiesPage.existingStudentLogin();
	}


}
