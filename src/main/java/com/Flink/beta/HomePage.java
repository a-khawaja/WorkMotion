package com.Flink.beta;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class HomePage extends PageBase {
    JavascriptExecutor js = (JavascriptExecutor) driver;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.XPATH, using = "//input[@id='email']")
    WebElement LOGIN_EMAIL;

    @FindBy(how = How.XPATH, using = "//input[@id='password']")
    WebElement LOGIN_PASSWORD;

    @FindBy(how = How.XPATH, using = "//button[@type='submit']")
    WebElement LOGIN_BUTTON;

    @FindBy(how = How.XPATH, using = "//span[contains(text(),'Dashboard')]")
    WebElement DASHBOARD_BUTTON;

    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Add employee')]")
    WebElement ADD_EMPLOYEE_BUTTON;

    @FindBy(how = How.XPATH, using = "//div[contains(@class,'css-1hwfws3')]")
    WebElement COUNTRY_SELECTION_BAR;

    @FindBy(how = How.XPATH, using = "//div[@class=' css-11unzgr']//div")
    List<WebElement> COUNTRY_LIST;

    @FindBy(how = How.XPATH, using = "//div[contains(@class,'css-1l7i409')]")
    WebElement COUNTRY_SELECTION_BAR_TEXT;

    @FindBy(how = How.XPATH, using = "//button[@type='submit']")
    WebElement GET_STARTED;

    @FindBy(how = How.XPATH, using = "//a[@id='Contract Details']")
    WebElement CONTRACT_DETAILS;

    @FindBy(how = How.XPATH, using = "//h1[@class='sc-higWrZ kqWBen']")
    WebElement CONTRACTCLAUSE_HEADER;

    @FindBy(how = How.XPATH, using = "//h1[@class='sc-higWrZ kqWBen']")
    WebElement PAGE_HEADER;

    public void enterPassword(String password) {
        inputText(LOGIN_PASSWORD, password);
    }

    public void enterUsername(String username) {
        inputText(LOGIN_EMAIL, username);
    }

    public void clickLoginButton() {
        click(LOGIN_BUTTON);
    }

    public boolean login(String username, String password) throws Exception {

        boolean flag = false;
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();

        waitForElementToBePresent(DASHBOARD_BUTTON);

        if (isElementPresent(DASHBOARD_BUTTON))
            flag = true;

        return flag;
    }


    public void clickAddEmployee() {
        waitForElementTobeClickable(ADD_EMPLOYEE_BUTTON);
        click(ADD_EMPLOYEE_BUTTON);
    }

    public void clickGetStartedButton() throws Throwable {
        waitForElementTobeClickable(GET_STARTED);
        try {
            if (isElementEnabled(GET_STARTED))
                click(GET_STARTED);
        } catch (NoSuchElementException e) {
            throw e.getCause();
        }
    }

    public String verifyPage(String text) throws InterruptedException {
        String header = null;
        if (text.equalsIgnoreCase("Country")) {
            waitForElementToBePresent(COUNTRY_SELECTION_BAR);
            header = COUNTRY_SELECTION_BAR_TEXT.getText();
        } else if (text.equalsIgnoreCase("Add Employee")) {
            waitForElementTobeClickable(ADD_EMPLOYEE_BUTTON);
            header = ADD_EMPLOYEE_BUTTON.getText();
        } else if (text.equalsIgnoreCase("Contract Details")) {
            waitForElementTobeClickable(CONTRACT_DETAILS);
            header = CONTRACT_DETAILS.getText();
        } else if (text.equalsIgnoreCase("Contract Clause")) {
            waitForElementTobeClickable(PAGE_HEADER);
            header = PAGE_HEADER.getText();
        } else if (text.equalsIgnoreCase("Invite Employee")) {
            waitForElementTobeClickable(PAGE_HEADER);
            header = PAGE_HEADER.getText();
        } else if (text.equalsIgnoreCase("Summary Review")) {
            waitForElementTobeClickable(PAGE_HEADER);
            header = PAGE_HEADER.getText();
        } else if (text.equalsIgnoreCase("Salary Calculator")) {
            waitForElementTobeClickable(CONTRACTCLAUSE_HEADER);
            header = CONTRACTCLAUSE_HEADER.getText();
        }
        return header;
    }

    public void enterCountry(String country) throws InterruptedException {

        click(COUNTRY_SELECTION_BAR);
        waitForElementTobeClickable(driver.findElement(By.xpath("//div[@class=' css-26l3qy-menu']")));
        Thread.sleep(5000);
        for (int i = 1; i <= COUNTRY_LIST.size(); i++) {
            WebElement elem = driver.findElement(By.xpath("//div[@class=' css-11unzgr']//div[" + i + "]"));
            String ele = elem.getText();
            if (ele.equalsIgnoreCase(country)) {
                click(elem);
                break;
            }
        }

    }
}