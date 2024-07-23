package pom_repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import base.Base_Class;
import utility.JavaScriptMethod;

public class My_Account_Page extends Base_Class
{
	public My_Account_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[@alt=\"My Shop\"]")
	private WebElement logo;
	
	@FindBy(xpath = "//h1[text()=\"My account\"]")
	private WebElement myAccountHeading;
	
	@FindBy(xpath = "//span[text()='Order history and details']")
	private WebElement orderHistory;
	
	@FindBy(xpath = "//span[text()=\"My addresses\"]")
	private WebElement myAddresses;
	
	@FindBy(xpath = "//a[@title=\"View my customer account\"]/span")
	private WebElement accountName;
	
	public boolean validateOrderHistory() throws Throwable {
		JavaScriptMethod.scrollToEle(driver, orderHistory);
		return orderHistory.isDisplayed();
	}
	
	public boolean validateAccountSuccessfulCreation(String fName, 
			String lName)
	{
		String actname=accountName.getText();
		System.out.println("The actual acc name is:"+actname);
		String exname=fName+" "+lName;
		System.out.println("The expected acc name is:"+actname);
		if(actname.equals(exname))
		{
		Reporter.log("Account created successfully");
		return true;
		}
		else
		{
		Reporter.log("Account was not created successfully");
		return false;
		}
		
	}
	
	public String getCurrentURL() throws Throwable {
		String curntURL=driver.getCurrentUrl();
		return curntURL;
	}
	
	public Index_Page navigateToIndexPage()
	{
		logo.click();
		return new Index_Page(driver);
	}
}
