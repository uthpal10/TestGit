package genericRepository;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImpClass implements ITestListener
{
	ExtentReports report;
	ExtentTest test;

	@Override
	public void onStart(ITestContext context) 
	{
		ExtentSparkReporter htmlreport = new ExtentSparkReporter("./ExtentReport/report.html");
		htmlreport.config().setDocumentTitle("HMS");
		htmlreport.config().setTheme(Theme.STANDARD);
		htmlreport.config().setReportName("Admin Module Smoke TC");
		
		report = new ExtentReports();
		report.attachReporter(htmlreport);
		
		report.setSystemInfo("Base Platform", "Windows 10");
		report.setSystemInfo("Base Browser", "chrome");
		report.setSystemInfo("Base URL", "http://rmgtestingserver/domain/Hospital_Management_System/");
		report.setSystemInfo("Reporter Name", "Uthpal");
	}
	
	@Override
	public void onTestStart(ITestResult result) 
	{	
		// Execution starts from here
		String MethodName = result.getMethod().getMethodName();
		test =	report.createTest(MethodName);
		Reporter.log(MethodName+ " ----> Execution starts");
	}

	@Override
	public void onTestSuccess(ITestResult result) 
	{	
		String MethodName = result.getMethod().getMethodName();
		test.log(Status.PASS, MethodName+ "----> Passed");
		Reporter.log(MethodName+ "---> Test Script Executed");
		
	}

	@Override
	public void onTestFailure(ITestResult result) 
	{	
			String MethodName = result.getMethod().getMethodName();
		try {
			String screenshot = WebDriverUtils.getScreenshotwithDate(BaseClass.driver, MethodName);
			test.log(Status.FAIL, "--- Failed");
			test.log(Status.FAIL, result.getThrowable());
			Reporter.log(MethodName+ "---> Failed");
			test.addScreenCaptureFromPath(screenshot);
		   	} 
		catch (Throwable e) 
		{
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) 
	{
		String MethodName = result.getMethod().getMethodName();
		test.log(Status.SKIP, MethodName+ "---> Test Script Skipped");
		test.log(Status.SKIP, result.getThrowable());
		Reporter.log(MethodName+ "---> Skipped");
	}
	
	@Override
	public void onFinish(ITestContext context) 
	{
		report.flush();
	}
}
