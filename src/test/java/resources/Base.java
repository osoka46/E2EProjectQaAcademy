package resources;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class Base {
    public WebDriver driver;
    public Properties properties;
    public WebDriver initializeDriver()
    {
        properties=new Properties();
        try {
            FileInputStream fileInputStream=new FileInputStream(System.getProperty("user.dir")+"/resources/"+"data.properties");
            properties.load(fileInputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String browser=properties.getProperty("url");

        switch (browser)
        {
            case "chrome":
            {
                System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/drivers"+"chromedriver");
                driver=new ChromeDriver();
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
        String destinationFolder=System.getProperty("user.dir"+"/test/java/reports");
        try {
            FileUtils.copyFile(sourceFile,new File(destinationFolder));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return destinationFolder;
    }
}
