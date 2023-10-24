import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMain {
    static AndroidDriver <AndroidElement> driver = null;

//    protected By number_1 = By.id("com.google.android.calculator:id/digit_1");
//    protected By number_2 = By.id("com.google.android.calculator:id/digit_2");
//    protected By number_3 = By.id("com.google.android.calculator:id/digit_3");
//    protected By number_4 = By.id("com.google.android.calculator:id/digit_4");
//    protected By number_5 = By.id("com.google.android.calculator:id/digit_5");
//    protected By number_6 = By.id("com.google.android.calculator:id/digit_6");
//    protected By number_7 = By.id("com.google.android.calculator:id/digit_7");
//    protected By number_8 = By.id("com.google.android.calculator:id/digit_8");
//    protected By number_9 = By.id("com.google.android.calculator:id/digit_9");
//    protected By number_0 = By.id("com.google.android.calculator:id/digit_0");
//    protected By plus = By.id("com.google.android.calculator:id/op_add");
//    protected By equals = By.id("com.google.android.calculator:id/eq");
//    protected By window = By.id("com.google.android.calculator:id/result_final");

    @BeforeAll
    public static void initialize () {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Nothing phone(1)");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.google.android.calculator");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.android.calculator2.Calculator");
        capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        try {
            driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void plusTest () {
        driver.findElement(ButtonLocator.number_1).click();
        driver.findElement(ButtonLocator.plus).click();
        driver.findElement(ButtonLocator.number_2).click();
        driver.findElement(ButtonLocator.equals).click();

        // 1 + 2 = 3
        assertEquals("3", driver.findElement(ButtonLocator.window_result).getText());
    }

    @Test
    public void minusTest () {
        driver.findElement(ButtonLocator.number_1).click();
        driver.findElement(ButtonLocator.number_0).click();
        driver.findElement(ButtonLocator.minus).click();
        driver.findElement(ButtonLocator.number_9).click();
        driver.findElement(ButtonLocator.equals).click();

        // 10 - 9 = 1
        assertEquals("1", driver.findElement(ButtonLocator.window_result).getText());
    }

    @Test
    public void multiplyTest () {
        driver.findElement(ButtonLocator.number_9).click();
        driver.findElement(ButtonLocator.multiply).click();
        driver.findElement(ButtonLocator.number_9).click();
        driver.findElement(ButtonLocator.multiply).click();
        driver.findElement(ButtonLocator.number_0).click();
        driver.findElement(ButtonLocator.equals).click();

        // 9 * 9 * 0 = 0
        assertEquals("0", driver.findElement(ButtonLocator.window_result).getText());
    }

    @Test
    public void divideTest () {
        driver.findElement(ButtonLocator.number_5).click();
        driver.findElement(ButtonLocator.number_0).click();
        driver.findElement(ButtonLocator.divide).click();
        driver.findElement(ButtonLocator.number_4).click();
        driver.findElement(ButtonLocator.equals).click();

        // 50 / 4 = 12.5
        assertEquals("12.5", driver.findElement(ButtonLocator.window_result).getText());
    }

    @AfterAll
    public static void tearDown () {
        driver.quit();
    }
}
