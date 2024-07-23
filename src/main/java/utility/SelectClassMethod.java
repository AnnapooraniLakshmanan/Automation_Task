package utility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import base.Base_Class;

public class SelectClassMethod extends Base_Class 
{
	public static void selectByVisibleText(WebElement ele,String value)
	{
	Select sele=new Select(ele);
	sele.selectByVisibleText(value);
	}
	
	public static void selectByValue(WebElement ele,String value)
	{
	Select sele=new Select(ele);
	sele.selectByValue(value);
	}
	
	public static void selectByIndex(WebElement ele,int value)
	{
	Select sele=new Select(ele);
	sele.selectByIndex(value);
	}

}
