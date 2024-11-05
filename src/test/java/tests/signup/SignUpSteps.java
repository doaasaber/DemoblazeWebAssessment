package tests.signup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.ProductsStore;
import tests.BaseTest;

public class SignUpSteps extends BaseTest{
    @Given("navigates to sign up")
    public void navigates() throws Exception {
        productsStore=new ProductsStore();
        productsStore.clickOnSignUpButton();
    }
    @When("fill data and click on sign up button based on data: {string} {string}")
    public void fillData (String username,String password) throws Exception {
        productsStore.signUp.fillData(username,password);
    }

    @And("validate on displayed message {string}")
    public void validateOnDisplayedMessage(String message){
        Assert.assertEquals( productsStore.signUp.getAlertText(),message);
    }
}
