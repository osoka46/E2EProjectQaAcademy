package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners extends Base implements ITestListener {
    ExtentTest test;
    ExtentReports extentReports=ExtentReporterNG.getExtentReportObject();
    //to be able to run tests parallel
    ThreadLocal<ExtentTest>extentTestThreadLocal=new ThreadLocal<ExtentTest>();

    @Override
    public void onTestStart(ITestResult result) {
        test=extentReports.createTest(result.getMethod().getMethodName());
        extentTestThreadLocal.set(test);
    }


    @Override
    public void onTestSuccess(ITestResult result) {
        extentTestThreadLocal.get().log(Status.PASS,"test passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        extentTestThreadLocal.get().fail(result.getThrowable());
        WebDriver driver=null;
        String testMethodName=result.getMethod().getMethodName();

        try {
            driver= (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
            extentTestThreadLocal.get().addScreenCaptureFromPath(getScreenShotPath(testMethodName,driver));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        extentReports.flush();
    }
}
