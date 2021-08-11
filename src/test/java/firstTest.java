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

    private static final String ERROR_MESSAGE_SEARCH_WIKIPEDIA = "Cannot find text \"Search Wikipedia\"" + "\n";
    private static final String ERROR_MESSAGE_NOT_FIND_INPUT = "Cannot find input" + "\n";
    private static final String ERROR_MESSAGE_NOT_FIND_ARTICLES = "Cannot find articles" + "\n";
    private static final String ERROR_MESSAGE_NOT_FIND_SEARCH_IMAGE = "Cannot find Search Image" + "\n";

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
        waitElement(By.xpath("//*[contains(@text,'Search Wikipedia')]"), ERROR_MESSAGE_SEARCH_WIKIPEDIA, 5);
    }

    @Test
    void searchWordCheckAndClear() {
        onboardingSkip();
        waitElementAndTap(By.xpath("//*[contains(@text,'Search Wikipedia')]"), ERROR_MESSAGE_SEARCH_WIKIPEDIA);
        WebElement element = waitElementAndSendKeys(By.id("org.wikipedia:id/search_src_text"), "Appium", ERROR_MESSAGE_NOT_FIND_INPUT);
        waitElement(By.xpath("//*[contains(@class, 'android.view.ViewGroup')]"), ERROR_MESSAGE_NOT_FIND_ARTICLES);
        element.clear();
        waitElement(By.id("org.wikipedia:id/search_empty_image"), ERROR_MESSAGE_NOT_FIND_SEARCH_IMAGE);

    }

    // Метод для пропуска онбординга при запуске мобильного приложения
    private void onboardingSkip() {
        ad.findElement(By.id("org.wikipedia:id/primaryTextView")).isDisplayed();
        TouchAction touchAction = new TouchAction(ad);
        touchAction.tap(PointOption.point(108, 1715)).perform();
    }

    private static WebElement waitElement(By by, String errorMessage, long timeInSecond) {
        WebDriverWait wait = new WebDriverWait(ad, timeInSecond);
        wait.withMessage(errorMessage + "\n");
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));

    }

    private static WebElement waitElement(By by, String errorMessage) {
        return waitElement(by, errorMessage, 5);
    }

    private static WebElement waitElementAndTap(By by, String errorMessage) {
        WebElement element = waitElement(by, errorMessage, 5);
        element.click();
        return element;
    }

    private static WebElement waitElementAndSendKeys(By by, String sendKeys, String errorMessage) {
        WebElement element = waitElement(by, errorMessage, 5);
        element.sendKeys(sendKeys);
        return element;
    }
}