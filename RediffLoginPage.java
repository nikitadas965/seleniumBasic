package objectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
/**Keeping all the objects of login page in one class*/
public class RediffLoginPage {
	WebDriver driver;

	public	RediffLoginPage(WebDriver driver)
	{
		this.driver=driver;
	}

	By username =By.xpath("//input[@id='login1']");
	By password = By.xpath("//input[@id='password']");
	By go = By.xpath("//input[@name='proceed']");
	By home=By.linkText("Home");

	public WebElement EmailId() // these methods will be used 
	{
		return driver.findElement(username);
	}

	public WebElement Password()
	{
		return driver.findElement(password);
	}

	public WebElement submit()
	{
		return driver.findElement(go);
	}

	public WebElement Home()
	{
		return driver.findElement(home);
	}


}
