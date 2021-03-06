package Android;

import Lib.CoreTestCase;
import Lib.ui.ArticlePageObject;
import Lib.ui.SearchPageObject;
import org.junit.jupiter.api.Test;

public class testArticle extends CoreTestCase {

    @Test
    public void saveTwoArticlesTest() {
        SearchPageObject searchPageObject = new SearchPageObject(driver);

        searchPageObject.findAndTapSearchInput();
        searchPageObject.sendKeysToSearchInput("Java");
        searchPageObject.waitForSearchResult("Java (programming language)");

        ArticlePageObject articlePageObject = new ArticlePageObject(driver);

        articlePageObject.createGroupAndAddArticle("Java (programming language");
        searchPageObject.waitForSearchResult("JavaScript");
        articlePageObject.tapToArticleAndSaveToGroup("JavaScript");
        articlePageObject.openSavedArticles();
        articlePageObject.deleteSavedArticleAndCheckSuccess();
    }

    @Test
    public void assertTitleTest() {
        SearchPageObject searchPageObject = new SearchPageObject(driver);

        searchPageObject.findAndTapSearchInput();
        searchPageObject.sendKeysToSearchInput("Java");

        ArticlePageObject articlePageObject = new ArticlePageObject(driver);

        articlePageObject.openArticle("JavaScript");
        articlePageObject.getTitleOfArticle();
    }

    @Test
    public void checkArticleAfterRotate() {
        SearchPageObject searchPageObject = new SearchPageObject(driver);

        searchPageObject.findAndTapSearchInput();
        searchPageObject.sendKeysToSearchInput("Java");

        ArticlePageObject articlePageObject = new ArticlePageObject(driver);
        articlePageObject.openArticle("JavaScript");

        articlePageObject.getAttributeRotateAndAssertAttribute("JavaScript");
    }
}
