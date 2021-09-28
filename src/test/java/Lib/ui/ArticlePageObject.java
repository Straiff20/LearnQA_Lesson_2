package Lib.ui;

import io.appium.java_client.AppiumDriver;
import org.junit.jupiter.api.Assertions;


public class ArticlePageObject extends MainPageObject {

    public static final String
            ARTICLE_FIRST_ELEMENT = "xpath://*[contains(@text, '{SUBSTRING}')]",
            ARTICLE_MENU_BOOKMARK = "id:org.wikipedia:id/article_menu_bookmark",
            ARTICLE_ADD_TO_LIST = "xpath://*[contains(@text, 'ADD TO LIST')]",
            NEW_GROUP_INPUT = "id:org.wikipedia:id/text_input",
            ADD_GROUP_NAME_OK_BUTTON = "id:android:id/button1",
            CREATE_NEW_GROUP_SUCCESS_POP_UP = "id:org.wikipedia:id/snackbar_text",
            ARTICLE_NAME = "xpath://*[contains(@text, '{SUBSTRING}')]",
            ADD_TO_CREATE_GROUP = "id:org.wikipedia:id/snackbar_action",
            NAME_GROUP_WITH_ARTICLES = "xpath://*[contains(@text, 'Test')]",
            ANDROID_NAVIGATE_BUTTON_UP = "xpath://*[contains(@class, 'android.widget.ImageButton')]",
            TO_SAVED_ARTICLES = "xpath://*[contains(@content-desc, 'Saved')]",
            MY_SAVED_GROUP = "xpath://*[contains(@text, 'Test')]",
            SAVED_ARTICLES_LIST = "xpath://androidx.recyclerview.widget.RecyclerView/*",
            ARTICLE_FOR_SWIPE = "xpath://androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[3]",
            ELEMENT_UNDO = "xpath://*[contains(@text, 'UNDO')]";

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
        this.waitElementAndTap(articleName, "Cannot find article name in search result");

        String inArticleFirstElement = getArticleFirstElement(searchInput);
        this.waitElementPresent(inArticleFirstElement, "Cannot find article element" + searchInput);
    }

    public void createGroupAndAddArticle(String articleElement) {
        this.openArticle(articleElement);
        this.waitElementAndTap(ARTICLE_MENU_BOOKMARK, "Cannot find menu bookmark");
        this.waitElementAndTap(ARTICLE_ADD_TO_LIST, "Cannot find add to list button");
        this.waitElementAndSendKeys(NEW_GROUP_INPUT, "Test", "Cannot find and send keys to input for new group");
        this.waitElementAndTap(ADD_GROUP_NAME_OK_BUTTON, "Cannot find jk button");
        this.waitElementPresent(CREATE_NEW_GROUP_SUCCESS_POP_UP, "Cannot find success pop up");
        appiumDriver.navigate().back();
    }

    public void tapToArticleAndSaveToGroup(String articleElement) {
        this.openArticle(articleElement);
        this.waitElementAndTap(ARTICLE_MENU_BOOKMARK, "Cannot find menu bookmark");
        this.waitElementAndTap(ADD_TO_CREATE_GROUP, "Cannot find and tap to add read list");
        this.waitElementAndTap(NAME_GROUP_WITH_ARTICLES, "Cannot find create group");
        this.waitElementPresent(CREATE_NEW_GROUP_SUCCESS_POP_UP, "Cannot find success pop up");
        appiumDriver.navigate().back();
        appiumDriver.hideKeyboard();
        this.waitElementAndTap(ANDROID_NAVIGATE_BUTTON_UP, "Cannot find and tap to android navigate button up");

    }

    public void openSavedArticles() {
        this.waitElementAndTap(TO_SAVED_ARTICLES, "Cannot find and tap navigate to saved groups");
        this.waitElementAndTap(MY_SAVED_GROUP, "Cannot find and tap to my create group" + MY_SAVED_GROUP);
    }

    public void deleteSavedArticleAndCheckSuccess() {
        int quantityArticle_Before_Swipe = this.getAmountsOfElements(SAVED_ARTICLES_LIST);
        this.swipeToLeft(ARTICLE_FOR_SWIPE, "Cannot find and swipe article");
        this.waitElementAndTap(ELEMENT_UNDO, "Cannot find and tap to UNDO");
        int quantityArticle_After_Swipe = this.getAmountsOfElements(SAVED_ARTICLES_LIST);
        Assertions.assertEquals(quantityArticle_After_Swipe, quantityArticle_Before_Swipe - 1, "Not right quantity Articles");
    }

    public void getTitleOfArticle() {
        Assertions.assertNotNull(this.getAndCheckTitleOfArticle());
    }
}
