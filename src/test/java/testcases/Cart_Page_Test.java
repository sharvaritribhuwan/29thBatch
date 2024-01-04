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
import pages.Inventory_Page;
import pages.LoginPage;
import utility.ReadData;
import utility.Screenshot;

public class Cart_Page_Test extends TestBase
{

	LoginPage login;
	Inventory_Page invent;
	CartPage cart;
	@BeforeMethod(alwaysRun = true)
	public void setup() throws IOException, InterruptedException 
	{
		initialization();
		login=new LoginPage();
		invent = new Inventory_Page();
		cart= new CartPage();
		login.logintoApplication();
		invent.add6products();
		invent.clickoncartIcon();
		
		
	}
	@Test (enabled = true, priority = 0, groups= {"Sanity"})
	public void verifycartURLTest() throws EncryptedDocumentException, IOException 
	{
		String expURL=ReadData.readExcel(1, 7) ;// https://www.saucedemo.com/cart.html (1,7);
		String actURL= cart.verifycartURL();
		Assert.assertEquals(actURL, expURL);
		Reporter.log("Current page URL of cart page = "+actURL);
				
	}
	@Test (enabled = true, priority = 1, groups= {"Retesting"})
	public void verifycartPageLabelTest() throws EncryptedDocumentException, IOException 
	{
		String explabel= ReadData.readExcel(1, 8);// Your Cart (1,8);
		String actlabel= cart.verifycartPageLabel();
		Assert.assertEquals(explabel, actlabel);
		Reporter.log("Cart page label = "+actlabel);
	}
	
	@Test (enabled = true, priority = 2)
	public void clickonCheckoutButtonTest() 
	{
		String expURL ="https://www.saucedemo.com/checkout-step-one.html";
		String actURL= cart.clickonCheckoutButton();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("URL after clicking on checkout button = "+actURL);
	}
	
	@Test (enabled = true, priority = 3)
	public void clickoncontinueshoppingTest() 
	{
		String expURL="https://www.saucedemo.com/inventory.html";
		String actURL= cart.clickoncontinueshopping();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("URL after clicking on continue shopping button ="+ actURL);
		
	}
	
	@AfterMethod(alwaysRun = true)
	public void closeBrowser(ITestResult It) throws IOException 
	{
		if(It.FAILURE== It.getStatus()) 
		{
			Screenshot.screenshot(It.getName());
		}
		driver.close();
	}
}
