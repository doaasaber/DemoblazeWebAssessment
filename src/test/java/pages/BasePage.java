package pages;

import org.openqa.selenium.WebDriver;
import utilities.DriverSetUp;

public class BasePage {
    public SignUp signUp;
    public LogIn logIn;
    public Laptops laptop;
    public Product product;
    public Cart cart;
    public PlaceOrderData placeOrderData;


    protected WebDriver driver;
   public BasePage(){
       this.driver= DriverSetUp.getWebDriver();

   }
}
