package tests.proceedorderwithoutdata;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(glue = {"tests"},
        features = {"src/test/java/tests/proceedorderwithoutdata/proceedorderwithoutdata.feature"},
        plugin = {"pretty","io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm"}
        ,monochrome = true)
public class ProceedOrderWithoutDataRunner extends AbstractTestNGCucumberTests {
}
