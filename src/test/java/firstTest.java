import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

public class firstTest {

    private static AndroidDriver ad;

    private static final String ERROR_MESSAGE_SEARCH_WIKIPEDIA = "Cannot find text \"Search Wikipedia\"";

    @BeforeAll
    static void setUp() throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();

        dc.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        dc.setCapability("platformName", "Android");
        dc.setCapability("appPackage", "org.wikipedia");
        dc.setCapability("appActivity", ".main.MainActivity");
        dc.setCapability("app", "C:\\Users\\pliyev.ilya\\IdeaProjects\\JavaAppiumAutomation\\apks\\org.wikipedia.apk");

        ad = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), dc);
    }

    @AfterAll
    static void tearDown() {
        ad.quit();
    }

    @Test
    void searchTextTest() throws InterruptedException {
        onboardingSkip();
        assertElementHasTextwaitElement("//*[contains(@text,'Search Wikipedia')]", ERROR_MESSAGE_SEARCH_WIKIPEDIA, 5);
    }

    // Метод для пропуска онбординга при запуске мобильного приложения
    private void onboardingSkip() {
        ad.findElement(By.id("org.wikipedia:id/primaryTextView")).isDisplayed();
        TouchAction touchAction = new TouchAction(ad);
        touchAction.tap(PointOption.point(108, 1715)).perform();
    }

    private static WebElement assertElementHasTextwaitElement(String xpath, String errorMessage, long timeInSecond) {
        WebDriverWait wait = new WebDriverWait(ad, timeInSecond);
        wait.withMessage(errorMessage + "\n");
        By by = By.xpath(xpath);
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }
}