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
import pages.Inventory_Page;
import pages.LoginPage;
import utility.ReadData;
import utility.Screenshot;

public class Inventory_PageTest extends TestBase
{

	LoginPage login;// as Login method is non static we create its object and write it globally to give access
	Inventory_Page invent; // as invent method is non static we create its object and write it globally to give access
	@BeforeMethod(alwaysRun = true)
	public void setup() throws IOException, InterruptedException 
	{
		initialization(); //method from TestBase
		login =new LoginPage(); 
		invent = new Inventory_Page(); //creating object 
		login.logintoApplication();// for login we use logintoApplication method from LoginPage
	}
	
	@Test (enabled = true, priority = 0, groups= {"Retesting"})
	public void verifyProductlableTest() throws EncryptedDocumentException, IOException 
	{
		String explabel=ReadData.readExcel(1, 3);//"Products";(1,3)
		String actlabel=invent.verifyProductlable();
		Assert.assertEquals(explabel, actlabel);
		Reporter.log("Product label = "+actlabel);
	}
	@Test (enabled = true, priority = 1)
	public void verifytextPresentonPage() throws EncryptedDocumentException, IOException 
	{
		String exptext=ReadData.readExcel(1, 4);//"© 2023 Sauce Labs. All Rights Reserved. Terms of Service | Privacy Policy";(1,4)
		String acttext= invent.verifytextPresentonPage();
		Assert.assertEquals(exptext, acttext);
		Reporter.log("Text present on webpage = "+ acttext);
	}
	
	@Test (enabled = true, priority = 2, groups= {"Sanity"})
	public void verifyTwitterLogo() 
	{
		boolean result = invent.verifyTwitterLogo(); // boolean because our data type is boolean
		Assert.assertEquals(result, true); // we write true instead of actual value nad compare result with true 
		// if it is same it'll return true
		Reporter.log("Visibility of Twitter logo = "+ result );
	}
	
	@Test (enabled = true, priority = 3)
	public void verifyFacebooklogo() 
	{
		boolean result =invent.verifyFacebooklogo();
		Assert.assertEquals(result, true);
		Reporter.log("Visibility of Facebook logo = "+ result);
	}
	
	@Test (enabled = true, priority = 4)
	public void verifyLinkedInLogo() 
	{
		boolean result= invent.verifyLinkedInLogo();
		Assert.assertEquals(result, true);
		Reporter.log("Visibility of LinkedIn logo = "+ result);
	}
	
	@Test (enabled = true, priority = 5, groups= {"Sanity","Regression"})
	public void add6products() throws EncryptedDocumentException, IOException 
	{
		String expproducts= ReadData.readExcel(1, 5); //"6";(1,5)
		String actproducts= invent.add6products();
		Assert.assertEquals( expproducts, actproducts);
		Reporter.log("Product added in cart = "+actproducts);
	}
	
	@Test (enabled = true, priority = 6, groups= {"Sanity","Regression"})
	public void remove2productsTest() throws EncryptedDocumentException, IOException 
	{
		String expcount=ReadData.readExcel(1, 6); //"4";(1,6)
		String actcount= invent.remove2products();
		Assert.assertEquals(expcount, actcount);
		Reporter.log("Number of products after removing = "+actcount);
	}
	
	@AfterMethod(alwaysRun = true)
	public void closeBrowser(ITestResult It) throws IOException //ITestResult it is a class which describes result of test
	// we created object of ITestResult that is It 
	{
		if(It.FAILURE== It.getStatus()) //if FAILURE == Status it'll capture screenshot 
		{
			Screenshot.screenshot(It.getName()); // classname.methodname(It.getName()) will get name of method
		}
		
		driver.close();
	}
}
