package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import objectRepo.RediffHomepage;
import objectRepo.RediffLoginPage;

public class LogintestCast {

	@Test
	public void login()
	{

		System.setProperty("webdriver.chrome.driver", "C://Users//nikitdas.CORP//Desktop//selenium//chromedriver_win32 (1)//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		RediffLoginPage login = new RediffLoginPage(driver);
		login.EmailId().sendKeys("hello");
		login.Password().sendKeys("hello");
		//login.submit().click();
		login.Home().click();

		RediffHomepage rh=new RediffHomepage(driver);
		rh.Search().sendKeys("rediff");
		rh.Submit().click();

	}

}
