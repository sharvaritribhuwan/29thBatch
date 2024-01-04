package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class CheckoutPage1 extends TestBase
{
	@FindBy(xpath = "//span[text()='Checkout: Your Information']") private WebElement checkInfoLabel;
	@FindBy(xpath = "//input[@id='first-name']") private WebElement firstnameTextbox;
	@FindBy(xpath = "//input[@id='last-name']") private WebElement lastnameTextbox;
	@FindBy(xpath = "//input[@id='postal-code']") private WebElement zip_postal_code;
	@FindBy(xpath = "//input[@name='continue']") private WebElement continueButton;
	@FindBy(xpath="//button[@name='cancel']") private WebElement cancelbutton;
	
	public CheckoutPage1() 
	{
		PageFactory.initElements(driver, this);
	}
	
	public String verifyURL() 
	{
		return driver.getCurrentUrl();
	}
	
	public String verifylabel() 
	{
		return checkInfoLabel.getText();
		
	}

	public String Inputinfo() 
	{
		firstnameTextbox.sendKeys("Harry");
		lastnameTextbox.sendKeys("Potter");
		zip_postal_code.sendKeys("27890");
		continueButton.click();
		return driver.getCurrentUrl();
		
	}
	public String cancelbutton() 
	{
		cancelbutton.click();
		return driver.getCurrentUrl();
		
	}
	public String continuebutton() 
	{
		continueButton.click();
        return driver.getCurrentUrl();
	}
	
}
