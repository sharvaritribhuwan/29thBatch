package testcases;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.TestBase;
import pages.LoginPage;
import utility.Screenshot;

public class VerifyloginPageApplicationWithMultiCredsTest extends TestBase
{
	LoginPage login;// as Login method is non static we create its object and write it globally to give access
	@BeforeMethod
	public void setup() throws IOException, InterruptedException 
	{
		initialization(); //method from TestBase
		login =new LoginPage(); 
	}
	
	@DataProvider(name="Credentials")
	public Object[][] getdata() 
	{
		return new Object [][] 
				{
			     {"standard_user","secret_sauce"},
			     {"locked_out_user",(Object) "secret_sauce"},
			     {"problem_user","secret_sauce"},
			     {"performance_glitch_user", "secret_sauce"},
			     { "error_user", "secret_sauce"},
			     {"visual_user", "secret_sauce"},
			     {"standard_user","secret_sauce1"},// CId, WP
			     {"standard_user1","secret_sauce"},// WI,CP
			     {"standard_user1","secret_sauce1"}//WI,WP
			   };
	}
	
	@Test(dataProvider="Credentials", enabled = false)
	public void loginToApplicationMultiCredsTest(String un, String pass) 
	{
		SoftAssert s= new SoftAssert();
		String expURL="https://www.saucedemo.com/inventory.html";
		String actURL=login.loginToApplicationMultiCreds(un, pass);
		s.assertEquals(expURL, actURL);
		s.assertAll();
	}
	@AfterMethod
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
