package com.Project;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import junit.framework.Assert;
import pageObjects.LandingPage;
import resources.base;

public class ValidateText extends base {

	public static WebDriver driver;
	private static Logger log=LogManager.getLogger(base.class.getName());
//	public static Logger log = LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver=initializeDriver(); // calling method from base class
		driver.get(prop.getProperty("url"));
		log.info("driver is initialized");

	}

	@Test
	public void baseNavigation() throws IOException
	{
		
		LandingPage page = new LandingPage(driver);
		//assertion
		Assert.assertEquals(page.getTitle().getText(), "FEATURED COURSES123");
		//comparison happens using Assert.assertEquals
		log.info("validated");


	}
	@AfterTest
	public void tearDown()
	{
		driver.close();
		driver=null;
	}




}
