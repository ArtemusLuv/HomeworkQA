import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

public class TestMTS {
    private WebDriver driver;
    private String number = "297777777";
    private String sum = "450";
    private String mail = "walterwhite3@gmail.com";

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.mts.by/");
    }


    @Test
    @Order(1)
    public void firstTest() {
        Assertions.assertEquals("Онлайн пополнение\nбез комиссии",
                driver.findElement(By.xpath("//section/div/h2")).getText());
    }

    @Test
    @Order(2)
    public void secondTest() {
        Assertions.assertEquals(false,
                driver.findElements(By.xpath("//section/div/div/ul/li")).isEmpty());
    }

    @Test
    @Order(3)
    public void thirdTest() {
        driver.findElement(By.xpath("//section/div/a")).click();
        Assertions.assertEquals("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/",
                driver.getCurrentUrl());
    }

    @Test
    @Order(4)
    public void thoughTest() {
        WebElement numbersField = driver.findElement(By.id("connection-phone"));
        WebElement sumField = driver.findElement(By.id("connection-sum"));
        WebElement mailField = driver.findElement(By.id("connection-email"));

        numbersField.click();
        numbersField.sendKeys(number);
        sumField.click();
        sumField.sendKeys(sum);
        mailField.click();
        mailField.sendKeys(mail);

        driver.findElement(By.xpath("//form[@id=\"pay-connection\"]/button")).click();
    }

    @AfterEach
    public void tearDown() {
        driver.close();
        driver.quit();
    }

}
