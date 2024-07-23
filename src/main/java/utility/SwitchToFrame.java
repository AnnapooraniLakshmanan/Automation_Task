package utility;

import org.openqa.selenium.WebDriver;

import base.Base_Class;

public class SwitchToFrame extends Base_Class
{

	public static void switchToFrameByIndex(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);	
	}
	
	public static void switchToFrameById(WebDriver driver,String id)
	{
		driver.switchTo().frame("id");	
	}
	
	public static void switchToFrameByName(WebDriver driver,String name)
	{
		driver.switchTo().frame("name");	
	}
	
	public static void switchToDefaultFrame(WebDriver driver)
	{
		driver.switchTo().defaultContent();	
	}

}
