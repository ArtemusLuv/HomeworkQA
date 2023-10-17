package org.astonqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import java.util.HashMap;

public class MainPage extends BasePage {
    private Actions builder;
    public MainPage (WebDriver driver) {
        super(driver);
        builder = new Actions(driver);
    }
//    private By productsLocator = By.cssSelector(".product-card .product-card__link");
    private By productPrice = By.cssSelector(".product-card .price__wrap ins");
    private By productName = By.cssSelector(".product-card.product-card--hoverable .product-card__brand-wrap");
    private By buttonsProductLocator = By.cssSelector(".product-card .product-card__add-basket");
    private By productSelectionTabSize = By.xpath("//ul[@class=\"sizes-list j-quick-order-sizes\"]/li[1]");
    private By productCardSize = By.cssSelector(".product-card .product-card__sizes");
    private String name;
    private String price;
    private String count;
    public HashMap <String, String[]> productsMap = new HashMap<>();

    public MainPage choseProduct (Integer index) throws InterruptedException {
        builder.scrollByAmount(0, 1000).build().perform();
        Thread.sleep(2000);
        name = driver.findElements(productName).get(index).getAttribute("outerText");
        price = driver.findElements(productPrice).get(index).getAttribute("outerText");
        count = "1";
        Thread.sleep(1000);
        productsMap.put(index.toString(), new String[]{name, price, count});
        return this;
    }

    public MainPage putProductInBasket (int index) throws InterruptedException {
        Thread.sleep(2000);
        driver.findElements(buttonsProductLocator).get(index).click();
        Thread.sleep(2000);
        if (driver.findElements(productCardSize).get(index).isDisplayed()) {
            Thread.sleep(2000);
            driver.findElement(productSelectionTabSize).click();
        }
        return this;
    }

//    public int getCount() {
//        return count;
//    }

//    public String getName() {
//        return name;
//    }

//    public String getPrice() {
//        return price;
//    }
}
