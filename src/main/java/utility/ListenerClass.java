package utility;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.testng.IAnnotationTransformer;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.ITestAnnotation;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import base.Base_Class;

public class ListenerClass extends Base_Class implements ITestListener,IAnnotationTransformer 
{
	
	@Override
	public void onTestStart(ITestResult result) {
		test = reports.createTest(result.getName());
		Reporter.log("test execution started",true);
		test.log(Status.INFO, "test execution started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, result.getName()+"-Test Case Passed" );
		}
		Reporter.log("test script passed",true);
	}

	@Override
	public void onTestFailure(ITestResult result)
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			test.log(Status.FAIL,MarkupHelper.createLabel(result.getName()+"-Test Case Failed",ExtentColor.RED));
			test.log(Status.FAIL,MarkupHelper.createLabel(result.getThrowable()+"-Test Case Failed",ExtentColor.RED));
			test.fail("Screenshot is attached",MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.takeScreenShot(driver)).build());
			Reporter.log("test script failed",true);
		}
		
		
	}
	
	public void onTestSkipped(ITestResult result) {
		if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, result.getName()+"Test case skipped" );
			Reporter.log("test script skipped",true);
		}
	}

	public void transform(
			ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		annotation.setRetryAnalyzer(RetryAnalyzer.class);
	}
}



