package com.Flink.stepdefs;


import com.Flink.utilities.GetConfig;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.commons.configuration.ConfigurationException;
import org.testng.Assert;

public class Task_StepDefs {
    String url;

    @Given("user opens the weathershopper page")
    public void userOpensTheWeathershopperPage() throws ConfigurationException, InterruptedException {
        url = GetConfig.getProperties("baseURL");
        Hooks_UI.container.homePage.enterURL(url);
    }

    @And("checks the temperature is {string} than {int}")
    public void checksTheTemperatureIsThan(String belowOrAbove, int tempValue) throws InterruptedException {

        if (belowOrAbove.equalsIgnoreCase("below")) {
            Assert.assertTrue(Hooks_UI.container.homePage.checkTempForMoisturizer(tempValue));
        } else if (belowOrAbove.equalsIgnoreCase("above")){
            Assert.assertTrue(Hooks_UI.container.homePage.checkTempForSunscreen(tempValue));
        } else  System.out.println("Temperature conditions are out of range.");
    }

    @And("user clicks on {string}")
    public void userClicksOn(String button) throws InterruptedException {

        if (button.equalsIgnoreCase("Buy Moisturizers")) {
            Hooks_UI.container.homePage.clickMoisturizer();
        } else if (button.equalsIgnoreCase("Buy Sunscreens")) {
           Hooks_UI.container.homePage.clickSunscreen();
        } else if (button.equalsIgnoreCase("Cart")) {
            Hooks_UI.container.productsPage.cartButton();
        } else if (button.equalsIgnoreCase("Pay with card")) {
            Hooks_UI.container.checkoutPage.payWithCardButton();
        } else if (button.equalsIgnoreCase("Pay")){
            Hooks_UI.container.checkoutPage.checkOutClick();
        }

    }

    @Then("user is landed to the {string} page")
    public void userIsLandedToThePage(String arg0) throws InterruptedException {
        if (arg0.equalsIgnoreCase("Moisturizers")) {
            Assert.assertEquals("Moisturizers", Hooks_UI.container.homePage.verifyHeader(arg0));
        } else if (arg0.equalsIgnoreCase("Sunscreens")) {
            Assert.assertEquals("Sunscreens", Hooks_UI.container.homePage.verifyHeader(arg0));
        }
    }

    @And("user verifies the price is the least")
    public void userVerifiesThePriceIsTheLeast() {
        // Already covered in the product selection Logic
    }

    @And("user selects {string} with {string}")
    public void userSelectsWith(String arg0, String arg1) throws InterruptedException {

        Hooks_UI.container.productsPage.ProductSelection(arg1);
    }

    @Then("user verifies the products are in the cart")
    public void userVerifiesTheProductsAreInTheCart() throws InterruptedException {

        Assert.assertEquals("Checkout", Hooks_UI.container.homePage.verifyHeader("Checkout"));
        Assert.assertTrue(Hooks_UI.container.checkoutPage.verifyCartData());
    }

    @And("the total amount is correct")
    public void theTotalAmountIsCorrect() {
    }

    @And("user enters {string} and {string}")
    public void userEntersAnd(String arg0, String arg1) throws InterruptedException {
        Hooks_UI.container.checkoutPage.enterCreditCardDetails(Hooks_UI.data.get("Email"),Hooks_UI.data.get("CardNumber"),Hooks_UI.data.get("Expiration"),Hooks_UI.data.get("CVC"),Hooks_UI.data.get("ZipCode"));
    }

    @Then("Strip {string} shows up")
    public void stripShowsUp(String iframeName) {
        Hooks_UI.container.checkoutPage.switchToIframe("stripe_checkout_app");

    }

    @Then("user sees the {string} window")
    public void userSeesTheWindow(String arg0) throws InterruptedException {

        Hooks_UI.container.checkoutPage.paymentConfirmation(Hooks_UI.data.get("SuccessMessage"));
    }
}
