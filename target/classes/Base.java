package resources;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class Base {
    private WebDriver driver;
    public Properties properties;
    private WebDriverWait wait;
    private SoftAssert softAssert;
    private ChromeOptions options;


    public SoftAssert setSoftAssert(SoftAssert softAssert) {
        return new SoftAssert();
    }
    public WebDriverWait setTime(WebDriver driver, Duration time)
    {
        return wait=new WebDriverWait(driver,time);
    }
    public WebDriver initializeDriver()
    {
        options=new ChromeOptions();
        properties=new Properties();
        try {
            FileInputStream fileInputStream=new FileInputStream(System.getProperty("user.dir")+"/src/test/java/resources/data.properties");
            properties.load(fileInputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //to active with maven
        //String browser=System.getProperty("browser");
        String browser=properties.getProperty("browser");
        System.out.println(browser);
        options.addArguments("--disable-popup-blocking");

        switch (browser)
        {
            case "chrome":
            {
                System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/src/test/java/drivers/chromedriver");
                driver=new ChromeDriver();
                break;
            }
            case "chromeHeadless":
            {
                System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/drivers"+"chromedriver");
                options.addArguments("headless");
                driver=new ChromeDriver(options);
                break;
            }
            case "firefox":
            {
                //firefox code
            }
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;
    }
    public String getScreenShotPath(String testCaseName, WebDriver driver)
    {
        TakesScreenshot takesScreenshot= (TakesScreenshot) driver;
        File sourceFile=takesScreenshot.getScreenshotAs(OutputType.FILE);
        String destinationFolder=System.getProperty("user.dir"+"/test/java/reports"+testCaseName+".png");
        try {
            FileUtils.copyFile(sourceFile,new File(destinationFolder));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return destinationFolder;
    }

}
