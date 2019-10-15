package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	public static WebDriver driver;

	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}


	By login = By.xpath("//a[contains(@href,'sign_in')]");
	By title = By.xpath("//h2[contains(text(),'Featured Courses')]");
	By navbar = By.xpath("//ul[@class='nav navbar-nav navbar-right']");

	public WebElement getLogin()
	{
		return driver.findElement(login);
	}

	public WebElement getTitle()
	{
		return driver.findElement(title);
	}

	public WebElement verifyNavBar()
	{
		return driver.findElement(navbar);
	}




}
