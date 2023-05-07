package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class pr1 implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {
		
		String mname=result.getMethod().getMethodName();
		
		Reporter.log(mname+" Test Started", true);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String mname=result.getMethod().getMethodName();
		Reporter.log(mname+" test success", true);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String mname = result.getMethod().getMethodName();
		
		Reporter.log(mname+" test failed",true);
		Reporter.log(result.getThrowable().toString()+" <-reason of failure",true);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		String mname=result.getMethod().getMethodName();
		Reporter.log(mname+" test got skipped",true);
		Reporter.log(result.getMethod().getMethodName()+" <- reson for skipped",true);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		
		Reporter.log("test execution started",true);
	}

	@Override
	public void onFinish(ITestContext context) {
		Reporter.log("test execution finished",true);
	}

}
