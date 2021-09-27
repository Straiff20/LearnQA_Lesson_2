package Lib.ui;

import io.appium.java_client.AppiumDriver;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;


public class ArticlePageObject extends MainPageObject {

    public static final String
            ARTICLE_FIRST_ELEMENT = "//*[contains(@text, '{SUBSTRING}')]",
            ARTICLE_MENU_BOOKMARK = "org.wikipedia:id/article_menu_bookmark",
            ARTICLE_ADD_TO_LIST = "//*[contains(@text, 'ADD TO LIST')]",
            NEW_GROUP_INPUT = "org.wikipedia:id/text_input",
            ADD_GROUP_NAME_OK_BUTTON = "android:id/button1",
            CREATE_NEW_GROUP_SUCCESS_POP_UP = "org.wikipedia:id/snackbar_text",
            ARTICLE_NAME = "//*[contains(@text, '{SUBSTRING}')]",
            ADD_TO_CREATE_GROUP = "org.wikipedia:id/snackbar_action",
            NAME_GROUP_WITH_ARTICLES = "//*[contains(@text, 'Test')]",
            ANDROID_NAVIGATE_BUTTON_UP = "//*[contains(@class, 'android.widget.ImageButton')]",
            TO_SAVED_ARTICLES = "//*[contains(@content-desc, 'Saved')]",
            MY_SAVED_GROUP = "//*[contains(@text, 'Test')]",
            SAVED_ARTICLES_LIST = "//androidx.recyclerview.widget.RecyclerView/*",
            ARTICLE_FOR_SWIPE = "//androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[3]",
            ELEMENT_UNDO = "//*[contains(@text, 'UNDO')]";

    public ArticlePageObject(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    /* TEMPLATES METHODS*/
    private static String getArticleName(String articleName) {
        return ARTICLE_NAME.replace("{SUBSTRING}", articleName);
    }

    private static String getArticleFirstElement(String articleElement) {
        return ARTICLE_FIRST_ELEMENT.replace("{SUBSTRING}", articleElement);
    }
    /* TEMPLATES METHODS*/

    public void openArticle(String searchInput) {
        String articleName = getArticleName(searchInput);
        this.waitElementAndTap(By.xpath(articleName), "Cannot find article name in search result");

        String inArticleFirstElement = getArticleFirstElement(searchInput);
        this.waitElementPresent(By.xpath(inArticleFirstElement), "Cannot find article element" + searchInput);
    }

    public void createGroupAndAddArticle(String articleElement) {
        this.openArticle(articleElement);
        this.waitElementAndTap(By.id(ARTICLE_MENU_BOOKMARK), "Cannot find menu bookmark");
        this.waitElementAndTap(By.xpath(ARTICLE_ADD_TO_LIST), "Cannot find add to list button");
        this.waitElementAndSendKeys(By.id(NEW_GROUP_INPUT), "Test", "Cannot find and send keys to input for new group");
        this.waitElementAndTap(By.id(ADD_GROUP_NAME_OK_BUTTON), "Cannot find jk button");
        this.waitElementPresent(By.id(CREATE_NEW_GROUP_SUCCESS_POP_UP), "Cannot find success pop up");
        appiumDriver.navigate().back();
    }

    public void tapToArticleAndSaveToGroup(String articleElement) {
        this.openArticle(articleElement);
        this.waitElementAndTap(By.id(ARTICLE_MENU_BOOKMARK), "Cannot find menu bookmark");
        this.waitElementAndTap(By.id(ADD_TO_CREATE_GROUP), "Cannot find and tap to add read list");
        this.waitElementAndTap(By.xpath(NAME_GROUP_WITH_ARTICLES), "Cannot find create group");
        this.waitElementPresent(By.id(CREATE_NEW_GROUP_SUCCESS_POP_UP), "Cannot find success pop up");
        appiumDriver.navigate().back();
        appiumDriver.hideKeyboard();
        this.waitElementAndTap(By.xpath(ANDROID_NAVIGATE_BUTTON_UP), "Cannot find and tap to android navigate button up");

    }

    public void openSavedArticles() {
        this.waitElementAndTap(By.xpath(TO_SAVED_ARTICLES), "Cannot find and tap navigate to saved groups");
        this.waitElementAndTap(By.xpath(MY_SAVED_GROUP), "Cannot find and tap to my create group" + MY_SAVED_GROUP);
    }

    public void deleteSavedArticleAndCheckSuccess() {
        int quantityArticle_Before_Swipe = this.getAmountsOfElements(By.xpath(SAVED_ARTICLES_LIST));
        this.swipeToLeft(By.xpath(ARTICLE_FOR_SWIPE), "Cannot find and swipe article");
        this.waitElementAndTap(By.xpath(ELEMENT_UNDO), "Cannot find and tap to UNDO");
        int quantityArticle_After_Swipe = this.getAmountsOfElements(By.xpath(SAVED_ARTICLES_LIST));
        Assertions.assertEquals(quantityArticle_After_Swipe, quantityArticle_Before_Swipe - 1, "Not right quantity Articles");
    }

    public void getTitleOfArticle() {
        Assertions.assertNotNull(this.getAndCheckTitleOfArticle());
    }
}
