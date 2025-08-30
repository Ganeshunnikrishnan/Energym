package utils;


import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReportManager  implements ITestListener {

	
	private static ExtentReports extent;
	private static ExtentSparkReporter sparkReporter; 
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public void onStart(ITestContext context) {
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String reportPath = "reports/ExtentReport_" + timestamp + ".html";

        sparkReporter = new ExtentSparkReporter(reportPath); //  new reporter class
        sparkReporter.config().setDocumentTitle("Fitness App Automation Report");
        sparkReporter.config().setReportName("Test Execution Report");
        sparkReporter.config().setTheme(Theme.DARK);
        
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        extent.setSystemInfo("Tester", "Ganesh U");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("Browser", "Chrome");
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
        test.set(extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.get().log(Status.PASS, " Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.get().log(Status.FAIL, " Test Failed: " + result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.get().log(Status.SKIP, " Test Skipped: " + result.getThrowable());
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
	
}
