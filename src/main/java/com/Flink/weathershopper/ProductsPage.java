package com.Flink.weathershopper;


import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProductsPage extends PageBase {

    public ProductsPage(WebDriver driver) {
        super(driver);
    }
    JavascriptExecutor js = (JavascriptExecutor) driver;

    @FindBy(how = How.XPATH, using = "//div[@class='container']/div[2]")
    WebElement FIRST_ROW_LIST;

    @FindBy(how = How.XPATH, using = "//div[@class='container']/div[3]")
    WebElement SECOND_ROW_LIST;

    @FindBy(how = How.XPATH, using = "//button[@class='thin-text nav-link']")
    WebElement CART_BUTTON;

    @FindBy(how = How.XPATH, using = "//h2[contains(text(),'Checkout')]")
    WebElement CHECKOUT_HEADER;

    public static List<String> finalSelectedList = new ArrayList<String>();

    public List<String> getList(){
        return  finalSelectedList;
    }

    public void cartButton() throws InterruptedException {
        click(CART_BUTTON);
    }

    public void ProductSelection(String keyword) throws InterruptedException {

        Thread.sleep(2000);
        List<String> productNameList1 = new ArrayList<String>();
        List<String> productNamelist2 = new ArrayList<String>();

        List<Integer> priceList1 = new ArrayList<Integer>();
        List<Integer> priceList2 = new ArrayList<Integer>();

        // Getting product names from the first Row
        for (int i = 1; i <= 3; i++) {
            WebElement elementProduct = driver.findElement(By.xpath("//div[@class='container']/div[2]/div[" + i + "]/p[@class='font-weight-bold top-space-10']"));
            String productName = elementProduct.getText();
            if (productName.contains(keyword)) {
                productNameList1.add(productName);
            }
        }


        // Getting product names from the second Row
        for (int i = 1; i <= 3; i++) {
            WebElement elementProduct = driver.findElement(By.xpath("//div[@class='container']/div[3]/div[" + i + "]/p[@class='font-weight-bold top-space-10']"));
            String productName = elementProduct.getText();

            if (productName.contains(keyword)) {
                productNamelist2.add(productName);
            }
        }

        List<String> newProductList = Stream.of(productNameList1, productNamelist2).flatMap(List::stream).collect(Collectors.toList()); // List after filtering

        // Iteration with the list after joining the first 2 rows and filtered product

        for (int i = 0; i < newProductList.size(); i++) {
            String prdt = newProductList.get(i);

            // For the first Row
            for (int j = 1; j <= 3; j++) {
                WebElement elementProduct = driver.findElement(By.xpath("//div[@class='container']/div[2]/div[" + j + "]/p[@class='font-weight-bold top-space-10']"));
                String productName = elementProduct.getText();

                if (productName.equalsIgnoreCase(prdt)) {
                    WebElement elementPrice = driver.findElement(By.xpath("//div[@class='container']/div[2]/div[" + j + "]/p[2]"));
                    String substring = elementPrice.getText().split("s")[1];
                    int priceValue = Integer.parseInt(substring.split(" ")[1].trim());

                    priceList1.add(priceValue);
                }
            }

            // For the second Row
            for (int j = 1; j <= 3; j++) {
                WebElement elementProduct = driver.findElement(By.xpath("//div[@class='container']/div[3]/div[" + j + "]/p[@class='font-weight-bold top-space-10']"));
                String productName = elementProduct.getText();

                if (productName.equalsIgnoreCase(prdt)) {
                    WebElement elementPrice = driver.findElement(By.xpath("//div[@class='container']/div[3]/div[" + j + "]/p[2]"));

                    int priceValue = Integer.parseInt(elementPrice.getText().split(" ")[1].trim());

                    priceList2.add(priceValue);
                }

            }
        }

        List<Integer> newPricetList = Stream.of(priceList1, priceList2).flatMap(List::stream).collect(Collectors.toList()); // List after filtering

        int leastPriceProductIndex = newPricetList.indexOf(Collections.min(newPricetList));

        String leastPriceProduct = newProductList.get(leastPriceProductIndex);
        finalSelectedList.add(leastPriceProduct); // added in the list to compare with the checkout data

        // Checking in the 1st row
        for (int j = 1; j <= 3; j++) {
            WebElement elementProduct = driver.findElement(By.xpath("//div[@class='container']/div[2]/div[" + j + "]/p[@class='font-weight-bold top-space-10']"));
            String productName = elementProduct.getText();

            if (productName.equalsIgnoreCase(leastPriceProduct)) {
                WebElement elementPrice = driver.findElement(By.xpath("//div[@class='container']/div[2]/div[" + j + "]/p[2]"));
                click(driver.findElement(By.xpath("//div[@class='container']/div[2]/div[" + j + "]/button")));
            }
        }

        // Checking in the second row
        for (int j = 1; j <= 3; j++) {
            WebElement elementProduct = driver.findElement(By.xpath("//div[@class='container']/div[3]/div[" + j + "]/p[@class='font-weight-bold top-space-10']"));
            String productName = elementProduct.getText();

            if (productName.equalsIgnoreCase(leastPriceProduct)) {
                WebElement elementPrice = driver.findElement(By.xpath("//div[@class='container']/div[3]/div[" + j + "]/p[2]"));
                click(driver.findElement(By.xpath("//div[@class='container']/div[3]/div[" + j + "]/button")));
            }
        }
    }
}

    /*public void openAnnotationWindow(int annotationNo) throws ConfigurationException {
        int yOffSet = 0;
        js.executeScript("arguments[0].scrollIntoView(true);", EDIT_VIEW_ANNOTATION_BUTTON);
        if (GetConfig.getProperties("ScenarioName").contains("TopLevel")) {
            yOffSet = -48;
        } else {
            yOffSet = 78;
        }
        waitForPageToLoad();
        wait(1000);
        waitForElementTobeClickable(SOURCE_AND_TARGET);
        if (annotationNo == 1)
            actions.moveToElement(SOURCE_AND_TARGET, 0, 0).moveByOffset(18, yOffSet).click().build().perform();
        else if (annotationNo == 2) {
            actions.moveToElement(SOURCE_AND_TARGET, 0, 0).moveByOffset(18, yOffSet + 20).click().build().perform();
        } else if (annotationNo == 3) {
            actions.moveToElement(SOURCE_AND_TARGET, 0, 0).moveByOffset(18, yOffSet + 40).click().build().perform();
        } else if (annotationNo == 4) {
            actions.moveToElement(SOURCE_AND_TARGET, 0, 0).moveByOffset(18, yOffSet + 60).click().build().perform();
        }
    }


    public boolean highlights_getButtonOrElementStatus(String button) {
        if (button.equalsIgnoreCase("+")) {
            waitForElementTobeClickable(HIGHLIGHT_BUTTON_SELECTED);
            return isElementPresent(PLUS_SYMBOL);
        } else if (button.equalsIgnoreCase("next")) {
            waitForElementTobeClickable(HIGHLIGHT_BUTTON_SELECTED);
            return isElementPresent(NEXT_BUTTON);
        } else if (button.equalsIgnoreCase("cancel")) {
            waitForElementTobeClickable(HIGHLIGHT_BUTTON_SELECTED);
            return isElementPresent(CANCEL_BUTTON);
        } else if (button.equalsIgnoreCase("Delete")) {
            waitForElementTobeClickable(WINDOW);
            return isElementPresent(DELETE_ANNOTATION_BUTTON);
        } else if (button.equalsIgnoreCase("visible in tour label"))
            return isElementPresent(VISIBLE_IN_TOUR_LABEL);
        else if (button.equalsIgnoreCase("visible in tour check box"))
            return isElementSelected(VISIBLE_IN_TOUR_CHECKBOX);
        else if (button.equalsIgnoreCase("catalog main")) {
            waitForElementToBePresent(HIGHLIGHT_CATALOG_MAIN_PAGE);
            return isElementPresent(HIGHLIGHT_CATALOG_MAIN_PAGE);
        } else if (button.equalsIgnoreCase("Catalog label"))
            return isElementPresent(HIGHLIGHT_CATALOG_LABEL);
        else if (button.equalsIgnoreCase("Catalog button"))
            return isElementPresent(HIGHLIGHT_CATALOG_BUTTON);
        else if (button.equalsIgnoreCase("Other label"))
            return isElementPresent(HIGHLIGHT_OTHER_LABEL);
        else if (button.equalsIgnoreCase("Other button"))
            return isElementPresent(HIGHLIGHT_OTHER_BUTTON_UNSELECTED);
        else if (button.equalsIgnoreCase("Search Bar"))
            return isElementPresent(HIGHLIGHT_SEARCH_BAR);
        else if (button.equalsIgnoreCase("Highlight Description box"))
            return isElementPresent(HIGHLIGHT_DESCRIPTION_BOX);
        else if (button.equalsIgnoreCase("Highlight name box"))
            return isElementPresent(HIGHLIGHT_NAME_BOX);

        return false;
    }


    public boolean imperfection_Information_getButtonOrElementStatus(String button) {
        waitForElementToBePresent(DIALOG_BORDER);
        if (button.equalsIgnoreCase("catalog main")) {
            waitForElementToBePresent(CHECKPOINT_SECTION);
            return isElementPresent(CHECKPOINT_SECTION)
                    && isElementPresent(DETAIL_SECTION)
                    && isElementPresent(ADDITIONAL_COMMENT_SECTION);
        } else if (button.equalsIgnoreCase("Checkpoint label")) {
            return isElementPresent(CHECKPOINT_LABEL);
        } else if (button.equalsIgnoreCase("Checkpoint Catalog label")) {
            return isElementPresent(CHECKPOINT_CATALOG_LABEL);
        } else if (button.equalsIgnoreCase("Checkpoint Catalog")) {
            return isElementPresent(CHECKPOINT_CATALOG_RADIOBUTTON);
        } else if (button.equalsIgnoreCase("Checkpoint Other label")) {
            return isElementPresent(CHECKPOINT_OTHER_LABEL);
        } else if (button.equalsIgnoreCase("Checkpoint Other")) {
            return isElementPresent(CHECKPOINT_OTHER_RADIOBUTTON);
        } else if (button.equalsIgnoreCase("Checkpoint SearchBar")) {
            return isElementPresent(CHECKPOINT_SEARCHBAR);
        } else if (button.equalsIgnoreCase("Checkpoint textarea")) {
            return isElementPresent(CHECKPOINT_TEXTAREA);
        } else if (button.equalsIgnoreCase("Detail label")) {
            return isElementPresent(DETAIL_LABEL);
        } else if (button.equalsIgnoreCase("Detail Catalog label")) {
            return isElementPresent(DETAIL_CATALOG_LABEL);
        } else if (button.equalsIgnoreCase("Detail Catalog")) {
            return isElementPresent(DETAIL_CATALOG_RADIOBUTTON);
        } else if (button.equalsIgnoreCase("Detail Other label")) {
            return isElementPresent(DETAIL_OTHER_LABEL);
        } else if (button.equalsIgnoreCase("Detail Other")) {
            return isElementPresent(DETAIL_OTHER_RADIOBUTTON);
        } else if (button.equalsIgnoreCase("Detail SearchBar")) {
            return isElementPresent(DETAIL_SEARCHBAR);
        } else if (button.equalsIgnoreCase("Additional comment")) {
            return isElementPresent(ADDITIONAL_COMMENT_SECTION);
        } else if (button.equalsIgnoreCase("Detail textarea")) {
            return isElementPresent(DETAIL_TEXTAREA);
        } else if (button.equalsIgnoreCase("Damage type") || button.equalsIgnoreCase("Information type")) {
            return isElementPresent(DAMAGE_INFORMATION_TYPE_LABEL);
        }
        return false;
    }


    public boolean getSelectionStatusOrSize(String button) {
        if (button.equalsIgnoreCase("Other button"))
            return isElementSelected(HIGHLIGHT_OTHER_BUTTON_SELECTED);
        else if (button.equalsIgnoreCase("Any Highlight"))
            return isElementPresent(SELECTED_HIGHLIGHT_CLASS);
        else if (button.equalsIgnoreCase("Checkpoint Catalog"))
            return isElementSelected(CHECKPOINT_CATALOG_RADIOBUTTON);
        else if (button.equalsIgnoreCase("Detail Catalog"))
            return isElementSelected(DETAIL_CATALOG_RADIOBUTTON);
        else if (button.equalsIgnoreCase("Checkpoint detail"))
            return isElementSelected(CHECKPOINT_OTHER_RADIOBUTTON);
        else if (button.equalsIgnoreCase("Detail other"))
            return isElementSelected(DETAIL_OTHER_RADIOBUTTON);
        else
            return false;
    }


    public void enterAdditionalComment(String comment) {
        inputText(ADDITIONAL_COMMENT_SECTION, comment);
    }

    public void verifyAnnotationInWidget(String annotationType) throws Exception {
        for (int i = 0; i < ANNOTATION.size(); i++) {
            if (!ANNOTATION.get(i).getAttribute("style").contains("display: none")) {

                if (annotationType.equalsIgnoreCase("Imperfection")) {
                    Assert.assertEquals(ANNOTATION.get(i).getAttribute("class"), "annotation-icon-damage");
                    break;
                } else if (annotationType.equalsIgnoreCase("Information")) {
                    Assert.assertEquals(ANNOTATION.get(i).getAttribute("class"), "annotation-icon-information");
                    break;
                } else if (annotationType.equalsIgnoreCase("Highlight")) {
                    Assert.assertEquals(ANNOTATION.get(i).getAttribute("class"), "annotation-icon-highlight");
                    break;
                }
            }
        }
        for (WebElement element : ANNOTATION_GROUP_HOLDER) {
            if (element.getAttribute("style").contains("transform")) {
                List<WebElement> grouping = element.findElements(By.tagName("a"));
                if (grouping.size() <= 1) {
                    if (annotationType.equalsIgnoreCase("Highlight")) {
                        Assert.assertEquals(grouping.get(0).getAttribute("data-type"), "highlight");
                    } else if (annotationType.equalsIgnoreCase("Information")) {
                        Assert.assertEquals(grouping.get(0).getAttribute("data-type"), "information");
                    } else if (annotationType.equalsIgnoreCase("Imperfection")) {
                        Assert.assertEquals(grouping.get(0).getAttribute("data-type"), "imperfection");
                    }
                } else {
                    boolean annotationVisible = false;
                    for (WebElement element2 : grouping) {
                        if (element2.getAttribute("data-type").equalsIgnoreCase(annotationType)) {
                            annotationVisible = true;
                            break;
                        }
                    }
                    if (!annotationVisible)
                        throw new Exception(annotationType + " is not visible in the widget");
                }
            }
        }
    }


    public String getAnnotationText(String annotationType) {
        if (annotationType.equalsIgnoreCase("Highlight") || annotationType.equalsIgnoreCase("New Highlight")) {
            return EXISTING_HIGHLIGHT_ICON_TEXT.getText();
        } else if (annotationType.equalsIgnoreCase("Imperfection")) {
            // return
        } else if (annotationType.equalsIgnoreCase("Information")) {
            // return
        }
        return null;
    }

    public void waitForCatalogOptionsToLoad(List<WebElement> element) {
        for (int i = 0; i < 10; i++) {
            if (element.size() > 0) {
                break;
            }
            wait(1000);
        }
    }

    public boolean verifyAnnotationInAnnotationList(String checkpoint, String detail, String damagetype) {
        boolean flag = false;
        waitForElementToBePresent(ANNOTATION_LIST_BUTTON);
        waitForElementTobeClickable(ANNOTATION_LIST_BUTTON);
        try {
            clickAndWait(ANNOTATION_LIST_BUTTON, ANNOTATIONLIST_SECTION);
        } catch (ElementNotInteractableException e) {
            wait(2000);

        }



    }


}
*/