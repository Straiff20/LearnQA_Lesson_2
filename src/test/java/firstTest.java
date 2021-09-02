import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class firstTest {

    private static AndroidDriver ad;

    private static final String ERROR_MESSAGE_NOT_FIND_ELEMENT = "Cannot find Element" + "\n";

    @BeforeEach
    void setUp() throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();

        dc.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        dc.setCapability("platformName", "Android");
        dc.setCapability("appPackage", "org.wikipedia");
        dc.setCapability("appActivity", ".main.MainActivity");
        dc.setCapability("app", "C:\\Users\\pliyev.ilya\\IdeaProjects\\JavaAppiumAutomation\\apks\\org.wikipedia.apk");

        ad = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), dc);
    }

    @AfterEach
    void tearDown() {
        ad.quit();
    }

    @Test
    void searchTextTest() {
        onboardingSkip();
        String xpathToSearchWikipedia = "//*[contains(@text,'Search Wikipedia')]";
        waitElement(By.xpath(xpathToSearchWikipedia), ERROR_MESSAGE_NOT_FIND_ELEMENT + xpathToSearchWikipedia);
    }

    @Test
    void searchWordCheckAndClearTest() {
        onboardingSkip();

        String xpathToSearchWikipedia = "//*[contains(@text,'Search Wikipedia')]";
        waitElementAndTap(By.xpath(xpathToSearchWikipedia), ERROR_MESSAGE_NOT_FIND_ELEMENT + xpathToSearchWikipedia);

        String xpathToSearchInput = "org.wikipedia:id/search_src_text";
        WebElement element = waitElementAndSendKeys(By.id(xpathToSearchInput), "Appium", ERROR_MESSAGE_NOT_FIND_ELEMENT + xpathToSearchInput);

        String xpathToGroupElement = "//*[contains(@class, 'android.view.ViewGroup')]";
        waitElement(By.xpath(xpathToGroupElement), ERROR_MESSAGE_NOT_FIND_ELEMENT + xpathToGroupElement);

        element.clear();

        String xpathToImageEmptySearch = "org.wikipedia:id/search_empty_image";
        waitElement(By.id(xpathToImageEmptySearch), ERROR_MESSAGE_NOT_FIND_ELEMENT + xpathToImageEmptySearch);
    }

    @Test
    void searchWordAndCheckAnswerTest() {
        onboardingSkip();

        String xpathToSearchWikipedia = "//*[contains(@text,'Search Wikipedia')]";
        waitElementAndTap(By.xpath(xpathToSearchWikipedia), ERROR_MESSAGE_NOT_FIND_ELEMENT + xpathToSearchWikipedia);

        String xpathToSearchInput = "org.wikipedia:id/search_src_text";
        WebElement element = waitElementAndSendKeys(By.id(xpathToSearchInput), "Java", ERROR_MESSAGE_NOT_FIND_ELEMENT + xpathToSearchInput);

        String xpathToArticle_1 = "//*[contains(@text,'Java')]";
        waitElement(By.xpath(xpathToArticle_1), ERROR_MESSAGE_NOT_FIND_ELEMENT + xpathToArticle_1);

        String xpathToArticle_2 = "//*[contains(@text,'JavaScript')]";
        waitElement(By.xpath(xpathToArticle_2), ERROR_MESSAGE_NOT_FIND_ELEMENT + xpathToArticle_2);

        String xpathToArticle_3 = "//*[contains(@text,'Java (programming language)')]";
        waitElement(By.xpath(xpathToArticle_3), ERROR_MESSAGE_NOT_FIND_ELEMENT + xpathToArticle_3);

        String xpathToArticle_4 = "//*[contains(@text,'Java version history')]";
        waitElement(By.xpath(xpathToArticle_4), ERROR_MESSAGE_NOT_FIND_ELEMENT + xpathToArticle_4);

        element.clear();

        String xpathToImageEmptySearch = "org.wikipedia:id/search_empty_image";
        waitElement(By.id(xpathToImageEmptySearch), ERROR_MESSAGE_NOT_FIND_ELEMENT + xpathToImageEmptySearch);

    }

    @Test
    void saveTwoArticlesTest() {
        onboardingSkip();

        String xpathToSearchWikipedia = "//*[contains(@text,'Search Wikipedia')]";
        waitElementAndTap(By.xpath(xpathToSearchWikipedia), ERROR_MESSAGE_NOT_FIND_ELEMENT + xpathToSearchWikipedia);

        String xpathToSearchInput = "org.wikipedia:id/search_src_text";
        waitElementAndSendKeys(By.id(xpathToSearchInput), "Java", ERROR_MESSAGE_NOT_FIND_ELEMENT + xpathToSearchInput);

        String xpathToFirstArticle = "//*[contains(@text, 'Java (programming language)')]";
        waitElementAndTap(By.xpath(xpathToFirstArticle), ERROR_MESSAGE_NOT_FIND_ELEMENT + xpathToFirstArticle);

        String xpathToFirstArticleElement = "//*[contains(@text, '\"Java language\" redirects here. It is not to be confused with')]";
        waitElement(By.xpath(xpathToFirstArticleElement), ERROR_MESSAGE_NOT_FIND_ELEMENT + xpathToFirstArticleElement);

        String xpathToMenuBookmark = "org.wikipedia:id/article_menu_bookmark";
        waitElementAndTap(By.id(xpathToMenuBookmark), ERROR_MESSAGE_NOT_FIND_ELEMENT + xpathToMenuBookmark);

        String xpathToAddToList = "//*[contains(@text, 'ADD TO LIST')]";
        waitElementAndTap(By.xpath(xpathToAddToList), ERROR_MESSAGE_NOT_FIND_ELEMENT + xpathToAddToList);

        String xpathToNameGroupInput = "org.wikipedia:id/text_input";
        waitElementAndSendKeys(By.id(xpathToNameGroupInput), "Test", ERROR_MESSAGE_NOT_FIND_ELEMENT + xpathToNameGroupInput);

        String xpathToOkButton = "android:id/button1";
        waitElementAndTap(By.id(xpathToOkButton), ERROR_MESSAGE_NOT_FIND_ELEMENT + xpathToOkButton);

        String xpathToSnackbarText = "org.wikipedia:id/snackbar_text";
        waitElement(By.id(xpathToSnackbarText), ERROR_MESSAGE_NOT_FIND_ELEMENT + xpathToSnackbarText);

        String xpathToNavigateButtonUp = "//android.widget.ImageButton[@content-desc=\"Navigate up\"]";
        waitElementAndTap(By.xpath(xpathToNavigateButtonUp), ERROR_MESSAGE_NOT_FIND_ELEMENT + xpathToNavigateButtonUp);

        ad.hideKeyboard();

        String xpathToSecondArticle = "//*[contains(@text, 'JavaScript')]";
        waitElementAndTap(By.xpath(xpathToSecondArticle), ERROR_MESSAGE_NOT_FIND_ELEMENT + xpathToSecondArticle);

        String xpathToSecondArticleElement = "//*[contains(@text, 'Not to be confused with')]";
        waitElement(By.xpath(xpathToSecondArticleElement), ERROR_MESSAGE_NOT_FIND_ELEMENT + xpathToSecondArticleElement);

        waitElementAndTap(By.id(xpathToMenuBookmark), ERROR_MESSAGE_NOT_FIND_ELEMENT + xpathToMenuBookmark);

        String xpathToSnackbarAction = "org.wikipedia:id/snackbar_action";
        waitElementAndTap(By.id(xpathToSnackbarAction), ERROR_MESSAGE_NOT_FIND_ELEMENT + xpathToSnackbarAction);

        String xpathToSelectGroup = "//*[contains(@text, 'Test')]";
        waitElementAndTap(By.xpath(xpathToSelectGroup), ERROR_MESSAGE_NOT_FIND_ELEMENT + xpathToSelectGroup);

        waitElement(By.id(xpathToSnackbarText), ERROR_MESSAGE_NOT_FIND_ELEMENT + xpathToSnackbarText);

        waitElementAndTap(By.xpath(xpathToNavigateButtonUp), ERROR_MESSAGE_NOT_FIND_ELEMENT + xpathToNavigateButtonUp);

        String xpathToAnotherButtonUp = "//*[contains(@class, 'android.widget.ImageButton')]";
        waitElementAndTap(By.xpath(xpathToAnotherButtonUp), ERROR_MESSAGE_NOT_FIND_ELEMENT + xpathToAnotherButtonUp);

        String xpathToSavedArticles = "//*[contains(@content-desc, 'Saved')]";
        waitElementAndTap(By.xpath(xpathToSavedArticles), ERROR_MESSAGE_NOT_FIND_ELEMENT + xpathToSavedArticles);

        String xpathToGroupWithSavedArticles = "//*[contains(@text, 'Test')]";
        waitElementAndTap(By.xpath(xpathToGroupWithSavedArticles), ERROR_MESSAGE_NOT_FIND_ELEMENT + xpathToGroupWithSavedArticles);

        String xpathToSavedArticlesList = "//androidx.recyclerview.widget.RecyclerView/*";
        int quantityArticle_Before_Swipe = getAmountsOfElements(By.xpath(xpathToSavedArticlesList));

        String xpathToElementForSwipe = "//androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[3]";
        swipeToLeft(By.xpath(xpathToElementForSwipe), ERROR_MESSAGE_NOT_FIND_ELEMENT + xpathToElementForSwipe);

        String xpathToUndoButton = "//*[contains(@text, 'UNDO')]";
        waitElementAndTap(By.xpath(xpathToUndoButton), ERROR_MESSAGE_NOT_FIND_ELEMENT + xpathToUndoButton);

        touchDisplay();

        int quantityArticle_After_Swipe = getAmountsOfElements(By.xpath(xpathToSavedArticlesList));

        assertEquals(quantityArticle_After_Swipe, quantityArticle_Before_Swipe - 1, "Not right quantity Articles");
    }

    private void onboardingSkip() {
        ad.findElement(By.id("org.wikipedia:id/primaryTextView")).isDisplayed();
        TouchAction touchAction = new TouchAction(ad);
        touchAction.tap(PointOption.point(108, 1715)).perform();
    }

    private void touchDisplay() {
        TouchAction touchAction = new TouchAction(ad);
        touchAction.tap(PointOption.point(570, 1));
    }

    private static WebElement waitElement(By by, String errorMessage, long timeInSecond) {
        WebDriverWait wait = new WebDriverWait(ad, timeInSecond);
        wait.withMessage(errorMessage + "\n");
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));

    }

    private static WebElement waitElement(By by, String errorMessage) {
        return waitElement(by, errorMessage, 10);
    }

    private static WebElement waitElementAndTap(By by, String errorMessage) {
        WebElement element = waitElement(by, errorMessage, 10);
        element.click();
        return element;
    }

    private static WebElement waitElementAndClear(By by, String errorMessage) {
        WebElement element = waitElement(by, errorMessage, 10);
        element.clear();
        return element;
    }

    private static WebElement waitElementAndSendKeys(By by, String sendKeys, String errorMessage) {
        WebElement element = waitElement(by, errorMessage, 10);
        element.sendKeys(sendKeys);
        return element;
    }

    protected void swipeUp(int timeOfSwipe) {

        TouchAction action = new TouchAction(ad);
        Dimension size = ad.manage().window().getSize();
        int x = size.width / 2;
        int start_y = (int) (size.height * 0.8);
        int end_y = (int) (size.height * 0.2);
        action
                .press(PointOption.point(x, start_y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(timeOfSwipe)))
                .moveTo(PointOption.point(x, end_y))
                .release()
                .perform();
    }

    protected void swipeUpQuick() {
        swipeUp(200);
    }

    protected void swipeToElement(By by, String errorMessage, int maxSwipes) {
        int alreadySwiped = 0;
        while (ad.findElements(by).size() == 0) {
            if (alreadySwiped > maxSwipes) {
                waitElement(by, ERROR_MESSAGE_NOT_FIND_ELEMENT, 0);
                return;
            }
            swipeUpQuick();
            ++alreadySwiped;
        }
    }

    protected void swipeToLeft(By by, String errorMessage) {
        WebElement element = waitElement(by, errorMessage, 10);

        int left_x = element.getLocation().getX();
        int right_x = left_x + element.getSize().getWidth();
        int upper_y = element.getLocation().getY();
        int lower_y = upper_y + element.getSize().getHeight();
        int middle_y = (upper_y + lower_y) / 2;

        TouchAction action = new TouchAction(ad);
        Dimension size = ad.manage().window().getSize();
        action
                .press(PointOption.point(right_x - 1, middle_y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(250)))
                .moveTo(PointOption.point(left_x + 1, middle_y))
                .release()
                .perform();
    }

    private int getAmountsOfElements(By by) {
        List elements = ad.findElements(by);
        return elements.size();
    }


    private String waitForElementAndGetAttribute(By by, String attribute, String errorMessage, long timeOutInSeconds) {
        WebElement element = waitElement(by, errorMessage, timeOutInSeconds);
        return element.getAttribute(attribute);
    }
}