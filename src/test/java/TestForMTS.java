import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class TestForMTS {

    private WebDriver driver;
    private Actions builder;
    private String number = "297777777";
    private String sum = "450";
    private String mail = "walterwhite3@gmail.com";

    @BeforeEach
    public void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.mts.by/");
        Thread.sleep(2000);
    }

    // Task 1

    @ParameterizedTest
    @CsvSource({"connection-phone, Номер телефона", "connection-sum, Сумма", "connection-email, E-mail для отправки чека"})
    public void firstTestForConnection(String id, String attribute) {
        driver.findElement(By.xpath("//div[@class = \"select__wrapper\"]/button")).click();
        driver.findElement(By.xpath("//ul[@class = \"select__list\"]/li[1]/p")).click();
        Assertions.assertEquals(driver.findElement(By.id(id)).getAttribute("placeholder"), attribute);
    }

    @ParameterizedTest
    @CsvSource({"internet-phone, Номер абонента","internet-sum, Сумма", "internet-email, E-mail для отправки чека"})
    public void firstTestForInternet(String id, String attribute) {
        driver.findElement(By.xpath("//div[@class = \"select__wrapper\"]/button")).click();
        driver.findElement(By.xpath("//ul[@class = \"select__list\"]/li[2]/p")).click();
        Assertions.assertEquals(driver.findElement(By.id(id)).getAttribute("placeholder"), attribute);
    }

    @ParameterizedTest
    @CsvSource({"score-instalment, Номер счета на 44","instalment-sum, Сумма", "instalment-email, E-mail для отправки чека"})
    public void firstTestForInstalment(String id, String attribute) {
        driver.findElement(By.xpath("//div[@class = \"select__wrapper\"]/button")).click();
        driver.findElement(By.xpath("//ul[@class = \"select__list\"]/li[3]/p")).click();
        Assertions.assertEquals(driver.findElement(By.id(id)).getAttribute("placeholder"), attribute);
    }

    @ParameterizedTest
    @CsvSource({"score-arrears, Номер счета на 2073","arrears-sum, Сумма", "arrears-email, E-mail для отправки чека"})
    public void firstTestForDebt(String id, String attribute) {
        driver.findElement(By.xpath("//div[@class = \"select__wrapper\"]/button")).click();
        driver.findElement(By.xpath("//ul[@class = \"select__list\"]/li[4]/p")).click();
        Assertions.assertEquals(driver.findElement(By.id(id)).getAttribute("placeholder"), attribute);
    }

    // Task 2
    @Test
    public void secondTest() throws InterruptedException {
        builder = new Actions(driver);
        driver.findElement(By.xpath("//div[@class = \"select__wrapper\"]/button")).click();
        driver.findElement(By.xpath("//ul[@class = \"select__list\"]/li[1]/p")).click();

        WebElement numbersField = driver.findElement(By.id("connection-phone"));
        WebElement sumField = driver.findElement(By.id("connection-sum"));
        WebElement mailField = driver.findElement(By.id("connection-email"));
        WebElement buttonSend = driver.findElement(By.xpath("//form[@id=\"pay-connection\"]/button"));

        builder.click(mailField).sendKeys(mail)
                .click(sumField).sendKeys(sum)
                .click(numbersField).sendKeys(number)
                .click(buttonSend).build().perform();

        Thread.sleep(5000);

        driver.switchTo().frame(driver.findElement(By.xpath("//div[@class=\"bepaid-app__container\"]/iframe")));

        // Check Sum and Numbers in label and button
        Assertions.assertTrue(driver.findElement(By.xpath("//header/div/div/p[1]"))
                .getAttribute("textContent").contains(sum));
        Assertions.assertTrue(driver.findElement(By.xpath("//header/div/div/p[2]"))
                .getAttribute("textContent").contains("375" + number));
        Assertions.assertTrue(driver.findElement(By.xpath("//app-card-page/div/div/button"))
                .getAttribute("textContent").contains(sum));

        // Check card field
        Assertions.assertEquals(driver.findElement(By.xpath("//div[@class=\"content ng-tns-c46-1\"]/label"))
                .getAttribute("textContent"), "Номер карты");
        Assertions.assertEquals(driver.findElement(By.xpath("//div[@class=\"content ng-tns-c46-4\"]/label"))
                .getAttribute("textContent"), "Срок действия");
        Assertions.assertEquals(driver.findElement(By.xpath("//div[@class=\"content ng-tns-c46-5\"]/label"))
                .getAttribute("textContent"), "CVC");
        Assertions.assertEquals(driver.findElement(By.xpath("//div[@class=\"content ng-tns-c46-3\"]/label"))
                .getAttribute("textContent"), "Имя держателя (как на карте)");

        // Check payment image
        Assertions.assertEquals(driver.findElement(By.xpath("//div[@class=\"cards-brands cards-brands__container" +
                        " ng-tns-c52-0 ng-trigger ng-trigger-brandsState ng-star-inserted\"]/img[1]"))
                .isDisplayed(), true);
        Assertions.assertEquals(driver.findElement(By.xpath("//div[@class=\"cards-brands cards-brands__container" +
                        " ng-tns-c52-0 ng-trigger ng-trigger-brandsState ng-star-inserted\"]/img[2]"))
                .isDisplayed(), true);
        Assertions.assertEquals(driver.findElement(By.xpath("//div[@class=\"cards-brands cards-brands__container" +
                        " ng-tns-c52-0 ng-trigger ng-trigger-brandsState ng-star-inserted\"]/img[3]"))
                .isDisplayed(), true);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

}
