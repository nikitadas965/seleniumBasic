package com.Project;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.base;

public class VerifynavbAr extends base {

	private static Logger log=LogManager.getLogger(base.class.getName());
	public static WebDriver driver;

	public VerifynavbAr() {
		// TODO Auto-generated constructor stub	

	}
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver=initializeDriver(); // calling method from base class
		driver.get(prop.getProperty("url"));
		

	}
	@Test
	public void baseNavigation() throws IOException
	{
		LandingPage page = new LandingPage(driver);
		Assert.assertTrue(page.verifyNavBar().isDisplayed());

		//isDisplayed method returns true is present else false
		//Assert.assertTrue expects value to be true 
		log.info("assertion done for navbar");
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
		driver=null;
	}

}
