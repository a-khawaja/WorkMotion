package com.Flink.weathershopper.pages;

import com.Flink.weathershopper.HomePage;
import com.Flink.weathershopper.PageBase;
import com.Flink.weathershopper.ProductsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class CheckoutPage extends PageBase {
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    ProductsPage productsPage = new ProductsPage(driver);
    JavascriptExecutor js = (JavascriptExecutor) driver;
    @FindBy(how = How.XPATH, using = "//span[contains(text(),'Pay with Card')]")
    WebElement PAY_WITH_CARD;

    @FindBy(how = How.ID, using = "submitButton")
    WebElement CHECKOUT_PAY;

    @FindBy(how = How.XPATH, using = "//h2[contains(text(),'PAYMENT SUCCESS')]")
    WebElement SUCCESS_MESSAGE_HEADER;

    @FindBy(how = How.XPATH, using = "//p[contains(text(),'Your payment was successful. You should receive a ')]")
    WebElement SUCCESS_MESSAGE_TEXT;

    public boolean verifyCartData() {

        boolean correctProducts = false;

        List<String> cartList = new ArrayList<String>();
        List<Integer> cartPrice = new ArrayList<Integer>();

        List<WebElement> cardTable = driver.findElements(By.tagName("tr"));

        for (int i = 1; i < cardTable.size(); i++) {
            String item = driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[" + i + "]/td[1]")).getText();
            cartList.add(item);
        }
        for (int i = 1; i < cardTable.size(); i++) {
            int itemPrice = Integer.parseInt(driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[" + i + "]/td[2]")).getText());
            cartPrice.add(itemPrice);
        }

        List<String> listFromProductSelection = productsPage.getList();
        if(listFromProductSelection.equals(cartList)){
            correctProducts = true;
        };

        return correctProducts;
    }

    public void payWithCardButton() throws InterruptedException {
        click(PAY_WITH_CARD);
    }
    public void checkOutClick() {
        click(CHECKOUT_PAY);
    }

    public void switchToIframe(String iframeName) {
        driver.switchTo().frame(iframeName);
        WebElement popUp = driver.findElement(By.cssSelector(".title"));
        waitForElementTobeClickable(popUp);
        Assert.assertTrue(popUp.isDisplayed());
    }

    public void enterCreditCardDetails(String email, String cardnumber, String expMth, String CVC, String zipcode) throws InterruptedException {

        driver.findElement(By.id("email")).sendKeys(email);

        WebElement card = driver.findElement(By.cssSelector("#card_number"));
        Assert.assertTrue(card.isDisplayed());
        js.executeScript("arguments[1].value = arguments[0]; ", cardnumber, card);

        WebElement exp1 = driver.findElement(By.id("cc-exp"));
        Assert.assertTrue(exp1.isDisplayed());
        click(exp1);
        //js.executeScript("arguments[0].click()",exp1);
        js.executeScript("arguments[1].value = arguments[0]; ", expMth, exp1);

        driver.findElement(By.id("cc-csc")).sendKeys(CVC);
        driver.findElement(By.id("billing-zip")).sendKeys(zipcode);
    }

    public void paymentConfirmation(String successmessage){

        waitForElementTobeClickable(SUCCESS_MESSAGE_HEADER);
        Assert.assertTrue(SUCCESS_MESSAGE_HEADER.isDisplayed());
        Assert.assertEquals(successmessage, SUCCESS_MESSAGE_TEXT.getText());
    }


}
