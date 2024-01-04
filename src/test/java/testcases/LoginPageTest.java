package testcases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;

import pages.LoginPage;
import utility.ReadData;
import utility.Screenshot;

public class LoginPageTest extends TestBase // as we need driver form TestBase
{

	LoginPage login;// as Login method is non static we create its object and write it globally to give access
	@BeforeMethod(alwaysRun = true)
	public void setup() throws IOException, InterruptedException 
	{
		initialization(); //method from TestBase
		login =new LoginPage(); 
	}
	@Test(enabled = true, priority = 1, groups= {"Retesting"})
	public void verifyTitleOfApplicationTest() throws EncryptedDocumentException, IOException 
	{
		String expTitle=ReadData.readExcel(1, 0); //"Swag Labs";(1,0)
		String actTitle= login.verifyTitleOfApplication();
		Assert.assertEquals(expTitle,actTitle);// assert equals string
	}
	@Test (enabled = true, priority = 0, groups= {"Sanity"})
	public void verifyURLofApplicationTest() throws EncryptedDocumentException, IOException 
	{
		String expURL= ReadData.readExcel(1, 1);//"https://www.saucedemo.com/";(1,1)
		String actURL= login.verifyURLofApplication();
		Assert.assertEquals(expURL, actURL);
	}
	
	@Test (enabled = true, priority = 2, groups= {"Sanity","Regression"}) //dependsOnMethods = "verifyURLofApplicationTest"
	public void logintoApplicationTest() throws IOException 
	{
		String expURL = ReadData.readExcel(1,2);//"https://www.saucedemo.com/inventory.html";(1,2)
		String actURL= login.logintoApplication();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("After successfull login, inventory page URL = "+ actURL );
		// we get log : which will show us text
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
