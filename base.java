package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;

public class base {

	public static WebDriver driver;
	public Properties prop;

	public WebDriver initializeDriver() throws IOException
	{
		FileInputStream fis= new FileInputStream("C:\\Users\\nikitdas.CORP\\Desktop\\Automation\\workspace_automation\\EndtoEndProject\\src\\main\\java\\resources\\data.properties");
		prop = new Properties();

		prop.load(fis);
		String browserName = prop.getProperty("browser");
		{
			if(browserName.equals("chrome"))
			{
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\nikitdas.CORP\\Desktop\\selenium\\chromedriver_win32 (1)\\chromedriver.exe");
				driver = new ChromeDriver();
			}
			else if(browserName.equals("firefox"))
			{
				//code 
			}
			else if(browserName.equals("IE"))
			{
				//code
			}
		}
		//Implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		return driver;


	}
	
	/* public static boolean isAlertPresent(WebDriver ldriver){
		 
         try{

         ldriver.switchTo().alert();

         return true;

         }catch(NoAlertPresentException ex){

         return false;}

         }*/

	public void getScreenshot(String result) throws IOException
	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Files.copy(src, new File("C:\\Users\\nikitdas.CORP\\Desktop\\screenshot\\"+result+"src.png"));
		
	}
}
