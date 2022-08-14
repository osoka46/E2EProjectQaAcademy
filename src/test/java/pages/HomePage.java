package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver)
    {
        this.driver = driver;
    }

    By navbar=By.cssSelector("[class='nav navbar-nav navbar-right']");


    public List<WebElement> getNavbar()
    {
        return driver.findElements(navbar);
    }







}
