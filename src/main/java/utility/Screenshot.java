package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import base.TestBase;

public class Screenshot extends TestBase
{
	public static String getData() 
	{
		return new SimpleDateFormat("dd-MM-YYY ss-mm-HH").format(new Date()); // SimpleDateFormat is given by java 
		//dd-MM-YYY ss-mm-HH is used for day-month-year and second-minutes-hours , format(new Date()) is used for setting date
		
	}
	public static void screenshot(String nameofmethod) throws IOException 
	{
	
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File file= new File("C:\\Users\\sharv\\eclipse-workspace\\Project_Selenium_29Batch\\Screenshot\\"+nameofmethod+"--"+getData()+".jpeg");
		FileHandler.copy(source, file);
		
	}

	

}
