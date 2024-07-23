package ts_001_register_functionality;

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
import pom_repo.Registration_Page;
import utility.DataaProviders;

public class TC_RF_003 extends Base_Class 
{
	Index_Page ip;
	Login_Page lp;
	Registration_Page rp;
	
	@Parameters("browser")
	@BeforeMethod
	public void setup(@Optional("chrome")String browser) throws IOException {
		launchApp(browser); 
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test(dataProvider = "email",dataProviderClass = DataaProviders.class)
	public void createAnAccountByProvidingExistingMailid(String[] testdata01) throws Throwable
	{
		ip=new Index_Page(driver);
		lp=ip.clickSignInBtn();
		rp=lp.toCreateNewAccount(testdata01[0]);
		boolean opt=rp.validateAcountCreatePage();
		Assert.assertTrue(opt);
		Reporter.log("User landed on account creation page successfully",true);
		
	} 
}

