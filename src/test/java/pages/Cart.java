package pages;

import io.cucumber.java.sl.In;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.BrowserActions;

public class Cart extends BasePage {
    private final By productTable=By.id("tbodyid");
    private final By totalPrice=By.id("totalp");
    private final By placeOrder=By.xpath("//*[@id=\"page-wrapper\"]/div/div[2]/button");
    private final By productName1=By.xpath(".//tr[2]/td[2]");
    private final By productName2=By.xpath(".//tr[1]/td[2]");
    private final By productprice1=By.xpath(".//tr[2]/td[3]");
    private final By productprice2=By.xpath(".//tr[1]/td[3]");


    public String getProductTitle1() throws Exception {
        //Thread.sleep(3000);
        return BrowserActions.waitAndGetCellText(productTable,productName1,driver);
    }
    public String getProductTitle2() throws Exception {
        return BrowserActions.waitAndGetCellText(productTable,productName2,driver);
    }
    public int getProductPrice1() throws Exception {
       return Integer.parseInt(BrowserActions.waitAndGetCellText(productTable,productprice1,driver));
    }
    public int getProductPrice2() throws Exception {
        return Integer.parseInt(BrowserActions.waitAndGetCellText(productTable,productprice2,driver));

    }

    public int GetTotalPrice() throws Exception {
       int total= Integer.parseInt(BrowserActions.waitAndGetElementText(totalPrice,driver));
        return total;
    }

    public void clickOnPlaceOrder() throws Exception {
        BrowserActions.waitAndClickOnWebElement(placeOrder,driver);
    }
}
