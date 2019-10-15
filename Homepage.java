package com.Project;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class Homepage extends base {
	
	public static WebDriver driver;
	private static Logger log=LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void initialize() throws IOException
	{
		//get the life of the driver by initializing it
		//this driver needs to be passed to page object classes
		driver=initializeDriver(); // calling method from base class
		log.info("driver is initialized");

	}
	//test method
	@Test(dataProvider="getData")
	public void baseNavigation(String email,String pass,String text) throws IOException
	{
		driver.get(prop.getProperty("url"));
		LandingPage page=new LandingPage(driver); // passing to page object classes
		page.getLogin().click(); //similar to driver.FindElement(By.xpath(""));

		// passing to page object classes
		//after this is goes to the login page class due to call of constructor
		LoginPage login = new LoginPage(driver);
		login.getEmail().sendKeys(email);
		login.getPassword().sendKeys(pass);
		//login.getPassword();
		log.info(text);
		//System.out.println(text);
		login.submit().click();



	}
	
	
	/***** TEST CLASS EXAMPLE WHERE WE'LL MAKE THE OBJECT AND CALL
	 
	  public class VerifyWordpressLogin 
	{\
	 
	@Test
	public void verifyValidLogin()
	{
	 
	driver.get(prop.getProperty("url"));
	 
	LoginPage login=new LoginPage(driver);
	 
	 
	 
	login.clickOnLoginButton();
	 
	 
	driver.quit();
	 
	} **********/
	 
	//PARAMETERIZING DATA
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data=new Object[2][3]; //array 

		data[0][0]="nikita6467@gmail.com";
		data[0][1]="nikita6467";
		data[0][2]="Restricted";

		data[1][0]="nikita@gmail.com";
		data[1][1]="ni789";
		data[1][2]="Non-Restricted";

		return data;


	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
		driver=null;
	}

}
