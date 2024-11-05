package tests.addproductstocart;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(glue = {"tests"},
        features = {"src/test/java/tests/addproductstocart/addproductstocart.feature"},
        plugin = {"pretty","io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm"}
        ,monochrome = true)
public class AddProductToCartRunner extends AbstractTestNGCucumberTests {
}
