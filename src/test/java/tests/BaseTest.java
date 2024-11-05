package tests;

import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import pages.ProductsStore;
import utilities.ExcelReadFile;

public class BaseTest {
    protected static ProductsStore productsStore;
    public static WebDriver driver;
    public static ExcelReadFile excelReadFile;
    public static String productName1;
    public static String productName2;
    public static int productPrice1;
    public static int productPrice2;

}
