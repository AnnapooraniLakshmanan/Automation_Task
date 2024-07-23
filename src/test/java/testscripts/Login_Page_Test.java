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
import utility.Utility_Method;


public class Login_Page_Test extends Base_Class
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
	
	
	@Test
	public void validateLoginPage()
	{
		ip=new Index_Page(driver);
		lp=ip.clickSignInBtn();
		boolean out=lp.validateHeading();
		Assert.assertTrue(out);
		Reporter.log("User landed on login page successfully",true);
	}
	
	@Test
	public void loginActionTest() throws Throwable
	{
		ip=new Index_Page(driver);
		lp=ip.clickSignInBtn();
		map=lp.loginAction(Utility_Method.getDataFromProperty("username"),Utility_Method.getDataFromProperty("password"),map);
	    /*boolean op=map.validateOrderHistory();
	    Assert.assertTrue(op);*/
		String exURL=map.getCurrentURL();
		String actURL=driver.getCurrentUrl();
		Assert.assertEquals(actURL,exURL);
	    Reporter.log("User landed on my account page successfully",true);
	}
	
	@Test(dataProvider = "email",dataProviderClass = DataaProviders.class)
	public void createNewAccTest(String[] tesstdata) throws Throwable
	{
		ip=new Index_Page(driver);
		lp=ip.clickSignInBtn();
		rp=lp.toCreateNewAccount(tesstdata[0]);
		boolean opt=rp.validateAcountCreatePage();
		Assert.assertTrue(opt);
		Reporter.log("User landed on account creation page successfully",true);
	}
}
