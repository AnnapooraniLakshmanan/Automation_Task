package utility;

import java.io.File;



import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import base.Base_Class;


public class ScreenShot extends Base_Class
{
	public static String takeScreenShot(WebDriver driver) 
	{
		String ScreenShotPath = "./screenshot/"+Utility_Method.getCurrentTime()+".png";
		TakesScreenshot ts= (TakesScreenshot)driver;
		File scr=ts.getScreenshotAs(OutputType.FILE);
		File trg= new File(ScreenShotPath);
		try {
			FileHandler.copy(scr, trg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	return "." + ScreenShotPath;
	}
}
