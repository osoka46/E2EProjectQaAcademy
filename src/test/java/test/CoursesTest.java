package test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import resources.Base;

public class CoursesTest extends Base {

    private WebDriver driver;
    public static Logger log = LogManager.getLogger(Base.class.getName());

    public CoursesTest(WebDriver driver) {
        this.driver = driver;
    }

    @BeforeClass
    public void initialize()
    {
        driver=initializeDriver();
    }

    @AfterClass
    public void closeDriver()
    {
        driver.close();
    }


}
