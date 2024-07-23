package utility;

import java.util.Set;

import org.openqa.selenium.WebDriver;

import base.Base_Class;

public class Switching_Windows extends Base_Class 
{
public static void switchWindowByTitle(WebDriver driver,String windowTitle)
{
	Set<String> allwins = driver.getWindowHandles();
	for (String win : allwins) 
	{
	driver.switchTo().window(win);
	String tit = driver.getTitle();
	System.out.println(tit);
	if(tit.contains(windowTitle))
	{
		break;
	}
	}
}

}
