package testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.CartPage;
import pages.CheckoutPage1;
import pages.CheckoutPage2;
import pages.Inventory_Page;
import pages.LoginPage;
import utility.Screenshot;

public class CheckoutPage2Test extends TestBase
{
	LoginPage login;
	Inventory_Page invent;
	CartPage cart;
	CheckoutPage1 checkout1;
	CheckoutPage2 checkout2;
	@BeforeMethod
	public void setup() throws IOException, InterruptedException 
	{
		initialization();
		login=new LoginPage();
		invent = new Inventory_Page();
		cart= new CartPage();
		checkout1= new CheckoutPage1();
		checkout2= new CheckoutPage2();
		login.logintoApplication();
		invent.add6products();
		invent.clickoncartIcon();
		cart.clickonCheckoutButton();
		checkout1.Inputinfo();
		
		
	}
		
	@Test (enabled = true, priority = 0)
	public void verifyURLofPage2Test() 
	{
		String expURL= "https://www.saucedemo.com/checkout-step-two.html";
		String actURL= checkout2.verifyURLofPage2();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("URL of Checkout page 2 = "+ actURL);
	}
	@Test (enabled = true, priority = 1,dependsOnMethods = "verifyURLofPage2Test")
	public void verifyLabelofPage2Test() 
	{
		String expLabel="Checkout: Overview";
		String actLabel= checkout2.verifyLabelofPage2();
		Assert.assertEquals(expLabel, actLabel);
		Reporter.log("Label on checkout page 2 = "+actLabel);
	}
	@Test (enabled = true, priority = 2,dependsOnMethods = "verifyURLofPage2Test")
	public void PaymentInformationLabelTest() 
	{
		String explabel="Payment Information";
		String actlabel= checkout2.PaymentInformationLabel();
		Assert.assertEquals(explabel, actlabel);
		Reporter.log("Payment Label = "+actlabel);
	}
	@Test (enabled = true, priority = 3,dependsOnMethods = "verifyURLofPage2Test")
	public void SauceCardLabelTest() 
	{
		String explabel="SauceCard #31337";
		String actlabel= checkout2.SauceCardLabel();
		Assert.assertEquals(explabel, actlabel);
		Reporter.log("Sauce card Label = "+actlabel);
		
	}
	@Test (enabled = true, priority = 4,dependsOnMethods = "verifyURLofPage2Test")
	public void ShippingInformationLabelTest() 
	{
		String explabel="Shipping Information";
		String actlabel= checkout2.ShippingInformationLabel();
		Assert.assertEquals(explabel, actlabel);
		Reporter.log("Shipping information Label = "+actlabel);
	}
	
	@Test (enabled = true, priority = 5,dependsOnMethods = "verifyURLofPage2Test")
	public void FreePonyExpressDeliveryLabelTest() 
	{
		String explabel="Free Pony Express Delivery!";
		String actlabel= checkout2.FreePonyExpressDeliveryLabel();
		Assert.assertEquals(explabel, actlabel);
		Reporter.log(" Free Pony Express Delivery Label = "+actlabel);
	}
	
	@Test (enabled = true, priority = 6,dependsOnMethods = "verifyURLofPage2Test")
	public void PriceTotalLabelTest() 
	{
		String explabel="Price Total";
		String actlabel= checkout2.PriceTotalLabel();
		Assert.assertEquals(explabel, actlabel);
		Reporter.log("Price Total Label = "+actlabel);
	}
	@Test (enabled = true, priority = 7,dependsOnMethods = "verifyURLofPage2Test")
	public void summary_subtotalTest() 
	{
		String explabel="Item total: $129.94";
		String actlabel= checkout2.summary_subtotal();
		Assert.assertEquals(explabel, actlabel);
		Reporter.log("Item Total = "+actlabel);
	}
	@Test (enabled = true, priority = 8,dependsOnMethods = "verifyURLofPage2Test")
	public void summary_taxTest() 
	{
		String explabel="Item total: $129.94";
		String actlabel= checkout2.summary_subtotal();
		Assert.assertEquals(explabel, actlabel);
		Reporter.log("Total Tax = "+actlabel);
	}
	@Test (enabled = true, priority = 9,dependsOnMethods = "verifyURLofPage2Test")
	public void summary_totalTest() 
	{
		String explabel="Total: $140.34";
		String actlabel= checkout2.summary_total();
		Assert.assertEquals(explabel, actlabel);
		Reporter.log("Total = "+actlabel);
	}
	@Test (enabled = true, priority = 10,dependsOnMethods = "verifyURLofPage2Test")
	public void CancelButtonTest() 
	{
		String expURL="https://www.saucedemo.com/inventory.html";
		String actURL= checkout2.CancelButton();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("URL after clicking cancel button = "+actURL);
	}
	@Test (enabled = true, priority = 11,dependsOnMethods = "verifyURLofPage2Test")
	public void FinishButtonTest() 
	{
		String expURL="https://www.saucedemo.com/checkout-complete.html";
		String actURL= checkout2.FinishButton();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("URL after clicking finish button = "+actURL);
	}
	@AfterMethod
	public void closebrowser(ITestResult It) throws IOException 
	{
		if(It.FAILURE==It.getStatus()) 
		{
			Screenshot.screenshot(It.getName());
		}
		driver.close();
	}
}

