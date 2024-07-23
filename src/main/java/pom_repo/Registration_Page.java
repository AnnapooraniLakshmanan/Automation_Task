package pom_repo;

import org.openqa.selenium.Keys;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import base.Base_Class;
import utility.SelectClassMethod;
import utility.Waits;

public class Registration_Page extends Base_Class
{
	public Registration_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[@alt=\"My Shop\"]")
	private WebElement logo;

	@FindBy(xpath = "//h1[text()='Create an account']")
	private WebElement formTitle;
	
	@FindBy(xpath = "//input[@id=\"id_gender1\"]")
	private WebElement mr;
	
	@FindBy(id = "id_gender2")
	private WebElement mrs;

	@FindBy(name = "customer_firstname")
	private WebElement firstName;

	@FindBy(xpath = "//label[text()=\"First name \"]/sup")
	private WebElement firstNameMandatoryField;
	
	@FindBy(name = "customer_lastname")
	private WebElement lastName;
	
	@FindBy(xpath = "//label[text()=\"Last name \"]/sup")
	private WebElement lastNameMandatoryField;
	
	@FindBy(xpath = "//input[@id=\"email\"]")
	private WebElement email;
	
	@FindBy(name = "passwd")
	private WebElement passWord;
	
	@FindBy(xpath = "//label[text()=\"Password \"]/sup")
	private WebElement passwdMandatoryField;

	@FindBy(name = "days")
	private WebElement days;

	@FindBy(name = "months")
	private WebElement months;

	@FindBy(name = "years")
	private WebElement years;
	
	@FindBy(xpath = "//input[@id=\"newsletter\"]")
	private WebElement newsletterCheckbox;
	
	@FindBy(name = "submitAccount")
	private WebElement registerBtn;
	
	public void createAccountWithNewsLetter(String gender,String fName, 
			String lName, 
			String pswd, 
			String day, 
			String month, 
			String year) throws Throwable {
		
		if(gender.equalsIgnoreCase("Mr")) 
		{
			mr.click();
		} 
		else 
		{
			mrs.click();
		}
		
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
		passWord.sendKeys(pswd);
		SelectClassMethod.selectByValue(days, day);
		SelectClassMethod.selectByValue(months, month);
		SelectClassMethod.selectByValue(years, year);
		newsletterCheckbox.click();
		}
	
	public void createAccountWithoutNewsLetter(String gender,String fName, 
			String lName, 
			String pswd, 
			String day, 
			String month, 
			String year) throws Throwable {
		
		if(gender.equalsIgnoreCase("Mr")) 
		{
			mr.click();
		} 
		else 
		{
			mrs.click();
		}
		
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
		passWord.sendKeys(pswd);
		SelectClassMethod.selectByValue(days, day);
		SelectClassMethod.selectByValue(months, month);
		SelectClassMethod.selectByValue(years, year);
		}
	
	public void createAccountWithMandatoryFields(String fName, 
			String lName, 
			String pswd) throws Throwable {
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
		passWord.sendKeys(pswd);
		
		}
	
	public void createAccountWithKeyboard(String gender,String fName, 
	String lName, 
	String pswd, 
	String day, 
	String month, 
	String year) throws Throwable 
	{
		if(gender.equalsIgnoreCase("Mr")) 
		mr.click();
		else 
		mrs.click();
		firstName.sendKeys(fName,Keys.TAB,lName,Keys.TAB,Keys.TAB,pswd,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB);
		newsletterCheckbox.click();
	}
	
	
	public My_Account_Page validateRegistration() throws Throwable {
		registerBtn.click();
		return new My_Account_Page(driver);
	}
	
	public boolean validateAcountCreatePage() throws Throwable {
		 boolean res=formTitle.isDisplayed();
		 return res;
	}
	
	public String validateEmailPlaceholder()
	{
		Waits.fluentWait(driver, 2, 10,email);
		String actVal=email.getAttribute("value");
		return  actVal;
	}
	
	public boolean ValidateFirstNameMandatoryField()
	{
		boolean fn=firstNameMandatoryField.isDisplayed();
		return fn;
	}
	
	public boolean ValidateLastNameMandatoryField()
	{
		boolean ln=lastNameMandatoryField.isDisplayed();
		return ln;
	}
	
	public boolean ValidatePsswdMandatoryField()
	{
		boolean psswd=passwdMandatoryField.isDisplayed();
		return psswd;
	}
	
	public boolean NewsLetterNotSelectedDefault()
	{
		boolean res=newsletterCheckbox.isSelected();
		return res;
	}
}
