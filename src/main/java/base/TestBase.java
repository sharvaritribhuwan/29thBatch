package base;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import utility.ReadData;

public class TestBase 
{
	
    public static WebDriver driver;// global scope of ChromeDriver, static cause we don't want it to be changed, 
    // we took chromedriver cause we're working on it if we're working on firefox we can use firefox. 
	public void initialization() throws IOException, InterruptedException 
	//public is access specifier, void cause we don't want anything in return, 
	//method names always starts with small letter.
	{
		
		String browser= ReadData.readpropertyfile("Browser");
		if(browser.equals("chrome")) 
		{
			WebDriverManager.chromedriver().setup(); //WebDriverManager is parent of WebDriver
			// WebDriverManager accesses chromedriver directly, setup method will by default set the path of chromedriver
			driver=new ChromeDriver();
		}
		else if(browser.equals("firfox")) 
		{
			WebDriverManager.firefoxdriver().setup(); //WebDriverManager is parent of WebDriver
			// WebDriverManager accesses chromedriver directly, setup method will by default set the path of chromedriver
			driver=new FirefoxDriver();
		}
		else if(browser.equals("edge")) 
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		driver.get(ReadData.readpropertyfile("URL"));
		driver.manage().deleteAllCookies();
		Thread.sleep(4000);
		
	}
}
