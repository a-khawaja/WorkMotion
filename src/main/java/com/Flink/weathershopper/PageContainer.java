package com.Flink.weathershopper;

import com.Flink.weathershopper.pages.CheckoutPage;
import org.openqa.selenium.WebDriver;

public class PageContainer {

    public WebDriver driver;
    public HomePage homePage;
    public ProductsPage productsPage;
    public CheckoutPage checkoutPage;


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
        productsPage = new ProductsPage(driver);
        checkoutPage = new CheckoutPage(driver);
    }

}
