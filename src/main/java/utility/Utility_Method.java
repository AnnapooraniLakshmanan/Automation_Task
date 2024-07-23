package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import base.Base_Class;

public class Utility_Method extends Base_Class
{

public static String getCurrentTime()
{
	LocalDateTime datetime=LocalDateTime.now();
	String date=datetime.toString().replace(":", "-");
    return date;
}

public static String getDataFromProperty(String key) throws IOException
{
	FileInputStream fis=new FileInputStream("./src/test/resources/TestData/prop.properties.txt");
	Properties pro=new Properties();
	pro.load(fis);
	return pro.getProperty(key);
}

public String getDataFromExcel(String sheet,int rownum,int colnum) throws EncryptedDocumentException, IOException
{
	FileInputStream fis=new FileInputStream("./src/test/resources/TestData/ExcelData.xlsx");
	Workbook wb=WorkbookFactory.create(fis);
	Sheet sh=wb.getSheet(sheet);
	return sh.getRow(rownum).getCell(colnum).toString();
}

}

