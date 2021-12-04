package com.Flink.beta;


import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.awt.*;

import static java.lang.System.getProperty;

public class AddEmployeePage extends PageBase {

    public AddEmployeePage(WebDriver driver) {
        super(driver);
    }

    JavascriptExecutor js = (JavascriptExecutor) driver;

    @FindBy(how = How.XPATH, using = "//input[@id='7ac6cb4a-d5e3-3f79-9c90-94367a01de86']")
    WebElement FIRST_NAME;

    @FindBy(how = How.XPATH, using = "//input[@id='bb93cab0-5b49-39d8-b02c-c4f2a1af3c5f']")
    WebElement SECOND_NAME;

    @FindBy(how = How.XPATH, using = "//div[@id='53178d0c-3465-38fa-927a-cedc5e76da52']//label[@class='sc-iJuVqt fNzFvY']//p[@class='sc-giImIA gOMaNd label'][contains(text(),'Yes')]")
    WebElement ELIGIBLE_YES_BUTTON;

    @FindBy(how = How.XPATH, using = "//div[@id='53178d0c-3465-38fa-927a-cedc5e76da52']//label[@class='sc-iJuVqt fNzFvY']//p[@class='sc-giImIA gOMaNd label'][contains(text(),'No')]")
    WebElement ELIGIBLE_NO_BUTTON;

    @FindBy(how = How.XPATH, using = "//div[@id='f8068a23-60f5-3c36-a904-192cacab4fc1']//label[@class='sc-iJuVqt fNzFvY']//p[@class='sc-giImIA gOMaNd label'][contains(text(),'Yes')]")
    WebElement EXECUTIVE_YES_BUTTON;

    @FindBy(how = How.XPATH, using = "//div[@id='f8068a23-60f5-3c36-a904-192cacab4fc1']//label[@class='sc-iJuVqt fNzFvY']//p[@class='sc-giImIA gOMaNd label'][contains(text(),'No')]")
    WebElement EXECUTIVE_NO_BUTTON;

    @FindBy(how = How.XPATH, using = "//input[@id='50a9d580-4a99-36a5-b143-09a4cf8b31e4']")
    WebElement JOB_TITLE;

    @FindBy(how = How.XPATH, using = "//textarea[@id='63ddd9a6-202a-314d-8fb5-3013f96c448f']")
    WebElement JOB_DESCRIPTION;

    @FindBy(how = How.XPATH, using = "//textarea[@id='c3515f18-0bc8-3abd-9253-0bc0d71a2d8a']")
    WebElement BUSINESS_ASSIGNMENT;

    @FindBy(how = How.XPATH, using = "//input[@id='4cd64790-f92e-3b14-9761-1fee6cd147f7']")
    WebElement ENTER_WORKING_HOURS;


    @FindBy(how = How.XPATH, using = "//p[contains(text(),'full-time')]")
    WebElement FULLTIME;

    @FindBy(how = How.XPATH, using = "//p[contains(text(),'part-time')]")
    WebElement PARTTIME;

    @FindBy(how = How.XPATH, using = "//input[@id='c661d9b7-b1b9-3173-8156-647a7a9d2eb1']")
    WebElement COST_CENTER;

    @FindBy(how = How.XPATH, using = "//input[@id='8cc64354-dec2-3e7b-9a30-2a5e7f43e7aa']")
    WebElement SIGNATORY_NAME;

    @FindBy(how = How.XPATH, using = "//input[@id='3de5eed9-c04b-3f70-b52f-7ffc3b6d5a3f']")
    WebElement SIGNATORY_TITLE;

    @FindBy(how = How.XPATH, using = "//input[@id='e8bec145-0d8d-3a08-b2b9-6d6df47e1fe9']")
    WebElement EMAIL_DIRECT_MANAGER;

    @FindBy(how = How.XPATH, using = "//body/div[@id='single-spa-application:monolith']/div[@class='sc-cHzqoD ilvogN']/div[@class='sc-JkixQ gIhOUX']/main[@id='main-container']/div[@class='sc-dkQkyq GLka-d']/div[@id='onboarding-app']/div[@class='sc-gTgzoy KuJMC']/div[@class='sc-laRQdt lmniXm']/div[@class='sc-tYqdw gJVWph']/div[@class='sc-ctaXho jfPKiY']/form[@action='#']/div/section[@class='sc-nFqVA itAvHp']/div[16]/div[1]/div[1]/div[1]/div[1]/div[1]")
    WebElement REIMBURSE_BUTTON;

    @FindBy(how = How.XPATH, using = "//body/div[@id='single-spa-application:monolith']/div[@class='sc-cHzqoD ilvogN']/div[@class='sc-JkixQ gIhOUX']/main[@id='main-container']/div[@class='sc-dkQkyq GLka-d']/div[@id='onboarding-app']/div[@class='sc-gTgzoy KuJMC']/div[@class='sc-laRQdt lmniXm']/div[@class='sc-tYqdw gJVWph']/div[@class='sc-ctaXho jfPKiY']/form[@action='#']/div/section[@class='sc-nFqVA itAvHp']/div[17]/div[1]/div[1]/div[1]/div[1]/div[1]")
    WebElement WORK_FROM_HOME_BUTTON;

    @FindBy(how = How.XPATH, using = "//button[@type='submit']")
    WebElement CONTINUE_BUTTON;

    @FindBy(how = How.XPATH, using = "//input[@id='b7108ff2-984f-3609-b62f-5f38699f7b45']")
    WebElement CALENDER_BUTTON_START_DATE;

    @FindBy(how = How.XPATH, using = "//input[@id='e3e1440d-2290-46f6-a2b9-8f3ff94fa606']")
    WebElement CALENDER_BUTTON_END_DATE;

    @FindBy(how = How.XPATH, using = "//h1[@class='sc-higWrZ kqWBen']")
    WebElement CONTRACTCLAUSE_HEADER;

    @FindBy(how = How.XPATH, using = "//input[@id='93a387eb-589d-3f4f-bd3f-75611645c600']")
    WebElement PAID_TIME_OFF;

    @FindBy(how = How.XPATH, using = "//input[@id='a0b95864-480e-3e9f-85f3-7f250512ad6a']")
    WebElement PROBABTION_TIME;

    @FindBy(how = How.XPATH, using = "//input[@id='0af5a726-17da-31d5-a79f-6b1c1088bb07']")
    WebElement TERMINATION_NOTICE;

    @FindBy(how = How.XPATH, using = "//textarea[@id='95f0e35d-5e92-36c9-8d83-bd2b8e9de934']")
    WebElement OPTIONAL_DATA;

    @FindBy(how = How.XPATH, using = "//input[@id='0b91cc78-03de-3b9f-b9f5-42263658da44']")
    WebElement BASE_SALARY;

    @FindBy(how = How.XPATH, using = "//input[@id='5a8da32e-0f82-317c-9158-ea5443e2698e']")
    WebElement SIGN_UP_BONUS;

    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Calculate')]")
    WebElement CALCULATE;

    @FindBy(how = How.XPATH, using = "//div[@id='Fees-calculation']/div[9]/p[1]")
    WebElement TOTALMONTHLYPAYMENT_HEADER;

    @FindBy(how = How.XPATH, using = "//div[@id='Fees-calculation']/div[9]/p[2]")
    WebElement TOTALMONTHLYPAYMENT;

    @FindBy(how = How.XPATH, using = "//input[@id='da1b7b0d-61e5-30c8-acb9-3fcaf9c1f91e']")
    WebElement EMAIL_ADDRESS;

    @FindBy(how = How.XPATH, using = "//button[@class='sc-bdfBQB eiJvie sc-jONnzC yTksv']")
    WebElement DOWNLOAD_AGREEMENT;

    @FindBy(how = How.XPATH, using = "//span[@class='sc-kstqJO gxJCBe']")
    WebElement CONFIRMATION;

    @FindBy(how = How.XPATH, using = "//button[@type='submit']")
    WebElement FINISH;

    @FindBy(how = How.XPATH, using = "//h1[@class='sc-hjWSTT OlOTB']")
    WebElement SUCCESSMESSAGE;

    public void enterFirstName(String name) {
        waitForElementTobeClickable(FIRST_NAME);
        click(FIRST_NAME);
        inputText(FIRST_NAME, name);
    }

    public void enterSecondName(String name) {
        waitForElementTobeClickable(SECOND_NAME);
        click(SECOND_NAME);
        inputText(SECOND_NAME, name);
    }

    public void enterJobTitle(String title) {
        waitForElementTobeClickable(JOB_TITLE);
        click(JOB_TITLE);
        inputText(JOB_TITLE, title);
    }

    public void enterJobDescription(String description) {
        waitForElementTobeClickable(JOB_DESCRIPTION);
        click(JOB_DESCRIPTION);
        inputText(JOB_DESCRIPTION, description);
    }

    public void enterBusinessAssignment(String assignment) {
        waitForElementTobeClickable(BUSINESS_ASSIGNMENT);
        click(BUSINESS_ASSIGNMENT);
        inputText(BUSINESS_ASSIGNMENT, assignment);
    }

    public void enterWorkingHours(String hours) {
        waitForElementTobeClickable(ENTER_WORKING_HOURS);
        click(ENTER_WORKING_HOURS);
        ENTER_WORKING_HOURS.sendKeys(Keys.BACK_SPACE);
        ENTER_WORKING_HOURS.clear();
        inputText(ENTER_WORKING_HOURS, hours);
    }

    public void enterPaidTimeOff(String time) {
        waitForElementTobeClickable(PAID_TIME_OFF);
        click(PAID_TIME_OFF);
        PAID_TIME_OFF.sendKeys(Keys.CONTROL, "A");
        PAID_TIME_OFF.sendKeys(Keys.BACK_SPACE);
        PAID_TIME_OFF.clear();
        inputText(PAID_TIME_OFF, time);
    }

    public void enterProbationTime(String time) {
        waitForElementTobeClickable(PROBABTION_TIME);
        click(PROBABTION_TIME);
        PROBABTION_TIME.sendKeys(Keys.BACK_SPACE);
        PROBABTION_TIME.clear();
        inputText(PROBABTION_TIME, time);
    }

    public void enterTerminationTime(String time) {
        waitForElementTobeClickable(TERMINATION_NOTICE);
        click(TERMINATION_NOTICE);
        TERMINATION_NOTICE.sendKeys(Keys.BACK_SPACE);
        TERMINATION_NOTICE.clear();
        inputText(TERMINATION_NOTICE, time);
    }

    public void enterAnythingElseSection(String text) {
        waitForElementTobeClickable(OPTIONAL_DATA);
        click(OPTIONAL_DATA);
        OPTIONAL_DATA.sendKeys(Keys.BACK_SPACE);
        OPTIONAL_DATA.clear();
        inputText(OPTIONAL_DATA, text);
    }

    public void enterBaseSalary(String salary) {
        waitForElementTobeClickable(BASE_SALARY);
        click(BASE_SALARY);
        BASE_SALARY.sendKeys(Keys.BACK_SPACE);
        BASE_SALARY.clear();
        inputText(BASE_SALARY, salary);
    }

    public void enterBonus(String bonus) {
        waitForElementTobeClickable(SIGN_UP_BONUS);
        click(SIGN_UP_BONUS);
        SIGN_UP_BONUS.sendKeys(Keys.BACK_SPACE);
        SIGN_UP_BONUS.clear();
        inputText(SIGN_UP_BONUS, bonus);
    }

    public void enterEmail(String bonus) {
        waitForElementTobeClickable(EMAIL_ADDRESS);
        click(EMAIL_ADDRESS);
        EMAIL_ADDRESS.sendKeys(Keys.BACK_SPACE);
        EMAIL_ADDRESS.clear();
        inputText(EMAIL_ADDRESS, bonus);
    }

    public void enterCostCenter(String cost) throws InterruptedException {
        waitForElementTobeClickable(COST_CENTER);
        click(COST_CENTER);
        inputText(COST_CENTER, cost);
    }

    public void enterSignatoryName(String name) {
        waitForElementTobeClickable(SIGNATORY_NAME);
        click(SIGNATORY_NAME);
        inputText(SIGNATORY_NAME, name);
    }

    public void enterSignatoryTitle(String title) {
        waitForElementTobeClickable(SIGNATORY_TITLE);
        click(SIGNATORY_TITLE);
        inputText(SIGNATORY_TITLE, title);
    }

    public void enterEmailManager(String email) {
        waitForElementTobeClickable(EMAIL_DIRECT_MANAGER);
        click(EMAIL_DIRECT_MANAGER);
        inputText(EMAIL_DIRECT_MANAGER, email);
    }

    public void clickContinueButton() throws InterruptedException {

        waitForElementTobeClickable(CONTINUE_BUTTON);
        click(CONTINUE_BUTTON);
        waitForElementTobeClickable(CONTINUE_BUTTON);
        waitForElementToBePresent(driver.findElement(By.xpath("//a[@class='sc-dFJtaz lcmQWI active']")));
    }

    public void clickCalculateButton() {
        waitForElementTobeClickable(CALCULATE);
        click(CALCULATE);
    }

    public void clickConfirmationButton() {
        waitForElementTobeClickable(CONFIRMATION);
        click(CONFIRMATION);
    }

    public void clickFinishButton() throws InterruptedException {
        waitForElementTobeClickable(FINISH);
        click(FINISH);
        Thread.sleep(3000);
    }

    public String getTOTALCostHeader(String element) {
        waitForElementTobeClickable(TOTALMONTHLYPAYMENT_HEADER);

        if (element.equalsIgnoreCase("Total Monthly Payment")) {

            js.executeScript("arguments[0].scrollIntoView();", TOTALMONTHLYPAYMENT_HEADER);
            String text = TOTALMONTHLYPAYMENT_HEADER.getText();
            return text;
        }
        return null;
    }


    public String getTOTALCost() {

        waitForElementTobeClickable(TOTALMONTHLYPAYMENT);
        js.executeScript("arguments[0].scrollIntoView();", TOTALMONTHLYPAYMENT);
        String text = TOTALMONTHLYPAYMENT.getText();
        return text;
    }

    public String getSuccessMessage() {

        String text = SUCCESSMESSAGE.getText();
        return text;
    }

    public void selectStartDate(String date) {
        waitForElementTobeClickable(CALENDER_BUTTON_START_DATE);
        click(CALENDER_BUTTON_START_DATE);

        CALENDER_BUTTON_START_DATE.sendKeys(date);
        click(CALENDER_BUTTON_START_DATE);
    }

    public void selectEndDate(String date) {
        waitForElementTobeClickable(CALENDER_BUTTON_END_DATE);
        click(CALENDER_BUTTON_END_DATE);
        CALENDER_BUTTON_END_DATE.sendKeys(date);
        click(CALENDER_BUTTON_END_DATE);

    }

    public void uploadFile() throws ConfigurationException, AWTException {

        String file = "\\src\\test\\resources\\testdata\\TestFile.docx";
        driver.findElement(By.xpath("//input[@type='file']")).sendKeys(getProperty("user.dir") + file);
    }

    public void enterNameDetails(String element1, String element2) {
        enterFirstName(element1);
        enterSecondName(element2);
    }

    public void enterJobDetails(String element1, String element2) {
        enterJobTitle(element1);
        enterJobDescription(element2);
    }

    public void clickRadioButtons(String button, String condition) {
        if (button.equalsIgnoreCase("Eligible")) {
            if (condition.contains("Yes")) {
                click(ELIGIBLE_YES_BUTTON);
            } else if (condition.contains("No")) {
                click(ELIGIBLE_NO_BUTTON);
            }
        } else if (button.equalsIgnoreCase("Executive")) {
            if (condition.contains("Yes")) {
                click(EXECUTIVE_YES_BUTTON);
            } else if (condition.contains("No")) {
                click(EXECUTIVE_NO_BUTTON);
            }
        } else if (button.equalsIgnoreCase("ContractType")) {
            if (condition.equalsIgnoreCase("Full")) {
                click(FULLTIME);
            } else if (condition.equalsIgnoreCase("Part")) {
                click(PARTTIME);
            }
        } else if (button.equalsIgnoreCase("Reimburse")) {
            if (condition.equalsIgnoreCase("Yes")) {
                click(REIMBURSE_BUTTON);
            }
        } else if (button.equalsIgnoreCase("Work from home")) {
            if (condition.equalsIgnoreCase("Yes")) {
                click(WORK_FROM_HOME_BUTTON);
                driver.findElement(By.xpath("//textarea[@id='2e32e287-cb06-4f80-aef7-00ef16ee59bd']")).sendKeys("Sample Address");
            }
        }
    }

    public void downloadAgreement() {
        js.executeScript("arguments[0].scrollIntoView();", DOWNLOAD_AGREEMENT);
        waitForElementTobeClickable(DOWNLOAD_AGREEMENT);
        click(DOWNLOAD_AGREEMENT);
        waitForElementTobeClickable(DOWNLOAD_AGREEMENT);
    }
}