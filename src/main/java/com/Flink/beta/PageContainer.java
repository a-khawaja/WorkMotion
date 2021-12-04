package com.Flink.beta;

import com.Flink.beta.pages.ActionItemsPage;
import org.openqa.selenium.WebDriver;

public class PageContainer {

    public WebDriver driver;
    public HomePage homePage;
    public AddEmployeePage addEmployeePage;
    public ActionItemsPage actionItemsPage;


    /**
     * Constructor of the class
     *
     * @param driver WebDriver
     */
    public PageContainer(WebDriver driver) {
        this.driver = driver;
        initPages();
    }

    /**
     * Intialise & use the methods implemented in the pages
     */
    public void initPages() {
        homePage = new HomePage(driver);
        addEmployeePage = new AddEmployeePage(driver);
        actionItemsPage = new ActionItemsPage(driver);
    }

}
