package pom_repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import base.Base_Class;
import utility.Waits;

public class Index_Page extends Base_Class
{
	Waits wt=new Waits();
	public Index_Page(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//a[text()=\"Contact us\"]")
	private WebElement contactusBtn;
	
	@FindBy(xpath = "//a[@class=\"login\"]") 
	private WebElement signInBtn;
	
	@FindBy(xpath = "//img[@alt=\"My Shop\"]")
	private WebElement logo;
	
	@FindBy(id="search_query_top")
	private WebElement searchBox;
	
	@FindBy(name="submit_search")
	private WebElement searchBtn;
	
	@FindBy(xpath = "//a[@title=\"View my shopping cart\"]")
	private WebElement cartBtn;
	
	@FindBy(linkText = "Best Sellers")
	private WebElement bestsellerBtn;

	public Login_Page clickSignInBtn() 
	{
		Waits.fluentWait(driver, 5, 20, signInBtn);
		signInBtn.click();
		return new Login_Page(driver);
	}

	public boolean validateLogo() 
	{
		boolean res=logo.isDisplayed();
		Reporter.log("Logo is present",true);
		return  res;
	}
	
	public String getTitle() {
		String Title=driver.getTitle();
		return Title;
	}
	
	public boolean validateLogoNavigation() 
	{
		boolean res=contactusBtn.isDisplayed();
		return  res;
	}

}
