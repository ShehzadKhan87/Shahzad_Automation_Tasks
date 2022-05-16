package com.qa.tasks.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.tasks.TestBase.TestBase;

public class piqoStudentsSmokeFunctionalitiesPage extends TestBase {
	
	@FindBy (id = "user_email")
	WebElement userEmailTxtBox;
	
	@FindBy (id = "user_password")
	WebElement userPasswordTxtBox;
	
	@FindBy (xpath = "//button[@class='btn btn-primary btn-lg w-100']")
	WebElement loginBtn;
	
	
	
	
	public piqoStudentsSmokeFunctionalitiesPage()
	{
		PageFactory.initElements(driver, this);
	}

	
	public void existingStudentLogin() throws InterruptedException {
		//Thread.sleep(10000);
		
		//new WebDriverWait(driver, 50).until(ExpectedConditions.elementToBeClickable(userEmailTxtBox)).click();
		
		userEmailTxtBox.sendKeys("piqosityqa@gmail.com");
		userPasswordTxtBox.sendKeys("123qasim");
		loginBtn.click();
		Thread.sleep(5000);
		
		
	}
	
	
	

}
