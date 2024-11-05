package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import utilities.BrowserActions;
import utilities.DriverSetUp;

public class Product extends BasePage {
    private final By title= By.xpath("//*[@id=\"tbodyid\"]/h2");
    private final By price=By.xpath("//*[@id=\"tbodyid\"]/h3");
    private final By addToCartButton=By.xpath("//*[@id=\"tbodyid\"]/div[2]/div/a");
    private final By cart=By.id("cartur");
    public String getProductTitle() throws Exception {
       String productName= BrowserActions.waitAndGetElementText(title,driver);
        return productName;
    }
    public int getProductPrice()throws Exception{
        String productPrice=BrowserActions.waitAndGetElementText(price,driver);
        productPrice=productPrice.replaceAll("[^0-9]", "");
        int price=Integer.parseInt(productPrice);
        return price;
    }
    public String addToCart() throws Exception {
        BrowserActions.waitAndClickOnWebElement(addToCartButton,driver);
        Thread.sleep(2000);

        String AlertText=BrowserActions.waitAndGetAlertText(driver);
        return AlertText;
    }
    public Laptops navigateToBack() throws Exception {
        driver.navigate().back();
        driver.navigate().back();
        return new Laptops();
    }
    public Cart navigateToCart() throws Exception {
        BrowserActions.waitAndClickOnWebElement(cart,driver);
        return new Cart();
    }
}
