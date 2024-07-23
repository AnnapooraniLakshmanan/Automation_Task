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
import pom_repo.My_Account_Page;
import pom_repo.Registration_Page;
import utility.DataaProviders;

public class TC_RF_010 extends Base_Class 
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
	
	@Test(dataProvider = "acc credentials",dataProviderClass = DataaProviders.class)
	public void checkEmailPlaceholder(String[] testdata)
	{
		ip=new Index_Page(driver);
		lp=ip.clickSignInBtn();
		rp=lp.toCreateNewAccount(testdata[0]);
		String actVal=rp.validateEmailPlaceholder();
		String exVal=testdata[0];
		Reporter.log("actValue--"+actVal,true);
		Reporter.log("ExValue--"+exVal,true);
		Assert.assertEquals(actVal, exVal);
	}
}

