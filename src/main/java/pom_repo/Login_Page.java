package pom_repo;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import base.Base_Class;
import utility.JavaScriptMethod;
import utility.Waits;

public class Login_Page extends Base_Class
{
	public Login_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[@alt=\"My Shop\"]")
	private WebElement logo;
	
	@FindBy(xpath = "//h3[text()=\"Create an account\"]")
	private WebElement createAccountHeading;
	
	@FindBy(id="email")
	private WebElement emailAdd;
	
	@FindBy(id="passwd")
	private WebElement pswd;
	
	@FindBy(linkText = "Forgot your password?")
	private WebElement forgotPswd;

	@FindBy(id="SubmitLogin")
	private WebElement signInBtn;
	
	@FindBy(name="email_create")
	private WebElement emailForNewAccount;
	
	@FindBy(name="SubmitCreate")
	private WebElement createNewAccountBtn;
	
	public My_Account_Page loginAction(String uname, String psswd,My_Account_Page myAccountPage) throws IOException
	{
		JavaScriptMethod.scrollToEle(driver,emailAdd);
		Waits.explicitWait(driver, 10,emailAdd);
		emailAdd.sendKeys(uname);
		pswd.sendKeys(psswd);
		signInBtn.click();
		myAccountPage=new My_Account_Page(driver);
		return myAccountPage;
	}
	
	public Registration_Page toCreateNewAccount(String newEmail)
	{
		emailForNewAccount.sendKeys(newEmail);
		createNewAccountBtn.click();
		return new Registration_Page(driver);
	}
	
	public boolean validateHeading()
	{
		boolean res=createAccountHeading.isDisplayed();
		return res;
	}
}
