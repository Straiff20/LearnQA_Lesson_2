import Lib.CoreTestCase;
import Lib.ui.MainPageObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class testSearch extends CoreTestCase {

    private static final String ERROR_MESSAGE_NOT_FIND_ELEMENT = "Cannot find Element" + "\n";
    private MainPageObject MainPageObject;

    protected void setUp() throws Exception {
        super.setUp();

        MainPageObject = new MainPageObject(ad);
    }

    @Test
    public void searchTextTest() {
        MainPageObject.onboardingSkip();
        String xpathToSearchWikipedia = "//*[contains(@text,'Search Wikipedia')]";
        MainPageObject.waitElement(By.xpath(xpathToSearchWikipedia), ERROR_MESSAGE_NOT_FIND_ELEMENT + xpathToSearchWikipedia);
    }

    @Test
    public void searchWordCheckAndClearTest() {
        MainPageObject.onboardingSkip();

        String xpathToSearchWikipedia = "//*[contains(@text,'Search Wikipedia')]";
        MainPageObject.waitElementAndTap(By.xpath(xpathToSearchWikipedia), ERROR_MESSAGE_NOT_FIND_ELEMENT + xpathToSearchWikipedia);

        String xpathToSearchInput = "org.wikipedia:id/search_src_text";
        WebElement element = MainPageObject.waitElementAndSendKeys(By.id(xpathToSearchInput), "Appium", ERROR_MESSAGE_NOT_FIND_ELEMENT + xpathToSearchInput);

        String xpathToGroupElement = "//*[contains(@class, 'android.view.ViewGroup')]";
        MainPageObject.waitElement(By.xpath(xpathToGroupElement), ERROR_MESSAGE_NOT_FIND_ELEMENT + xpathToGroupElement);

        element.clear();

        String xpathToImageEmptySearch = "org.wikipedia:id/search_empty_image";
        MainPageObject.waitElement(By.id(xpathToImageEmptySearch), ERROR_MESSAGE_NOT_FIND_ELEMENT + xpathToImageEmptySearch);
    }

    @Test
    public void searchWordAndCheckAnswerTest() {
        MainPageObject.onboardingSkip();

        String xpathToSearchWikipedia = "//*[contains(@text,'Search Wikipedia')]";
        MainPageObject.waitElementAndTap(By.xpath(xpathToSearchWikipedia), ERROR_MESSAGE_NOT_FIND_ELEMENT + xpathToSearchWikipedia);

        String xpathToSearchInput = "org.wikipedia:id/search_src_text";
        WebElement element = MainPageObject.waitElementAndSendKeys(By.id(xpathToSearchInput), "Java", ERROR_MESSAGE_NOT_FIND_ELEMENT + xpathToSearchInput);

        String xpathToArticle_1 = "//*[contains(@text,'Java')]";
        MainPageObject.waitElement(By.xpath(xpathToArticle_1), ERROR_MESSAGE_NOT_FIND_ELEMENT + xpathToArticle_1);

        String xpathToArticle_2 = "//*[contains(@text,'JavaScript')]";
        MainPageObject.waitElement(By.xpath(xpathToArticle_2), ERROR_MESSAGE_NOT_FIND_ELEMENT + xpathToArticle_2);

        String xpathToArticle_3 = "//*[contains(@text,'Java (programming language)')]";
        MainPageObject.waitElement(By.xpath(xpathToArticle_3), ERROR_MESSAGE_NOT_FIND_ELEMENT + xpathToArticle_3);

        String xpathToArticle_4 = "//*[contains(@text,'Java version history')]";
        MainPageObject.waitElement(By.xpath(xpathToArticle_4), ERROR_MESSAGE_NOT_FIND_ELEMENT + xpathToArticle_4);

        element.clear();

        String xpathToImageEmptySearch = "org.wikipedia:id/search_empty_image";
        MainPageObject.waitElement(By.id(xpathToImageEmptySearch), ERROR_MESSAGE_NOT_FIND_ELEMENT + xpathToImageEmptySearch);

    }

    @Test
    public void saveTwoArticlesTest() {
        MainPageObject.onboardingSkip();

        String xpathToSearchWikipedia = "//*[contains(@text,'Search Wikipedia')]";
        MainPageObject.waitElementAndTap(By.xpath(xpathToSearchWikipedia), ERROR_MESSAGE_NOT_FIND_ELEMENT + xpathToSearchWikipedia);

        String xpathToSearchInput = "org.wikipedia:id/search_src_text";
        MainPageObject.waitElementAndSendKeys(By.id(xpathToSearchInput), "Java", ERROR_MESSAGE_NOT_FIND_ELEMENT + xpathToSearchInput);

        String xpathToFirstArticle = "//*[contains(@text, 'Java (programming language)')]";
        MainPageObject.waitElementAndTap(By.xpath(xpathToFirstArticle), ERROR_MESSAGE_NOT_FIND_ELEMENT + xpathToFirstArticle);

        String xpathToFirstArticleElement = "//*[contains(@text, '\"Java language\" redirects here. It is not to be confused with')]";
        MainPageObject.waitElement(By.xpath(xpathToFirstArticleElement), ERROR_MESSAGE_NOT_FIND_ELEMENT + xpathToFirstArticleElement);

        String xpathToMenuBookmark = "org.wikipedia:id/article_menu_bookmark";
        MainPageObject.waitElementAndTap(By.id(xpathToMenuBookmark), ERROR_MESSAGE_NOT_FIND_ELEMENT + xpathToMenuBookmark);

        String xpathToAddToList = "//*[contains(@text, 'ADD TO LIST')]";
        MainPageObject.waitElementAndTap(By.xpath(xpathToAddToList), ERROR_MESSAGE_NOT_FIND_ELEMENT + xpathToAddToList);

        String xpathToNameGroupInput = "org.wikipedia:id/text_input";
        MainPageObject.waitElementAndSendKeys(By.id(xpathToNameGroupInput), "Test", ERROR_MESSAGE_NOT_FIND_ELEMENT + xpathToNameGroupInput);

        String xpathToOkButton = "android:id/button1";
        MainPageObject.waitElementAndTap(By.id(xpathToOkButton), ERROR_MESSAGE_NOT_FIND_ELEMENT + xpathToOkButton);

        String xpathToSnackbarText = "org.wikipedia:id/snackbar_text";
        MainPageObject.waitElement(By.id(xpathToSnackbarText), ERROR_MESSAGE_NOT_FIND_ELEMENT + xpathToSnackbarText);

        String xpathToNavigateButtonUp = "//android.widget.ImageButton[@content-desc=\"Navigate up\"]";
        MainPageObject.waitElementAndTap(By.xpath(xpathToNavigateButtonUp), ERROR_MESSAGE_NOT_FIND_ELEMENT + xpathToNavigateButtonUp);

        ad.hideKeyboard();

        String xpathToSecondArticle = "//*[contains(@text, 'JavaScript')]";
        MainPageObject.waitElementAndTap(By.xpath(xpathToSecondArticle), ERROR_MESSAGE_NOT_FIND_ELEMENT + xpathToSecondArticle);

        String xpathToSecondArticleElement = "//*[contains(@text, 'Not to be confused with')]";
        MainPageObject.waitElement(By.xpath(xpathToSecondArticleElement), ERROR_MESSAGE_NOT_FIND_ELEMENT + xpathToSecondArticleElement);

        MainPageObject.waitElementAndTap(By.id(xpathToMenuBookmark), ERROR_MESSAGE_NOT_FIND_ELEMENT + xpathToMenuBookmark);

        String xpathToSnackbarAction = "org.wikipedia:id/snackbar_action";
        MainPageObject.waitElementAndTap(By.id(xpathToSnackbarAction), ERROR_MESSAGE_NOT_FIND_ELEMENT + xpathToSnackbarAction);

        String xpathToSelectGroup = "//*[contains(@text, 'Test')]";
        MainPageObject.waitElementAndTap(By.xpath(xpathToSelectGroup), ERROR_MESSAGE_NOT_FIND_ELEMENT + xpathToSelectGroup);

        MainPageObject.waitElement(By.id(xpathToSnackbarText), ERROR_MESSAGE_NOT_FIND_ELEMENT + xpathToSnackbarText);

        MainPageObject.waitElementAndTap(By.xpath(xpathToNavigateButtonUp), ERROR_MESSAGE_NOT_FIND_ELEMENT + xpathToNavigateButtonUp);

        String xpathToAnotherButtonUp = "//*[contains(@class, 'android.widget.ImageButton')]";
        MainPageObject.waitElementAndTap(By.xpath(xpathToAnotherButtonUp), ERROR_MESSAGE_NOT_FIND_ELEMENT + xpathToAnotherButtonUp);

        String xpathToSavedArticles = "//*[contains(@content-desc, 'Saved')]";
        MainPageObject.waitElementAndTap(By.xpath(xpathToSavedArticles), ERROR_MESSAGE_NOT_FIND_ELEMENT + xpathToSavedArticles);

        String xpathToGroupWithSavedArticles = "//*[contains(@text, 'Test')]";
        MainPageObject.waitElementAndTap(By.xpath(xpathToGroupWithSavedArticles), ERROR_MESSAGE_NOT_FIND_ELEMENT + xpathToGroupWithSavedArticles);

        String xpathToSavedArticlesList = "//androidx.recyclerview.widget.RecyclerView/*";
        int quantityArticle_Before_Swipe = MainPageObject.getAmountsOfElements(By.xpath(xpathToSavedArticlesList));

        String xpathToElementForSwipe = "//androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[3]";
        MainPageObject.swipeToLeft(By.xpath(xpathToElementForSwipe), ERROR_MESSAGE_NOT_FIND_ELEMENT + xpathToElementForSwipe);

        String xpathToUndoButton = "//*[contains(@text, 'UNDO')]";
        MainPageObject.waitElementAndTap(By.xpath(xpathToUndoButton), ERROR_MESSAGE_NOT_FIND_ELEMENT + xpathToUndoButton);

        MainPageObject.touchDisplay();

        int quantityArticle_After_Swipe = MainPageObject.getAmountsOfElements(By.xpath(xpathToSavedArticlesList));

        Assertions.assertEquals(quantityArticle_After_Swipe, quantityArticle_Before_Swipe - 1, "Not right quantity Articles");
    }

    @Test
    public void assertTitleTest() {
        MainPageObject.onboardingSkip();

        String xpathToSearchWikipedia = "//*[contains(@text,'Search Wikipedia')]";
        MainPageObject.waitElementAndTap(By.xpath(xpathToSearchWikipedia), ERROR_MESSAGE_NOT_FIND_ELEMENT + xpathToSearchWikipedia);

        String xpathToSearchInput = "org.wikipedia:id/search_src_text";
        MainPageObject.waitElementAndSendKeys(By.id(xpathToSearchInput), "Java", ERROR_MESSAGE_NOT_FIND_ELEMENT + xpathToSearchInput);

        String xpathToFirstArticle = "//*[contains(@text, 'Java (programming language)')]";
        MainPageObject.waitElementAndTap(By.xpath(xpathToFirstArticle), ERROR_MESSAGE_NOT_FIND_ELEMENT + xpathToFirstArticle);

        String textArticle = "//*[@text='Indonesian island']";
        MainPageObject.waitElement(By.xpath(textArticle), ERROR_MESSAGE_NOT_FIND_ELEMENT + textArticle);

        Assertions.assertNotNull(MainPageObject.getTitleInWebWiewPage());
    }


}