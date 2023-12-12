package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Baseclass {
	
	public static WebDriver driver;

	public static void  OpenBrowser(String browser)
	{
		if(browser == "Chrome")
		{
			driver = new ChromeDriver();
		}
		
		if(browser == "FireFox")
		{
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://demo.openmrs.org/openmrs/login.htm");
		
	}
	
	public static void closebrowser()
	{
		driver.close();
	}
	
		
		
	
	
}
