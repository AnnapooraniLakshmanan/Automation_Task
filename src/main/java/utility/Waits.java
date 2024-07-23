package utility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.Base_Class;

public class Waits extends Base_Class 
{
	public static void implicitWait(WebDriver driver, long timeOut)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeOut));
	}
	
	public static void explicitWait(WebDriver driver, long timeOut,WebElement ele)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(timeOut)); 
		wait.until(ExpectedConditions.visibilityOf(ele));
		ele.click();
	}
	
	public static void fluentWait(WebDriver driver, long polling, long timeOut,WebElement ele)
	{
		FluentWait<WebDriver> wait=new FluentWait<WebDriver>(driver);
		wait.pollingEvery(Duration.ofSeconds(polling));
		wait.withTimeout(Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.visibilityOf(ele));
		ele.click();
	}
}
