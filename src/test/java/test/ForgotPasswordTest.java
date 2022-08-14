package test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import resources.Base;

public class ForgotPasswordTest extends Base {
    private WebDriver driver;
    public static Logger log = LogManager.getLogger(Base.class.getName());


    @BeforeClass
    public void initialize()
    {
        driver=initializeDriver();
    }

    public ForgotPasswordTest(WebDriver driver)
    {
        this.driver = driver;
    }

    @AfterClass
    public void closeDriver()
    {
        driver.close();
    }


}
