package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.BrowserActions;
import utilities.DriverSetUp;

public class ProductsStore extends BasePage {

    private final By signup=By.id("signin2");
    private final By laptops=By.xpath("//a[@id='itemc' and @onclick=\"byCat('notebook')\"]");
    private final By login=By.id("login2");


    public ProductsStore(){
        logIn=new LogIn();
        signUp=new SignUp();
        laptop=new Laptops();
        product=new Product();
        cart=new Cart();
        placeOrderData=new PlaceOrderData();
    }

    public SignUp clickOnSignUpButton() throws Exception {
        BrowserActions.waitAndClickOnWebElement(signup,driver);
        return new SignUp();

    }
    public LogIn clickOnLogInButton() throws Exception {
        BrowserActions.waitAndClickOnWebElement(login,driver);
        return new LogIn();

    }
    public Laptops clickOnLaptopsButton() throws Exception {
        Thread.sleep(3000);
        BrowserActions.waitAndClickOnWebElement(laptops,driver);
        return new Laptops();

    }

}
