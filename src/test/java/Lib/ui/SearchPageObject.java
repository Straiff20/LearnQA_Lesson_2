package Lib.ui;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class SearchPageObject extends MainPageObject {

    public static final String
            SEARCH_WIKIPEDIA = "//*[contains(@text,'Search Wikipedia')]",
            SEARCH_INPUT_WIKIPEDIA = "org.wikipedia:id/search_src_text",
            SEARCH_CLOSE_BUTTON = "org.wikipedia:id/search_close_btn",
            SEARCH_RESULT_BY_SUBSTRING_TPL = "//*[@resource-id='org.wikipedia:id/search_results_container']//*[@text='{SUBSTRING}']";

    public SearchPageObject(AndroidDriver ad) {
        super(ad);
    }
    /* TEMPLATES METHODS*/

    private static String getResultSearchElement(String substring) {
        return SEARCH_RESULT_BY_SUBSTRING_TPL.replace("{SUBSTRING}", substring);
    }
    /* TEMPLATES METHODS*/

    public void findAndTapSearchInput() {
        this.onboardingSkip();
        this.waitElementAndTap(By.xpath((SEARCH_WIKIPEDIA)), "Cannot find and tap search input");
    }

    public void sendKeysToSearchInput(String sendKeys) {
        this.waitElementAndSendKeys(By.id(SEARCH_INPUT_WIKIPEDIA), sendKeys, "Cannot find and send keys to search input");
    }

    public void waitForSearchResult(String substring) {
        String searchResultXpath = getResultSearchElement(substring);
        this.waitElementPresent(By.xpath(searchResultXpath), "Cannot find search result with substring" + substring);
    }

    public void waitForCloseSearchButtonToAppear() {
        this.waitElementPresent(By.id(SEARCH_CLOSE_BUTTON), "Cannot find close button");
    }

    public void waitForCloseSearchButtonToDisappear() {
        this.waitElementNotPresent(By.id(SEARCH_CLOSE_BUTTON), "Close button is still present");
    }

    public void tapToCloseSearchInputButton() {
        this.waitElementAndTap(By.id(SEARCH_CLOSE_BUTTON), "Cannot find and tap close button");
    }
}
