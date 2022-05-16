package com.qa.tasks.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.javafaker.Faker;
import com.qa.tasks.TestBase.TestBase;

public class piqoGlobalUsersRegistrationPage extends TestBase {

	@FindBy (xpath = "//a[@class='link-primary fw-border']")
	WebElement createAccountBtn;

	@FindBy (id = "user_type")
	WebElement userTypeDropDown;

	@FindBy (id= "org_type")
	WebElement tutoringCompanyDropDown;

	@FindBy (xpath = "//input[@placeholder = 'Company or School Name']")
	WebElement tutoringCompanySchoolNameTxtBox;

	@FindBy (id = "subdomain")
	WebElement subdomainNameTxtBox;

	@FindBy (xpath = "(//input[@id='first_name'])[1]")
	WebElement stdFirstNameTxtBox;

	@FindBy (xpath = "(//input[@id='first_name'])[2]")
	WebElement educatorFirstNameTxtBox;

	@FindBy (xpath = "(//input[@id='first_name'])[3]")
	WebElement orgAdminFirstNameTxtBox;

	@FindBy (xpath = "(//input[@id='last_name'])[1]")
	WebElement stdLastNameTxtBox;

	@FindBy (xpath = "(//input[@id='last_name'])[2]")
	WebElement educatorLastNameTxtBox;

	@FindBy (xpath = "(//input[@id='last_name'])[3]")
	WebElement orgAdminLastNameTxtBox;

	@FindBy (id = "job_title")
	WebElement jobTitleTxtBox;

	@FindBy (xpath = "(//input[@id='user_email'])[1]")
	WebElement stdEmailTxtBox;

	@FindBy (xpath = "(//input[@id='user_email'])[2]")
	WebElement educatorEmailTxtBox;

	@FindBy (xpath = "(//input[@placeholder='E-Mail Address'])[3]")
	WebElement orgAdminEmailTxtBox;

	@FindBy (xpath = "(//input[@id='student_location'])[1]")
	WebElement stdCityZipCodeTxtBox;

	@FindBy (xpath = "(//input[@id='teacher_location'])[1]")
	WebElement educatorCityZipCodeTxtBox;

	@FindBy (xpath = "(//input[@id='organization_location'])[1]")
	WebElement orgAdminCityZipCodeTxtBox;

	@FindBy (xpath = "(//input[@id='user_password'])[1]")
	WebElement stdPasswordTxtBox;

	@FindBy (xpath = "(//input[@id='teacher_password'])[1]")
	WebElement educatorPasswordTxtBox;

	@FindBy (xpath = "(//input[@id='admin_password'])[1]")
	WebElement orgAdminPasswordTxtBox;

	@FindBy (xpath = "(//input[@id='user_password_confirmation'])[1]")
	WebElement stdConfirmPasswordTxtBox;

	@FindBy (xpath = "(//input[@id='teacher_password_confirmation'])[1]")
	WebElement educatorConfirmPasswordTxtBox;

	@FindBy (xpath = "(//input[@id='confirm_password'])[1]")
	WebElement orgAdminConfirmPasswordTxtBox;

	@FindBy (id= "user_grade")
	WebElement userGradeDropDown;

	@FindBy (xpath = "(//select[@id='course_slug'])[1]")
	WebElement stdPrimaryCourseDropDown;

	@FindBy (xpath = "(//select[@id='course_slug'])[2]")
	WebElement educatorPrimaryCourseDropDown;

	@FindBy (id= "student_terms")
	WebElement studentTermsAndPrivacyCheckBox;

	@FindBy (id = "teacher_terms")
	WebElement teacherTermsAndPrivacyCheckBox;

	@FindBy (id = "org_terms")
	WebElement orgAdminAuthCheckBox;

	@FindBy (id = "org_authorized")
	WebElement orgAdminTermsAndPrivacyCheckBox;

	@FindBy (xpath = "(//span[@class='indicator-label'])[1]")
	WebElement stdJoinPiqosityBtn;

	@FindBy (xpath = "(//span[@class='indicator-label'])[2]")
	WebElement educatorJoinPiqosityBtn;

	@FindBy (xpath = "(//span[@class='indicator-label'])[3]")
	WebElement orgAdminJoinPiqosityBtn;


	public static Faker faker = new Faker();
	public static String fName= faker.name().firstName();
	public static String lName = faker.name().lastName();
	public static String email = lName+"@gmail.com";

	//+TestUtil.userIntiger()


	public piqoGlobalUsersRegistrationPage()
	{
		PageFactory.initElements(driver, this);
	}



	public void newStudentRegistration(String fName,String lName,String email) throws InterruptedException {

		createAccountBtn.click();
		Thread.sleep(5000);

		Select userRoleType = new Select(userTypeDropDown);
		userRoleType.selectByVisibleText("Student/ Parent");

		stdFirstNameTxtBox.sendKeys(fName);
		stdLastNameTxtBox.sendKeys(lName);
		stdEmailTxtBox.sendKeys(email);
		stdCityZipCodeTxtBox.sendKeys("54600");
		stdPasswordTxtBox.sendKeys("Abc@12345");
		stdConfirmPasswordTxtBox.sendKeys("Abc@12345");

		Select gradeSelector = new Select(userGradeDropDown);
		gradeSelector.selectByVisibleText("3");

		Select stdPrimaryCourseSelector = new Select(stdPrimaryCourseDropDown);
		stdPrimaryCourseSelector.selectByVisibleText("Algebra 1");

		boolean selected = studentTermsAndPrivacyCheckBox.isSelected();
		if(!selected)
		{
			studentTermsAndPrivacyCheckBox.click();
		}
		stdJoinPiqosityBtn.click();

		Thread.sleep(7000);

	}



	public void newEducatorRegistration(String fName,String lName,String email) throws InterruptedException {

		createAccountBtn.click();
		Thread.sleep(5000);

		Select userRoleType = new Select(userTypeDropDown);
		userRoleType.selectByVisibleText("Tutor/ Teacher");

		//		to perform Scroll on application using Selenium.
		//		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//		jse.executeScript("window.scrollBy(0,350)");

		//		new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(firstNameTxtBox)).click();
		//		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

		//		JavascriptExecutor js = (JavascriptExecutor)driver;
		//		js.executeScript("document.getElementById('first_name').setAttribute('value', 'Shehzad')");

		educatorFirstNameTxtBox.sendKeys(fName);
		educatorLastNameTxtBox.sendKeys(lName);
		educatorEmailTxtBox.sendKeys(email);
		educatorCityZipCodeTxtBox.sendKeys("54000");
		educatorPasswordTxtBox.sendKeys("Abc@12345");
		educatorConfirmPasswordTxtBox.sendKeys("Abc@12345");

		Select educatorPrimaryCourseSelector = new Select(educatorPrimaryCourseDropDown);
		educatorPrimaryCourseSelector.selectByVisibleText("Algebra 1");

		boolean selected = teacherTermsAndPrivacyCheckBox.isSelected();
		if(!selected)
		{
			teacherTermsAndPrivacyCheckBox.click();
		}
		educatorJoinPiqosityBtn.click();

		Thread.sleep(7000);

	}



	public void newOrganizationAdminRegistration(String fName,String lName,String email) throws InterruptedException {

		createAccountBtn.click();
		Thread.sleep(5000);

		Select userRoleType = new Select(userTypeDropDown);
		userRoleType.selectByVisibleText("Tutoring Company/ School");

		Select tutoringCompanySelector = new Select(tutoringCompanyDropDown);
		tutoringCompanySelector.selectByVisibleText("School");

		tutoringCompanySchoolNameTxtBox.sendKeys("UET Lahore");
		subdomainNameTxtBox.sendKeys(".App");	

		orgAdminFirstNameTxtBox.sendKeys(fName);
		orgAdminLastNameTxtBox.sendKeys(lName);
		jobTitleTxtBox.sendKeys("Test Automation Engineer");
		orgAdminEmailTxtBox.sendKeys(email);
		orgAdminCityZipCodeTxtBox.sendKeys("54000");
		orgAdminPasswordTxtBox.sendKeys("Abc@12345");
		orgAdminConfirmPasswordTxtBox.sendKeys("Abc@12345");

		boolean selected1 = orgAdminAuthCheckBox.isSelected();
		if(!selected1)
		{
			orgAdminAuthCheckBox.click();
		}

		boolean selected2 = orgAdminTermsAndPrivacyCheckBox.isSelected();
		if(!selected2)
		{
			orgAdminTermsAndPrivacyCheckBox.click();
		}
		orgAdminJoinPiqosityBtn.click();

		Thread.sleep(7000);

	}

}
