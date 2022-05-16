package com.qa.tasks.tests;

import java.util.concurrent.TimeoutException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.tasks.TestBase.TestBase;
import com.qa.tasks.pages.piqoGlobalUsersRegistrationPage;

public class piqoGlobalUsersRegistrationTest extends TestBase {

	piqoGlobalUsersRegistrationPage PiqoGlobalUsersRegistrationPage; 



	public piqoGlobalUsersRegistrationTest()
	{
		super();
	}

	@DataProvider
	public Object[][] registerNowData()
	{
		Object data[][] = new Object[1][3];
		data[0][0]= piqoGlobalUsersRegistrationPage.fName;
		data[0][1]=	piqoGlobalUsersRegistrationPage.lName;
		data[0][2]= piqoGlobalUsersRegistrationPage.email;

		return data;
	}


	@BeforeMethod
	public void setUp() throws TimeoutException
	{
		initialization();
		PiqoGlobalUsersRegistrationPage = new piqoGlobalUsersRegistrationPage();

	}


	@Test(priority=1,dataProvider="registerNowData",dataProviderClass=piqoGlobalUsersRegistrationTest.class)
	public void validateNewStudentRegistration(String fName,String lName,String email) throws InterruptedException
	{
		PiqoGlobalUsersRegistrationPage.newStudentRegistration(fName, lName, email);
	}


	@Test(priority=2,dataProvider="registerNowData",dataProviderClass=piqoGlobalUsersRegistrationTest.class)
	public void validateNewEducatorRegistration(String fName,String lName,String email) throws InterruptedException
	{
		PiqoGlobalUsersRegistrationPage.newEducatorRegistration(fName, lName, email);
	}


	@Test(priority=3,dataProvider="registerNowData",dataProviderClass=piqoGlobalUsersRegistrationTest.class)
	public void validatenewOrganizationAdminRegistration(String fName,String lName,String email) throws InterruptedException
	{
		PiqoGlobalUsersRegistrationPage.newOrganizationAdminRegistration(fName, lName, email);
	}


}
