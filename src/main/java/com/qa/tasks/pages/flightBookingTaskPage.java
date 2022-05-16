package com.qa.tasks.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.tasks.TestBase.TestBase;


public class flightBookingTaskPage extends TestBase {

	//	@FindBy (xpath = "(//span[@class='im-close'])[2]")
	//	WebElement popUpCloseBtn;

	@FindBy (id="TT_OW")
	WebElement oneWayTripSelectorBtn;

	@FindBy (xpath = "//div[@class='datepicker depart no-return selected']/span")
	WebElement datePickerBtn;

	@FindBy (xpath ="//div[@class='vc-h-full']/span[@aria-label='Saturday, April 30, 2022']")
	WebElement dateSelectionFromCalender;

	@FindBy (xpath = "//span[contains(text(),'Search')]")
	WebElement searchBtn;

	@FindBy (xpath = "//span[@class='price'][1]")
	WebElement priceSelectionBtn;

	@FindBy (xpath = "//div[@class='terms-and-conditions-link']/label")
	WebElement termsAndConditionsBtn;

	@FindBy (xpath = "//div[@class='action']/button")
	WebElement continueBtn;

	@FindBy (xpath = "//div[@class='autocomplete read-only empty']/div")
	WebElement genderSelection;

	@FindBy (xpath = "(//ul[@id='autocomplete-results']/li[@id='MR'])[1]")
	WebElement mrBtnSelector;

	@FindBy (xpath = "//input[@id='firstName1']")
	WebElement firstNameTxtBox;
	
	@FindBy (xpath = "//input[@id='lastName1']")
	WebElement lastNameTxtBox;
	
	@FindBy (xpath = "//input[@id='PX[0].EM[0].email']")
	WebElement emailTxtBox;
	
	@FindBy (xpath = "//input[@id='PX[0].presentAddress']")
	WebElement residentialAddress;
	
	@FindBy (xpath = "//input[@id='PX[0].presentCity']")
	WebElement cityName;
	
	@FindBy (xpath = "//input[@id='PX[0].PH[0].phoneNumber']")
	WebElement mobileNumber;
	
	@FindBy (xpath = "//input[@id='PX[0].ID[0].documentID']")
	WebElement passportNRCNumber;
	
	@FindBy (xpath = "//div[@class='action']/button")
	WebElement continueBtn2;


	public flightBookingTaskPage()
	{
		PageFactory.initElements(driver, this);
	}


	
	public void flightBooking() throws InterruptedException {

		//		
		try {
			oneWayTripSelectorBtn.click();
		} catch (Exception e) {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();",oneWayTripSelectorBtn);
		}

		try {
			datePickerBtn.click();
		} catch (Exception e) {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();",datePickerBtn);
		}
		//dateSelectionFromCalender.click();
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();",dateSelectionFromCalender);

		searchBtn.click();
		priceSelectionBtn.click();
		Thread.sleep(5000);

		termsAndConditionsBtn.click();
		continueBtn.click();

		Thread.sleep(5000);

		genderSelection.click();
		mrBtnSelector.click();
		firstNameTxtBox.sendKeys("Shehzad");
		lastNameTxtBox.sendKeys("Amir Khan");
		emailTxtBox.sendKeys("shahzadkhan.3ssol@gmail.com");
		residentialAddress.click();
		residentialAddress.sendKeys("Lahore, Pakistan.");
		cityName.sendKeys("Lahore");
		mobileNumber.sendKeys("3439843976");
		passportNRCNumber.sendKeys("12345678912");
		continueBtn2.click();
		Thread.sleep(5000);
		
		
		
		
		
		
		
		Thread.sleep(5000);


	}



}
