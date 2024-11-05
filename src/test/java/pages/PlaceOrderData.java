package pages;

import org.openqa.selenium.By;
import utilities.BrowserActions;

public class PlaceOrderData extends BasePage {
    private final By name=By.id("name");
    private final By country=By.id("country");
    private final By card=By.id("card");
    private final By city=By.id("city");
    private final By month=By.id("month");
    private final By year=By.id("year");
    private final By purchaseButton=By.xpath("//button[.='Purchase']");
    private final By total=By.xpath("//label[@id='totalm']");
    private final By successMsg=By.xpath("/html/body/div[10]/h2");
    public int getTotal() throws Exception {
        //Thread.sleep(3000);
        String price=BrowserActions.waitAndGetElementText(total,driver).replaceAll("[^0-9]", "");
       return Integer.parseInt(price);
    }
    public void fillData(String Name , String Country,String Year , String City,String Card , String Month) throws Exception {
        BrowserActions.waitAndEnterTextInWebElement(Name,name,driver);
        BrowserActions.waitAndEnterTextInWebElement(City,city,driver);
        BrowserActions.waitAndEnterTextInWebElement(Country,country,driver);
        BrowserActions.waitAndEnterTextInWebElement(Card,card,driver);
        BrowserActions.waitAndEnterTextInWebElement(Month,month,driver);
        BrowserActions.waitAndEnterTextInWebElement(Year,year,driver);
    }

    public void clickOnPurchase() throws Exception {
        BrowserActions.scrollIntoView(purchaseButton,driver);
        BrowserActions.waitAndClickOnWebElement(purchaseButton,driver);
    }
    public String getSuccessMessage() throws Exception {
        return BrowserActions.waitAndGetElementText(successMsg,driver);

    }
    public String getErrorMessage() throws Exception {
        return BrowserActions.waitAndGetAlertText(driver);

    }
}
