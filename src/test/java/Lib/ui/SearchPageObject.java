package Lib.ui;

import io.appium.java_client.AppiumDriver;

public class SearchPageObject extends MainPageObject {

    public static final String
            SKIP_BUTTON = "id:org.wikipedia:id/fragment_onboarding_skip_button",
            SEARCH_WIKIPEDIA = "xpath://*[contains(@text,'Search Wikipedia')]",
            SEARCH_INPUT_WIKIPEDIA = "id:org.wikipedia:id/search_src_text",
            SEARCH_CLOSE_BUTTON = "id:org.wikipedia:id/search_close_btn",
            SEARCH_RESULT_BY_SUBSTRING_TPL = "xpath://*[@resource-id='org.wikipedia:id/search_results_container']//*[@text='{SUBSTRING}']";

    public SearchPageObject(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }
    /* TEMPLATES METHODS*/

    private static String getResultSearchElement(String substring) {
        return SEARCH_RESULT_BY_SUBSTRING_TPL.replace("{SUBSTRING}", substring);
    }
    /* TEMPLATES METHODS*/

    public void findAndTapSearchInput() {
        this.waitElementAndTap(SKIP_BUTTON, "Cannot find and tap to skip button");
        this.waitElementAndTap(SEARCH_WIKIPEDIA, "Cannot find and tap search input");
    }

    public void sendKeysToSearchInput(String sendKeys) {
        this.waitElementAndSendKeys(SEARCH_INPUT_WIKIPEDIA, sendKeys, "Cannot find and send keys to search input");
    }

    public void waitForSearchResult(String substring) {
        String searchResultXpath = getResultSearchElement(substring);
        this.waitElementPresent(searchResultXpath, "Cannot find search result with substring" + substring);
    }

    public void waitForCloseSearchButtonToAppear() {
        this.waitElementPresent(SEARCH_CLOSE_BUTTON, "Cannot find close button");
    }

    public void waitForCloseSearchButtonToDisappear() {
        this.waitElementNotPresent(SEARCH_CLOSE_BUTTON, "Close button is still present");
    }

    public void tapToCloseSearchInputButton() {
        this.waitElementAndTap(SEARCH_CLOSE_BUTTON, "Cannot find and tap close button");
    }
}