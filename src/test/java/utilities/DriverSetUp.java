package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class DriverSetUp {
    public static WebDriver driver;

    public static WebDriver driverInitiate() throws IOException {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/resources/driver/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        String browserUrl = "resources/config/configBrowser.properties";
        ConfigProperties configBrowser = new ConfigProperties(browserUrl);
        browserUrl = configBrowser.getProperty("URL");
        driver.get(browserUrl);
        driver.manage().window().maximize();
        return driver;
    }
    public static void resetCache() {
        driver.manage().deleteAllCookies();
    }

    public static void close() {
        driver.quit();
    }
    public static WebDriver getWebDriver() {
        return driver;
    }



}
