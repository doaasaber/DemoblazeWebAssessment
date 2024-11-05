package tests.addproductstocart;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.ProductsStore;
import tests.BaseTest;

public class AddProductToCartSteps extends BaseTest {

    @Given("user navigate to login")
    public void userNavigateToLogin() throws Exception {
        productsStore=new ProductsStore();
        productsStore.clickOnLogInButton();
    }
    @When("user login with valid data {string} {string}")
    public void userLoginWithValidData(String username,String password) throws Exception {
        productsStore.logIn.fillData(username,password);
    }
    @And("user navigate to laptops")
    public void userNavigateToLaptops()throws Exception{
        productsStore.clickOnLaptopsButton();
    }
    @And("user choose first product")
    public void userChooseFirstProduct()throws Exception{
        productsStore.laptop.clickOnFirstLaptop();
    }
    @And ("user add first product to cart and validate on message {string}")
    public void userAddFirstProductToCartAndValidateOnMessage(String message)throws Exception{
        productName1=productsStore.product.getProductTitle();
        productPrice1=productsStore.product.getProductPrice();
        Assert.assertEquals( productsStore.product.addToCart(),message);
    }
    @And ("user back to the last page")
    public void userBackToTheLastPage() throws Exception {
        productsStore.product.navigateToBack();
    }
    @And("user choose second product")
    public void userChooseSecondProduct()throws Exception{
        productsStore.laptop.clickOnSecondLaptop();
    }
    @And ("user add second product to cart and validate on message {string}")
    public void userAddSecondProductToCartAndValidateOnMessage(String message)throws Exception{
        productName2=productsStore.product.getProductTitle();
        productPrice2=productsStore.product.getProductPrice();
        Assert.assertEquals( productsStore.product.addToCart(),message);
    }
    @And("user navigate to cart")
    public void userNavigateToCart() throws Exception {
        productsStore.product.navigateToCart();
    }
    @And("validate that two products include title and Price are added in products page")
    public void validateThatTwoProductsIncludeTitleAndPriceAreAddedInProductsPage() throws Exception {
        Assert.assertEquals( productsStore.cart.getProductTitle1(),productName1);
        Assert.assertEquals( productsStore.cart.getProductTitle2(),productName2);
        Assert.assertEquals( productsStore.cart.getProductPrice1(),productPrice1);
        Assert.assertEquals( productsStore.cart.getProductPrice2(),productPrice2);

    }
    @And("validate that total amount is calculated correctly")
    public void validateThatTotalAmountIsCalculatedCorrectly() throws Exception {
        Assert.assertEquals( productsStore.cart.GetTotalPrice(),productPrice1+productPrice2);

    }
    @And("user click on place order")
    public void userClickOnPlaceOrder() throws Exception {
        productsStore.cart.clickOnPlaceOrder();
    }
    @And("validate that total amount is the same calculated before")
    public void validateThatTotalAmountIsTheSameCalculatedBefore() throws Exception {
        Assert.assertEquals( productsStore.placeOrderData.getTotal(),productPrice1+productPrice2);
    }
    @And("user fill data {string}{string}{string}{string}{string}{string}")
    public void userFillData(String name,String city,String country,String card ,String month, String year) throws Exception {
        productsStore.placeOrderData.fillData(name,city,country,card,month,year);
    }
    @And("user click on purchase")
    public void userClickOnPurchase() throws Exception {
        productsStore.placeOrderData.clickOnPurchase();
    }
    @Then("validate on success message{string}")
    public void validateOnSuccessMessage(String message) throws Exception {
        Assert.assertEquals( productsStore.placeOrderData.getSuccessMessage(),message);
    }

}
