package Lib.ui;

import io.appium.java_client.AppiumDriver;

public class OnboardingPageObject extends MainPageObject {

    public OnboardingPageObject(AppiumDriver driver) {
        super(driver);
    }

    private static final String
            BUTTON_NEXT = "xpath://XCUIElementTypeStaticText[@name='Next']",
            ONBOARDING_TEXT_FIRST_PAGE = "id:The free encyclopedia",
            ONBOARDING_TEXT_SECOND_PAGE = "id:New ways to explore",
            ONBOARDING_TEXT_THIRD_PAGE = "id:Search in over 300 languages",
            ONBOARDING_TEXT_FOURTH_PAGE = "id:Help make the app better",
            BUTTON_GET_STARTED = "xpath://XCUIElementTypeButton[@name='Get started']",
            SEARCH_INPUT = "id:Search Wikipedia";

    public void waitFistOnboardingPage() {
        this.waitElementPresent(ONBOARDING_TEXT_FIRST_PAGE, "Cannot find text on first page");
    }

    public void tapToNextButton() {
        this.waitElementAndTap(BUTTON_NEXT, "Cannot find and tap to the next button");
    }

    public void tapToGetStartedButton() {
        this.waitElementAndTap(BUTTON_GET_STARTED, "Cannot find and tap to the get started button");
    }

    public void waitSecondOnboardingPage() {
        this.waitElementPresent(ONBOARDING_TEXT_SECOND_PAGE, "Cannot find text on second page");
    }

    public void waitThirdOnboardingPage() {
        this.waitElementPresent(ONBOARDING_TEXT_THIRD_PAGE, "Cannot find text on third page");
    }

    public void waitFourthdOnboardingPage() {
        this.waitElementPresent(ONBOARDING_TEXT_FOURTH_PAGE, "Cannot find text on fourth page");
    }

    public void waitSearchInput() {
        this.waitElementPresent(SEARCH_INPUT, "Cannot find search input on page");
    }
}