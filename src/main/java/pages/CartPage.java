package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class CartPage extends TestBase
{

	@FindBy(xpath = "//span[text()='Your Cart']") private WebElement cartPageLabel;
	@FindBy(xpath = "//button[@id='checkout']") private WebElement checkoutButton;
	@FindBy(xpath = "//button[@id='continue-shopping']") private WebElement continueshoppingButton;
	
	public  CartPage() 
	{
		PageFactory.initElements(driver, this);
	}
	
	public String verifycartURL() 
	{
		
		return driver.getCurrentUrl();
		
	} 
	public String verifycartPageLabel() 
	{
		return cartPageLabel.getText();
		
	}
	public String clickoncontinueshopping() 
	{
		continueshoppingButton.click();
		return driver.getCurrentUrl();
	}
	public String clickonCheckoutButton() 
	{
		checkoutButton.click();
		return driver.getCurrentUrl();
		
	}
}

