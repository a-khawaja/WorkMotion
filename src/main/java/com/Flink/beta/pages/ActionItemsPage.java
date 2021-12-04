package com.Flink.beta.pages;

import com.Flink.beta.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class ActionItemsPage extends PageBase {

    public ActionItemsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.XPATH, using = "//section[@class='sc-hBUSln bXtoGQ']//a[2]")
    WebElement ACTION_ITEMS;

    @FindBy(how = How.XPATH, using = "//section[@class='sc-hBUSln bXtoGQ']")
    WebElement SPINNER;

    @FindBy(how = How.XPATH, using = "//span[contains(text(),'Pending')]")
    WebElement PENDING_BOX;

    @FindBy(how = How.XPATH, using = "//span[contains(text(),'Filter')]")
    WebElement DROPDOWN;

    @FindBy(how = How.XPATH, using = "//ul[@class='rc-dropdown-menu rc-dropdown-menu-root rc-dropdown-menu-vertical']//li")
    List<WebElement> DROPDOWN_LIST;

    @FindBy(how = How.XPATH, using = "//span[@style='max-width: 500px; overflow-wrap: break-word;']")
    WebElement EMPLOYEE_ENTRY;

    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Mark as done')]")
    WebElement MARK_AS_DONE;

    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Retrieve')]")
    WebElement DONE_ACTION;

    public void clickActionItems() {
        waitForElementTobeClickable(ACTION_ITEMS);
        click(ACTION_ITEMS);
        waitForPageToLoad();
    }

    public void clickDropDown() {
        waitForElementTobeClickable(DROPDOWN);
        jsclick(DROPDOWN);
    }

    public void selectFromDropDown(String value) throws InterruptedException {

        Thread.sleep(4000); // Change this with expected condition
        for (int i = 1; i <= DROPDOWN_LIST.size(); i++) {
            WebElement element = driver.findElement(By.xpath("//ul[@class='rc-dropdown-menu rc-dropdown-menu-root rc-dropdown-menu-vertical']//li[" + i + "]"));
            String ele = element.getText();
            if (ele.equalsIgnoreCase(value)) {
                click(element);
                break;
            }
        }
    }

    public boolean verifyIncompleteActionList() throws InterruptedException {

        Thread.sleep(3000);
        boolean flag = false;

        String pending = PENDING_BOX.getText();
        if (pending.equalsIgnoreCase("Pending")) {
            flag = true;
        }
        return flag;
    }

    public boolean getEmployeeName(String enteredName) {
        waitForElementTobeClickable(EMPLOYEE_ENTRY);
        boolean flag = false;
        String name = EMPLOYEE_ENTRY.getText();

        if (name.contains(enteredName)) {
            flag = true;
        }
        return flag;
    }

    public void clickDone() {
        waitForElementTobeClickable(MARK_AS_DONE);
        click(MARK_AS_DONE);
    }


}
