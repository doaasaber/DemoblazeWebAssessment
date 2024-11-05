package tests;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.DriverSetUp;
import utilities.ExcelReadFile;
import utilities.extentreport.ExtentReport;
import utilities.imagereducer.ImageReducer;

import java.io.IOException;

public class HooksHandler extends BaseTest{


    @Before(order=3)
    public void initiateTest(Scenario scenario) throws Exception {
        driver = DriverSetUp.driverInitiate();
        HooksHandler.excelReadFile = new ExcelReadFile("input.xlsx");
    }
    @Before(order = 1)
    public void startTCHooks(Scenario scenario) {
        ExtentReport.setScenario(scenario);
        ExtentReport.startTC();
    }
    @Before(order = 2)
    public void setStepDefs() throws NoSuchFieldException, IllegalAccessException {
        ExtentReport.setStepDefs();
    }

    @AfterStep
    public void AfterStep(Scenario scenario) throws IOException {
        String stepName = ExtentReport.getCurrentStepName();
        Status logStatus;

        if (scenario.isFailed()) {
            logStatus = Status.FAIL;
            byte[] image = ((TakesScreenshot) DriverSetUp.getWebDriver()).getScreenshotAs(OutputType.BYTES);
            String base64Screenshot = ImageReducer.reduce(image, 800, 600);
            ExtentReport.getTest().log(logStatus, stepName, MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
        } else {
            logStatus = Status.PASS;
            ExtentReport.getTest().log(logStatus, stepName);
        }
    }

    @After(order = 1)
    public void endTC() {
        if (ExtentReport.isCurrentlyUsingReport()) {
            ExtentReport.getExtent().flush();
        }
    }
    @After(order = 2)
    public void tearDown() {
        DriverSetUp.resetCache();
        DriverSetUp.close();
    }

}
