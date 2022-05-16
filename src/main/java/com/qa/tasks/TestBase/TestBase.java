package com.qa.tasks.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.piqo.qa.testUtilities.TestUtil;




public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebDriverEventListener eventListener;
	
	
	public TestBase(){
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:\\Users\\LENOVO\\eclipse-workspace\\MySeleniumAutomationTasks\\src\\main\\java\\com\\qa\\tasks\\EnvironmentalVariables\\Config.properties");

			//	C:\Users\Dell\eclipse-workspace\glf_test_automation\src\main\java\com\glf\qa\environmentalVariables

			prop.load(ip);
		}

		catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	

	public static void initialization()throws TimeoutException{
		String browserName = prop.getProperty("browser");
		

		if(browserName.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\LENOVO\\Downloads\\Compressed\\chromedriver.exe");
			driver = new ChromeDriver();			
		}
		
		
		//		else if(browserName.equals("FF")){
		//			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Dell\\Downloads\\Automation Files\\geckodriver.exe");	
		//			driver = new FirefoxDriver(); 
		//		}


		//		e_driver = new EventFiringWebDriver(driver);
		//		
		//		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		//		
		//		eventListener = new WebEventListener();
		//		e_driver.register(eventListener);
		//		driver = e_driver;

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);


		try {	
			driver.get(prop.getProperty("url"));
		}
		catch(Exception ex) {
			driver.navigate().refresh();
		}

	}
}




