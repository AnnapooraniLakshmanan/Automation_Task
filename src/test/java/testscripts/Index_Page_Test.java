package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.Base_Class;
import pom_repo.Index_Page;

@Test
public class Index_Page_Test extends Base_Class
{
	private Index_Page ip;

	@Parameters("browser")
	@BeforeMethod
	public void setup(@Optional("chrome")String browser) throws IOException {
		launchApp(browser); 
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
		
public void verifyLogo()
{
		ip=new Index_Page(driver);
	boolean result=ip.validateLogo();
	Assert.assertTrue(result);
}

	
public void verifyTitle()
{
	String actTit=ip.getTitle();
	String expTit="My Shop";
	Assert.assertEquals(actTit,expTit );
}

}
