package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.BrowserActions;

public class SignUp extends BasePage {
    private final By userName= By.id("sign-username");
    private final By password=By.id("sign-password");
    private final By signUpButton=By.xpath("//button[.='Sign up']");

    public void fillData(String Username,String Password) throws Exception {
        BrowserActions.waitAndEnterTextInWebElement(Username,userName,driver);
        BrowserActions.waitAndEnterTextInWebElement(Password,password,driver);
        BrowserActions.waitAndClickOnWebElement(signUpButton,driver);

    }

    public String getAlertText (){
       String alertText= BrowserActions.waitAndGetAlertText(driver);
       return alertText;
    }
}
