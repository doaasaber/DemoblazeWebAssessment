package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import sun.security.util.Password;
import utilities.BrowserActions;

public class LogIn extends BasePage {
    private final By userName= By.id("loginusername");
    private final By password=By.id("loginpassword");
    private final By logInButton=By.xpath("//button[.='Log in']");
    public ProductsStore fillData(String Username,String Password) throws Exception {
        BrowserActions.waitAndEnterTextInWebElement(Username,userName,driver);
        BrowserActions.waitAndEnterTextInWebElement(Password, password,driver);
        BrowserActions.waitAndClickOnWebElement(logInButton,driver);
        return new ProductsStore();
    }

}
