import Lib.CoreTestCase;
import Lib.ui.ArticlePageObject;
import Lib.ui.SearchPageObject;
import org.junit.jupiter.api.Test;

public class testArticle extends CoreTestCase {

    @Test
    public void saveTwoArticlesTest() {
        SearchPageObject searchPageObject = new SearchPageObject(appiumDriver);

        searchPageObject.findAndTapSearchInput();
        searchPageObject.sendKeysToSearchInput("Java");
        searchPageObject.waitForSearchResult("Java (programming language)");

        ArticlePageObject articlePageObject = new ArticlePageObject(appiumDriver);

        articlePageObject.createGroupAndAddArticle("Java (programming language");
        searchPageObject.waitForSearchResult("JavaScript");
        articlePageObject.tapToArticleAndSaveToGroup("JavaScript");
        articlePageObject.openSavedArticles();
        articlePageObject.deleteSavedArticleAndCheckSuccess();
    }

    @Test
    public void assertTitleTest() {
        SearchPageObject searchPageObject = new SearchPageObject(appiumDriver);

        searchPageObject.findAndTapSearchInput();
        searchPageObject.sendKeysToSearchInput("Java");

        ArticlePageObject articlePageObject = new ArticlePageObject(appiumDriver);

        articlePageObject.openArticle("JavaScript");
        articlePageObject.getTitleOfArticle();
    }
}
