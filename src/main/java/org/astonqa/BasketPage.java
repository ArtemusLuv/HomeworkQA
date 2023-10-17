package org.astonqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class BasketPage extends BasePage {
    private Actions builder;
    public BasketPage(WebDriver driver) {
        super(driver);
    }

    private By productNames = By.cssSelector(".good-info__good-name");
    private By productPrices = By.cssSelector(".basket-page .list-item__price-new");
    private By productCounts = By.cssSelector(".basket-page .count__numeric");

    public String getName (int index) {
        return driver.findElements(productNames).get(index).getText();
    }

    public String getPrice (int index) {
        return driver.findElements(productPrices).get(index).getAttribute("outerText");
    }

    public String getCount (int index) {
        return driver.findElements(productCounts).get(index).getAttribute("value");
    }

}
