package utility;

import java.io.File;

import java.io.FileInputStream;



import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;


public class DataaProviders 
{
	
	@DataProvider(name = "acc credentials",indices = {16})
	public String[][] testdata() throws EncryptedDocumentException, IOException
	{
		
	File excelFile=new File("./src/test/resources/TestData/ExcelData.xlsx");
	FileInputStream fis=new FileInputStream(excelFile);	
          try (XSSFWorkbook wb = new XSSFWorkbook(fis)) {
			XSSFSheet sheet = wb.getSheet("Account Credentials");
		
		int noOfRow = sheet.getPhysicalNumberOfRows();
		System.out.println(noOfRow);
		
		int noOfCol=sheet.getRow(0).getPhysicalNumberOfCells();
		System.out.println(noOfCol);
		
		String[][] data=new String[noOfRow-1][noOfCol];
		
		for(int i=0;i<noOfRow-1;i++)
		{
			for(int j=0;j<noOfCol;j++)
		    {
				DataFormatter df=new DataFormatter();
				data[i][j]=df.formatCellValue(sheet.getRow(i+1).getCell(j));
			}	
		}
		return data;
		}
	}
	
	
	@DataProvider(name = "Valid Email")
	public String[][] tesstdata() throws EncryptedDocumentException, IOException
	{
		
	File excelFile=new File("./src/test/resources/TestData/ExcelData.xlsx");
	FileInputStream fis=new FileInputStream(excelFile);	
    try (XSSFWorkbook wb = new XSSFWorkbook(fis)) 
    {
		XSSFSheet sheet = wb.getSheet("Valid Email");
		
		int noOfRow = sheet.getPhysicalNumberOfRows();
		System.out.println(noOfRow);
		
		int noOfCol=sheet.getRow(0).getPhysicalNumberOfCells();
		System.out.println(noOfCol);
		
		String[][] data=new String[noOfRow-1][noOfCol];
		
		for(int i=0;i<noOfRow-1;i++)
		{
			for(int j=0;j<noOfCol;j++)
		    {
				DataFormatter df=new DataFormatter();
				data[i][j]=df.formatCellValue(sheet.getRow(i+1).getCell(j));
			}	
		}
		return data;
	}
	}
	
	@DataProvider(name = "email",indices = {0,1})
	public String[][] testdata01() throws EncryptedDocumentException, IOException
	{
		
	File excelFile=new File("./src/test/resources/TestData/ExcelData.xlsx");
	FileInputStream fis=new FileInputStream(excelFile);	
    try (XSSFWorkbook wb = new XSSFWorkbook(fis)) 
    {
		XSSFSheet sheet = wb.getSheet("Emails");
		
		int noOfRow = sheet.getPhysicalNumberOfRows();
		System.out.println(noOfRow);
		
		int noOfCol=sheet.getRow(0).getPhysicalNumberOfCells();
		System.out.println(noOfCol);
		
		String[][] data=new String[noOfRow-1][noOfCol];
		
		for(int i=0;i<noOfRow-1;i++)
		{
			for(int j=0;j<noOfCol;j++)
		    {
				DataFormatter df=new DataFormatter();
				data[i][j]=df.formatCellValue(sheet.getRow(i+1).getCell(j));
			}	
		}
		return data;
	}
	}

	@DataProvider(name = "Invalid Email",indices = {1,2})
	public String[][] testdata02() throws EncryptedDocumentException, IOException
	{
		
	File excelFile=new File("./src/test/resources/TestData/ExcelData.xlsx");
	FileInputStream fis=new FileInputStream(excelFile);	
    try (XSSFWorkbook wb = new XSSFWorkbook(fis)) 
    {
		XSSFSheet sheet = wb.getSheet("Invalid Email");
		
		int noOfRow = sheet.getPhysicalNumberOfRows();
		System.out.println(noOfRow);
		
		int noOfCol=sheet.getRow(0).getPhysicalNumberOfCells();
		System.out.println(noOfCol);
		
		String[][] data=new String[noOfRow-1][noOfCol];
		
		for(int i=0;i<noOfRow-1;i++)
		{
			for(int j=0;j<noOfCol;j++)
		    {
				DataFormatter df=new DataFormatter();
				data[i][j]=df.formatCellValue(sheet.getRow(i+1).getCell(j));
			}	
		}
		return data;
	}
	}
}

