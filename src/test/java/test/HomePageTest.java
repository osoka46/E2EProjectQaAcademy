package test;
import org.openqa.selenium.WebDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import resources.Base;

public class HomePageTest extends Base {
    public WebDriver driver;
    public static Logger log= LogManager.getLogger(Base.class.getName());
    HomePage homePage=new HomePage(driver);


    @BeforeClass
    public void initialize()
    {
        driver=initializeDriver();
    }

    @Test
    public void navbarItemSize()
    {
        driver.get(properties.getProperty("url"));

    }


    @AfterClass
    public void closeDriver()
    {
        driver.close();
    }



}
