package com.ajio.generalUtililies;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementation implements ITestListener{
	ExtentReports report;
	ExtentTest test;
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		test=report.createTest(result.getMethod().getMethodName());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, result.getMethod().getMethodName()+" is Pass");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL,result.getMethod().getMethodName()+" is Failed");
		test.log(Status.FAIL, result.getThrowable());
		test.addScreenCaptureFromPath(WebdriverRepository.takeAScreenshot(BaseClass.staticdriver,result.getMethod().getMethodName()));
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, result.getMethod().getMethodName()+" is Skipped");
		test.log(Status.SKIP, result.getThrowable());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Test is failed with partial success");
	}

	@Override
	public void onStart(ITestContext context) {
		report=new ExtentReports();
		ExtentSparkReporter spark=new ExtentSparkReporter("./Extent-Report/extentReport.html");
		spark.config().setDocumentTitle("AJIO");
		spark.config().setTheme(Theme.DARK);
		spark.config().setReportName("AJIO-Report");
		report.attachReporter(spark);
		report.setSystemInfo("Environment", "TestNG");
		report.setSystemInfo("Reporter Name", "Smitha S");
		report.setSystemInfo("Platform", "Windows");
		report.setSystemInfo("Unit Testing Tool", "TestNG");
		report.setSystemInfo("Automation", "Selenium");
		report.setSystemInfo("Build Management Tool", "Mavan");
	}

	@Override
	public void onFinish(ITestContext context) {
		report.flush();
		
	}
	

}
