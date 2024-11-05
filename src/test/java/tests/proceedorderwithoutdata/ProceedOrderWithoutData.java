package tests.proceedorderwithoutdata;

import io.cucumber.java.en.Then;
import org.testng.Assert;
import tests.BaseTest;

public class ProceedOrderWithoutData extends BaseTest {
    @Then("validate on error message {string}")
    public void validateOnErrorMessage(String message) throws Exception {
        Assert.assertEquals(productsStore.placeOrderData.getErrorMessage(),message);
    }

}
