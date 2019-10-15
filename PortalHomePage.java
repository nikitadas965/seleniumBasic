package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PortalHomePage {
	
	public WebDriver driver;
	
	//defined an object
	By searchBox = By.cssSelector("input[id='search-courses']");
	
	public PortalHomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public WebElement getSearchBox()
	{
		//calling an object
		return driver.findElement(searchBox);
		
	}

}
