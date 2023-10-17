import org.astonqa.BasePage;
import org.astonqa.BasketPage;
import org.astonqa.InitDriver;
import org.astonqa.MainPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class WBTest {
    protected WebDriver driver = InitDriver.createDriver();
    protected BasePage basePage = new BasePage(driver);
    protected MainPage mainPage = new MainPage(driver);
    protected BasketPage basketPage = new BasketPage(driver);

    @Test
    public void testing () throws InterruptedException {
        basePage.open(Config.MAIN_WB_URL);
        Thread.sleep(2000);

        mainPage.choseProduct(0).putProductInBasket(0)
                .choseProduct(1).putProductInBasket(1)
                .choseProduct(2).putProductInBasket(2);
        Thread.sleep(2000);

        basePage.open(Config.BASKET_WB_URL);
        Thread.sleep(2000);
        testFirstProduct();
        testSecondProduct();
        testThirdProduct();
        driver.quit();
    }

    public void testFirstProduct () throws InterruptedException {
        Thread.sleep(1000);
//        System.out.println(mainPage.productsMap.get("2")[0]);
//        System.out.println(basketPage.getName(0));
        Assertions.assertTrue(mainPage.productsMap.get("2")[0].contains(basketPage.getName(0)));
        Assertions.assertEquals(basketPage.getPrice(0), mainPage.productsMap.get("2")[1]);
        Assertions.assertEquals(basketPage.getCount(0), mainPage.productsMap.get("2")[2]);
    }

    public void testSecondProduct () throws InterruptedException {
        Thread.sleep(1000);
//        System.out.println(mainPage.productsMap.get("1")[0]);
//        System.out.println(basketPage.getName(1));
        Assertions.assertTrue(mainPage.productsMap.get("1")[0].contains(basketPage.getName(1)));
        Assertions.assertEquals(basketPage.getPrice(1), mainPage.productsMap.get("1")[1]);
        Assertions.assertEquals(basketPage.getCount(1), mainPage.productsMap.get("1")[2]);
    }

    public void testThirdProduct () throws InterruptedException {
        Thread.sleep(1000);
//        System.out.println(mainPage.productsMap.get("0")[0]);
//        System.out.println(basketPage.getName(2));
        Assertions.assertTrue(mainPage.productsMap.get("0")[0].contains(basketPage.getName(2)));
        Assertions.assertEquals(basketPage.getPrice(2), mainPage.productsMap.get("0")[1]);
        Assertions.assertEquals(basketPage.getCount(2), mainPage.productsMap.get("0")[2]);
    }

}
