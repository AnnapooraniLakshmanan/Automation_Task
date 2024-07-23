package utility;

import org.openqa.selenium.WebDriver;

import base.Base_Class;

public class Getter_Methods extends Base_Class 
{
	public static String getTitle(WebDriver driver) 
	{
	String title=driver.getTitle();
	return title;
	}
	
	public static String getCurrentURL(WebDriver driver)  
	{
	String currentURL=driver.getCurrentUrl();
	return currentURL;
	}
	
	public static String getPageSource(WebDriver driver)  
	{
	String pagesource=driver.getPageSource();
	return pagesource;
	}

}
