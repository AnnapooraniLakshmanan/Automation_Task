package utility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.Base_Class;

public class JavaScriptMethod extends Base_Class
{
	
	
	public static void scrollToEle(WebDriver driver,WebElement ele)
	{
	JavascriptExecutor  js= (JavascriptExecutor)driver;
	js.executeScript("arguments[0].scrollIntoView()",ele);
	}
	
	public static void scrollToPageDown(WebDriver driver)
	{
	JavascriptExecutor  js= (JavascriptExecutor)driver;
	js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
	
	public static void scrollDown(WebDriver driver)
	{
	JavascriptExecutor  js= (JavascriptExecutor)driver;
	for(int i=0;i<3;i++)
	{
		js.executeScript("window.scrollBy(0,900)");
		//to scroll down
	}
	}
	
	public static void scrollUp(WebDriver driver)
	{
	JavascriptExecutor  js= (JavascriptExecutor)driver;
	for(int i=0;i<3;i++)
	{
		js.executeScript("window.scrollBy(0,-900)");
		//to scroll up
	}
	}
	
	public static void passValue(WebDriver driver, WebElement element, String value)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value='"+value+"'", element);
	}
	
	public static void jsClick(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", element);
	}
}
