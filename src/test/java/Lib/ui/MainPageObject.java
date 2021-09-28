package Lib.ui;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class MainPageObject {

    protected AppiumDriver appiumDriver;

    public MainPageObject(AppiumDriver appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public String getAndCheckTitleOfArticle() {
        appiumDriver.getContextHandles();
        appiumDriver.context("WEBVIEW");
        return appiumDriver.getTitle();
    }

//    public void onboardingSkip(String locator) {
//        waitElementAndTap(locator,"SkipButton not found");
//    }

    public void touchDisplay() {
        TouchAction touchAction = new TouchAction(appiumDriver);
        touchAction.tap(PointOption.point(570, 1));
    }

    public WebElement waitElementPresent(String locator, String errorMessage, long timeInSecond) {
        By by = this.getLocatorByString(locator );
        WebDriverWait wait = new WebDriverWait(appiumDriver, timeInSecond);
        wait.withMessage(errorMessage + "\n");
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public boolean waitElementNotPresent(String locator, String errorMessage, long timeInSecond) {
        By by = this.getLocatorByString(locator );
        WebDriverWait wait = new WebDriverWait(appiumDriver, timeInSecond);
        wait.withMessage(errorMessage + "\n");
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    public WebElement waitElementPresent(String locator, String errorMessage) {
        return waitElementPresent(locator, errorMessage, 10);
    }

    public boolean waitElementNotPresent(String locator, String errorMessage) {
        return waitElementNotPresent(locator, errorMessage, 10);
    }

    public WebElement waitElementAndTap(String locator, String errorMessage) {
        WebElement element = waitElementPresent(locator, errorMessage, 10);
        element.click();
        return element;
    }

    public WebElement waitElementAndClear(String locator, String errorMessage) {
        WebElement element = waitElementPresent(locator, errorMessage, 10);
        element.clear();
        return element;
    }

    public WebElement waitElementAndSendKeys(String locator, String sendKeys, String errorMessage) {
        WebElement element = waitElementPresent(locator, errorMessage, 10);
        element.sendKeys(sendKeys);
        return element;
    }

    public void swipeUp(int timeOfSwipe) {
        TouchAction action = new TouchAction(appiumDriver);
        Dimension size = appiumDriver.manage().window().getSize();
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

    public void swipeUpQuick() {
        swipeUp(200);
    }

    public void swipeToElement(String locator, String errorMessage, int maxSwipes) {
        By by = this.getLocatorByString(locator );
        int alreadySwiped = 0;
        while (appiumDriver.findElements(by).size() == 0) {
            if (alreadySwiped > maxSwipes) {
                waitElementPresent(locator, "Cannot swipe page to element", 0);
                return;
            }
            swipeUpQuick();
            ++alreadySwiped;
        }
    }

    public void swipeToLeft(String locator, String errorMessage) {
        WebElement element = waitElementPresent(locator, errorMessage, 10);

        int left_x = element.getLocation().getX();
        int right_x = left_x + element.getSize().getWidth();
        int upper_y = element.getLocation().getY();
        int lower_y = upper_y + element.getSize().getHeight();
        int middle_y = (upper_y + lower_y) / 2;

        TouchAction action = new TouchAction(appiumDriver);
        Dimension size = appiumDriver.manage().window().getSize();
        action
                .press(PointOption.point(right_x - 1, middle_y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(250)))
                .moveTo(PointOption.point(left_x + 1, middle_y))
                .release()
                .perform();
    }

    public int getAmountsOfElements(String locator) {
        By by = this.getLocatorByString(locator );
        List elements = appiumDriver.findElements(by);
        return elements.size();
    }

    public String waitForElementAndGetAttribute(String locator, String attribute, String errorMessage, long timeOutInSeconds) {
        WebElement element = waitElementPresent(locator, errorMessage, timeOutInSeconds);
        return element.getAttribute(attribute);
    }

    private By getLocatorByString(String locatorWithType) {
        String[] explodedLocator = locatorWithType.split(":", 2);
        String byType = explodedLocator[0];
        String locator = explodedLocator[1];

        if (byType.equals("xpath")) {
            return By.xpath(locator);
        } else if (byType.equals("id")) {
            return By.id(locator);
        } else {
            throw new IllegalArgumentException("Cannot get type or locator. Locator " + locatorWithType);
        }
    }
}
