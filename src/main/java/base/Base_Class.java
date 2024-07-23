package base;

import java.io.IOException;






import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import utility.Utility_Method;
import utility.Waits;
import utility.ListenerClass;


@Listeners(ListenerClass.class)
public class Base_Class
{
	public static WebDriver driver;
	public static ExtentSparkReporter reporter;
	public static ExtentReports reports;
	public static ExtentTest test;
	

	@BeforeSuite(alwaysRun = true)
	public void extendingReports()
	{
		reporter=new ExtentSparkReporter("./reports/"+Utility_Method.getCurrentTime()+".html");
		reports=new ExtentReports();
		reports.attachReporter(reporter);
	
	}
	
	
	public void launchApp(String bname) throws IOException
	{
		if(bname.contains("chrome"))
			driver=new ChromeDriver();

		else if(bname.contains("firefox"))
			driver=new FirefoxDriver();

		else if(bname.contains("edge"))
			driver=new EdgeDriver();

		else if(bname.contains("internet"))
			driver=new InternetExplorerDriver();

		else
			Reporter.log("pls enter a valid browser name",true);

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		Waits.implicitWait(driver, 10);
		driver.get(Utility_Method.getDataFromProperty("url"));

	}

	
	
   @AfterSuite(alwaysRun = true)
	public void reportGeneration() 
	{
		reports.flush();
	}
}
