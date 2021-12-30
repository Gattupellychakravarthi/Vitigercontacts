package com.login;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ITlListenerClass implements ITestListener {

	// builds a new report using the html template
	ExtentHtmlReporter reporter;

	ExtentReports reports;
	// helps to generate the logs in test report.
	ExtentTest test;

	public void onTestStart(ITestResult result) {
		test = reports.createTest(result.getMethod().getMethodName());

	}

	public void onTestSuccess(ITestResult result) {
		System.out.println(result.getMethod().getMethodName() + " " + "Test Passed");

	}

	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, result.getMethod().getMethodName() + " " + "Test get Faild");
		test.log(Status.FAIL, result.getThrowable());
		try {
			String path = ExtendRepots.takeCreenshort(result.getMethod().getMethodName());
			test.addScreenCaptureFromPath(path);

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP,result.getMethod().getMethodName()+" "+"Test got Skipped");

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onTestFailedWithTimeout(ITestResult result) {

	}

	public void onStart(ITestContext context) {
		reporter = new ExtentHtmlReporter("./ExtentReports/SDET2.html");
		reporter.config().setDocumentTitle("Vtiger");
		reporter.config().setTheme(Theme.STANDARD);

		reports = new ExtentReports();
		reports.attachReporter(reporter);

		reports.setSystemInfo("Name of app", "Vtiger");
		reports.setSystemInfo("Name of test Engineer", "Chakri");
		reports.setSystemInfo("Build no", "4.1.0");

	}

	public void onFinish(ITestContext context) {
		reporter.flush();
	}

}
