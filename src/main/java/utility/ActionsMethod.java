package utility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import base.Base_Class;

public class ActionsMethod extends Base_Class
{
	
	public static Actions act = new Actions(driver);
	
	public static void clickElement(WebElement ele)
	{
	act.moveToElement(ele).perform();
	}
	
	public static void rightClick(WebElement ele)
	{
		act.contextClick(ele).perform();
	}
	
	public static void doubleClick(WebElement ele)
	{
		act.doubleClick(ele).perform();
	}
	
	public static void moveByOffset()
	{
		act.moveByOffset(10, 10).click().perform();
	}
	
	public static void dragAndDrop(WebElement drag,WebElement drop)
	{
		act.dragAndDrop(drag, drop).perform();
	}
}
