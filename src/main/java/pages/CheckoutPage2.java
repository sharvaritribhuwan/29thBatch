package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class CheckoutPage2 extends TestBase
{
	@FindBy(xpath = "//span[text()='Checkout: Overview']") private WebElement overviewlabel;
	@FindBy(xpath = "//div[text()='Payment Information']") private WebElement PaymentInformationText;
	@FindBy(xpath = "//div[text()='SauceCard #31337']")private WebElement SauceCardText ;
	@FindBy(xpath = "//div[text()='Shipping Information']")private WebElement ShippingInformationText ;
	@FindBy(xpath = "//div[text()='Free Pony Express Delivery!']")private WebElement FreePonyExpressDeliveryText ;
	@FindBy(xpath = "//div[text()='Price Total']")private WebElement PriceTotalText ;
	@FindBy(xpath = "//div[@class='summary_subtotal_label']")private WebElement summary_subtotalLabel ;
	@FindBy(xpath = "//div[@class='summary_tax_label']")private WebElement summary_tax_label ;
	@FindBy(xpath = "//div[@class='summary_info_label summary_total_label']")private WebElement summary_total_label ;
	@FindBy(xpath = "//button[@name='cancel']") private WebElement cancelButton;
	@FindBy(xpath = "//button[@name='finish']") private WebElement finishButton;
	
	public CheckoutPage2() 
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public String verifyURLofPage2() 
	{
		return driver.getCurrentUrl();
		
	}
	public String verifyLabelofPage2() 
	{
		return overviewlabel.getText();
		
	}
	
	public String PaymentInformationLabel() 
	{
		return PaymentInformationText.getText();
		
	}
	public String SauceCardLabel() 
	{
		return SauceCardText.getText();
		
	}
	
	public String ShippingInformationLabel() 
	{
		return ShippingInformationText.getText();
		
	}
	public String FreePonyExpressDeliveryLabel() 
	{
		return FreePonyExpressDeliveryText.getText();
		
	}
	public String PriceTotalLabel() 
	{
		return PriceTotalText.getText();
		
	}
	public String summary_subtotal() 
	{
		return summary_subtotalLabel.getText();
		
	}
	public String summary_tax() 
	{
		return summary_tax_label.getText();
		
	}
	public String summary_total() 
	{
		return summary_total_label.getText();
	}
	
	public String CancelButton() 
	{
		 cancelButton.click();
		 return driver.getCurrentUrl();
	}
	public String FinishButton() 
	{
		finishButton.click();
		return driver.getCurrentUrl();
	}
	
}

