package utility;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

import base.Base_Class;

public class Alerts extends Base_Class
{
public static void Alert(WebDriver driver)
{
	Alert alt = driver.switchTo().alert();
	alt.accept();
}
}
