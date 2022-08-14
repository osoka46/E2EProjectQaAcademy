package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    By emailLogin = By.id("user_email");
    By passwordLogin = By.id("user_password");
    By buttonLogin = By.id("[value='Log In']");
    By forgotPassword = By.cssSelector("a[href*='password']");

    public WebElement getEmailLogin() {
        return driver.findElement(emailLogin);
    }

    public WebElement getPasswordLogin() {
        return driver.findElement(passwordLogin);
    }

    public WebElement getButtonLogin() {
        return driver.findElement(buttonLogin);
    }

    public WebElement getForgotPassword() {
        return driver.findElement(forgotPassword);
    }

}