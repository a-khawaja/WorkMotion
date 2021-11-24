package com.Flink.weathershopper;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage extends PageBase {
    JavascriptExecutor js = (JavascriptExecutor) driver;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.XPATH, using = "//span[@id='temperature']")
    WebElement TEMP_VALUE;

    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Buy moisturizers')]")
    WebElement BUY_MOISTURIZER;

    @FindBy(how = How.XPATH, using = "//h2[contains(text(),'Moisturizers')]")
    WebElement MOISTURIZER_HEADER;

    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Buy sunscreens')]")
    WebElement BUY_SUNSCREEN;

    @FindBy(how = How.XPATH, using = "//h2[contains(text(),'Sunscreens')]")
    WebElement SUNSCREENS_HEADER;

    @FindBy(how = How.XPATH, using = "//h2[contains(text(),'Checkout')]")
    WebElement CHECKOUT_HEADER;

    public int getTemperature() {

        int tempValue = Integer.parseInt(TEMP_VALUE.getText().split(" ")[0]);
        return tempValue;
    }

    public boolean checkTempForMoisturizer(int tp) throws InterruptedException {

        Boolean flag = false;
        int temperature = getTemperature();
        if (temperature < tp) {
            flag = true;
        }
        return flag;
    }

    public boolean checkTempForSunscreen(int tp) {
        Boolean flag = false;
        int temperature = getTemperature();
        if (temperature > tp) {
            flag = true;
        }
        return flag;
    }

    public void clickMoisturizer() {
        click(BUY_MOISTURIZER);
    }

    public void clickSunscreen() {
        click(BUY_SUNSCREEN);
    }


    public String verifyHeader(String text) throws InterruptedException {
        Thread.sleep(1000);
        String header = null;
        if (text.equalsIgnoreCase("Moisturizers")) {
            waitForElementTobeClickable(MOISTURIZER_HEADER);
            header = MOISTURIZER_HEADER.getText();
        } else if (text.equalsIgnoreCase("Sunscreens")) {
            waitForElementTobeClickable(SUNSCREENS_HEADER);
            header = SUNSCREENS_HEADER.getText();
        } else if (text.equalsIgnoreCase("Checkout")) {
            header = CHECKOUT_HEADER.getText();
        }
        return header;
    }
}