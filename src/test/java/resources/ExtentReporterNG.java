package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporterNG {
    static ExtentReports extentReports;

    public static ExtentReports getExtentReportObject()
    {
        String path=System.getProperty("user.dir"+"/reports/index/html");
        ExtentSparkReporter extentSparkReporter=new ExtentSparkReporter(path);
        extentSparkReporter.config().setReportName("Web QaAcademy Test Results");
        extentSparkReporter.config().setDocumentTitle("Test Results");
        extentSparkReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyy, hh:mm a'('zzz')");
        extentSparkReporter.config().setTheme(Theme.DARK);

        extentReports=new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);
        extentReports.setSystemInfo("Tester","Osmanbozdag");
        return extentReports;
    }
}
