import Lib.Android_CoreTestCase;
import Lib.ui.ArticlePageObject;
import Lib.ui.SearchPageObject;
import org.junit.jupiter.api.Test;

public class testArticle extends Android_CoreTestCase {

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
