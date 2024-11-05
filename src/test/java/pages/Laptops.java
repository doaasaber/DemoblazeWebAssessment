package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.BrowserActions;

public class Laptops extends BasePage{
    private final By laptop1=By.linkText("Sony vaio i5");
    private final By laptop2=By.linkText("Sony vaio i7");


    public void clickOnFirstLaptop() throws Exception {
        BrowserActions.waitAndClickOnWebElement(laptop1,driver);
    }
    public void clickOnSecondLaptop() throws Exception {
        BrowserActions.waitAndClickOnWebElement(laptop2,driver);
    }
}
