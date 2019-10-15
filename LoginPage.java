package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginPage {

	public static WebDriver driver;

	By email = By.cssSelector("input[id='user_email']");
	By password = By.cssSelector("input[id='user_password']");
	By submit = By.cssSelector("input[name='commit']");

	// call from homepage comes here and
	//attaches to the local driver of this class
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	/*IF WE DONT USE THIS CONSTRUCTOR, NPE WILL BE THROWN*/

	public WebElement getEmail()
	{

		// then we attach the object by finding the elements
		return driver.findElement(email);

	}
	public WebElement submit()
	{
		return driver.findElement(submit);
	}

	public WebElement getPassword()//String pass 
	{
		return driver.findElement(password);//.sendkeys(pass);
	}




	
	  @Test(dataProvider="getData")
	 public void loginToWordpress(String userid,String pass)
{
 
driver.findElement(email).sendKeys(userid);
driver.findElement(password).sendKeys(pass);
driver.findElement(submit).click();
 
}
 
 
public void typeUserName(String uid)
{
 
driver.findElement(email).sendKeys(uid);
}
 
public void typePassword(String pass)
{
 
driver.findElement(password).sendKeys(pass);
}
 
public void clickOnLoginButton()
{
driver.findElement(submit).click();
}
	
}
	
 

	
	
	/********/
	
	/***PARAMETERIZING DATA
	@DataProvider
	public Object[][] getData()
	COL->NO.OF VALUES
	ROW->NO.OF SETS
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
	**/






