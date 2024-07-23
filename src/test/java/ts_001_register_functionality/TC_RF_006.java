package ts_001_register_functionality;

import java.io.IOException;

import org.testng.Assert;
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

public class TC_RF_006 extends Base_Class 
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
	public void creatingNewAccByNotProvidingAllFields() throws Throwable
	{
		ip=new Index_Page(driver);
		lp=ip.clickSignInBtn();
		rp=lp.toCreateNewAccount("aaaddmiinn@gmail.com");
		rp.createAccountWithNewsLetter("","","","","","","");
		map=rp.validateRegistration();
	    boolean res=map.validateOrderHistory();
	    Assert.assertTrue(res);
	    
	}
}
