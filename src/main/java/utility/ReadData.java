package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadData 
{
	public static String readpropertyfile(String value) throws IOException 
	{
		Properties prop= new Properties();
		FileInputStream file= new FileInputStream("C:\\Users\\sharv\\eclipse-workspace\\Project_Selenium_29Batch\\TestData\\config.properties");
		prop.load(file);
		return prop.getProperty(value);
		
	}
	public static String readExcel(int rownum,int colnum) throws EncryptedDocumentException, IOException //parameterization
	{
		FileInputStream file= new FileInputStream("C:\\Users\\sharv\\eclipse-workspace\\Project_Selenium_29Batch\\TestData\\SauceDemo_TestData.xlsx");
		Sheet excelsheetdata = WorkbookFactory.create(file).getSheet("Data");
		String value = excelsheetdata.getRow(rownum).getCell(colnum).getStringCellValue();
		return value;
		
	}

}
