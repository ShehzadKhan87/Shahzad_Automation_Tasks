package com.qa.tasks.pages;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.qa.tasks.TestBase.TestBase;

public class ShahzadAutomationAssessmentPage extends TestBase {


	@FindBy (xpath = "//input[@id='usernameInput']")
	public WebElement emailTxtBox;

	@FindBy (xpath = "//input[@id='passwordInput']")
	public WebElement pwdTxtBox;

	@FindBy (xpath = "//button[@data-group='loginForm']")
	WebElement signInBtn;

	@FindBy (xpath = "//label[contains(@text(),'')]/parent::div[@class='ui checkbox mrbm ']")
	WebElement keepMeSignedInChckBox;

	@FindBy (xpath = "//a[contains(@class,' color-login-links  mrrs mrtm')]")
	WebElement forgotPwdLinkBtn;

	@FindBy (xpath = "//a[contains(@class,' color-login-links mrrs')]")
	WebElement dontHaveAnAccountLinkBtn;

	@FindBy(className="user-avatar")
	WebElement userAvatar;

	@FindBy(xpath="//input[@id='usernameInput']")
	public WebElement emailCaptionLabel;

	//input[@id='passwordInput']/following-sibling::div/span[@classname]
	@FindBy(xpath="//input[@id='passwordInput']")
	public WebElement passwordCaptionLabel;

	@FindBy (xpath = "//a[contains(@class,' color-login-links  mrrs mrtm')]")
	WebElement forgotPasswordLink;

	@FindBy (xpath = "//span[@class='color-white text-size-l']")
	WebElement incorrectCredentsErrorMessage;



	public ShahzadAutomationAssessmentPage()
	{
		PageFactory.initElements(driver, this);
	}


	public boolean urlHitProcessFtn() throws InterruptedException {
		//logging in the user with correct credentials
		emailTxtBox.sendKeys("fast_mani@yahoo.com");
		pwdTxtBox.sendKeys("abcde12345@");
		signInBtn.click();
		Thread.sleep(2000);

		//After login, the user avatar is displayed.So verifying it after login
		return userAvatar.isDisplayed();	
	}


	public String emailText,emailCaptionalLabelText,pwdTxtBoxText,passwordCaptionLabelText;
	public void verifyPlaceHolderText() throws InterruptedException
	{
		emailTxtBox.click();
		boolean v1=emailCaptionLabel.getAttribute("placeholder").contains("Enter your email address");

		//Comparing that the text 'Email' is in the placeholder, not in the email caption label and same or password.
		Assert.assertNotEquals(v1, "Email");

		Thread.sleep(2000);
		driver.navigate().refresh();

		pwdTxtBox.click();
		emailTxtBox.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;  
		js.executeScript("arguments[0].click();",pwdTxtBox);
		boolean v2=passwordCaptionLabel.getAttribute("placeholder").contains("Enter your password");
		Assert.assertNotEquals(v2, "Password");

	}


	public void verifyLocationOfKeepMeSignedInCheckBox() throws InterruptedException 
	{
		//Since all these values lie on the same X-Axis value, I-e 533 , So we need to check only on the Y-Axis to differentiate.

		int locationOfPasswordField	=	pwdTxtBox.getLocation().getY();
		int locationOfCheckBox		=	keepMeSignedInChckBox.getLocation().getY();
		int locationOfSignInButton	=	signInBtn.getLocation().getY();

		//Checking through multiple conditions
		if(locationOfCheckBox>locationOfPasswordField&&locationOfCheckBox<locationOfSignInButton)
		{
			System.out.println("Success ! The CheckBox for'Keep Me Signed in' is inbetween Password & SignIn Button.");
		}
		else 
		{
			System.out.println("Failure ! The checkbox isn't at the right place ! ");
		}
	}


	public void verifyLocationOfForgotYourPasswordLink()
	{
		int locationOfSignInBtn	=	signInBtn.getLocation().getY();
		int locationOfForgotMyPasswordLink = forgotPasswordLink.getLocation().getY();

		System.out.println("Location number One : "+locationOfSignInBtn);
		System.out.println("Location number One : "+locationOfForgotMyPasswordLink);

		//Checking through multiple conditions
		if(locationOfSignInBtn<locationOfForgotMyPasswordLink)
		{
			System.out.println("Success !  'Forgot your password? Reset it now.' link is displayed below 'Sign in' button");
		}
		else
		{
			System.out.println("Failure ! Forgot your password Link is NOT displayed below Sign in Button.");
		}

	}

	public void verifyIncorrectEmailErrorMessage() throws InterruptedException
	{
		//Passing incorrect credentials
		emailTxtBox.sendKeys("abc@gmail.com");
		pwdTxtBox.sendKeys("Asdf@123");

		//clicking on the sign in button
		signInBtn.click();
		Thread.sleep(2000);

		String errorMessage = incorrectCredentsErrorMessage.getText();
		System.out.println("Error Message:  "+ errorMessage);	

	}

	public void verifyFieldsViewInMinimumWidthSize()
	{


		Dimension d = new Dimension(516,600);
		driver.manage().window().setSize(d);

		int locationOfEmailField = 		emailTxtBox.getLocation().getY();
		int locationOfPasswordField	=	pwdTxtBox.getLocation().getY();
		int locationOfSignInButton	=	signInBtn.getLocation().getY();

		//Get Browser Size to cross check
		System.out.println("Chrome browser size: " + driver.manage().window().getSize());

		//Checking with multiple conditions now
		if(locationOfEmailField==locationOfPasswordField)
		{
			System.out.println("The Fields are overlapping on the minimum window Size");
		}
		else if(locationOfPasswordField==locationOfSignInButton) 
		{
			System.out.println("The Fields are overlapping on the minimum window Size");	
		}
		else {
			System.out.println("Success ! The Fields are not overlapping on the minimum window Size");
		}

	}

}

