package testscripts;



import java.io.IOException;

import org.testng.Assert;

import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import base.Base_Class;
import pom_repo.Index_Page;
import pom_repo.Login_Page;
import pom_repo.My_Account_Page;
import pom_repo.Registration_Page;
import utility.DataaProviders;


public class Registration_Page_Test extends Base_Class 
{
	Index_Page ip;
	Login_Page lp;
	Registration_Page rp;
	My_Account_Page map;
	
	@Parameters("browser")
	@BeforeMethod
	public void setup(@Optional("chrome")String browser) throws IOException {
		launchApp(browser); 
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test(priority = 1,dataProvider = "email",dataProviderClass = DataaProviders.class)
	public void validateRegistrationPge(String[] tesstdata) throws Throwable
	{
		ip=new Index_Page(driver);
		lp=ip.clickSignInBtn();
		rp=lp.toCreateNewAccount(tesstdata[0]);
		boolean opt=rp.validateAcountCreatePage();
		Assert.assertTrue(opt);
		Reporter.log("User landed on account creation page successfully",true);
	}
	
	//@Test(priority = 2,dataProvider = "acc credentials",dataProviderClass = DataaProviders.class)
	public void creatingNewAccTest(String[] testdata) throws Throwable
	{
		ip=new Index_Page(driver);
		lp=ip.clickSignInBtn();
		rp=lp.toCreateNewAccount(testdata[0]);
		rp.createAccountWithNewsLetter(testdata[1],testdata[2],testdata[3],testdata[4],testdata[5],testdata[6],testdata[7]);
	    map=rp.validateRegistration();
	    String actURL=driver.getCurrentUrl();
	    String exURL=map.getCurrentURL();
	    Assert.assertEquals(actURL, exURL);
	    
	}
}
