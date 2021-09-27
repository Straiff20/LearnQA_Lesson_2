package Lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class OnboardingPageObject extends MainPageObject {

    public OnboardingPageObject(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    private static final String
            BUTTON_NEXT = "//XCUIElementTypeStaticText[@name='Next']",
            ONBOARDING_TEXT_FIRST_PAGE = "The free encyclopedia",
            ONBOARDING_TEXT_SECOND_PAGE = "New ways to explore",
            ONBOARDING_TEXT_THIRD_PAGE = "Search in over 300 languages",
            ONBOARDING_TEXT_FOURTH_PAGE = "Help make the app better",
            BUTTON_GET_STARTED = "//XCUIElementTypeButton[@name='Get started']",
            SEARCH_INPUT = "Search Wikipedia";

    public void waitFistOnboardingPage() {
        this.waitElementPresent(By.id(ONBOARDING_TEXT_FIRST_PAGE), "Cannot find text on first page");
    }

    public void tapToNextButton() {
        this.waitElementAndTap(By.xpath(BUTTON_NEXT), "Cannot find and tap to the next button");
    }

    public void tapToGetStartedButton() {
        this.waitElementAndTap(By.xpath(BUTTON_GET_STARTED), "Cannot find and tap to the get started button");
    }

    public void waitSecondOnboardingPage() {
        this.waitElementPresent(By.id(ONBOARDING_TEXT_SECOND_PAGE), "Cannot find text on second page");
    }

    public void waitThirdOnboardingPage() {
        this.waitElementPresent(By.id(ONBOARDING_TEXT_THIRD_PAGE), "Cannot find text on third page");
    }

    public void waitFourthdOnboardingPage() {
        this.waitElementPresent(By.id(ONBOARDING_TEXT_FOURTH_PAGE), "Cannot find text on fourth page");
    }

    public void waitSearchInput() {
        this.waitElementPresent(By.id(SEARCH_INPUT), "Cannot find search input on page");
    }
}