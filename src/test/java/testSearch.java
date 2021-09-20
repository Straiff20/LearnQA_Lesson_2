import Lib.CoreTestCase;
import Lib.ui.ArticlePageObject;
import Lib.ui.MainPageObject;
import Lib.ui.SearchPageObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class testSearch extends CoreTestCase {

    private static final String ERROR_MESSAGE_NOT_FIND_ELEMENT = "Cannot find Element" + "\n";
    private MainPageObject MainPageObject;

    @BeforeEach
    protected void setUp() throws Exception {
        super.setUp();

        MainPageObject = new MainPageObject(ad);
    }

    @Test
    public void searchWordAndCheckAnswerTest() {
        SearchPageObject searchPageObject = new SearchPageObject(ad);

        searchPageObject.findAndTapSearchInput();
        searchPageObject.sendKeysToSearchInput("Java");
        searchPageObject.waitForSearchResult("JavaScript");
    }

    @Test
    public void searchWordCheckAndClearTest() {
        SearchPageObject searchPageObject = new SearchPageObject(ad);

        searchPageObject.findAndTapSearchInput();
        searchPageObject.sendKeysToSearchInput("Appium");
        searchPageObject.waitForCloseSearchButtonToAppear();
        searchPageObject.tapToCloseSearchInputButton();
        searchPageObject.waitForCloseSearchButtonToDisappear();
    }

    @Test
    public void saveTwoArticlesTest() {
        SearchPageObject searchPageObject = new SearchPageObject(ad);

        searchPageObject.findAndTapSearchInput();
        searchPageObject.sendKeysToSearchInput("Java");
        searchPageObject.waitForSearchResult("Java (programming language)");

        ArticlePageObject articlePageObject = new ArticlePageObject(ad);

        articlePageObject.createGroupAndAddArticle("Java (programming language");
        searchPageObject.waitForSearchResult("JavaScript");
        articlePageObject.tapToArticleAndSaveToGroup("JavaScript");
        articlePageObject.openSavedArticles();
        articlePageObject.deleteSavedArticleAndCheckSuccess();
    }

    @Test
    public void assertTitleTest() {
        SearchPageObject searchPageObject = new SearchPageObject(ad);

        searchPageObject.findAndTapSearchInput();
        searchPageObject.sendKeysToSearchInput("Java");

        ArticlePageObject articlePageObject = new ArticlePageObject(ad);

        articlePageObject.openArticle("JavaScript");
        articlePageObject.getTitleOfArticle();
    }
}