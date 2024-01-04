package testcases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.CartPage;
import pages.CheckoutPage1;
import pages.Inventory_Page;
import pages.LoginPage;
import utility.ReadData;
import utility.Screenshot;

public class CheckoutPage1Test extends TestBase
{
	LoginPage login;
	Inventory_Page invent;
	CartPage cart;
	CheckoutPage1 checkout1;
	@BeforeMethod
	public void setup() throws IOException, InterruptedException 
	{
		initialization();
		login=new LoginPage();
		invent = new Inventory_Page();
		cart= new CartPage();
		checkout1= new CheckoutPage1();
		login.logintoApplication();
		invent.add6products();
		invent.clickoncartIcon();
		cart.clickonCheckoutButton();
		
		
	}
	
	@Test (enabled = true, priority = 0)
	public void verifyURLTest() throws EncryptedDocumentException, IOException 
	{
		String expURL= ReadData.readExcel(1, 9); // https://www.saucedemo.com/checkout-step-one.html (1,9)
		String actURL= checkout1.verifyURL();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("URL of check out step 1 page = "+actURL);
	}
	
	@Test (enabled = true, priority = 1,dependsOnMethods = "verifyURLTest")
	public void verifylabelTest() throws EncryptedDocumentException, IOException 
	{
		String expURL= ReadData.readExcel(1, 10); // Checkout: Your Information (1,10)
		String actURL= checkout1.verifylabel();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("Text present on checkout step 1 page = "+actURL);
	}
	
	@Test (enabled = true, priority = 2,dependsOnMethods = "verifyURLTest")
	public void InputinfoTest() throws EncryptedDocumentException, IOException 
	{
		String expURL= ReadData.readExcel(1, 12);// https://www.saucedemo.com/checkout-step-two.html (1,12)
		String actURL= checkout1.Inputinfo();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("After clicking on continue button we should navigate to this page = "+actURL);
	}
	
	@Test (enabled = true, priority = 3 ,dependsOnMethods = "verifyURLTest")
	public void cancelbuttonTest() 
	{
		String expURL="https://www.saucedemo.com/cart.html";
		String actURL= checkout1.cancelbutton();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("After clicking on cancel button we should navigate to this page = "+actURL);
	}
	@Test (enabled = true, priority = 4,dependsOnMethods = "verifyURLTest")
	public void continuebuttonTest() 
	{
		String expURL="https://www.saucedemo.com/checkout-step-one.html";
		String actURL= checkout1.continuebutton();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("After clicking on continue button we should navigate to this page = "+actURL);
	}
	
	@AfterMethod()
	public void closeBrowser(ITestResult It ) throws IOException
	{
		if(It.FAILURE== It.getStatus());
		{
			Screenshot.screenshot(It.getName());
		}
		driver.close();
	}
}
