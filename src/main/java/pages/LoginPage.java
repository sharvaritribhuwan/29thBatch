package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;
import utility.ReadData;

public class LoginPage extends TestBase // as we need driver form TestBase 
                 // inheritance concept is used
{
    //object repository(placing our elements: xpaths)
	//constructors
	//methods
	
	
	@FindBy(xpath="//input[@id=\"user-name\"]")  private WebElement usernameTextbox ;
	@FindBy(xpath="//input[@id=\"password\"]") private WebElement passwordTextbox;
	@FindBy(xpath="//input[@id=\"login-button\"]") private WebElement loginbuttonText;
	//@FindBy is annotation
    // OOPS concept encapsulation is used here in private.
	//private has access within class to use them we need method but to call them we need constructor.
	//we can't call web elements directly in constructor
	//so to call them we need PageFactory
	
	public LoginPage() //constructor used to load data member
	{
		PageFactory.initElements(driver, this);
		// PageFactory is a class which has static method initElements 
		// this:is the keyword which'll refer our current object
		//eg: this will point each and every web element and check it and then only call method
	}
	
	
	public String logintoApplication() throws IOException 
	{
		usernameTextbox.sendKeys(ReadData.readpropertyfile("Username"));
		passwordTextbox.sendKeys(ReadData.readpropertyfile("Password"));
		loginbuttonText.click();
		// these three web elements are dependent on each other so we wrote one method
		
		return driver.getCurrentUrl();// getting driver from TestBase
		
	}
	public String loginToApplicationMultiCreds(String un, String Pass) 
	{
		usernameTextbox.sendKeys(un);
		passwordTextbox.sendKeys(Pass);
		loginbuttonText.click();
		return driver.getCurrentUrl();
		
	}
	
	public String verifyTitleOfApplication() 
	{
		return driver.getTitle(); // getting driver from TestBase
		
	}
	
	
	public String verifyURLofApplication() 
	{
		return driver.getCurrentUrl(); // getting driver from TestBase
		
	}
}
